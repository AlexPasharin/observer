package observer;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Pasharin
 */
public class ClockTimer extends Observable implements Runnable{
    
    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    

    @Override
    public void run() {  
        
        LocalDateTime now = LocalDateTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
        
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClockTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.tick();
            this.setChanged();
            this.notifyObservers();
        }
    }

    private void tick() {
        this.second++;
        if(second >= 60){
            this.second = 0;
            this.minute++;
            if(this.minute >= 60){
                this.hour++;
                if(this.hour >=24) this.hour = 0;
            }
        }
    }
    
    
    
}

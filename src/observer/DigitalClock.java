/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Alex
 */
public class DigitalClock implements Observer{
    
    private final ClockTimer timer;
    
    public DigitalClock(ClockTimer ct){
        this.timer = ct;
        this.timer.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        if(o == this.timer) draw();
    }
    
    private void draw(){
        int hour = this.timer.getHour();
        int minute = this.timer.getMinute();
        int second = this.timer.getSecond();
        
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);       
    }
}

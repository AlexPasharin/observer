/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Alex
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClockTimer ct = new ClockTimer();
        DigitalClock clock = new DigitalClock(ct);
        
        new Thread(ct).start();
    }
    
}

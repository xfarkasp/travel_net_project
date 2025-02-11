package com.travelnet.model.strategy;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

/**
 * The type Travel car strategy.
 */
public class TravelCarStrategy implements TravelStrategy{
    /**
     * Travel gif source.
     */
    //gif source: https://gifs.alphacoders.com/gifs/view/6558
    private final String travelAnimation = "images/gif/dieselTime.gif";
    /**
     * Current travel.
     */
    private Travel travel;
    /**
     * Time left to arrive to the selected city.
     */
    private int timeLeft;
    /**
     * The Km counter.
     */
    protected int kmCounter;

    /**
     * Instantiates a new Travel car strategy.
     *
     * @param travel the travel
     */
    public TravelCarStrategy(Travel travel){
        this.travel = travel;
    }
    /**
     * travelTo handles the travel process to a new city
     * Decrements user values calculates the time out time
     * starts new thrad for timeout counter
     *
     * @return true if travel was successful, false if not
     */
    @Override
    public boolean travelTo() {
        City cityCurrent = travel.getCurrentCity();
        if(travel.getVehicle().getCondition() > 0){
                for(User user : travel.getCompanions()){
                    if(user.getHunger() >= 10 && user.getStamina() >= 10) {
                        user.setHunger(user.getHunger() - 10);
                        user.setStamina(user.getStamina() - 10);
                    }else{return false;}
            }
            kmCounter += cityCurrent.getDistance();
            travel.getVehicle().setCondition(travel.getVehicle().getCondition() - travel.getVehicle().getFail());
            new threadService("pain").start();
            return true;


        }
        System.out.println("The car is in bad condition, call a mechanic");
        return false;
    }
    /**
     * Counts down based on distance and vehicle speedfactor
     * Runs on different thread until reaches 0
     *
     */
    private void delayCounter(){
        timeLeft = this.travel.getCurrentCity().getDistance()/10 + travel.getVehicle().getSpeed();
        while (timeLeft != 0) {
            timeLeft--;
            try {
                System.out.println(timeLeft);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
    /**
     * Returns time left from delayCounter
     *
     * @return timeLeft
     */
    @Override
    public int getTimeLeft() {
        return timeLeft;
    }
    /**
     * Returns travelAnimation path
     *
     * @return travelAnimation
     */
    @Override
    public String getTravelAnimation() {
        return travelAnimation;
    }

    /**
     * The type Thread service.
     * Creates a new thread for delay counter method.
     *
     */
    public class threadService extends Service<String> {
        private threadService(String timeLeft){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {

                }
            });
        }
        /**
         * Starts the delay counter on another thread
         *
         * @return "ok" when task finishes
         */
        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    TravelCarStrategy.this.delayCounter();
                    return "ok";
                }
            };
        }
    }
}

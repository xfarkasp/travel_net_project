package com.travelnet.model.strategy;

import com.travelnet.model.cities.City;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class TravelCarStrategy implements TravelStrategy{
    //gif source: https://gifs.alphacoders.com/gifs/view/6558
    private final String travelAnimation = "images/gif/dieselTime.gif";
    private Travel travel;

    private int timeLeft;
    protected int kmCounter;
    public TravelCarStrategy(Travel travel){
        this.travel = travel;
    }
    /**
     * @return
     */
    @Override
    public boolean travelTo() {
        City cityCurrent = travel.getCurrentCity();
        if(travel.getVehicle().getCondition() > 0){

            kmCounter += cityCurrent.getDistance();
            new threadService("pain").start();
            return true;


        }
        System.out.println("The car is in bad condition, call a mechanic");
        return false;
    }

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
     * @return
     */
    @Override
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * @return
     */
    @Override
    public String getTravelAnimation() {
        return travelAnimation;
    }

    public class threadService extends Service<String> {
        private threadService(String timeLeft){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {

                }
            });
        }

        /**
         * @return
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

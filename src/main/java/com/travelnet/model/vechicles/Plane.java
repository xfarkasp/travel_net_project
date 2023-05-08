package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.Pilot;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class Plane implements Vehicle{
    protected int speedFactor = 15;

    protected int condition = 30;
    protected int failFactor = 10;
    protected int cost = 10;
    protected int kmCounter;
    private int timeLeft;

    @Override
    public boolean travelTo(Travel travel) {
        City cityCurrent = travel.getCurrentCity();
        if (travel.getCompanions().size() == 0) {
            System.out.println("no companions");
            return false;
        }
        for (int i = 0; i < travel.getCompanions().size(); i++) {
            if (travel.getCompanions().get(i) instanceof Pilot) {
                //int distance = cityCurrent.getDistance(cityCurrent.getName());

                if (travel.getCompanions().get(i).skill(this)) {
                    kmCounter += cityCurrent.getDistance();
                    new threadService("pain").start();
                    return true;
                }
            }
        }
        return false;
    }

    private void delayCounter(){
        timeLeft = speedFactor;
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
     * @param user
     */
    @Override
    public void maintenance(User user) {
        if(user.skill(this)){
            System.out.println("Plane repaired");
            return;
        }
        System.out.println("this user can not repair a car");

    }

    /**
     * @param user
     * @param distance
     * @return
     */
    @Override
    public boolean payments(User user, int distance) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int getCondition() {
        return condition;
    }

    /**
     * @param condition
     */
    @Override
    public void setCondition(int condition) {

    }

    /**
     *
     */
    @Override
    public int getTimeLeft() {
        return timeLeft;
    }

    public class threadService extends Service<String>{
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
                    Plane.this.delayCounter();
                    return "ok";
                }
            };
        }
    }
}

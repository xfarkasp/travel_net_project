package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class Car implements Vehicle {
    protected int speedFactor = 15;

    protected int condition = 15;
    protected int failFactor = 3;

    protected int kmCounter;

    private int timeLeft;

   /* @Override
    public boolean travelTo(Travel travel) {
        City cityCurrent = travel.getCurrentCity();
        if(condition > 0){
            int distance = cityCurrent.getDistance();

                kmCounter += cityCurrent.getDistance();
                new Car.threadService("pain").start();
                return true;


        }
        System.out.println("The car is in bad condition, call a mechanic");
        return false;
    }*/

    /**
     * @return
     */
    @Override
    public int getSpeed() {
        return speedFactor;
    }

    @Override
    public void maintenance(User user) {
        if(user.skill(this)){
            System.out.println("Car repaired");
            return;
        }
        System.out.println("this user can not repair a car");

    }

   /* @Override
    public boolean payments(User user, int distance) {
        if(user.getMoney() >= distance){

            System.out.println("Payment was succesful");
            return true;
        }
        System.out.println("You don't have enough money to travel");
        return false;
    }*/


    @Override
    public int getCondition() {return condition;}


    @Override
    public void setCondition(int condition) {this.condition = condition;}

    /**
     * @return
     */


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
                    Car.this.delayCounter();
                    return "ok";
                }
            };
        }
    }
}

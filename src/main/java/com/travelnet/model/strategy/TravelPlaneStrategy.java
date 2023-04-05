package com.travelnet.model.strategy;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.Pilot;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import com.travelnet.model.vechicles.Plane;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class TravelPlaneStrategy implements TravelStrategy{
    /**
     * Travel gif source.
     */
    private final String travelAnimation = "images/gif/travel-map-destinations-aqmubawbrhnfybku.gif";
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
     * Instantiates a new Travel plane strategy.
     *
     * @param travel the travel
     */
    public TravelPlaneStrategy(Travel travel){
        this.travel = travel;
    }
    /**
     * Travel algorithm which is used to travel to a new destination
     * vehicle condition is evaluated, then the method looks for an instance of Pilot in the travel
     * if he finds a pilot, it uses its skill method then decrements the hunger and stamina for all the users
     *
     *  @return true if travel was successful, false if not
     */
    @Override
    public boolean travelTo() {
        if(travel.getVehicle().getCondition() > 0) {
            City cityCurrent = travel.getCurrentCity();
            if (travel.getCompanions().size() == 0) {
                System.out.println("no pilot in your company");
                return false;
            }
            for (int i = 0; i < travel.getCompanions().size(); i++) {
                if (travel.getCompanions().get(i) instanceof Pilot) {
                    //int distance = cityCurrent.getDistance(cityCurrent.getName());

                    if (travel.getCompanions().get(i).skill(travel.getVehicle())) {
                        kmCounter += cityCurrent.getDistance();
                        for(User user : travel.getCompanions()){
                            if( !(user instanceof Pilot) && user.getHunger() >= 5 && user.getStamina() >= 5) {
                                user.setHunger(user.getHunger() - 5);
                                user.setStamina(user.getStamina() - 5);
                            }
                        }
                        //vehicle condition decremented
                        travel.getVehicle().setCondition(travel.getVehicle().getCondition() - travel.getVehicle().getFail());

                        new threadService("pain").start();
                        return true;
                    }
                }
            }
        }
        return false;
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
                    TravelPlaneStrategy.this.delayCounter();
                    return "ok";
                }
            };
        }
    }
}

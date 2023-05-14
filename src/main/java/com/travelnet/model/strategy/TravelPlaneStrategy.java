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
    private final String travelAnimation = "images/gif/travel-map-destinations-aqmubawbrhnfybku.gif";
    private Travel travel;

    private int timeLeft;
    protected int kmCounter;
    public TravelPlaneStrategy(Travel travel){
        this.travel = travel;
    }
    /**
     * @return
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
                            user.setHunger(user.getHunger() - 5);
                            user.setStamina(user.getStamina() - 5);
                        }

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
                    TravelPlaneStrategy.this.delayCounter();
                    return "ok";
                }
            };
        }
    }
}

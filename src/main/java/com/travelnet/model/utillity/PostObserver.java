package com.travelnet.model.utillity;

import com.travelnet.controller.MainWindowController;

import java.util.ArrayList;

public class PostObserver {
    private static final PostObserver instance = new PostObserver();
    private PostObserver(){tnInstances = new ArrayList<>();};
    private ArrayList<MainWindowController> tnInstances;

    public static PostObserver getInstance(){
        return instance;
    }

    public void subscribe(MainWindowController controller){
        tnInstances.add(controller);
    }
    public void unSubscribe(MainWindowController controller){
        tnInstances.remove(controller);
    }

    public void notifySubjects(){
        for(MainWindowController controller : tnInstances) {
            controller.update();
            System.out.println("observer notified");
        }
    }
}

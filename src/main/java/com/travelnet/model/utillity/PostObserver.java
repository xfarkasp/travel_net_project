package com.travelnet.model.utillity;

import com.travelnet.controller.MainWindowController;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * The type Post observer.
 * Observer patern
 * updates every MainWindowController instance when new post was added
 */
public class PostObserver {
    /**
     * Singleton instance
     */
    private static final PostObserver instance = new PostObserver();
    private PostObserver(){tnInstances = new ArrayList<>();};
    /**
     * Subs of observer
     */
    private ArrayList<MainWindowController> tnInstances;

    /**
     * Get instance post observer.
     *
     * @return the post observer
     */
    public static PostObserver getInstance(){
        return instance;
    }

    /**
     * Subscribe.
     *
     * @param controller the controller
     */
    public void subscribe(MainWindowController controller){
        tnInstances.add(controller);
    }

    /**
     * Un subscribe.
     *
     * @param controller the controller
     */
    public void unSubscribe(MainWindowController controller){
        tnInstances.remove(controller);
    }

    /**
     * Notify subjects.
     * Adds post from every instance of MainWindowController
     */
    public void notifySubjects(){
        for(MainWindowController controller : tnInstances) {
            controller.update();
            System.out.println("observer notified");
        }
    }

    /**
     * Notify deleter.
     *Deletes post from every instance of MainWindowController
     * @param index the index
     */
    public void notifyDeleter(int index){
        for(MainWindowController controller : tnInstances) {
            controller.delete(index);
            System.out.println("observer notified");
        }
    }
}

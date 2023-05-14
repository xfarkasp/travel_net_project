package com.travelnet.controller;

import javafx.scene.image.Image;

/**
 * The interface Map controller.
 */
public interface MapController {
    /**
     * Show hotels clicked.
     */
    public void showHotelsClicked();

    /**
     * Show interests clicked.
     */
    public void showInterestsClicked();

    /**
     * Show restaurants clicked.
     */
    public void showRestaurantsClicked();

    /**
     * Sets img.
     *
     * @param imgPath the img path
     */
    public void setImg(String imgPath);
}

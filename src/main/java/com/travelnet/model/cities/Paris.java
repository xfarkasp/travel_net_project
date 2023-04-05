package com.travelnet.model.cities;

/**
 * The type Paris.
 */
public class Paris extends CityTemplate implements City {

    private int distance = 70;

    /**
     * Instantiates a new Paris.
     */
    public Paris(){
        this.name = "Paris";
        //img source: https://www.dreamstime.com/royalty-free-stock-photos-paris-france-image19597218
        this.imagePath = "src/main/resources/images/city_imgs/paris.jpg";
    }
    /**
     * Gets image path.
     *
     * @return imagePath
     */
    @Override
    public String getImagePath() {
        return imagePath;
    }
    /**
     * Gets name.
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Gets distance.
     *
     * @return the distance
     */
    @Override
    public int getDistance() {
        return distance;
    }

}



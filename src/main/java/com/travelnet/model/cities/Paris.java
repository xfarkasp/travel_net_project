package com.travelnet.model.cities;

public class Paris extends CityTemplate implements City {


    private int distance = 70;



    public int getDistance() {
        return distance;
    }


    public Paris(){
        this.name = "Paris";
        //img source: https://www.dreamstime.com/royalty-free-stock-photos-paris-france-image19597218
        this.imagePath = "src/main/resources/images/city_imgs/paris.jpg";
    }

    /**
     * @return
     */
    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String getName() {
        return name;
    }



    public int getDistance(String city) {
        return distance;
    }


}



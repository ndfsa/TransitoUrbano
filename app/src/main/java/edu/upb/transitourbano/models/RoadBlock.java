package edu.upb.transitourbano.models;

public class RoadBlock {

    private int id;

    private String adress;

    private String info;

    private String informant;

    private double lat;

    private double lng;

    public RoadBlock(int id, String adress, String info, String informant, double lat, double lng) {
        this.id = id;
        this.adress = adress;
        this.info = info;
        this.informant = informant;
        this.lat = lat;
        this.lng = lng;
    }


    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public String getInfo() {
        return info;
    }

    public String getInformant() {
        return informant;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}

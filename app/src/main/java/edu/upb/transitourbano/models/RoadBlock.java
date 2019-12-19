package edu.upb.transitourbano.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class RoadBlock implements ClusterItem {

    private long uuid;

    private String adress;

    private String info;

    private String informant;

    private double lat;

    private double lng;

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setLatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public RoadBlock(long uuid, String adress, String info, String informant, double lat, double lng) {
        this.uuid = uuid;
        this.adress = adress;
        this.info = info;
        this.informant = informant;
        this.lat = lat;
        this.lng = lng;
    }
    public RoadBlock(long uuid, String adress, String info, String informant) {
        this.uuid = uuid;
        this.adress = adress;
        this.info = info;
        this.informant = informant;
    }

    public int getId() {
        return 1;
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

    public long getUuid() {
        return uuid;
    }

    @Override
    public LatLng getPosition() {
        return new LatLng(lat, lng);
    }

    @Override
    public String getTitle() {
        return adress;
    }

    @Override
    public String getSnippet() {
        return info;
    }
}

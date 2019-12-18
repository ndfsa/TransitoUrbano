package edu.upb.transitourbano.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class RoadBlock implements ClusterItem {

    private int id;

    private String adress;

    private String info;

    private String informant;

    private LatLng latLng;

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public RoadBlock(int id, String adress, String info, String informant, LatLng latLng) {
        this.id = id;
        this.adress = adress;
        this.info = info;
        this.informant = informant;
        this.latLng = latLng;
    }
    public RoadBlock(int id, String adress, String info, String informant) {
        this.id = id;
        this.adress = adress;
        this.info = info;
        this.informant = informant;
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

    @Override
    public LatLng getPosition() {
        return latLng;
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

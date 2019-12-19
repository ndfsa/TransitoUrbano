package edu.upb.transitourbano.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.Exclude;
import com.google.maps.android.clustering.ClusterItem;

public class RoadBlock implements ClusterItem {

    private long uuid;
    private String address;
    private String info;
    private String informant;
    private LatLng position;

    public void setAddress(String address) {
        this.address = address;
    }

    public RoadBlock(long uuid, String address, String info, String informant, LatLng position) {
        this.uuid = uuid;
        this.address = address;
        this.info = info;
        this.informant = informant;
        this.position = position;

    }
    public RoadBlock(long uuid, String address, String info, String informant) {
        this.uuid = uuid;
        this.address = address;
        this.info = info;
        this.informant = informant;
    }

    public String getAddress() {
        return address;
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

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public LatLng getPosition() {
        return position;
    }

    @Exclude
    @Override
    public String getTitle() {
        return address;
    }

    @Exclude
    @Override
    public String getSnippet() {
        return "Possible roadblock";
    }
}

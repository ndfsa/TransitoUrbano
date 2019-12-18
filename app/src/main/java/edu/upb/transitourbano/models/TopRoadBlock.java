package edu.upb.transitourbano.models;

public class TopRoadBlock {

    private int id;

    private String adress;

    private String rank;

    private String proba;

    public TopRoadBlock(int id, String adress, String  rank, String proba) {
        this.id = id;
        this.adress = adress;
        this.rank = rank;
        this.proba =proba;
    }


    public int getId() {
        return id;
    }

    public String getAdress() {
        return adress;
    }

    public String getRank() {
        return rank;
    }

    public String getProba(){ return proba; }

}

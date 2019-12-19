package edu.upb.transitourbano.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "top_road_block_table")
public class TopRoadBlock {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "adress")
    private String adress;

    @ColumnInfo(name = "rank")
    private String rank;

    @ColumnInfo(name = "proba")
    private String proba;

    public void setId(int id) {
        this.id = id;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setProba(String proba) {
        this.proba = proba;
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

package edu.upb.transitourbano.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
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

    public TopRoadBlock() {
    }

    @Ignore
    public TopRoadBlock(int id, String adress, String rank, String proba) {
        this.id = id;
        this.adress = adress;
        this.rank = rank;
        this.proba = proba;
    }

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

    public int  getId() {
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

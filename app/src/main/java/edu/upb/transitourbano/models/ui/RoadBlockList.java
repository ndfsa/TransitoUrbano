package edu.upb.transitourbano.models.ui;

import java.util.LinkedList;
import java.util.List;

import edu.upb.transitourbano.models.RoadBlock;

public class RoadBlockList {
    private static final RoadBlockList ourInstance = new RoadBlockList();
    List<RoadBlock> roadBlockList = new LinkedList<>();

    public static RoadBlockList getInstance() {
        return ourInstance;
    }

    private RoadBlockList() {
    }

    public List<RoadBlock> getRoadBlockList() {
        return roadBlockList;
    }

    public void setRoadBlockList(List<RoadBlock> roadBlockList) {
        this.roadBlockList = roadBlockList;
    }
}

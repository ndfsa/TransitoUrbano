package edu.upb.transitourbano.utils;

import java.util.ArrayList;
import java.util.List;


import edu.upb.transitourbano.models.TopRoadBlock;

public class TopRoadBlockUtils {

    public static List<TopRoadBlock> getTopBlockedRoads(){
        List<TopRoadBlock>topblockedRoads = new ArrayList<>();

        topblockedRoads.add(new TopRoadBlock(1,"El Prado","#1","75%"));
        topblockedRoads.add(new TopRoadBlock(2,"Plaza Murillo","#2","70%"));
        topblockedRoads.add(new TopRoadBlock(3,"Plaza del Estudiante","#3","72%"));
        topblockedRoads.add(new TopRoadBlock(4,"Achumani calle 29","#4","50%"));
        topblockedRoads.add(new TopRoadBlock(5,"Calacoto calle 8","#5","40%"));

        return topblockedRoads;
    }
}

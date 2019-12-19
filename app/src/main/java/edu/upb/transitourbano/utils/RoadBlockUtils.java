package edu.upb.transitourbano.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.transitourbano.models.RoadBlock;


public class RoadBlockUtils {

    public static List<RoadBlock> getBlockedRoads(){
        List<RoadBlock>blockedRoads = new ArrayList<>();
        blockedRoads.add(new RoadBlock(1,"El Prado","Protesta", "Andres"));
        blockedRoads.add(new RoadBlock(2,"Achumani calle 13","Contrucción obstruye el paso", "Gabriel"));
        blockedRoads.add(new RoadBlock(3,"Obrajes calle 10","Bloqueo de estudiantes", "Sergio"));
        blockedRoads.add(new RoadBlock(4,"Achocalla","Caseta de peaje destruida", "Kevin"));



        return blockedRoads;
    }
}

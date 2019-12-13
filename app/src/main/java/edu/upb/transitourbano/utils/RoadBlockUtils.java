package edu.upb.transitourbano.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.models.User;

public class RoadBlockUtils {

    public static List<RoadBlock> getBlockedRoads(){
        List<RoadBlock>blockedRoads = new ArrayList<>();
        blockedRoads.add(new RoadBlock(1,"El Prado","Protesta", "Andres", 45,89));
        blockedRoads.add(new RoadBlock(2,"Achumani calle 13","Contrucción obstruye el paso", "Gabriel", 56,89));
        blockedRoads.add(new RoadBlock(3,"Obrajes calle 10","Bloqueo de estudiantes", "Sergio", 45,84));
        blockedRoads.add(new RoadBlock(4,"Achocalla","Caseta de peaje destruida", "Kevin", 45,84));



        return blockedRoads;
    }
}

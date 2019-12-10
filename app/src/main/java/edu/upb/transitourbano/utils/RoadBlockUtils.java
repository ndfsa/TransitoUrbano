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
        blockedRoads.add(new RoadBlock(1,"Here","Is Bloqued", "Andres", 45,89));
        blockedRoads.add(new RoadBlock(2,"Here","Is Bloqued", "Gabo", 56,89));
        blockedRoads.add(new RoadBlock(3,"Here","Is Bloqued", "Sergio", 45,84));
        blockedRoads.add(new RoadBlock(4,"Here","Is Bloqued", "1", 45,84));
        blockedRoads.add(new RoadBlock(5,"Here","Is Bloqued", "2", 45,84));

        return blockedRoads;
    }
}

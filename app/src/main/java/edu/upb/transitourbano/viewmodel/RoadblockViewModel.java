package edu.upb.transitourbano.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.repository.firebase.FirebaseRepository;

public class RoadblockViewModel extends AndroidViewModel {

    public RoadblockViewModel(@NonNull Application application) {
        super(application);
    }

    public List<RoadBlock> getRoadblocks(){
        FirebaseRepository.getInstance().subscribeToValues("roadblocks");
        return null;
    }

    public void setRoadblock(RoadBlock roadblock){
        FirebaseRepository.getInstance().setValue("roadblocks/" + roadblock.getUuid(),roadblock);
    }

    //public void
}

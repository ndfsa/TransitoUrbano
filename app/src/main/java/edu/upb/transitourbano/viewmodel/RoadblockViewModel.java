package edu.upb.transitourbano.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.repository.firebase.FirebaseRepository;

public class RoadblockViewModel extends AndroidViewModel {

    public RoadblockViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Base> getRoadblocks(){
        return FirebaseRepository.getInstance().subscribeToValues("roadblocks");
    }

    public void setRoadblock(RoadBlock roadblock, long dbIndex){
        FirebaseRepository.getInstance().setValue("roadblocks/" + dbIndex, roadblock);
    }

    //public void
}

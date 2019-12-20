package edu.upb.transitourbano.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.repository.Repository;

public class TopRoadBlockViewModel extends AndroidViewModel {
    private Repository repository;

    public TopRoadBlockViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public LiveData<Base> register(final TopRoadBlock topRoadBlock) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        repository.insert(topRoadBlock);
        return result;
    }

    public LiveData<List<TopRoadBlock>> getAll() {
        return repository.getAll();
    }


}

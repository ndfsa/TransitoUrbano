package edu.upb.transitourbano.repository.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.repository.local.db.TransitoUrbanoDB;

public class LocalRepository {
    private TransitoUrbanoDB db;


    public LocalRepository(Application application) {
        db = TransitoUrbanoDB.getDatabase(application);
    }

    public void insert(final TopRoadBlock topRoadBlock) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().insert(topRoadBlock);
                    }
                }
        );
        thread.start();
    }

    public LiveData<List<TopRoadBlock>> getAll() {
        return db.userDao().getAll();
    }
}

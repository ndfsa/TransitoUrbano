package edu.upb.transitourbano.repository.local;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.repository.local.db.TransitoUrbanoDB;

public class LocalRepository {
    private TransitoUrbanoDB db;

    private static final String LOG = TopRoadBlock.class.getSimpleName();

    public LocalRepository(Application application) {
        db = TransitoUrbanoDB.getDatabase(application);
    }

    public void insert(final TopRoadBlock topRoadBlock) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        db.topRoadBlockDao().insert(topRoadBlock);
                        Log.e("LRepo","id: "+topRoadBlock.getId());
                    }
                }
        );
        thread.start();
    }

    public LiveData<List<TopRoadBlock>> getAll() {
        return db.topRoadBlockDao().getAll();
    }
}

package edu.upb.transitourbano.repository.local.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.repository.local.dao.TopRoadBlockDao;

@Database(entities = {TopRoadBlock.class}, version = 1)
public abstract class TransitoUrbanoDB extends RoomDatabase {

    public abstract TopRoadBlockDao topRoadBlockDao();

    private static volatile TransitoUrbanoDB INSTANCE;

    static public TransitoUrbanoDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TransitoUrbanoDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TransitoUrbanoDB.class, "transito_urbano_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

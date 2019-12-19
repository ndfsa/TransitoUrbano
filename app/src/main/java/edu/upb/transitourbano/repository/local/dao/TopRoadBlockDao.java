package edu.upb.transitourbano.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.models.User;

@Dao
public interface TopRoadBlockDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(TopRoadBlock topRoadBlock);

    @Query("DELETE FROM top_road_block_table")
    void deleteAll();

    @Query("SELECT * from top_road_block_table ORDER BY id ASC")
    LiveData<List<TopRoadBlock>> getAll();

    @Query("SELECT * from top_road_block_table WHERE adress like :adress")
    LiveData<TopRoadBlock> getUser(String adress);
}



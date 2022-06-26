package app.lucas.newssoccer.data.local;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import app.lucas.newssoccer.domain.News;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news WHERE favorite = :favorite")
    List<News> loadFavoriteNews(boolean favorite);
}

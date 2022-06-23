package app.lucas.newssoccer.data.remote;


import java.util.List;

import app.lucas.newssoccer.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsSoccerApi {
    @GET("news.json")
    Call<List<News>> getNews();
}

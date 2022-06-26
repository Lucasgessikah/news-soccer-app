package app.lucas.newssoccer.ui.news;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

import app.lucas.newssoccer.data.remote.NewsSoccerApi;
import app.lucas.newssoccer.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private  final NewsSoccerApi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://lucasgessikah.github.io/news-soccer-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         api = retrofit.create(NewsSoccerApi.class);


        this.fiendNews();


    }

    private void fiendNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()){
                    news.setValue(response.body());
                }else {
                    // TODO pensar em uma estratégia de tratamentos de erros.
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                // TODO pensar em uma estratégia de tratamentos de erros.

            }
        });
    }

    public LiveData<List<News>> getnews() {
        return news;
    }
}
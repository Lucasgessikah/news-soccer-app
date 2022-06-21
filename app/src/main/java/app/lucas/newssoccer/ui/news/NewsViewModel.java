package app.lucas.newssoccer.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.lucas.newssoccer.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        // TODO: Remover Mock de Notícias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviaria Tem Desfalque Importante.", " is simply dummy text of the printing and typesetting industry."));
        news.add(new News("Ferrinha Joga Sábado.", " is simply dummy text of the printing and typesetting industry."));
        news.add(new News("Ferroviaria Perde Jogo Pssado.", " is simply dummy text of the printing and typesetting industry."));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getnews() {
        return news;
    }
}
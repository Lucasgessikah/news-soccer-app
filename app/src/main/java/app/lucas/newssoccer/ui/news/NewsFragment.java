package app.lucas.newssoccer.ui.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import app.lucas.newssoccer.databinding.FragmentNewsBinding;
import app.lucas.newssoccer.ui.adapter.NewsAdapter;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private  AppDatabase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel newsViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = Room.databaseBuilder(getContext(), AppDatabase.class, "news-soccer")
                .allowMainThreadQueries()
                .build();

        binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        newsViewModel.getnews().observe(getViewLifecycleOwner(), news -> {
            binding.rvNews.setAdapter(new NewsAdapter(news, updatedNews -> {
                 db.newsDao().insert(updatedNews);
            }));

        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
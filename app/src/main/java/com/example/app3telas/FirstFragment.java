package com.example.app3telas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app3telas.adapter.MovieAdapter;
import com.example.app3telas.databinding.FragmentFirstBinding;
import com.example.app3telas.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(
                "O Brinquedo Assassino",
                "Terror / Suspense",
                1988,
                4.5,
                "Um assassino moribundo transfere sua alma para um boneco Good Guy, que acaba sendo dado de presente a um garoto inocente.",
                "Tom Holland",
                "Catherine Hicks, Chris Sarandon, Alex Vincent",
                R.drawable.o_brinquedo_assasino
        ));
        movieList.add(new Movie(
                "Interestelar",
                "Ficção Científica / Drama",
                2014,
                4.9,
                "Um grupo de astronautas viaja através de um buraco de minhoca em busca de um novo lar para a humanidade.",
                "Christopher Nolan",
                "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                android.R.drawable.ic_menu_mapmode
        ));
        movieList.add(new Movie(
                "Matrix",
                "Ação / Ficção Científica",
                1999,
                4.7,
                "Um hacker descobre que o mundo em que vive é uma simulação controlada por máquinas tiranas.",
                "Lana Wachowski, Lilly Wachowski",
                "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",
                android.R.drawable.ic_menu_compass
        ));
        movieList.add(new Movie(
                "Batman: O Cavaleiro das Trevas",
                "Ação / Crime",
                2008,
                4.9,
                "Batman enfrenta o Coringa, um gênio do crime que quer mergulhar Gotham City em anarquia.",
                "Christopher Nolan",
                "Christian Bale, Heath Ledger, Aaron Eckhart",
                android.R.drawable.ic_menu_gallery
        ));
        movieList.add(new Movie(
                "Gladiador",
                "Ação / Drama Histórico",
                2000,
                4.6,
                "Um general romano traído busca vingança contra o corrupto imperador que assassinou sua família.",
                "Ridley Scott",
                "Russell Crowe, Joaquin Phoenix, Connie Nielsen",
                android.R.drawable.ic_menu_camera
        ));

        MovieAdapter adapter = new MovieAdapter(movieList, movie -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("movie", movie);
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
        });

        binding.recyclerViewMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewMovies.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

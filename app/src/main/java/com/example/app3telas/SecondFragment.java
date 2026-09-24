package com.example.app3telas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app3telas.databinding.FragmentSecondBinding;
import com.example.app3telas.model.Movie;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Movie currentMovie;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            currentMovie = (Movie) getArguments().getSerializable("movie");
        }

        if (currentMovie != null) {
            binding.txtDetailTitle.setText(currentMovie.getTitle());
            binding.txtDetailGenreYear.setText(currentMovie.getGenre() + " • " + currentMovie.getYear());
            binding.txtDetailRating.setText("⭐ " + currentMovie.getRating() + " / 5.0");
            binding.txtDetailDirector.setText(currentMovie.getDirector());
            binding.txtDetailCast.setText(currentMovie.getCast());
            binding.txtDetailSynopsis.setText(currentMovie.getSynopsis());
            binding.imgDetailPoster.setImageResource(currentMovie.getImageResId());
        }

        binding.buttonSecond.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            if (currentMovie != null) {
                bundle.putSerializable("movie", currentMovie);
            }
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_ThirdFragment, bundle);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

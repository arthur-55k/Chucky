package com.example.app3telas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app3telas.databinding.FragmentMovieReviewsBinding;
import com.example.app3telas.model.Movie;

public class MovieReviewsFragment extends Fragment {

    private FragmentMovieReviewsBinding binding;
    private Movie currentMovie;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentMovieReviewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            currentMovie = (Movie) getArguments().getSerializable("movie");
        }

        if (currentMovie != null) {
            binding.txtSelectedMovieTitle.setText(currentMovie.getTitle());
        }

        binding.btnBookTicket.setOnClickListener(v ->
                Toast.makeText(getContext(), R.string.ticket_success, Toast.LENGTH_SHORT).show()
        );

        binding.btnBackCatalog.setOnClickListener(v ->
                NavHostFragment.findNavController(MovieReviewsFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

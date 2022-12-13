package be.ehb.notedroid.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import be.ehb.notedroid.databinding.FragmentDetailsBinding;
import be.ehb.notedroid.model.Note;

public class DetailsFragment extends Fragment {

    private FragmentDetailsBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Note note = (Note) getArguments().getSerializable("note");

        binding.tvDetailsCreated.setText(note.getDateCreated().toString());
        binding.tvDetailsTitle.setText(note.getTitle());
        binding.tvDetailsContent.setText(note.getContent());
    }
}

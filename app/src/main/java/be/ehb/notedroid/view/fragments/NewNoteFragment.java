package be.ehb.notedroid.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import be.ehb.notedroid.R;
import be.ehb.notedroid.databinding.FragmentNewNoteBinding;
import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.viewmodel.NoteViewModel;


public class NewNoteFragment extends Fragment {

    private FragmentNewNoteBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentNewNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NoteViewModel viewModel = new ViewModelProvider(getActivity()).get(NoteViewModel.class);

        binding.btnNewSave.setOnClickListener(
                (View v)->{
                    String title = binding.etNewTitle.getText().toString();
                    String content = binding.etNewContent.getText().toString();
                    Note note = new Note(title, content);
                    viewModel.insertNote(note);
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
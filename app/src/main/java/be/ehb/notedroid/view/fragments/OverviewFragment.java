package be.ehb.notedroid.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.ehb.notedroid.R;
import be.ehb.notedroid.databinding.FragmentOverviewBinding;
import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.view.fragments.util.NoteAdapter;
import be.ehb.notedroid.viewmodel.NoteViewModel;


public class OverviewFragment extends Fragment {

    private FragmentOverviewBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentOverviewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NoteAdapter noteAdapter = new NoteAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        binding.rcOverview.setAdapter(noteAdapter);
        binding.rcOverview.setLayoutManager(layoutManager);

        NoteViewModel viewModel = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
        viewModel.getAllNotes().observe(getViewLifecycleOwner(), (List<Note> notes) -> {
            noteAdapter.addItems(notes);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
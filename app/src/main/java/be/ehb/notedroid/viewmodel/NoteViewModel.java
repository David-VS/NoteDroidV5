package be.ehb.notedroid.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.notedroid.model.Note;
import be.ehb.notedroid.model.NoteDataBass;

public class NoteViewModel extends AndroidViewModel {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private NoteDataBass noteDataBass;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteDataBass = NoteDataBass.getInstance(application);
    }

    public LiveData<List<Note>> getAllNotes(){
        return noteDataBass.getNoteDAO().getAllNotes();
    }

    public void insertNote(Note n){
        executorService.execute(()->{
            noteDataBass.getNoteDAO().insertNote(n);
        });
    }
}

package be.ehb.notedroid.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllNotes();

    @Update
    void updateNote(Note note);

    @Delete
    void deleteNote(Note n);
}

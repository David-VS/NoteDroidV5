package be.ehb.notedroid.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.notedroid.model.converters.DateConverters;

@Database(entities = {Note.class}, version = 1)
@TypeConverters({DateConverters.class})
public abstract class NoteDataBass extends RoomDatabase {

    private static NoteDataBass Instance;

    public static NoteDataBass getInstance(Context context) {
        if(Instance == null){
            Instance = Room.databaseBuilder(
                            context,
                            NoteDataBass.class,
                            "notes.db")
                    .build();
        }
        return Instance;
    }

    public abstract NoteDao getNoteDAO();
}

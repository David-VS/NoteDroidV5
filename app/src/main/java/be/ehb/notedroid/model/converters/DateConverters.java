package be.ehb.notedroid.model.converters;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;

public class DateConverters {

    @TypeConverter
    public LocalDateTime StringToDate(String string){
        return LocalDateTime.parse(string);
    }

    @TypeConverter
    public String dateToString(LocalDateTime date){
        return date.toString();
    }
}

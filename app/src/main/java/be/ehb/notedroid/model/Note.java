package be.ehb.notedroid.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title, content;
    private LocalDateTime dateCreated, dateModified;

    public Note() {
    }

    @Ignore
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.dateCreated = LocalDateTime.now();
        this.dateModified = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }
}

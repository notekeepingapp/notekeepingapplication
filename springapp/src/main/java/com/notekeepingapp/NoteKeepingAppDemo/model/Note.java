package com.notekeepingapp.NoteKeepingAppDemo.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {

    @TableGenerator(name = "Note",initialValue = 1)
    @Column(name = "noteId", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "userName")
    @NotBlank
    private String user;

    @Column(name = "noteTitle")
    private String noteTitle;

    @Column(name = "noteContent")
    @NotBlank(message = "Enter a Content ")
    @Size(min = 2)
    private String noteContent;

    @Column(name = "createdAt")
    @CreatedDate
    private Date createdAt;

    public Note() {
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Note(int id, String user, String noteTitle, String noteContent, Date createdAt) {
        this.id = id;
        this.noteTitle = noteTitle;
        this.user = user;
        this.noteContent = noteContent;
        this.createdAt = createdAt;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", user='" + user + '\'' + ", noteTitle='" + noteTitle + '\'' + ", noteContent='"
                + noteContent + '\'' + ", createdAt=" + createdAt + '}';
    }
}

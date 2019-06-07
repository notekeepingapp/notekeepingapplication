package com.notekeepingapp.NoteKeepingAppDemo.service.noteservice;

import com.notekeepingapp.NoteKeepingAppDemo.model.Note;

import java.util.List;

public interface NoteService {

    public List<Note> getNotes(String username);

    public Note saveNote(Note note);

    public void updateNote(Note note);

    public void deleteNote(int id);

    public boolean isNoteExists(int id);

}

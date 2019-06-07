package com.notekeepingapp.NoteKeepingAppDemo.service.noteservice;

import com.notekeepingapp.NoteKeepingAppDemo.DAO.NoteRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> getNotes(String user) {
        return noteRepository.findNoteByUser(user);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.updatenoteTitle(note.getId(), note.getNoteTitle());
        noteRepository.updatenoteContent(note.getId(), note.getNoteContent());
    }

    @Override
    public boolean isNoteExists(int id) {
        return noteRepository.findNoteById(id) != null;
    }
}

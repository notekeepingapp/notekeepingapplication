package com.notekeepingapp.NoteKeepingAppDemo.service;

import com.notekeepingapp.NoteKeepingAppDemo.DAO.NoteRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.noteservice.NoteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;


    List<Note> mockNotesList = new ArrayList<Note>();
    Note mockNote;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockNote= new Note(1, "admin", "title", "content", new Date());
        mockNotesList.add(new Note(1, "admin", "title", "content", new Date()));
        mockNotesList.add(new Note(2, "admin", "title", "content", new Date()));
        mockNotesList.add(new Note(3, "admin", "title", "content", new Date()));
    }

    @Test
    public void shouldReturnNotesList_ForGetNotes(){
        when(noteRepository.findNoteByUser("admin")).thenReturn(mockNotesList);
        List<Note> notes = noteService.getNotes("admin");
        assertEquals(3, notes.size());
    }

    @Test
    public void shouldReturnTrue_For_isNoteExists_withExistingId(){
        when(noteRepository.findNoteById(1)).thenReturn(mockNote);
        assertTrue(noteService.isNoteExists(1));
    }

    @Test
    public void shouldReturnFalse_For_isNoteExists_withNonExistingId(){
        when(noteRepository.findNoteById(1)).thenReturn(mockNote);
        assertEquals(false, noteService.isNoteExists(2));
    }

    @Test
    public void shouldReturnSavedNote_For_saveNote(){
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(mockNote);
        Note note = noteService.saveNote(mockNote);
        assertNotNull(note);
    }

    @Test
    public void shouldVerify_deleteNote(){
        noteService.deleteNote(1);
        verify(noteRepository, times(1)).deleteById(1);
    }

    @Test
    public void shouldVerify_updateNote(){
        noteService.updateNote(mockNote);
        verify(noteRepository, times(1)).updatenoteTitle(1, "title");
        verify(noteRepository, times(1)).updatenoteContent(1, "content");
    }
}

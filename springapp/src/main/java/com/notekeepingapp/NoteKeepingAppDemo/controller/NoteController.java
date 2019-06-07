package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.notekeepingapp.NoteKeepingAppDemo.exception.NoteNotFoundException;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.noteservice.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @GetMapping("/{name}/notes")
    public ResponseEntity<List<Note>> getNotes(@PathVariable String name) {
        return new ResponseEntity<>(noteService.getNotes(name), HttpStatus.OK);
    }

    @PostMapping("/{name}/notes")
    public ResponseEntity<Note> saveNote(@PathVariable String name, @RequestBody Note note) {
        note.setUser(name);
        note.setCreatedAt(new Date());
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.OK);
    }

    @PostMapping("/{name}/notes/{id}")
    public ResponseEntity updateNote(@PathVariable String name, @PathVariable int id, @RequestBody Note note) throws NoteNotFoundException {
        note.setId(id);
        note.setUser(name);
        if (noteService.isNoteExists(id)) {
            noteService.updateNote(note);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            throw new NoteNotFoundException("Note doesn't exist");
        }
    }

    @RequestMapping(value = "/{name}/notes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteNote(@PathVariable int id) throws NoteNotFoundException {
        if ((noteService.isNoteExists(id))) {
            noteService.deleteNote(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            throw new NoteNotFoundException("Note doesn't exist");
        }
    }
}

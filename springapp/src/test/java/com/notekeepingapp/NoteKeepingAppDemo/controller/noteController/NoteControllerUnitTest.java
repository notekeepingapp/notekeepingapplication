package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.notekeepingapp.NoteKeepingAppDemo.model.Note;
import com.notekeepingapp.NoteKeepingAppDemo.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = NoteController.class, secure = false)
public class NoteControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NoteService noteService;

    private List<Note> mockNotesList = Arrays.asList(new Note(1, "test", "Anju", "in28Minutes", new Date()));
    private Note mockNote = new Note(1, "test", "Anju", "in28Minutes", new Date());
    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void should_ReturnSuccess_For_getNotes() throws Exception {
        Mockito.when(noteService.getNotes(Mockito.anyString())).thenReturn(mockNotesList);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/Anju/notes").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assertEquals(true, result.getResponse().getContentAsString().contains("Anju"));
    }

    @Test
    public void should_ReturnSuccess_For_addNote() throws Exception {
        String mockeNoteString = ow.writeValueAsString(mockNote);
        Mockito.when(noteService.addNote(Mockito.any(Note.class))).thenReturn(mockNote);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/Anju/notes").accept(MediaType.APPLICATION_JSON).content(mockeNoteString)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains("Anju"));
    }

    @Test
    public void should_ReturnSuccess_For_updateNote() throws Exception {
        String mockeNoteString = ow.writeValueAsString(mockNote);
        Mockito.when(noteService.updateNote(Mockito.any(Note.class))).thenReturn(true);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/Anju/notes/1").accept(MediaType.APPLICATION_JSON).content(mockeNoteString)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assertEquals("true", result.getResponse().getContentAsString());
    }

//    @Test
//    public void shouldTestDeleteNotesResponseStatusToBeSuccess() throws Exception {
//        Mockito.when(noteService.addNote(Mockito.any(Note.class))).thenReturn(mockNote);
//        Mockito.when(noteService.deleteNote(Mockito.anyInt())).thenReturn(true);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/Anju/notes/",1)).andReturn();
//        assertEquals(200, result.getResponse().getStatus());
//    }

    //For delete note there should also be test for false case as well
}

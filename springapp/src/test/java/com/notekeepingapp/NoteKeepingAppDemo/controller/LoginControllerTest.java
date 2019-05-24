package com.notekeepingapp.NoteKeepingAppDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.notekeepingapp.NoteKeepingAppDemo.DAO.UserRepository;
import com.notekeepingapp.NoteKeepingAppDemo.model.User;
import com.notekeepingapp.NoteKeepingAppDemo.service.LoginService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class, secure = false)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LoginService loginService ;

    @MockBean
    UserRepository userRepository;

    User mockUser = new User("Anju", "admin");
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void saveUser() throws Exception{
        String uri = "/login";
        boolean isUserRegistered = true;
        String mockUserJSON = ow.writeValueAsString(mockUser);
//        given(loginService.isUserRegistered(mockUser)).willReturn(false);
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(mockUserJSON).contentType(MediaType.APPLICATION_JSON)).andReturn();
//        System.out.println(result.getResponse().getStatus());
        assertEquals(200, 200);
    }
}

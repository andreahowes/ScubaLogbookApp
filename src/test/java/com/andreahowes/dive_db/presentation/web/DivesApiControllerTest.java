package com.andreahowes.dive_db.presentation.web;

import com.andreahowes.dive_db.logic.dive.Dive;
import com.andreahowes.dive_db.logic.dive.DivesService;
import com.andreahowes.dive_db.presentation.api.DivesApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DivesApiController.class, secure = false)
public class DivesApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DivesService divesService;

    @Test
    public void givenAllDives_whenGivenAllDives_thenReturnJsonArray() throws Exception{
        Dive dive1= new Dive();
        dive1.setLocation("Playa");

        List<Dive> allDives = Arrays.asList(dive1);
        //ArrayList<Dive> allDives = new ArrayList<>();

        //allDives.add(0, dive1);

        given(divesService.getAllDives()).willReturn(allDives);

        mvc.perform(get("/user/logbook/dives")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].location", is(dive1.getLocation())));

    }






































}
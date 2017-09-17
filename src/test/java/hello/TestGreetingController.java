package hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGreetingController {

    private MockMvc mockMvc;

    @InjectMocks
    private GreetingController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void shouldReturnWorld() throws Exception {
        MvcResult result = mockMvc.perform(get("/greeting")).andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content, anyOf(containsString("World")));
    }

    @Test
    public void shouldReturnJorge() throws Exception {
        MvcResult result = mockMvc.perform(get("/greeting?name=Jorge")).andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content, anyOf(containsString("Jorge")));
    }
}
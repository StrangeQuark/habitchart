package com.strangequark.habitchart;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "debug=false")
@AutoConfigureMockMvc
class HabitchartApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void healthEndpointIsPublic() throws Exception {
		mockMvc.perform(get("/api/habitchart/health"))
				.andExpect(status().isOk())
				.andExpect(content().string("200 OK"));
	}

	@Test
	void configEndpointIsPublic() throws Exception {
		mockMvc.perform(get("/api/habitchart/config"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.applicationName").value("habitchart"))
				.andExpect(jsonPath("$.version").value("0.0.1-SNAPSHOT"))
				.andExpect(jsonPath("$.localFirst").value(true))
				.andExpect(jsonPath("$.features", contains("local-first", "offline-ready", "habit-chart")));
	}

	@Test
	void unknownApiRoutesAreNotExposed() throws Exception {
		mockMvc.perform(get("/api/habitchart/private"))
				.andExpect(status().isForbidden());
	}

}

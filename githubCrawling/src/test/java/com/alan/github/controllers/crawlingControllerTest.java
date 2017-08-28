package com.alan.github.controllers;

import static org.junit.Assert.*;

import javax.sound.midi.MidiDevice.Info;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alan.github.model.GitInfo;
import com.alan.github.repostories.GitInfoRepository;
import com.alan.github.tools.DropCollection;

@RunWith(SpringRunner.class)
@WebMvcTest(value = crawlingController.class, secure = false)
public class crawlingControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private GitInfoRepository gRepository;
@Test
public void testCraawling() throws Exception {
	
}
	
	
	
	
	
	
	
	
	
	
	

}

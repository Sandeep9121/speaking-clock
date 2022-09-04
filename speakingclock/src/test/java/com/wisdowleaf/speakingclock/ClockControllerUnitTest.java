package com.wisdowleaf.speakingclock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.wisdowleaf.speakingclock.convert.ClockServiceImpl;
import com.wisdowleaf.speakingclock.convert.SpeakingClock;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SpeakingclockApplication.class)
public class ClockControllerUnitTest {
	
	@Autowired
	private ClockServiceImpl clockService;
	
	@Test
	public void  speakingClock_AM_Test() {
		String input="08:45";
		
		try {
			SpeakingClock  response =clockService.speakClock(input);
			assertNotNull(response);
			assertEquals(response.getStatusMessage(),"SUCCESS");
		
		}catch(Exception e) {
			fail("got Exeption");
		}
		  
		
	}
	
	@Test
	public void  speakingClock_PM_Test() {
		String input="zz:45";
	
		try {
			SpeakingClock  response =clockService.speakClock(input);
			assertNotNull(response);
			assertEquals(response.getStatusMessage(),"FAILURE");
		
		}catch(Exception e) {
			fail("got Exeption");
		}
		  
		
	}
	

}

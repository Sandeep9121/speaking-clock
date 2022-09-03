package com.wisdowleaf.speakingclock.convert;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Sandeep
 */
@RestController
public class ClockController {
	private IClockService clockService;

    @GetMapping("clock/{time}")
    public ResponseEntity<SpeakingClock> getById(@PathVariable String time) {
    	
    	   clockService.speakClock(time);

		return null;
    }
	
}

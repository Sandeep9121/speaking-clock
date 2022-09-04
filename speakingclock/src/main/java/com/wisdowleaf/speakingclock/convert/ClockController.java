package com.wisdowleaf.speakingclock.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Sandeep
 */
@RestController
public class ClockController {
	@Autowired
	private IClockService clockService;
	

    @GetMapping("clock")
    public ResponseEntity<SpeakingClock> getById(@RequestParam(required=true) String time) {
    
    	SpeakingClock words=  clockService.speakClock(time);

		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new SpeakingClock(words.getSpeakTime(),
						words.getSpeakDayTime(),words.getStatusMessage()));
    }
	
}

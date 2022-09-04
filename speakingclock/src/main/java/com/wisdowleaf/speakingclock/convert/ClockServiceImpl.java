package com.wisdowleaf.speakingclock.convert;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ClockServiceImpl implements IClockService{
  
	private static final String sRegex="^([0-1][0-9]|2[0-3]):?([0-5][0-9])$";
	private static final int max_hours=24 ,mid_hours=12, max_mins=60;
	private static String midNight ="its a MIDNIGHT",midDay="its a MIDDAY";
	
	
	
	@Override
	public  SpeakingClock speakClock(String digitalTime) {

		SpeakingClock speakingClock = new SpeakingClock();
		int hours, minutes = 0;
		boolean pm = false;

		StringJoiner clockSpeaker = new StringJoiner(" ","ITS ","");
		boolean valid=true;
		valid=validatePattern(digitalTime);
		if (valid) {
			String[] digitalList = digitalTime.split(":");

			hours = Integer.parseInt(digitalList[0]);
			minutes = Integer.parseInt(digitalList[1]);

			/******fetching hours ****/
			String day_night = "";
			if ( hours < max_hours) {

				/* setting midday-midnight */
				if (hours >= mid_hours && hours < mid_hours + 3) {
					day_night = midDay;
				} else if (hours == 0 && hours <= 2) {
					day_night = midNight;
				}

				if (hours > mid_hours && hours < max_hours) {
					int hours_pm = hours - 12;
					clockSpeaker.add(getWords(hours_pm));
					pm = true;

				} else if (hours != 0) {
					clockSpeaker.add(getWords(hours));
				} else {
					clockSpeaker.add(DigitToWords.TWELVE.toString());
				}

			}

			/********* fetching the minutes **********/

			if (minutes > 19 && minutes<max_mins) {
				int last = minutes % 10;
				int d_minutes = minutes - last;
				clockSpeaker.add(getWords(d_minutes));

				if (last != 0) {
					clockSpeaker.add(getWords(last));
				}
				
			} else if(minutes<=19){
				clockSpeaker.add(getWords(minutes));

			}
			String meridian = pm ? "PM" : "AM";

			clockSpeaker.add(meridian);

			speakingClock.setSpeakTime(clockSpeaker.toString());
			speakingClock.setSpeakDayTime(day_night);
			speakingClock.setStatusMessage("SUCCESS");
		}else {
			speakingClock.setStatusMessage("FAILURE");
			//LOG.ERROR 
			System.out.println("Wrong input #format hh:mm  limit hr:[00-12] min[00-59]"); 
			
		}
		//cannot use lombok my  system not taking ... used println sample check 
		System.out.println(clockSpeaker.toString());

		return speakingClock;
	}

	private static String getWords(int number) {
		try {
			return DigitToWords.stream().filter(d -> d.number == number).findFirst().get().toString();
		} catch (Exception e) {
			return "No Such Value";
		}

	}
	

	
	private static boolean validatePattern(String digitalTime) {
		try {
		Matcher matched =Pattern.compile(sRegex).matcher(digitalTime);
		return matched.matches();
		}catch(Exception e){
			return false ;
			
		}

		
	}
	
}

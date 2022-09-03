package com.wisdowleaf.speakingclock.convert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ClockServiceImpl implements IClockService{
  
	private static final String sRegex="^[0-9]{2}:[0-9]{2}$";
	private static final int max_hours=24,mid_hours=12, max_mins=60;
	
	
	
	@Override
	public SpeakingClock speakClock(String digitalTime) {
		// TODO Auto-generated method stub
		int hours ,minutes=0;
		String speakingHours=new String();
		    if(validatePattern(digitalTime)!=false){
		    	String []digitalList=digitalTime.split(":");

				 hours=Integer.parseInt(digitalList[0]);
				 minutes=Integer.parseInt(digitalList[1]);
				 /******fetching hours ****/
				 
				 if(minutes<max_hours && hours<max_mins) {
					
					 if(hours >mid_hours && hours<max_hours) {
						 int hours_pm=hours-12;
						speakingHours.concat(getOneToNineteenEnums(hours_pm));
					 }else if(hours!=0) {
						 speakingHours.concat(getOneToNineteenEnums(hours));
					 }else {
						 speakingHours.concat(OneToNineteen.TWELVE.toString());
						 }
					 
				 }
				 
				 /*********fetching the minutes **********/
				 
				 
		    	
		    }
		return null;
	}

	private static String getOneToNineteenEnums(int number) {
		return OneToNineteen.stream().filter(d->d.number ==number).findFirst().get().toString();

	}
	
	private static String getDoubleDigitEnums(int number) {
		return OneToNineteen.stream().filter(d->d.number ==number).findFirst().get().toString();

	}
	
	private static boolean validatePattern(String digitalTime) {
		Matcher matched =Pattern.compile(sRegex).matcher(digitalTime);
		if(matched.matches()==false) {
			System.out.println("regex");
		}

		return matched.matches();
	}
	
}

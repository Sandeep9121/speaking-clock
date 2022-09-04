package com.wisdowleaf.speakingclock.convert;

public class SpeakingClock  {
  
	

	private String SpeakTime;
	
	private  String speakDayTime;
	
	
	private  String statusMessage;
	public SpeakingClock() {
		
	}

	public SpeakingClock(String speakTime, String speakDayTime, String statusMessage) {
		super();
		SpeakTime = speakTime;
		this.speakDayTime = speakDayTime;
		this.statusMessage = statusMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getSpeakTime() {
		return SpeakTime;
	}

	public void setSpeakTime(String speakTime) {
		SpeakTime = speakTime;
	}

	public String getSpeakDayTime() {
		return speakDayTime;
	}

	public void setSpeakDayTime(String speakDayTime) {
		this.speakDayTime = speakDayTime;
	}



	
}

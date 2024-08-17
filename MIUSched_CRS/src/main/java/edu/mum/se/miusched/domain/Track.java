package edu.mum.se.miusched.domain;

public enum Track {
	MSD("MSD"), FPP("FPP"), MPP("MPP");

	private String trackName; 
	Track(String trackName) {
		this.trackName = trackName;
	}
	
	@Override
    public String toString(){
        return trackName;
    }
}

package com.domain;

public class Subject {
	
	private String title;
	private int checked; //0->false, 1->true
	
	public Subject(String title, int checked) {
		this.title = title;
		this.checked = checked;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}

}

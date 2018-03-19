package com.ttms.model;

public class Studio {
	
	private int studioId;

	private String studioName;
	private int studioRows;
	private int studioCols;
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public int getStudioId() {
		return studioId;
	}
	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}
	
	public int getStudioRows() {
		return studioRows;
	}
	public void setStudioRows(int studioRows) {
		this.studioRows = studioRows;
	}
	public int getStudioCols() {
		return studioCols;
	}
	public void setStudioCols(int studioCols) {
		this.studioCols = studioCols;
	}
	
}

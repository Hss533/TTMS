package com.ttms.model;

public class Studio {
	
	private int studioId;//演出厅ID
	private String studioName;//演出厅名称
	private int studioRows;//行数
	private int studioCols;//列数
	
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

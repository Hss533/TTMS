package com.ttms.model;

import java.math.BigDecimal;
import java.util.Date;

public class Play {
	private int playId;//�ݳ�ID
	private int movieId;//��ӰId
	private String movieName;//��Ӱ����
	private int studioId;//�ݳ���Id
	private String studioName;//�ݳ�������
	private Date startTime;//��ʼʱ��
	private Date endTime;//����ʱ��
	private BigDecimal ticketPrice;//Ʊ��
	private int ticketNums;//Ʊ��
	private int ticketSold;//����Ʊ��
	private int ticketStartNum;//Ʊ����ʼ����
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getStudioName() {
		return studioName;
	}
	public void setStudioName(String studioName) {
		this.studioName = studioName;
	}
	public int getPlayId() {
		return playId;
	}
	public void setPlayId(int playId) {
		this.playId = playId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getStudioId() {
		return studioId;
	}
	public void setStudioId(int studioId) {
		this.studioId = studioId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketNums() {
		return ticketNums;
	}
	public void setTicketNums(int ticketNums) {
		this.ticketNums = ticketNums;
	}
	public int getTicketSold() {
		return ticketSold;
	}
	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}
	public int getTicketStartNum() {
		return ticketStartNum;
	}
	public void setTicketStartNum(int ticketStartNum) {
		this.ticketStartNum = ticketStartNum;
	}
}

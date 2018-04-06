package com.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.ttms.model.User;
import com.ttms.util.DbUtil;
import com.ttms.view.SmallSeat;

public class SeatDao {
	
	DbUtil dbUtil=new DbUtil();
	private int [][] getseat;
	private Connection con;
	private int i;
	
	public SeatDao(int [][] getseat, Connection con) {
		this.getseat = getseat;
		this.con = con;
		this.i= i;
	}

	
	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public int addSeat(){
		
		int judge=0;
		con=dbUtil.getConnection();
		
		try {
			for (int[] is : getseat) {
				Statement stat=(Statement) con.createStatement();
				if(is[0]!=0 && is[1]!=0){
					String sql="insert into seat (seatRow,seatCol) value ("+is[0]+","+is[1]+")";
					stat.executeUpdate(sql);
					judge=1;
				}
					
			}
		} catch (SQLException e) {
			judge=0;
			System.out.println("¹ºÂòÊ§°Ü");
			e.printStackTrace();
		}
		return judge;
	}
}

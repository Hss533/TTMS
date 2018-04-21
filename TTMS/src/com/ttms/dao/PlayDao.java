package com.ttms.dao;

import com.ttms.model.*;
import com.ttms.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 演出管理
 * @author hu
 *
 */
public class PlayDao {
	
	//查询演出
	public List<Play> selectPlay(Connection con,String sql)
	{
		List<Play> list=new ArrayList<>();
		try{
			PreparedStatement ptmt=con.prepareStatement(sql);
			ResultSet res=ptmt.executeQuery();
			Play play=null;
			while(res.next())
			{
				play=new Play();
				play.setPlayId(res.getInt("playId"));
				play.setMovieId(res.getInt("movieId"));
				play.setMovieName(res.getString("movieName"));
				play.setStudioId(res.getInt("studioId"));
				play.setStudioName(res.getString("studioName"));
				play.setStartTime(res.getTimestamp("startTime"));
				play.setEndTime(res.getTimestamp("endTime"));
				play.setTicketPrice(res.getBigDecimal("ticketPrice"));
				play.setTicketNums(res.getInt("ticketNums"));
				play.setTicketSold(res.getInt("ticketSold"));
				play.setTicketStartNum(res.getInt("ticketStartNum"));
				list.add(play);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	//添加删除或者给修改演出
	public int addPlay(Connection con,String sql)
	{
		PreparedStatement ptmt;
		int resulet=0;
		try {
			ptmt = con.prepareStatement(sql);
			resulet=ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resulet; 
	}
}

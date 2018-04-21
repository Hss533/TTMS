package com.ttms.dao;

import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

import com.ttms.model.Studio;
import com.ttms.util.DbUtil;

public class StudioDao {
	
	DbUtil dbUtil=new DbUtil();
	/**
	 * 添加演出厅
	 */
	public int addStudio(Studio studio,Connection con)
	{
		String sql="insert into studio (studioId,studioRows,studioCols) values (?,?,?,?)";
		int num = 0;
		PreparedStatement ptmt=null;
		try{
			con.prepareStatement(sql);
			ptmt.setString(1,studio.getStudioName());
			ptmt.setInt(2,studio.getStudioRows());
			ptmt.setInt(3, studio.getStudioCols());
			num=ptmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * 删除演出厅
	 */
	public int removeStduio(Studio studio,Connection con){
		String sql="delete from studio where id=?";
		int num = 0;
		PreparedStatement ptmt=null;
		try{
			con.prepareStatement(sql);
			ptmt.setString(1,studio.getStudioName());
			ptmt.setInt(2,studio.getStudioRows());
			ptmt.setInt(3, studio.getStudioCols());
			num=ptmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * 修改演出厅
	 */
	public int modifyStudio(Studio studio,Connection con)
	{
		String sql="update from studio set stdioName=? , stdioRowsset studio";
		int num = 0;
		PreparedStatement ptmt=null;
		try{
			con.prepareStatement(sql);
			ptmt.setString(1,studio.getStudioName());
			ptmt.setInt(2,studio.getStudioRows());
			ptmt.setInt(3, studio.getStudioCols());
			num=ptmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return num;
	}
	/**
	 * 查询所有演出厅
	 */
	public List<Studio> allStudio(Connection con)
	{
		List<Studio> studioList=new ArrayList<>();
		String sql="select * from studio";
		PreparedStatement ptmt;
		ResultSet res=null;	
		try
		{
			Studio studio=new Studio();
			ptmt=con.prepareStatement(sql);
			res=ptmt.executeQuery();
			while(res.next())
			{
				studio.setStudioId(res.getInt("studioId"));
				studio.setStudioName(res.getString("studioName"));
				studio.setStudioRows(res.getInt("studioRows"));
				studio.setStudioCols(res.getInt("studioCols"));
				studioList.add(studio);
			}
		}
		catch(Exception e)
		{
			
		}
		return studioList;
	}
}

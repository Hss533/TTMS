package com.ttms.dao;

import java.sql.PreparedStatement;
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
		String sql="update from studio set stdioName=? ,set studio";
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
	public ResultSet allStudio(Studio studio,Connection)
	{
		
	}
}

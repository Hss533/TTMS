package com.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ttms.model.User;
import com.ttms.util.DbUtil;


public class UserDao {
	
	DbUtil dbUtil=new DbUtil();
	
	/**
	 * 注册用户
	 * 返回1表示注册成功
	 * 返回0表示注册失败
	 * 注册用户默认的为售票员
	 */
	public int addUser(User user,Connection con){
		
		int judge=0;
		con=dbUtil.getConnection();
		String sql="insert into user (userName,userPassword,userPower,userDesc) values (?,?,?,?)";
		try {
			
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1, user.getUserName());
			ptmt.setString(2, user.getUserPassword());
			ptmt.setInt(3, user.getUserPower());
			ptmt.setString(4,user.getUserDesc());
			ptmt.executeUpdate();
			judge=1;
			System.out.println("添加成功");
		} catch (SQLException e) {
			judge=0;
			System.out.println("添加失败");
			e.printStackTrace();
		}
		return judge;
	}
	/**
	 * 用户登录
	 * 该用户是否为管理员
	 * 
	 * */
	public int Login(User user,Connection con)
	{
		int userPower=-1;
		con=dbUtil.getConnection();
		String sql="select userPower from user where userName=? and userPassword=?";
		try{
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1,user.getUserName());
			ptmt.setString(2,user.getUserPassword());
			ResultSet res=ptmt.executeQuery();
			while(res.next())
			{
				userPower=res.getInt("userPower");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return userPower;
	}
	
	/**
	 * 查看用户名是否重复
	 * 如果返回值为1表示重复
	 * 如果返回值为0表示没有重复了
	 * */
	public int judges(User user,Connection con)
	{
		
		int judge=0;
		con=dbUtil.getConnection();
		String sql="select * from user where userName=?";
		try {
			PreparedStatement ptmt=con.prepareStatement(sql);
			ptmt.setString(1,user.getUserName());
			ResultSet res=ptmt.executeQuery();
			while(res.next())
			{
				judge=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;
	}

	
}
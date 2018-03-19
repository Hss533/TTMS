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
	 * ע���û�
	 * ����1��ʾע��ɹ�
	 * ����0��ʾע��ʧ��
	 * ע���û�Ĭ�ϵ�Ϊ��ƱԱ
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
			System.out.println("��ӳɹ�");
		} catch (SQLException e) {
			judge=0;
			System.out.println("���ʧ��");
			e.printStackTrace();
		}
		return judge;
	}
	/**
	 * �û���¼
	 * ���û��Ƿ�Ϊ����Ա
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
	 * �鿴�û����Ƿ��ظ�
	 * �������ֵΪ1��ʾ�ظ�
	 * �������ֵΪ0��ʾû���ظ���
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
package com.ttms.util;
import java.sql.*;

/**
 * ���ݿ�����
 * @author hu
 *
 */
public class DbUtil {
		private  String Url="jdbc:mysql://localhost:3306/ttms?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		private  String User="root";
		private  String Password="533533";
		public Connection getConnection()
		{
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("�ɹ��������ݿ�����");
				con=DriverManager.getConnection(Url,User,Password);
			}catch(ClassNotFoundException e)
			{
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			} catch (SQLException e) {
				
				System.out.println("���ݿ����ʧ��");
				e.printStackTrace();
			}
			return con;
		}
		
}


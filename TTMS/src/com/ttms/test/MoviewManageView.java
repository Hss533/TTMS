package com.ttms.test;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ttms.dao.*;
import com.ttms.model.Movie;
/**
 * ��Ӱ����
 * @author hu
 *
 */
import com.ttms.model.User;
import com.ttms.util.DbUtil;

public class MoviewManageView{ 
	
	DbUtil dbUtil=new DbUtil();
	MovieDao movieDao=new MovieDao();
	
	public static void main(String[] args) {
		
		MoviewManageView test=new MoviewManageView();
		test.moviwManage(null);
	}
	public void moviwManage(User user)
	{
		Connection con=dbUtil.getConnection();
		JFrame frame=new JFrame("��Ӱ����");
		
		String sql="select * from movie";
		List<Movie> movies=new ArrayList<>();
		movies=movieDao.movieList(con, sql);
		
		Object[][] movieInfo=new Object[movies.size()][5];
		
		for(int i=0;i<movies.size();i++)
		{
			movieInfo[i][0]=new Integer(movies.get(i).getMovieId());
			movieInfo[i][1]=new String(movies.get(i).getMovieName());
			movieInfo[i][2]=new String(movies.get(i).getMovieDesc());
			movieInfo[i][3]=new String(movies.get(i).getMovieImage());
			movieInfo[i][4]=new Integer(movies.get(i).getIsReleased());
			
		}
		String[] Names={"ӰƬID","ӰƬ����","ӰƬ����","ӰƬ����","�Ƿ�Ϊ������ӳ"};
		JTable  table= new JTable(movieInfo, Names);
		 // ���ô˱���ͼ����ѡ��С
	    table.setPreferredScrollableViewportSize(new Dimension(550, 100));
	    // �������뵽�����������
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    // �ٽ������������ӵ��м�������
	    frame.pack();
	    frame.setVisible(true);
	    
	    //���ӵ�Ӱ ��ɾ����Ӱ���޸ĵ�Ӱ
	    JButton buttonadd=new JButton("���ӵ�Ӱ");
	    JButton buttondelete=new JButton("ɾ����Ӱ");
	    JButton buttonmodify=new JButton("�޸ĵ�Ӱ");
	    
	    

	}
	
	
}

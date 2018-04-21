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
 * 电影管理
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
		JFrame frame=new JFrame("电影管理");
		
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
		String[] Names={"影片ID","影片名称","影片介绍","影片海报","是否为今日上映"};
		JTable  table= new JTable(movieInfo, Names);
		 // 设置此表视图的首选大小
	    table.setPreferredScrollableViewportSize(new Dimension(550, 100));
	    // 将表格加入到滚动条组件中
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	    // 再将滚动条组件添加到中间容器中
	    frame.pack();
	    frame.setVisible(true);
	    
	    //增加电影 ，删除电影，修改电影
	    JButton buttonadd=new JButton("增加电影");
	    JButton buttondelete=new JButton("删除电影");
	    JButton buttonmodify=new JButton("修改电影");
	    
	    

	}
	
	
}

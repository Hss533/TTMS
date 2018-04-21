package com.ttms.view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.ttms.dao.PlayDao;
import com.ttms.model.*;
import com.ttms.util.DbUtil;
import com.ttms.util.StringUtil;

public class PlayView {
	
	PlayDao playDao=new PlayDao();
	DbUtil dbUtil=new DbUtil();
	
	public static void main(String[] args) {
		PlayView test=new PlayView();
		Movie m=new Movie();
		m.setMovieId(1);
		test.showPlay(m);
	}
	/**
	 *
	 * 影片介绍有点问题换行问题
	 * @param movie
	 */
	public void showPlay(Movie movie)
	{
		String a="asdaddasdasdasdsdddddddddddddddddddddddd"+"<br>"
				+ "asdddddddddddddddddddddddddddddddd"
				+ "saddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "asdddddddddddddddddddddddddddddddddddddddddddddddddddddd"
				+ "gtttttttttttttttttttttsdvvaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvv";
		
		Connection con=dbUtil.getConnection();
		JFrame jFrame=new JFrame("选择影片场次");
		JPanel jPanel=new JPanel();
		JPanel jPanelText=new JPanel();
		jPanelText.add(new Label(a));
		
		String sql="select * from play where movieId="+movie.getMovieId()+" order by startTime";//根据时间排
		List<Play> list=new ArrayList<>();
		list=playDao.selectPlay(con, sql);

		JPanel[] jP=new JPanel[list.size()+1];
		JButton[] button=new JButton[list.size()];
		
		jP[0]=new JPanel();
		jP[0].setLayout(null);
		JLabel jLabel=new JLabel("<html>"+a+"</html>");
		jLabel.setSize(300,200);
		jP[0].add(jLabel);
		jP[0].setBorder(BorderFactory.createLineBorder(Color.red, 1));
		for(int i=0;i<list.size();i++)
		{
			int j=i+1;
			jP[j]=new JPanel();
			JLabel jLabelId=new JLabel("今日第"+j+"场");
			JLabel jLabelName=new JLabel(list.get(i).getMovieName());//电影名称
			JLabel jLabelTime=new JLabel(StringUtil.dateToString(list.get(i).getStartTime(),"yyyy-MM-dd hh:mm")+"-"+StringUtil.dateToString(list.get(i).getEndTime(),"yyyy-MM-dd:hh:mm"));//电影放映时间
			JLabel jLabelStudio=new JLabel(list.get(i).getStudioName());//电影放映厅
			JLabel jLabelTicketNums=new JLabel(list.get(i).getTicketSold()+"/"+list.get(i).getTicketNums());//已售票数和总票数
			JLabel jLabelPrice=new JLabel(list.get(i).getTicketPrice()+"RMB");//票价
			jP[j].add(jLabelId);
			jP[j].add(jLabelName);
			jP[j].add(jLabelTime);
			jP[j].add(jLabelStudio);
			jP[j].add(jLabelTicketNums);
			jP[j].add(jLabelPrice);
			button[i]=new JButton("选择该场次");//添加按钮
			button[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						//选择票 ahhhhh
				}
			});
			jP[j].setBorder(BorderFactory.createLineBorder(Color.red, 1));
			jP[j].add(button[i]);
		}
		//这个应该是覆盖了  所以 
		for(int i=0;i<list.size();i++)
		{
			jPanel.add(jP[i]);
			
		}
		jPanel.setLayout(new GridLayout(list.size(),1,10, 10));
		jFrame.add(jPanel);	
		jFrame.setSize(1000, 1000);
		jFrame.setLocation(400, 50);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(true);  //Resizable:可调整大小的
	}
}

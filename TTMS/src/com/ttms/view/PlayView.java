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
	 * ӰƬ�����е����⻻������
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
		JFrame jFrame=new JFrame("ѡ��ӰƬ����");
		JPanel jPanel=new JPanel();
		JPanel jPanelText=new JPanel();
		jPanelText.add(new Label(a));
		
		String sql="select * from play where movieId="+movie.getMovieId()+" order by startTime";//����ʱ����
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
			JLabel jLabelId=new JLabel("���յ�"+j+"��");
			JLabel jLabelName=new JLabel(list.get(i).getMovieName());//��Ӱ����
			JLabel jLabelTime=new JLabel(StringUtil.dateToString(list.get(i).getStartTime(),"yyyy-MM-dd hh:mm")+"-"+StringUtil.dateToString(list.get(i).getEndTime(),"yyyy-MM-dd:hh:mm"));//��Ӱ��ӳʱ��
			JLabel jLabelStudio=new JLabel(list.get(i).getStudioName());//��Ӱ��ӳ��
			JLabel jLabelTicketNums=new JLabel(list.get(i).getTicketSold()+"/"+list.get(i).getTicketNums());//����Ʊ������Ʊ��
			JLabel jLabelPrice=new JLabel(list.get(i).getTicketPrice()+"RMB");//Ʊ��
			jP[j].add(jLabelId);
			jP[j].add(jLabelName);
			jP[j].add(jLabelTime);
			jP[j].add(jLabelStudio);
			jP[j].add(jLabelTicketNums);
			jP[j].add(jLabelPrice);
			button[i]=new JButton("ѡ��ó���");//��Ӱ�ť
			button[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						//ѡ��Ʊ ahhhhh
				}
			});
			jP[j].setBorder(BorderFactory.createLineBorder(Color.red, 1));
			jP[j].add(button[i]);
		}
		//���Ӧ���Ǹ�����  ���� 
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
		jFrame.setResizable(true);  //Resizable:�ɵ�����С��
	}
}

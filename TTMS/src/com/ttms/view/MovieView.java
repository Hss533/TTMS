package com.ttms.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ttms.dao.MovieDao;
import com.ttms.model.Movie;
import com.ttms.model.User;
import com.ttms.util.DbUtil;
import com.ttms.dao.*;

public class MovieView extends JFrame{
		
		DbUtil db=new DbUtil();
		MovieDao movieDao=new MovieDao();
		public static void main(String[] args) {
				MovieView test=new MovieView();
				test.showMoview(null);
		}
		//��ʾ���еĵ�Ӱ
		public void showMoview(User user)
		{
			JFrame jf=new JFrame("��Ӱ���");
			Connection con=db.getConnection();
			
			String sql="select * from movie where isReleased=1";
			List<Movie> list=new ArrayList<>();
			list=movieDao.movieList(con, sql);
			
			 int size = list.size(); 
			 JPanel jPanel[] = new JPanel[size];
			 JButton button[]=new JButton[size];
			//�������
	        for(int i = 0; i<size; i++){
	        	
	        	//ͼƬ·��
	        	String string="src/image/"+list.get(i).getMovieImage();
	        	//��ӵ�ӰͼƬ
	        	jPanel[i] = new JPanel(){
	        		protected void paintComponent(Graphics g) {
	   				 
					    ImageIcon icon = new ImageIcon(string);
					    Image img = icon.getImage();
					    g.drawImage(img, 10, 10,icon.getIconWidth(),
					      icon.getIconHeight(), icon.getImageObserver());
					    //this.setSize(icon.getIconWidth()-20, icon.getIconHeight());
					   }
	        	};
	        	/*
	        	jPanel[i].add(new JLabel(list.get(i).getMovieName()));
	        	jPanel[i].setBorder(BorderFactory.createLineBorder(Color.red, 1));
	        	*/
	        	
	        	//���һ����ť
	        	button[i]=new JButton(list.get(i).getMovieName());
	        	button[i].setBackground(Color.WHITE);
	        	button[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
							//ѡ��Ʊ�ͳ���
					}
				});
	        	
	        }
	       
	        //�������������������
	        for(int i = 0; i<size; i++){
	            this.add(jPanel[i]);
	            jPanel[i].add(button[i]);
	        }
	        
	        //�������񲼾�
	        this.setLayout(new GridLayout(3, 3, 10, 10));
	        
	        //���ô�������
	        this.setTitle("��Ӱ���");
	        this.setSize(1000, 1000);
	        this.setLocation(400, 50);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(true);  //Resizable:�ɵ�����С��
			
		}
}

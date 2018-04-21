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
		//显示所有的电影
		public void showMoview(User user)
		{
			JFrame jf=new JFrame("电影浏览");
			Connection con=db.getConnection();
			
			String sql="select * from movie where isReleased=1";
			List<Movie> list=new ArrayList<>();
			list=movieDao.movieList(con, sql);
			
			 int size = list.size(); 
			 JPanel jPanel[] = new JPanel[size];
			 JButton button[]=new JButton[size];
			//创建组件
	        for(int i = 0; i<size; i++){
	        	
	        	//图片路径
	        	String string="src/image/"+list.get(i).getMovieImage();
	        	//添加电影图片
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
	        	
	        	//添加一个按钮
	        	button[i]=new JButton(list.get(i).getMovieName());
	        	button[i].setBackground(Color.WHITE);
	        	button[i].addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
					
							//选择票和场次
					}
				});
	        	
	        }
	       
	        //在面板上添加组件添加组件
	        for(int i = 0; i<size; i++){
	            this.add(jPanel[i]);
	            jPanel[i].add(button[i]);
	        }
	        
	        //设置网格布局
	        this.setLayout(new GridLayout(3, 3, 10, 10));
	        
	        //设置窗格属性
	        this.setTitle("电影浏览");
	        this.setSize(1000, 1000);
	        this.setLocation(400, 50);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(true);  //Resizable:可调整大小的
			
		}
}

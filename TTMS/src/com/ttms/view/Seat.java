package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;
import com.ttms.dao.SeatDao;
import com.ttms.util.DbUtil;


public class Seat{
		
		static SmallSeat[] Seat1s = new SmallSeat[226];  // 座位 15行 X 15列
		private JLabel label1;	// “请选择座位”标签
		private static JPanel text1; // 选中座位的标签
		private JLabel label2 ;  //“总计”标签
		private static JTextArea text2; // 金额数量显示
		private JButton button1;  //“确定” 按钮
		private static int num;  //选中数量
		private JLabel label3;   // "巨幕" 标签
		String[] numS = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};  
		private static int getseat[][]; //已选中座位的数组
		
		DbUtil dbUtil=new DbUtil();
		private Connection con;

		
		public Seat() {
			num = 0;
			label1 = new JLabel("所选择的座位：");
			text1 = new JPanel();
			label2 = new JLabel("总计：");
			text2 = new JTextArea(8,8);
			button1 = new JButton("确定");
			label3 = new JLabel("巨  幕");
			getseat = new int[15][3];
			
		}

		public int getnum(){
			return num;
		}
		
		public static JPanel getText1() {
			return text1;
		}

		public static SmallSeat[] getSeat1s() {
			return Seat1s;
		}

		public static void setSeat1s(SmallSeat[] seat1s) {
			Seat1s = seat1s;
		}
		
		/*
		 * 将确定选择的座位存放进getSeat数组中
		 */
		public static void setGetseat(int row,int col) {
			getseat[num][0] = row;
			getseat[num][1] = col;
		}
		
		/*
		 * 将放弃选择的座位从getSeat数组中删除
		 */
		public static void delGetseat(int row,int col){
			for (int[] is : getseat) {
				if(is[0]==row && is[1]==col)
					{
						is[0] = 0;
						is[1] = 0;
					}
			}
		}
		
		public static int[][] getGetseat() {
			return getseat;
		}

		
		/* 
		 *  计算金额 
		 *  numof() 增加
		 *	numoff() 减少	
		 */
		public static void numof(){
			num++;
			text2.setText(num*10 +"元");
		}
		
		public static void numoff(){
			num--;
			text2.setText(num*10 +"元");
		}
	
		
		/*
		 *  panel中设置15X15布局
		 *  构造出座位
		 *  构造出座位
		 */
		public JPanel builtBoxs() throws SQLException{
			
			con = dbUtil.getConnection();
			Statement stat=(Statement) con.createStatement();
			String sql = "select *from seat";
			
			
			JPanel panel = new JPanel(); //存放位置的panel
			panel.setLayout(new GridLayout(15, 15));   
			panel.setBorder(BorderFactory.createEmptyBorder(25, 10, 10,10));
			int row,col;
			for (int i = 1; i < 226; i++) { 
				
	        	if(i%15 != 0)
	        	{
	        		Seat1s[i] = new SmallSeat("第"+(i/15+1)+"排"+"第"+i%15+"个",(i/15+1),i%15);
	        		row = i/15+1;
	        		col = i%15;
	        	}
	        		
	            else
	            	{
	            		Seat1s[i] = new SmallSeat("第"+i/15+"排"+"第15个",15,i/15); 	
	            		row = 15;
	            		col = i/15;
	            	}
	        	ResultSet rec = stat.executeQuery(sql);
	        	while(rec.next())
				{
					if(rec.getInt("seatRow") == row && rec.getInt("seatCol" )==col){
						Seat1s[i] = new SmallSeat("第"+row+"排"+"第"+col+"个",row,col,true);
					}
				}

	            panel.add(Seat1s[i].getBox());           
	        }
			
			return panel;
		}
		
		/*
		 * 将 每排的名字添加进去
		 */
		public JPanel addname(){	
			
			  JPanel namePanel = new JPanel();
			  
		        namePanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 10, 10));
		        namePanel.setLayout(new GridLayout(15, 15) );
		        for(int i = 0; i<15;i++)
		        	namePanel.add(new Label(numS[i]));
		        
		        return namePanel;
		        
		}
		
		/*
		 * 修改label的信息
		 */
		public JLabel altLabel(){
			 label3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		        label3.setBounds(10, 10, 2, 2);
		        label3.setHorizontalAlignment(SwingConstants.CENTER);      
		        return label3;
		}
			
		/*
		 *  添加和设置选中位置的标签栏
		 */
		public JScrollPane setNameLabel(){	
			JPanel panel5 = new JPanel();

			JScrollPane scroller = new JScrollPane(panel5);
			scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	

			panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
			panel5.add(text1);
			
			return scroller;
	
		}
		
		public void go(){
			JFrame frame = new JFrame();
			
			text1.setLayout(new BoxLayout(text1,BoxLayout.Y_AXIS));

	        JPanel panel1 = new JPanel();
	        JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			

			panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
			
			panel2.add(label1); 
			panel2.add(new JPanel());
			
			panel2.add(setNameLabel());
			
			panel3.add(label2);
			panel3.add(text2);
			panel3.add(button1);
			
			panel1.add(panel2);
			panel1.add(panel4);
			panel1.add(panel3);
			
			button1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
//					for (int[] is : getseat) {
//						System.out.println(is[0]+","+is[1]);
//					}
					
					Connection con = null;
					SeatDao sd = new SeatDao(getseat,con);
					if(sd.addSeat()==1){
						System.out.println("购买成功！");
						frame.dispose();	
//						 JButton j = new JButton("购买成功！");
//						j.setVisible(true);
					}
					
					else 
						System.out.println("购买失败！");
				}
		
			});
			
			frame.setBounds(675, 200, 500, 500);
			frame.getContentPane().add(altLabel(), BorderLayout.NORTH);
			frame.getContentPane().add(addname(), BorderLayout.WEST);
			frame.getContentPane().add(panel1, BorderLayout.EAST);
			try {
				frame.getContentPane().add( BorderLayout.CENTER,builtBoxs());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			frame.setSize(500,500);
			frame.setVisible(true);
		}
	
	}
		
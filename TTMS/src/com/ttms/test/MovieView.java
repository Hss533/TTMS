package com.ttms.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MovieView extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieView frame = new MovieView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MovieView() {
		setResizable(false);
		setTitle("\u5F71\u7247");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(370, 150, 1221, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel(){
			
			 protected void paintComponent(Graphics g) {
				 
				    ImageIcon icon = new ImageIcon("src/image/film1.jpg");
				    Image img = icon.getImage();
				    g.drawImage(img, 0, 0, icon.getIconWidth(),
				      icon.getIconHeight(), icon.getImageObserver());
				    this.setSize(icon.getIconWidth(), icon.getIconHeight());
				   }
		};
		
		JPanel panel_1 = new JPanel(){
			
			 protected void paintComponent(Graphics g) {
				 
				    ImageIcon icon = new ImageIcon("src/image/film0.jpg");
				    Image img = icon.getImage();
				    g.drawImage(img, 0, 0, icon.getIconWidth(),
				      icon.getIconHeight(), icon.getImageObserver());
				    this.setSize(icon.getIconWidth(), icon.getIconHeight());
				   }
		};
		
		JPanel panel_2 = new JPanel(){
			protected void paintComponent(Graphics g) {
				 
			    ImageIcon icon = new ImageIcon("src/image/film2.jpg");
			    Image img = icon.getImage();
			    g.drawImage(img, 0, 0, icon.getIconWidth(),
			      icon.getIconHeight(), icon.getImageObserver());
			    this.setSize(icon.getIconWidth(), icon.getIconHeight());
			   }
		};
		
		JPanel panel_3 = new JPanel(){
			protected void paintComponent(Graphics g) {
				 
			    ImageIcon icon = new ImageIcon("src/image/film8.jpg");
			    Image img = icon.getImage();
			    g.drawImage(img, 0, 0, icon.getIconWidth(),
			      icon.getIconHeight(), icon.getImageObserver());
			    this.setSize(icon.getIconWidth(), icon.getIconHeight());
			   }
		};
		
		JPanel panel_4 = new JPanel(){
			protected void paintComponent(Graphics g) {
				 
			    ImageIcon icon = new ImageIcon("src/image/film7.jpg");
			    Image img = icon.getImage();
			    g.drawImage(img, 0, 0, icon.getIconWidth(),
			      icon.getIconHeight(), icon.getImageObserver());
			    this.setSize(icon.getIconWidth(), icon.getIconHeight());
			   }
		};
		
		JButton btnNewButton = new JButton("choose");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				choosefilm(e);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u4ECA \u65E5 \u70ED \u6620");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel label = new JLabel("\u4E09\u5757\u5E7F\u544A\u724C");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u6349\u5996\u8BB0");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u6C34\u5F62\u7269\u8BED");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("\u9EC4\u91D1\u65F6\u4EE3");
		label_3.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_4 = new JLabel("\u6C34\u679C\u786C\u7CD6");
		label_4.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton btnChoose = new JButton("choose");
		JButton btnChoose_1 = new JButton("choose");
		JButton btnChoose_2 = new JButton("choose");
		JButton btnChoose_3 = new JButton("choose");
		btnChoose.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				choosefilm(e);
			}
		});
		btnChoose_1.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				choosefilm(e);
			}
		});
		btnChoose_2.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				choosefilm(e);
			}
		});
		btnChoose_3.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				choosefilm(e);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(106)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnChoose, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(114)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChoose_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChoose_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addGap(104)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnChoose_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addGap(80))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
					.addGap(109)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnChoose)
						.addComponent(btnChoose_1)
						.addComponent(btnChoose_2)
						.addComponent(btnChoose_3))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void choosefilm(ActionEvent event)
	{
		new PlayView().setVisible(true);
	}
}

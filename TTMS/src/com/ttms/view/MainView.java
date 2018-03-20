package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setTitle("\u5F52\u674E\u4EAE\u7684\u7238\u7238\u4EEC\u7968\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 100, 1126, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel(){
			protected void paintComponent(Graphics g) {
				 
			    ImageIcon icon = new ImageIcon("src/icon/buy.png");
			    Image img = icon.getImage();
			    g.drawImage(img, 0, 0, icon.getIconWidth(),
			      icon.getIconHeight(), icon.getImageObserver());
			    this.setSize(icon.getIconWidth(), icon.getIconHeight());
			   }
		};
		panel1.setBackground(new Color(255, 228, 225));
		
		JButton btnNewButton = new JButton("\u8D2D\u7968");
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		btnNewButton.setBackground(new Color(255, 228, 225));
		
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				  ImageIcon icon = new ImageIcon("src/icon/managers.png");
				    Image img = icon.getImage();
				    g.drawImage(img, 0, 0, icon.getIconWidth(),
				      icon.getIconHeight(), icon.getImageObserver());
				    this.setSize(icon.getIconWidth(), icon.getIconHeight());
			}
		};
		panel.setBackground(new Color(255, 228, 225));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 82, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 92, Short.MAX_VALUE)
				.addGap(0, 92, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JButton button = new JButton("\u7BA1\u7406");
		button.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		button.setBackground(new Color(255, 228, 225));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(274)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(474, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGap(88))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(484)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(488)
					.addComponent(btnNewButton)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 277, Short.MAX_VALUE)
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 129, Short.MAX_VALUE)
		);
		panel1.setLayout(gl_panel1);
		contentPane.setLayout(gl_contentPane);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				buyfilmticket(e);
			}

			
		});
	}
	private void buyfilmticket(ActionEvent e) {
		new MovieView().setVisible(true);
	}
}

package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class PlayView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayView frame = new PlayView();
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
	public PlayView() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("\u7535\u5F71\u8BE6\u60C5");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(700, 120, 465, 633);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u653E \u6620 \u65F6 \u6BB5");
		label.setFont(new Font("黑体", Font.PLAIN, 24));
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(255, 228, 225));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		
		JLabel label_1 = new JLabel("\u6349 \u5996 \u8BB0");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u4E00\u53F7\u653E\u6620\u5385");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_4 = new JLabel("8:00-10:00");
		label_4.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton button = new JButton("\u9009\u62E9");
		button.setBackground(new Color(255, 228, 225));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 434, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(24)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(33)))
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addComponent(label_1))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		
		JLabel label_5 = new JLabel("\u6349 \u5996 \u8BB0");
		label_5.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_6 = new JLabel("\u4E00\u53F7\u653E\u6620\u5385");
		label_6.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_7 = new JLabel("8:00-10:00");
		label_7.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton button_1 = new JButton("\u9009\u62E9");
		button_1.setBackground(new Color(255, 228, 225));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 434, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(24)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(33)))
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 146, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addComponent(label_5))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(31)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		JButton btnNewButton = new JButton("\u9009\u62E9");
		btnNewButton.setBackground(new Color(255, 228, 225));
		
		JLabel lblNewLabel = new JLabel("\u6349 \u5996 \u8BB0");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("\u4E00\u53F7\u653E\u6620\u5385");
		label_3.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_8 = new JLabel("8:00-10:00");
		label_8.setFont(new Font("黑体", Font.PLAIN, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addGap(33)))
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addComponent(lblNewLabel))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				chooseseats(e);
			}

			
		});
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				chooseseats(e);
			}

		});
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				chooseseats(e);
			}

		});

	}
	private void chooseseats(ActionEvent e) {
		Seat a = new Seat();
		a.go();
	}
}

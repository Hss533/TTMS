package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class ManageChoose extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageChoose frame = new ManageChoose();
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
	public ManageChoose() {
		setTitle("\u7BA1\u7406\u9009\u62E9");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(600, 100, 474, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6F14\u51FA\u5385\u7BA1\u7406");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label = new JLabel("\u6F14\u51FA\u7BA1\u7406");
		label.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("\u7968\u52A1\u7BA1\u7406");
		label_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7BA1\u7406");
		label_2.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton btnChoose = new JButton("choose");
		btnChoose.setBackground(new Color(255, 228, 225));
		
		JButton button = new JButton("choose");
		button.setBackground(new Color(255, 228, 225));
		
		JButton button_1 = new JButton("choose");
		button_1.setBackground(new Color(255, 228, 225));
		
		JButton button_2 = new JButton("choose");
		button_2.setBackground(new Color(255, 228, 225));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChoose)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnChoose))
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(99)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2))
					.addGap(85))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

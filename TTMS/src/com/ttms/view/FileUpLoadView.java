package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FileUpLoadView extends JFrame {

	private JPanel contentPane;
	private JFileChooser  fc ;
	private String path;
/*
	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileUpLoadView frame = new FileUpLoadView();
					frame.fileUpLoadView();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * Create the frame.
	 */
	public String[] fileUpLoadView() {
		
		String[] filepath=new String[2];
		setTitle("\u6587\u4EF6\u4E0A\u4F20");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 513);
		contentPane = new JPanel();
		contentPane.setVisible(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		fc  = new JFileChooser ();	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(fc , GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(fc , Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		fc.setMultiSelectionEnabled(false);             //设为多选  
		int returnVal = fc.showOpenDialog(new JButton());        //是否打开文件选择框  
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{//如果符合文件类型  
			  
			 filepath[0] = fc.getSelectedFile().getAbsolutePath();      //获取绝对路径  
			 filepath[1]=fc.getSelectedFile().getName();//输出相对路径
			 
		} 
		return filepath;
	}
}

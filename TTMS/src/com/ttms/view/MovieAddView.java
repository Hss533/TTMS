package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ttms.dao.MovieDao;
import com.ttms.util.DbUtil;
import com.ttms.util.FileUpload;
import com.ttms.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class MovieAddView extends JFrame {

	private JPanel contentPane;
	private JTextField movieNameTextField;
	private JTextField movieImageTextField;
	private JTextArea movieDescTextArea;
	private JComboBox idReleasedComboBox; 
	private String[] filePaths=new String[2];
	
	FileUpLoadView fileUpLoadView=new FileUpLoadView();
	MovieDao movieDao=new MovieDao();
	DbUtil dbUtil=new DbUtil();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieAddView frame = new MovieAddView();
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
	public MovieAddView() {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(400, 50, 857, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u7535\u5F71");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel movieNameJL = new JLabel("\u7535\u5F71\u540D\u79F0");
		movieNameJL.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("\u6DFB\u52A0\u7535\u5F71");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel movieImageJL = new JLabel("\u6DFB\u52A0\u7535\u5F71\u6D77\u62A5");
		movieImageJL.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel isReleasedJL = new JLabel("\u662F\u5426\u4ECA\u65E5\u4E0A\u6620");
		isReleasedJL.setFont(new Font("黑体", Font.BOLD, 20));
		
		movieNameTextField = new JTextField();
		movieNameTextField.setColumns(10);
		
		movieImageTextField = new JTextField();
		movieImageTextField.setColumns(10);
		movieImageTextField.setEditable(false);
		
		movieDescTextArea = new JTextArea();
		
		JButton movieImageButton = new JButton("\u6D4F\u89C8\u6587\u4EF6");
		movieImageButton.setBackground(Color.WHITE);
		movieImageButton.setFont(new Font("黑体", Font.BOLD, 15));
		movieImageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				filePaths=fileUpLoadView.fileUpLoadView();
				movieImageTextField.setText(filePaths[1]);
			}
		});
		
		
		idReleasedComboBox = new JComboBox();
		idReleasedComboBox.setBackground(Color.WHITE);
		
		JButton cancelButton = new JButton("\u9000\u51FA");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		JButton reSetButton = new JButton("\u91CD\u7F6E");
		reSetButton.setBackground(Color.WHITE);
		reSetButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		JButton OKButton = new JButton("\u786E\u5B9A");
		OKButton.setBackground(Color.WHITE);
		OKButton.setFont(new Font("黑体", Font.BOLD, 20));
		OKButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addMoviePorformedAction(e);
			}

			
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(88)
							.addComponent(cancelButton)
							.addGap(198)
							.addComponent(reSetButton)
							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
							.addComponent(OKButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(107, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(movieDescTextArea, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(movieImageJL, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(movieImageTextField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(movieImageButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(movieNameJL, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(movieNameTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(isReleasedJL, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idReleasedComboBox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(movieNameJL, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(isReleasedJL, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(idReleasedComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(movieImageJL, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieImageTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieImageButton))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieDescTextArea, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cancelButton)
						.addComponent(OKButton)
						.addComponent(reSetButton))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
		this.fillMovie();
	}
	private void addMoviePorformedAction(ActionEvent e) 
	{
		
		String movieName=movieNameTextField.getText();//电影名称
		String movieImage=movieImageTextField.getText();//海报
		String movieDesc=movieDescTextArea.getText();//介绍
		String isReleased=(String)this.idReleasedComboBox.getSelectedItem();
		int isReleasedNum=0;
		if("否".equals(isReleased))
		{
			isReleasedNum=0;
		}
		if("是".equals(isReleased))
		{
			isReleasedNum=1;
		}
		String sql="insert into movie values (null,'"+movieName+"','"+movieDesc+"','"+movieImage+"',"+isReleasedNum+" )";
		System.out.println(sql);
		if(filePaths!=null)
		{
			String fileSourse=filePaths[0].replaceAll("\\\\", "/");
			String fileItem="src/image/"+filePaths[1];
			System.out.println(filePaths[0].replaceAll("\\\\", "/")  +" \n"+fileItem);
			FileUpload.copyFile(fileSourse,fileItem);
		}
		if(StringUtil.isEmpty(movieName))
		{
			JOptionPane.showMessageDialog(null, "未填写电影名称");
		}
		
		if(filePaths==null)
		{
			JOptionPane.showMessageDialog(null, "未添加图片");
		}
		//添加电影
		Connection con=dbUtil.getConnection();
		int result=movieDao.admMovie(con, sql);
		if(result==1)
		{
			JOptionPane.showMessageDialog(null, "添加成功");
		}
		else{
			JOptionPane.showMessageDialog(null, "添加失败");
		}
		
	}
	private void fillMovie() 
	{
			this.idReleasedComboBox.addItem("是");
			this.idReleasedComboBox.addItem("否");
	}
}

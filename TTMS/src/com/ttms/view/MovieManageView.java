package com.ttms.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import com.ttms.dao.MovieDao;
import com.ttms.model.Movie;
import com.ttms.util.DbUtil;
import com.ttms.util.FileUpload;
import com.ttms.util.StringUtil;


public class MovieManageView extends JFrame {

	private JPanel contentPane;
	private JTextField movieIdTextField;
	private JTextField movieNameTextField;
	private JTextField textField_3;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JTextArea movieDescTextArea;
	private JTable table;
	private JTextField movieImageTextField;
	String[] filePaths;
	DbUtil dbUtil=new DbUtil();
	MovieDao dao=new MovieDao();
	FileUpLoadView fileUpLoadView=new FileUpLoadView();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("ok test");
					MovieManageView frame = new MovieManageView();
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
	public MovieManageView() {
		setTitle("\u7535\u5F71\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JButton button = new JButton("\u6DFB\u52A0\u7535\u5F71");
		button.setFont(new Font("黑体", Font.BOLD, 20));
		button.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setFont(new Font("黑体", Font.BOLD, 20));
		button_1.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, 682, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 346, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me)
			{
				movieTableMousePresses(me);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7535\u5F71Id", "\u7535\u5F71\u540D\u79F0", "\u7535\u5F71\u7B80\u4ECB", "\u7535\u5F71\u6D77\u62A5\u540D\u79F0", "\u7535\u5F71\u662F\u5426\u4ECA\u65E5\u4E0A\u6620"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(112);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		String sql="select * from movie";		
		this.fillTable(sql);
		
		
		JLabel lblNewLabel_1 = new JLabel("\u7535\u5F71ID");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 20));
		
		movieIdTextField = new JTextField();
		movieIdTextField.setColumns(10);
		movieIdTextField.setEditable(false);
		
		movieNameTextField = new JTextField();
		movieNameTextField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		
		movieDescTextArea = new JTextArea();
		movieDescTextArea.setLineWrap(true);
		
		JLabel label = new JLabel("\u7535\u5F71\u540D\u79F0");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("\u662F\u5426\u4E3A\u4ECA\u65E5\u4E0A\u6620");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u7535\u5F71\u6D77\u62A5");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("\u7535\u5F71\u7B80\u4ECB");
		label_3.setFont(new Font("黑体", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				movieDeleteActionPerformed(e);
			}
		});
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				movieUpdateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u6D4F\u89C8\u6587\u4EF6");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				filePaths=fileUpLoadView.fileUpLoadView();
				movieImageTextField.setText(filePaths[1]);
				
			}
		});
		
		movieImageTextField = new JTextField();
		movieImageTextField.setColumns(10);
		movieImageTextField.setEditable(false);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(47)
									.addComponent(btnNewButton_2)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addComponent(movieIdTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
													.addGap(194))
												.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
													.addComponent(movieImageTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
													.addGap(26)
													.addComponent(btnNewButton_1)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_1.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_1.createSequentialGroup()
													.addGap(3)
													.addComponent(movieNameTextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))))
										.addComponent(movieDescTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_3)
									.addGap(23))))
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(movieIdTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieNameTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieImageTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(movieDescTextArea, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(139))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u7535\u5F71\u540D\u79F0");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				movieSearchActionPerformed(e);
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		comboBox_1= new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_6 = new JLabel("\u662F\u5426\u662F\u4ECA\u65E5\u4E0A\u6620");
		lblNewLabel_6.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("\u67E5\u8BE2\u7535\u5F71");
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(100)
					.addComponent(btnNewButton)
					.addGap(74))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addContainerGap(850, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		this.fillMovie("search");
		this.fillMovie("modify");
		
	}

	/**
	 * 表格点击事件
	 * @param me
	 */
	protected void movieTableMousePresses(MouseEvent me) {
		
		int row=this.table.getSelectedRow();//获得点击的行数
		this.movieIdTextField.setText(table.getValueAt(row, 0)+"");
		this.movieNameTextField.setText((String)table.getValueAt(row, 1));
		this.movieDescTextArea.setText((String)table.getValueAt(row, 2));
		this.movieImageTextField.setText((String)table.getValueAt(row, 3));
		String isReleased=""+table.getValueAt(row, 4);
		if("1".equals(isReleased))
		{
			isReleased="是";
		}else if("0".equals(isReleased)){
			isReleased="否";
		}
		int n=this.comboBox.getItemCount();
		String j=null;
		for(int i=0;i<n;i++)
		{
			j=(String) this.comboBox.getItemAt(i);
			if(j.equals(isReleased))
			{
				this.comboBox.setSelectedIndex(i);
			}
		}
		
	}

	/**
	 * 修改电影事件
	 * @param e
	 */
	private void movieUpdateActionPerformed(ActionEvent e) {
		
		String movieName=movieNameTextField.getText();
		String movieDesc=movieDescTextArea.getText();
		String movieId=movieIdTextField.getText();
		String movieImage=movieImageTextField.getText();
		String isReleased=(String)this.comboBox.getSelectedItem();
		int isRe=0;
		if("否".equals(isReleased))
		{
			isRe=0;
		}
		if("是".equals(isReleased))
		{
			isRe=1;
		}
		StringBuffer sql=new StringBuffer("update movie set movieName='"+movieName+"' , movieDesc='"+movieDesc+""
				+ "' , movieImage= '"+movieImage+"', isReleased="+isRe+"  where movieId="+movieId);
		System.out.println(sql.toString());
		Connection con=dbUtil.getConnection();
		//上传文件
		if(filePaths!=null)
		{
			String fileSourse=filePaths[0].replaceAll("\\\\", "/");
			String fileItem="src/image/"+filePaths[1];
			System.out.println(filePaths[0].replaceAll("\\\\", "/")  +" \n"+fileItem);
			FileUpload.copyFile(fileSourse,fileItem);
		}
		int result=dao.admMovie(con, sql.toString());
		if(result==1)
		{
			JOptionPane.showMessageDialog(null, "修改成功");
			this.resetValue();
			this.fillTable("select * from movie");//进行刷新
		}
	}

	/**
	 * 删除电影事件
	 * @param e
	 */
	private void movieDeleteActionPerformed(ActionEvent e)
	{
		String movieId=movieIdTextField.getText();
		if(StringUtil.isEmpty(movieId))
		{
			JOptionPane.showMessageDialog(null, "请选择要删除的电影");
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要进行删除操作么？");
		if(n==0)
		{
			Connection con=dbUtil.getConnection();
			String sql="delete from movie where movieID="+movieId;
			int result=dao.admMovie(con, sql);
			if(result==1)
			{
				JOptionPane.showMessageDialog(null, "删除成功");
				this.fillTable("select * from movie");//刷新表格
				this.resetValue();//重置下面的表单
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}
		
	}
	/**
	 * 初始化下拉菜单
	 * @param string
	 */
	private void fillMovie(String string) {
		
		/**
		 * 如果是search的话需要添加一个请选择的下拉框
		 * 如果是modify的话不用加此下拉框
		 */
		if("search".equals(string))
		{
			this.comboBox_1.addItem("请选择");
			this.comboBox_1.addItem("是");
			this.comboBox_1.addItem("否");
		}
		if("modify".equals(string))
		{
			this.comboBox.addItem("是");
			this.comboBox.addItem("否");
		}
	}

	/**
	 * 搜索
	 * @param e
	 */
	private  void movieSearchActionPerformed(ActionEvent e) {
		
		StringBuffer sql=new StringBuffer("select * from movie");
		String movieName=this.textField_3.getText();
		String isReleased=(String)this.comboBox_1.getSelectedItem();
		System.out.println(movieName+isReleased);
		if("是".equals(isReleased))
		{
			sql.append(" and isReleased=1 ");
		}
		if("否".equals(isReleased))
		{
			sql.append(" and isReleased=0 ");
		}
		if((!"".equals(movieName))&&(movieName!=null))
		{
			sql.append(" and movieName like "+"'%"+movieName+"%'");
		}
		this.fillTable(sql.toString().replaceFirst("and", "where"));
			
	}

	/**
	 * 初始化表格 将所有电影添加到表格中
	 * @param movie
	 */
	private void fillTable(String sql) {
		
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;
		try{
			con=dbUtil.getConnection();
			List<Movie> listMovie=dao.movieList(con,sql);
			for(Movie m:listMovie)
			{
				Vector v=new Vector();
				v.add(m.getMovieId());
				v.add(m.getMovieName());
				v.add(m.getMovieDesc());
				v.add(m.getMovieImage());
				v.add(m.getIsReleased());
				dtm.addRow(v);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		
		}finally
		{
			try {
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置下面的表格
	 */
	private void resetValue()
	{
		this.movieIdTextField.setText("");
		this.movieNameTextField.setText("");
		this.movieDescTextArea.setText("");
		this.movieImageTextField.setText("");
		this.comboBox.setSelectedIndex(0);
		
	}
}

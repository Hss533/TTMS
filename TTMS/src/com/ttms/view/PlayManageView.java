package com.ttms.view;
import com.ttms.dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ttms.model.Movie;
import com.ttms.model.Play;
import com.ttms.util.DbUtil;
import com.ttms.util.StringUtil;

public class PlayManageView extends JFrame {

	private JPanel contentPane;
	private JTextField searchMovieNameTextField;
	private JTextField textField_1;
	private JTextField textField_2;	
	private JTextField playTextField;
	private JTextField startTimeTextField;
	private JTextField endTimetextField;
	private JTextField ticketPriceTextField;
	private JTable table;
	private JComboBox searchStudioComboBox;
	private JComboBox searchIsSoleComboBox;
	private JComboBox movieNameComboBox;
	private JComboBox stdioNameComboBox;
	
	DbUtil dbUtil=new DbUtil();
	PlayDao playDao=new PlayDao();
	MovieDao movieDao=new MovieDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayManageView frame = new PlayManageView();
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
	public PlayManageView() {
		
		setTitle("演出管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50,1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		/**
		 * 面板
		 */
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		/**
		 * 中间的表格
		 */
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6F14\u51FAId", "\u7535\u5F71\u540D\u79F0", "\u653E\u6620\u5385\u540D\u79F0", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u7968\u4EF7", "\u662F\u5426\u552E\u5B8C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		table.getColumnModel().getColumn(3).setPreferredWidth(115);
		table.getColumnModel().getColumn(4).setPreferredWidth(127);
		table.getColumnModel().getColumn(6).setPreferredWidth(93);
		scrollPane.setViewportView(table);
		this.fillTable("select * from play");
		/**
		 * 文字
		 */
		JLabel label_5 = new JLabel("\u7535\u5F71\u540D\u79F0");
		label_5.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel lblid = new JLabel("\u6F14\u51FAId\r\n");
		lblid.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_7 = new JLabel("\u7535\u5F71\u540D\u79F0");
		label_7.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_8 = new JLabel("\u653E\u6620\u5385\u540D\u79F0");
		label_8.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_9 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		label_9.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_10 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		label_10.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_11 = new JLabel("\u7968\u4EF7");
		label_11.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("\u7535\u5F71\u540D\u79F0");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label = new JLabel("\u67E5\u8BE2\u6F14\u51FA");
		label.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u653E\u6620\u5385");
		label_1.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u9009\u62E9\u653E\u6620\u65F6\u6BB5");
		label_2.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_3 = new JLabel("\u2014\u2014");
		label_3.setFont(new Font("黑体", Font.BOLD, 20));
		
		JLabel label_4 = new JLabel("\u7968\u662F\u5426\u5356\u5B8C");
		label_4.setFont(new Font("黑体", Font.BOLD, 20));
		
		/**
		 * 下拉框
		 */
		searchStudioComboBox = new JComboBox();
		searchIsSoleComboBox = new JComboBox();
		movieNameComboBox = new JComboBox();
		stdioNameComboBox = new JComboBox();
		
		/**
		 * w文本框
		 */
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		searchMovieNameTextField = new JTextField();
		searchMovieNameTextField.setColumns(10);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setColumns(10);
		
		endTimetextField = new JTextField();
		endTimetextField.setColumns(10);
		
		ticketPriceTextField = new JTextField();
		ticketPriceTextField.setColumns(10);
		
		playTextField = new JTextField();
		playTextField.setColumns(10);
		
		/**
		 * 按钮们
		 */
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setBackground(Color.WHITE);
		searchButton.setFont(new Font("黑体", Font.BOLD, 20));
		
		JButton modifyButton = new JButton("\u4FEE\u6539");
		modifyButton.setFont(new Font("黑体", Font.BOLD, 20));
		modifyButton.setBackground(Color.WHITE);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.setFont(new Font("黑体", Font.BOLD, 20));
		deleteButton.setBackground(Color.WHITE);
		
		JButton button = new JButton("\u6DFB\u52A0\u6F14\u51FA");
		button.setFont(new Font("黑体", Font.BOLD, 20));
		button.setBackground(Color.WHITE);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.setFont(new Font("黑体", Font.BOLD, 20));
		button_3.setBackground(Color.WHITE);
		
		
		/**
		 * 位置调整
		 */
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 752, Short.MAX_VALUE)
								.addComponent(button_3)))
						.addContainerGap())
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_3)
							.addComponent(button))
						.addGap(18)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addGap(21))
			);	
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(startTimeTextField)
								.addComponent(playTextField, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
							.addGap(35)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(endTimetextField, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
								.addComponent(movieNameComboBox, 0, 174, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(stdioNameComboBox, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(ticketPriceTextField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))))
					.addGap(94))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(99)
					.addComponent(modifyButton)
					.addPreferredGap(ComponentPlacement.RELATED, 553, Short.MAX_VALUE)
					.addComponent(deleteButton)
					.addGap(140))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(playTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stdioNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(movieNameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(startTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(endTimetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(ticketPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteButton)
						.addComponent(modifyButton))
					.addGap(31))
		);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(searchMovieNameTextField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(6)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchStudioComboBox, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(44)
									.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(searchIsSoleComboBox, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addGap(59)
									.addComponent(searchButton))))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchIsSoleComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(searchMovieNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchStudioComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		this.fillMovie();
		this.fillISReleased();
	}
	
	/**
	 * 初始化表格
	 * @param sql
	 */
	private void fillTable(String sql)
	{
		
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;
		try{
			con=dbUtil.getConnection();
			List<Play> listPlay=playDao.selectPlay(con,sql);
			for(Play p:listPlay)
			{
				Vector v=new Vector();
				v.add(p.getPlayId());
				v.add(p.getMovieName());
				v.add(p.getStudioName());
				v.add(StringUtil.dateToString(p.getStartTime(),"yyyy-MM-dd HH:mm"));
				v.add(StringUtil.dateToString(p.getEndTime(),"yyyy-MM-dd HH:mm"));
				v.add(p.getTicketPrice());
				v.add(p.getTicketSold()+"/"+p.getTicketNums());
				dtm.addRow(v);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		
		}finally
		{
			try
			{
				//关闭数据库
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 初始电影名称下拉框
	 */
	private void fillMovie() {
		String sql="select * from movie";
		Connection con=dbUtil.getConnection();
		List<Movie> movieList=new ArrayList<>();
		movieList=movieDao.movieList(con, sql);
		for(Movie m:movieList)
		{
			this.movieNameComboBox.addItem(m.getMovieName());
		}
	}
	/**
	 * 初始化放映厅
	 */
	private void fillStudio()
	{
		
	}
	private void fillISReleased()
	{
		this.searchIsSoleComboBox.addItem("请选择");
		this.searchIsSoleComboBox.addItem("是");
		this.searchIsSoleComboBox.addItem("是");
		
	}
	
}

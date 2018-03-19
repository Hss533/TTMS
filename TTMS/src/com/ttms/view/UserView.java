package com.ttms.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ttms.dao.UserDao;
import com.ttms.model.User;
import com.ttms.util.DbUtil;


public class UserView  extends JFrame{
	
	UserDao userDao=new UserDao();
	User user=new User();
	DbUtil dbUtil=new DbUtil();
	UserView userView=null;
	public void loginUi()
	{
		JFrame jf=new JFrame("用户登录");
		JPanel jp=new JPanel();
		JLabel jl1=new JLabel("登录        ");
		jl1.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel jl2=new JLabel("用户名");
		jl2.setFont(new Font("黑体", Font.BOLD, 18));
		JLabel jl3=new JLabel("密  码");
		jl3.setFont(new Font("黑体", Font.BOLD, 18));
		JTextField jt1=new JTextField();//用户名
		JPasswordField jt2=new JPasswordField();//密码
		JButton bu1=new JButton("注册");
		JButton bu2=new JButton("重置");
		JButton bu3=new JButton("确定");
		JButton bu4=new JButton("退出");
		jp.setLayout(null);
		jl1.setBounds(200,1, 200, 50);
		jl2.setBounds(50,80,200,30);
		jl3.setBounds(50,180,200,30);
		jt1.setBounds(150,80,200,30);
		jt2.setBounds(150,180,200,30);
		bu1.setBounds(50,300,80,30);
		bu2.setBounds(180,300,80,30);
		bu3.setBounds(300,300,80,30);
		bu4.setBounds(350,400,80,30);
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jt1);
		jp.add(jt2);
		jp.add(bu1);
		jp.add(bu2);
		jp.add(bu3);
		jp.add(bu4);
		jf.add(jp);
		jf.setVisible(true);
		jf.setBounds(600,200,500,500);
		/**注册*/
		bu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userView=new UserView();
				userView.addUser();
			}
		});
		/**重置*/
		bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
			}
		});
		/**确定*/
		bu3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!("".equals(jt1.getText().replaceAll(" +","")))&&!("".equals(jt2.getText().replaceAll(" +",""))))
				{
					int num;
					String userName=jt1.getText();
					String userPassword=jt2.getText();
					User user=new User(userName,userPassword);
					Connection con=dbUtil.getConnection();
					num=userDao.Login(user,con);
					if(num==-1)
					{
						JOptionPane.showMessageDialog(null,"用户不存在，请填写正确的用户名和密码");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"登录成功");
						jf.dispose();
						//登录成功，分别转入不同的主界面
						if(num==0)
						{
							//售票员
						}
						if(num==1)
						{
							//系统管理员
						}
						if(num==2)
						{
							//经理
						}
					}
					
				}
				else{
					//用户名和密码不能为空
					JOptionPane.showMessageDialog(null,"用户名和密码不能为空");
				}
			}
		});
		/**取消*/
		bu4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	public void addUser()
	{
		JFrame jf=new JFrame("用户注册");
		JPanel jp=new JPanel();
		JLabel jl1=new JLabel("用户注册");
		jl1.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel jl2=new JLabel("用 户 名");
		jl2.setFont(new Font("黑体", Font.BOLD, 18));
		JLabel jl3=new JLabel("密    码");
		jl3.setFont(new Font("黑体", Font.BOLD, 18));
		JLabel jl4=new JLabel("确认密码");
		jl4.setFont(new Font("黑体", Font.BOLD, 18));
		JLabel jl5=new JLabel("个人说明");
		jl5.setFont(new Font("黑体", Font.BOLD, 18));
		JTextArea jta=new JTextArea();//message
		jta.setLineWrap(true);
		JTextField jt1=new JTextField();//name
		JPasswordField jt2=new JPasswordField();//pass
		JPasswordField jt3=new JPasswordField();//repass
		JButton bu1=new JButton("重置");
		JButton bu2=new JButton("取消");
		JButton bu3=new JButton("确定");
		jp.setLayout(null);
		jl1.setBounds(200,1, 200, 50);
		jl2.setBounds(50,80,200,30);
		jl3.setBounds(50,150,200,30);
		jl4.setBounds(50,220,200,30);
		jl5.setBounds(50,280,100,30);
		jt1.setBounds(150,80,200,30);
		jt2.setBounds(150,150,200,30);
		jt3.setBounds(150,220, 200,30);
		jta.setBounds(150,280,300,100);
		bu1.setBounds(50,450,80,30);
		bu2.setBounds(200,450,80,30);
		bu3.setBounds(350,450,80,30);
		jp.add(jl1);
		jp.add(jl2);
		jp.add(jl3);
		jp.add(jl4);
		jp.add(jl5);
		jp.add(jt1);
		jp.add(jt2);
		jp.add(jt3);
		jp.add(jta);
		jp.add(bu1);
		jp.add(bu2);
		jp.add(bu3);
		jf.add(jp);
		jf.setBounds(600, 200, 500, 600);
		jf.setVisible(true);
		bu1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
			}
		});
		bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		bu3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String name=jt1.getText().replaceAll(" +","");
				String pass=jt2.getText().replaceAll(" +","");
				String repa=jt3.getText().replaceAll(" +","");
				String mess=jta.getText();
				User usertemp=new User(name,pass);
				Connection con=dbUtil.getConnection();
				
				if((!("".equals(name))&&(!("".equals(pass)))&&(!("".equals(repa)))))
				{
					if(userDao.judges(user,con)==0)
					{
						if(pass.equals(repa))
						{
							//注册的为默认的售票员
							User user=new User(name,pass,0,mess);
							userDao.addUser(user, con);
							JOptionPane.showMessageDialog(null,"注册成功");
							jf.dispose();
						}
						else
						{
							//密码不相符
							JOptionPane.showMessageDialog(null,"两次输入的密码不相同");
						}
					
					}
					else{
						//用户名已存在
						JOptionPane.showMessageDialog(null,"该用户名已存在");
					}
				}
				else
				{
					//全为空格
					JOptionPane.showMessageDialog(null,"用户名或密码全为空格");
				}
			}
		});
	}
	public static void main(String[] args) {
		UserView tets=new UserView();
		tets.loginUi();;
	}
}

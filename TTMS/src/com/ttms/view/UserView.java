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
		JFrame jf=new JFrame("�û���¼");
		JPanel jp=new JPanel();
		JLabel jl1=new JLabel("��¼        ");
		jl1.setFont(new Font("����", Font.BOLD, 24));
		JLabel jl2=new JLabel("�û���");
		jl2.setFont(new Font("����", Font.BOLD, 18));
		JLabel jl3=new JLabel("��  ��");
		jl3.setFont(new Font("����", Font.BOLD, 18));
		JTextField jt1=new JTextField();//�û���
		JPasswordField jt2=new JPasswordField();//����
		JButton bu1=new JButton("ע��");
		JButton bu2=new JButton("����");
		JButton bu3=new JButton("ȷ��");
		JButton bu4=new JButton("�˳�");
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
		/**ע��*/
		bu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userView=new UserView();
				userView.addUser();
			}
		});
		/**����*/
		bu2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
			}
		});
		/**ȷ��*/
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
						JOptionPane.showMessageDialog(null,"�û������ڣ�����д��ȷ���û���������");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"��¼�ɹ�");
						jf.dispose();
						//��¼�ɹ����ֱ�ת�벻ͬ��������
						if(num==0)
						{
							//��ƱԱ
						}
						if(num==1)
						{
							//ϵͳ����Ա
						}
						if(num==2)
						{
							//����
						}
					}
					
				}
				else{
					//�û��������벻��Ϊ��
					JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ��");
				}
			}
		});
		/**ȡ��*/
		bu4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	public void addUser()
	{
		JFrame jf=new JFrame("�û�ע��");
		JPanel jp=new JPanel();
		JLabel jl1=new JLabel("�û�ע��");
		jl1.setFont(new Font("����", Font.BOLD, 24));
		JLabel jl2=new JLabel("�� �� ��");
		jl2.setFont(new Font("����", Font.BOLD, 18));
		JLabel jl3=new JLabel("��    ��");
		jl3.setFont(new Font("����", Font.BOLD, 18));
		JLabel jl4=new JLabel("ȷ������");
		jl4.setFont(new Font("����", Font.BOLD, 18));
		JLabel jl5=new JLabel("����˵��");
		jl5.setFont(new Font("����", Font.BOLD, 18));
		JTextArea jta=new JTextArea();//message
		jta.setLineWrap(true);
		JTextField jt1=new JTextField();//name
		JPasswordField jt2=new JPasswordField();//pass
		JPasswordField jt3=new JPasswordField();//repass
		JButton bu1=new JButton("����");
		JButton bu2=new JButton("ȡ��");
		JButton bu3=new JButton("ȷ��");
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
							//ע���ΪĬ�ϵ���ƱԱ
							User user=new User(name,pass,0,mess);
							userDao.addUser(user, con);
							JOptionPane.showMessageDialog(null,"ע��ɹ�");
							jf.dispose();
						}
						else
						{
							//���벻���
							JOptionPane.showMessageDialog(null,"������������벻��ͬ");
						}
					
					}
					else{
						//�û����Ѵ���
						JOptionPane.showMessageDialog(null,"���û����Ѵ���");
					}
				}
				else
				{
					//ȫΪ�ո�
					JOptionPane.showMessageDialog(null,"�û���������ȫΪ�ո�");
				}
			}
		});
	}
	public static void main(String[] args) {
		UserView tets=new UserView();
		tets.loginUi();;
	}
}

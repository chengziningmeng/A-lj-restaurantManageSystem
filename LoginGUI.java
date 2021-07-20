package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.User;
import service.UserLogin_service;

public class LoginGUI {
	static JPasswordField textpassword;
	static JTextField textname;
	public static void LoginFrame(){
		final JFrame jf=new JFrame("餐厅登录");
		jf.setBounds(300, 300, 300, 300);
		jf.setLayout(new GridLayout(3,1));					
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		jf.setLocationRelativeTo(null);
		Image image=toolkit.getImage("image/logintitle.png");
		jf.setIconImage(image);
		JPanel jp1=new JPanel();
		jp1.setBackground(Color.black);
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		//上
		JLabel top=new JLabel();
		ImageIcon icon=new ImageIcon("image/loginPanel.png");
		top.setIcon(icon);
		jp1.add(top);
		//中
		JLabel user_image=new JLabel();
		ImageIcon user_icon=new ImageIcon("image/user.png");
		user_image.setIcon(user_icon);
		
		JLabel pass_image=new JLabel();
		ImageIcon pass_icon=new ImageIcon("image/pass.png");
		pass_image.setIcon(pass_icon);
		JLabel username=new JLabel("账号(U):");
		JLabel password=new JLabel("密码(P):");				
		textname=new JTextField(16);
		textpassword=new JPasswordField(16);
		jp2.add(user_image);
		jp2.add(username);
		jp2.add(textname);
		jp2.add(pass_image);
		jp2.add(password);jp2.add(textpassword);
		jp2.setBackground(Color.lightGray);
		//下
		JLabel login=new JLabel();
		ImageIcon login_icon=new ImageIcon("image/loginbutton.png");
		login.setIcon(login_icon);
		JLabel blank1=new JLabel("             ");
		JLabel registe=new JLabel();
		ImageIcon registe_icon=new ImageIcon("image/login_registebutton.png");
		registe.setIcon(registe_icon);
		JLabel blank2=new JLabel("             ");
		JLabel exit=new JLabel();
		ImageIcon exit_icon=new ImageIcon("image/login_exitbutton.png");
		exit.setIcon(exit_icon);
		jp3.add(login);jp3.add(blank1);jp3.add(registe);jp3.add(blank2);jp3.add(exit);
		jp3.setBackground(Color.darkGray);
		//设置热键
		login.setDisplayedMnemonic('L');exit.setDisplayedMnemonic('x');registe.setDisplayedMnemonic('R');
		//事件
		login.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				String name=textname.getText().trim();
				String pass=textpassword.getText().trim();
				if("root".equals(name) && "123456".equals(pass)){
					RestaurantGUI.restaurant();
					jf.setVisible(false);
				}
				else if("".equals(name)||"".equals(pass)){
					JOptionPane.showMessageDialog(null, "输入错误，请重新输入");
				}
				
				else if(UserLogin_service.isSelectUserByUser(name)==false){
					JOptionPane.showMessageDialog(null, "账号或密码错误请联系管理员");			
				}
				else if(UserLogin_service.selectUser(name).getUser().equals(name)&&UserLogin_service.selectUser(name).getPassword().equals(pass)){
					OrderGUI.order();
					jf.setVisible(false);
				}
			}
		});
		
		registe.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				RegisteGUI.register();;
				jf.setVisible(false);
			}
		});
		
		exit.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		
		jf.add(jp1);
		jf.add(jp2);
		jf.add(jp3);
		jf.setResizable(false);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		LoginGUI.LoginFrame();
	}
}

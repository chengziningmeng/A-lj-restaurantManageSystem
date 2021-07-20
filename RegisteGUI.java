package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bean.User;
import service.Registe_service;
import util.JDBC_Connection;

public class RegisteGUI {
	static JPasswordField textpassword;
	static JTextField textname;
	public static void register(){
		final JFrame jf = new JFrame("注册");
		jf.setBounds(500, 500, 500, 500);
		Toolkit tool = Toolkit.getDefaultToolkit();
		jf.setLocationRelativeTo(null);
		jf.setLayout(new GridLayout(3,1));
		Image image=tool.getImage("image/registetitle.png");
		jf.setIconImage(image);
		JPanel jp1=new JPanel();
		jp1.setBackground(Color.black);
		JPanel jp2=new JPanel();
		JPanel jp3=new JPanel();
		//上
		JLabel top=new JLabel();
		ImageIcon icon=new ImageIcon("image/registePanel.png");
		top.setIcon(icon);
		jp1.add(top);
		//中
		JLabel blanks=new JLabel("                                      ");
		
		JLabel user_image=new JLabel();
		ImageIcon user_icon=new ImageIcon("image/user.png");
		user_image.setIcon(user_icon);
		
		JLabel blank=new JLabel("                                       ");
		
		JLabel pass_image=new JLabel();
		ImageIcon pass_icon=new ImageIcon("image/pass.png");
		pass_image.setIcon(pass_icon);
		
		textname=new JTextField(16);
		textpassword=new JPasswordField(16);
		jp2.add(blanks);
		jp2.add(user_image);
		jp2.add(textname);
		jp2.add(blank);
		jp2.add(pass_image);
		jp2.add(textpassword);
		jp2.setBackground(Color.lightGray);
		//下
		JLabel registe=new JLabel();
		ImageIcon registe_icon=new ImageIcon("image/registebutton.png");
		registe.setIcon(registe_icon);
		
		JLabel blank1=new JLabel("             ");
		
		JLabel back=new JLabel();
		ImageIcon back_icon=new ImageIcon("image/backbutton.png");
		back.setIcon(back_icon);
		
		JLabel blank2=new JLabel("             ");
		
		JLabel exit=new JLabel();
		ImageIcon exit_icon=new ImageIcon("image/registe_exitbutton.png");
		exit.setIcon(exit_icon);
		jp3.add(registe);jp3.add(blank1);jp3.add(back);jp3.add(blank2);jp3.add(exit);
		jp3.setBackground(Color.darkGray);
		//设置热键
		back.setDisplayedMnemonic('B');exit.setDisplayedMnemonic('x');registe.setDisplayedMnemonic('R');
		//事件
		registe.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				String name=textname.getText().trim();
				String pass=textpassword.getText().trim();
				User s=new User(name,pass);
				if(Registe_service.registeuser(s)){
					JOptionPane.showMessageDialog(null, "注册成功");
					LoginGUI.LoginFrame();
					jf.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "注册失败");			// 19103645 张强
				}
			}
		});
		
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent E){
				LoginGUI.LoginFrame();
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

}


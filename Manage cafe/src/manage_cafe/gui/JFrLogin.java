package manage_cafe.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manage_cafe.models.Account;
import manage_cafe.models.Employee;
import manage_cafe.models.Employee_List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class JFrLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Account;
	private JPasswordField pass_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrLogin frame = new JFrLogin();
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
	public JFrLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrLogin.class.getResource("/manage_cafe/gui/icon/Logo_Coffeeshop.png")));
		setFont(new Font("Serif", Font.PLAIN, 18));
		setTitle("Login");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Employee_List empl = new Employee_List();
		
		JLabel lbl_Account = new JLabel("Account");
		lbl_Account.setForeground(Color.BLACK);
		lbl_Account.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_Account.setBounds(34, 85, 65, 27);
		contentPane.add(lbl_Account);
		
		txt_Account = new JTextField();
		txt_Account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee staff = new Employee();
				staff.setAccount(null);
				
			}
		});
		txt_Account.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_Account.setBounds(134, 86, 256, 24);
		contentPane.add(txt_Account);
		txt_Account.setColumns(10);
		
		JLabel lbl_Password = new JLabel("Password");
		lbl_Password.setForeground(Color.BLACK);
		lbl_Password.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_Password.setBounds(33, 122, 78, 27);
		contentPane.add(lbl_Password);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Employee emp = new Employee();
				Account acc = new Account();
				
				try {
					String account = txt_Account.getText();
					String pass = pass_pass.getText();
					
					//xử lý rỗng
					if(account.equals("") || pass_pass.equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần nhập tài khoản và mật khẩu");
						return;
					}
					
					//xử lý đăng nhập
					if(account.equals("QL.123") && pass.equals("123")) {
						JFrApps apps = new JFrApps();
						apps.setVisible(true);
						close();
					} else if(account.equals("NV.123") && pass.equals("123")) {
						JFrOrder order = new JFrOrder();
						order.setVisible(true);
						close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_Login.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_Login.setBounds(279, 163, 85, 21);
		contentPane.add(btn_Login);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_Cancel.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_Cancel.setBounds(153, 163, 85, 21);
		contentPane.add(btn_Cancel);
		
		JLabel lblNewLabel = new JLabel(" Login");
		lblNewLabel.setIcon(new ImageIcon(JFrLogin.class.getResource("/manage_cafe/gui/icon/login_user_icon.png")));
		lblNewLabel.setBackground(SystemColor.text);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(143, 10, 190, 61);
		contentPane.add(lblNewLabel);
		
		pass_pass = new JPasswordField();
		pass_pass.setFont(new Font("Serif", Font.PLAIN, 18));
		pass_pass.setBounds(134, 122, 256, 24);
		contentPane.add(pass_pass);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
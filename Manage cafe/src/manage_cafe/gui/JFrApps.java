package manage_cafe.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class JFrApps extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrApps frame = new JFrApps();
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
	public JFrApps() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrApps.class.getResource("/manage_cafe/gui/icon/Logo_Coffeeshop.png")));
		setTitle("Manage cafe");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 524);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_file = new JMenu("File");
		mnNewMenu_file.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_file);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit all task");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				close();
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmNewMenuItem.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_file.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("About");
		mnNewMenu.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Programme");
		mntmNewMenuItem_1.setFont(new Font("Serif", Font.PLAIN, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Đây là chương trình quản lý quán cà phê bao gồm có 4 ứng dụng chính:\n"
						+ "+ Quản ly nhân viên\n+ Quản lý bảng chấm công\n+ Quản lý sản phẩm nguyên liệu\n+ "
						+ "Menu bán hàng.","Programme",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Programmer");
		mntmNewMenuItem_2.setFont(new Font("Serif", Font.PLAIN, 14));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sinh Viên: Nguyễn Quốc Duy\nMSSV: 22011127\n"
						+ "Đồ án: Quản lý quán cà phê","Programmer",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Course");
		mntmNewMenuItem_3.setFont(new Font("Serif", Font.PLAIN, 14));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "- Môn: Lập trình hướng đối tượng\n- Lớp: 1446_2133\n"
						+ "- Mã môn học: TIN132DV02\n- Giảng viên hướng dẫn: Ths. Tran Thi Truong Thi.","Course",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_goods = new JButton(" warehouse");
		btn_goods.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/warehouse_storage_icon(1).png")));
		btn_goods.setForeground(new Color(139, 69, 19));
		btn_goods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrList_product goods = new JFrList_product();
				goods.setVisible(true);
				close();
			}
		});
		btn_goods.setFont(new Font("Serif", Font.PLAIN, 40));
		btn_goods.setBounds(435, 178, 311, 86);
		contentPane.add(btn_goods);
		
		JButton btn_employeelist = new JButton(" Employee");
		btn_employeelist.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/Employee_icon.png")));
		btn_employeelist.setForeground(new Color(205, 133, 63));
		btn_employeelist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List_employee empl = new List_employee();
				empl.setVisible(true);
				close();
			}
		});
		btn_employeelist.setFont(new Font("Serif", Font.PLAIN, 40));
		btn_employeelist.setBounds(54, 326, 311, 86);
		contentPane.add(btn_employeelist);
		
		JButton btn_order = new JButton(" Order");
		btn_order.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/Logo_coffee_cup.png")));
		btn_order.setForeground(new Color(210, 180, 140));
		btn_order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrOrder order = new JFrOrder();
				order.setVisible(true);
				close();
			}
		});
		btn_order.setFont(new Font("Serif", Font.PLAIN, 40));
		btn_order.setBounds(54, 178, 311, 86);
		contentPane.add(btn_order);
		
		JButton btn_timesheet = new JButton(" Time Sheet");
		btn_timesheet.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/Time_Sheep_icon.png")));
		btn_timesheet.setForeground(new Color(139, 69, 19));
		btn_timesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrTimesheets timesh = new JFrTimesheets();
				timesh.setVisible(true);
				close();
			}
		});
		btn_timesheet.setFont(new Font("Serif", Font.PLAIN, 40));
		btn_timesheet.setBounds(435, 326, 311, 86);
		contentPane.add(btn_timesheet);
		
		JLabel lblNewLabel = new JLabel(" STATION COFFEE");
		lblNewLabel.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/Coffee_shop_sign_icon.png")));
		lblNewLabel.setForeground(new Color(139, 69, 19));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(82, 33, 664, 121);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JFrApps.class.getResource("/manage_cafe/gui/icon/Coffee_bean_icon.png")));
		lblNewLabel_1.setBounds(636, 98, 59, 34);
		contentPane.add(lblNewLabel_1);
	}

	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
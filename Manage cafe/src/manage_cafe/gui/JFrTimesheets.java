package manage_cafe.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import manage_cafe.models.Employee;
import manage_cafe.models.TimesheetList;
import manage_cafe.models.Timesheets;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class JFrTimesheets extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_hour;
	private JTextField txt_dayoff;
	private JTable table;
	DefaultTableModel model = null;
	TimesheetList tsl = new TimesheetList();
	private JTextField txt_search;
	Locale localeVN = new Locale("vi","VN"); 
	NumberFormat vn = NumberFormat.getInstance(localeVN);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrTimesheets frame = new JFrTimesheets();
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
	public JFrTimesheets() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/Logo_Coffeeshop.png")));
		setTitle("Time Sheet");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 421);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Close all windows");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mntmNewMenuItem.setForeground(Color.BLACK);
		mntmNewMenuItem.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Close");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		mntmNewMenuItem_1.setForeground(Color.BLACK);
		mntmNewMenuItem_1.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Menu");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Selling");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrOrder order = new JFrOrder();
				order.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setForeground(Color.BLACK);
		mntmNewMenuItem_2.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Employee");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List_employee emp = new List_employee();
				emp.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setForeground(Color.BLACK);
		mntmNewMenuItem_4.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Time Sheet");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrTimesheets ts = new JFrTimesheets();
				ts.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setForeground(Color.BLACK);
		mntmNewMenuItem_5.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Warehouse");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrList_product pro = new JFrList_product();
				pro.setVisible(true);
			}
		});
		mntmNewMenuItem_3.setForeground(Color.BLACK);
		mntmNewMenuItem_3.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Abount");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Functions");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chương trình gồm 3 chức năng chính:\n"
						+ "  + Cập nhật thông tin số giờ và ngày nghỉ phép của nhân viên\n  + Lưu thông tin vào file ngoài\n"
						+ "  + Tìm kiếm nhân viên bằng mã\n","Functions",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Entities");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Đây là chương trình bảng chấm công gồm các thông tin\n  + Mã nhân viên\n"
						+ "  + Tên nhân viên\n  + Số ngày nhân viên đã nghỉ phép\n  + Số giờ nhân viên đã làm trong tháng\n"
						+ "Dữ liệu đọc lên được dùng chung trong file Employee.txt",
						"Entities",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mntmNewMenuItem_6.setForeground(Color.BLACK);
		mntmNewMenuItem_6.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_id = new JLabel("ID");
		lbl_id.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_id.setBounds(27, 111, 50, 24);
		contentPane.add(lbl_id);
		
		txt_id = new JTextField();
		txt_id.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_id.setColumns(10);
		txt_id.setBounds(104, 110, 215, 25);
		contentPane.add(txt_id);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_name.setBounds(27, 145, 50, 24);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_name.setColumns(10);
		txt_name.setBounds(104, 144, 215, 25);
		contentPane.add(txt_name);
		
		JLabel lbl_hour = new JLabel("Hour");
		lbl_hour.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_hour.setBounds(395, 144, 63, 24);
		contentPane.add(lbl_hour);
		
		txt_hour = new JTextField();
		txt_hour.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_hour.setColumns(10);
		txt_hour.setBounds(472, 145, 215, 25);
		contentPane.add(txt_hour);
		
		JButton btn_Cancel = new JButton("");
		btn_Cancel.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Cancel.setIcon(new ImageIcon(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/Sign-Back-icon.png")));
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrApps app = new JFrApps();
				app.setVisible(true);
				close();
			}
		});
		btn_Cancel.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_Cancel.setBounds(14, 21, 63, 24);
		contentPane.add(btn_Cancel);
		
		JButton btn_update = new JButton("UPDATE");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Timesheets tl = new Timesheets();
				
				//gán giá trị
				tl.setId(Integer.parseInt(txt_id.getText()));
				tl.setName(txt_name.getText());
				tl.setDayoff(Integer.parseInt(txt_dayoff.getText()));
				tl.setWorkinghour(Integer.parseInt(txt_hour.getText()));
				
				//update
				tsl.updatesalary(tl);
				
				//refresh
				model.getDataVector().clear();
				for(Timesheets t : tsl.getAlltimesheet()) {
					Vector<String> v = new Vector<String>();
					v.add(t.getId()+"");
					v.add(t.getName());
					v.add(t.getPosition().getPosition());
					v.add(t.getDayoff()+"");
					v.add(t.getWorkinghour()+"h");
					v.add(vn.format(t.getSalary())+"");
					v.add(vn.format(t.getTotalsalary())+"");
					model.addRow(v);
				}
				txt_dayoff.setText("");
				txt_hour.setText("");
			}
		});
		btn_update.setIcon(new ImageIcon(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/Pencil-icon.png")));
		btn_update.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_update.setBounds(273, 197, 138, 24);
		contentPane.add(btn_update);
		
		JLabel lbl_dayoff = new JLabel("Day Off");
		lbl_dayoff.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_dayoff.setBounds(395, 109, 63, 24);
		contentPane.add(lbl_dayoff);
		
		txt_dayoff = new JTextField();
		txt_dayoff.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_dayoff.setColumns(10);
		txt_dayoff.setBounds(472, 110, 215, 25);
		contentPane.add(txt_dayoff);
		
		table = new JTable();
		model = new DefaultTableModel(
			new String[] {
				"ID", "Name", "Position", "Day off", "Working Hour", "Salary", "Total"
			},0
		);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		updatedata();
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 231, 703, 145);
		contentPane.add(scrollPane);
		
		JButton btn_search = new JButton(" Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txt_search.getText());
				Timesheets tl = tsl.findbyid(id);
				
				//gán giá trị
				try {
					if(tl != null) {
						txt_id.setText(tl.getId()+"");
						txt_name.setText(tl.getName());
					} else {
						txt_search.setText("");
						JOptionPane.showMessageDialog(null, "Không có nhân viên nào trong hệ thống");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				txt_search.setText("");
			}
		});
		btn_search.setIcon(new ImageIcon(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/search-icon.png")));
		btn_search.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_search.setBounds(443, 196, 115, 24);
		contentPane.add(btn_search);
		
		JButton btn_save = new JButton("SAVE");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tsl.WriteDB();
				JOptionPane.showMessageDialog(null, "Lưu thành công");
			}
		});
		btn_save.setIcon(new ImageIcon(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/floppy-icon.png")));
		btn_save.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_save.setBounds(125, 197, 138, 24);
		contentPane.add(btn_save);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 83, 703, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel(" Time Sheep");
		lblNewLabel.setIcon(new ImageIcon(JFrTimesheets.class.getResource("/manage_cafe/gui/icon/5084637_alarm_clock_time_watch_icon.png")));
		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(220, 10, 291, 62);
		contentPane.add(lblNewLabel);
		
		txt_search = new JTextField();
		txt_search.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_search.setColumns(10);
		txt_search.setBounds(568, 196, 138, 25);
		contentPane.add(txt_search);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	public void updatedata() {
		tsl.ReadDB();
		tsl.sortid();
		//refresh
		model.getDataVector().clear();
		for(Timesheets tl : tsl.getAlltimesheet()) {
			Vector<String> v = new Vector<String>();
			v.add(tl.getId()+"");
			v.add(tl.getName());
			v.add(tl.getPosition().getPosition());
			v.add(tl.getDayoff()+"");
			v.add(tl.getWorkinghour()+"h");
			v.add(vn.format(tl.getSalary())+"");
			v.add(vn.format(tl.getTotalsalary())+"");
			model.addRow(v);
		}
	}
	
	public void total() {
		Timesheets tl = new Timesheets();
		double total = 0d;
		total = (double) (tl.getSalary() * tl.getWorkinghour());
		System.out.println(total+"");
		tl.setTotalsalary(total);
	}
}

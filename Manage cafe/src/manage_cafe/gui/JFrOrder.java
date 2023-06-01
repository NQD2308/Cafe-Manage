package manage_cafe.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import manage_cafe.models.Menu;
import manage_cafe.models.MenuList;
import manage_cafe.models.Menu_Drink;
import manage_cafe.models.Menu_Topping;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;

public class JFrOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = null;
	MenuList menulist = new MenuList();
	JLabel lbl_money = new JLabel("");
	private JTextField txt_search;
	private JComboBox comboBox_product;
	private JComboBox comboBox_topping;
	private JComboBox comboBox_suger;
	private JComboBox comboBox_ice;
	private JComboBox comboBox_size;
	Locale localeVN = new Locale("vi","VN"); 
	NumberFormat vn = NumberFormat.getInstance(localeVN);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrOrder frame = new JFrOrder();
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
	public JFrOrder() {
		setTitle("Selling");
		setFont(new Font("Serif", Font.PLAIN, 18));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 516);
		
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
		
		JMenu mnNewMenu_2 = new JMenu("Abount");
		mnNewMenu_2.setForeground(Color.BLACK);
		mnNewMenu_2.setFont(new Font("Serif", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Functions");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Chương trình gồm có 5 chức năng chính:\n"
						+ "  + Thêm món\n  + Xóa món\n  + Chỉnh sửa món theo yêu cầu khách hàng  \n  + "
						+ "Tìm kiếm món khách hàng đã đặt\n" + "  + Xuất hóa đơn","Functios",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Enitities");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Đây là chương trình bán hàng bao gồm có 6 thực thể:\n"
						+ "  + Chọn món chính\n  + Chọn các topping có thể đi kèm mới đồ uống\n  + Chọn lượng đường gồm mức: 0%, 25%, 50%, 75%, 100%  \n  + "
						+ "Chọn lượng đá 5 gồm mức: 0%, 25%, 50%, 75%, 100%\n  + Chọn kích size ly không tính thêm tiền có 3 mức: S, M, L",
						"Entities",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		mntmNewMenuItem_6.setForeground(Color.BLACK);
		mntmNewMenuItem_6.setFont(new Font("Serif", Font.PLAIN, 14));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Product = new JLabel("Product");
		lbl_Product.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_Product.setBounds(32, 123, 66, 24);
		contentPane.add(lbl_Product);
		
		JLabel lbl_size = new JLabel("Size");
		lbl_size.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_size.setBounds(419, 194, 66, 24);
		contentPane.add(lbl_size);
		
		JButton btn_print = new JButton("Print");
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//xuat hoa don
				menulist.WriteDB();
				// refresh giao dien
				menulist.clearAll();
//				System.out.println();
					
				lbl_money.setText("0 VND");
				
				model.getDataVector().clear();
				
					Vector<String> v = new Vector<String>();
					v.add("");
					v.add("");
					v.add("");
					v.add("");
					v.add("");
					v.add("");			
					model.addRow(v);
			}
		});
		btn_print.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_print.setBounds(586, 271, 84, 24);
		contentPane.add(btn_print);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btn_Cancel.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_Cancel.setBounds(190, 271, 88, 24);
		contentPane.add(btn_Cancel);
		
		comboBox_size = new JComboBox();
		comboBox_size.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_size.setModel(new DefaultComboBoxModel(new String[] {"S", "M", "L"}));
		comboBox_size.setSelectedIndex(1);
		comboBox_size.setBounds(508, 195, 133, 24);
		contentPane.add(comboBox_size);
		
		JLabel lbl_topping = new JLabel("Topping");
		lbl_topping.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_topping.setBounds(32, 160, 66, 24);
		contentPane.add(lbl_topping);
		
		comboBox_topping = new JComboBox();
		ArrayList<Menu_Topping> listtopping = Menu_Topping.ListTopping();
		comboBox_topping.addItem("");
		for(Menu_Topping topping : listtopping) {
			comboBox_topping.addItem(topping.getTopping());
		}
		comboBox_topping.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_topping.setBounds(121, 158, 202, 25);
		contentPane.add(comboBox_topping);
		
		comboBox_suger = new JComboBox();
		comboBox_suger.setModel(new DefaultComboBoxModel(new String[] {"0%", "25%", "50%", "75%", "100%"}));
		comboBox_suger.setSelectedIndex(2);
		comboBox_suger.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_suger.setBounds(508, 123, 133, 25);
		contentPane.add(comboBox_suger);
		
		JLabel lbl_suger = new JLabel("Suger");
		lbl_suger.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_suger.setBounds(419, 125, 66, 24);
		contentPane.add(lbl_suger);
		
		comboBox_ice = new JComboBox();
		comboBox_ice.setModel(new DefaultComboBoxModel(new String[] {"0%", "25%", "50%", "75%", "100%"}));
		comboBox_ice.setSelectedIndex(2);
		comboBox_ice.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_ice.setBounds(508, 160, 133, 25);
		contentPane.add(comboBox_ice);
		
		JLabel lbl_ice = new JLabel("Ice");
		lbl_ice.setFont(new Font("Serif", Font.PLAIN, 18));
		lbl_ice.setBounds(419, 160, 66, 24);
		contentPane.add(lbl_ice);
		
		comboBox_product = new JComboBox();
		ArrayList<Menu_Drink> listname = Menu_Drink.getListDrink();
		comboBox_product.addItem("");
		for(Menu_Drink drink : listname) {
			comboBox_product.addItem(drink.getDrink());
		}
		comboBox_product.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_product.setBounds(121, 123, 202, 25);
		contentPane.add(comboBox_product);
		
		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();

				Menu_Drink menudrink = new Menu_Drink();
				menudrink.setDrink(comboBox_product.getSelectedItem().toString());
				menu.setMdr(menudrink);
				
				Menu_Topping topping = new Menu_Topping();
				topping.setTopping(comboBox_topping.getSelectedItem().toString());
				menu.setMtop(topping);
				
				String product = comboBox_product.getSelectedItem().toString();
				String toping = comboBox_topping.getSelectedItem().toString();
				
				menu.setSize(comboBox_size.getSelectedItem().toString());
				menu.setSuger(comboBox_suger.getSelectedItem().toString());
				menu.setIce(comboBox_ice.getSelectedItem().toString());
				
				int cost1 = 0;
				
				if(product.equals("Espresso")) {
					cost1 = 39000; 
				} else if(product.equals("Capuccino")) {
					cost1 = 35000;
				} else if(product.equals("Cafe latte")) {
					cost1 = 30000;
				} else if(product.equals("Vanilla latte")) {
					cost1 = 30000;
				} else if(product.equals("Cafe americano")) {
					cost1 = 40000;
				} else if(product.equals("Cafe chocolate")) {
					cost1 = 35000;
				} else if(product.equals("Orange Juice")) {
					cost1 = 29000;
				} else if(product.equals("Lavender")) {
					cost1 = 35000;
				} else if(product.equals("Lemonadever")) {
					cost1 = 35000;
				} else if(product.equals("Avocado smoothie")) {
					cost1 = 29000;
				} else if(product.equals("Strawberry smoothi")) {
					cost1 = 29000;
				} else if(product.equals("Meak tea")) {
					cost1 = 29000;
				} else if(product.equals("Fruit tea")) {
					cost1 = 29000;
				} else if(product.equals("Garlic tea")){
					cost1 = 20000;
				} 
				menu.setCost_drink(cost1);
				
				int cost2 = 0;
				if(toping.equals("Machiato")) {
					cost2 = 10000;
				} else if(toping.equals("Caoacao pouder")) {
					cost2 = 5000;
				}
				else if(toping.equals("Matcha pouder")) {
					cost2 = 5000;
				}
				else if(toping.equals("Pudding")) {
					cost2 = 10000;
				}
				menu.setCost_topping(cost2);
				
				menulist.addmenu(menu);
				
				lbl_money.setText(vn.format(menulist.getTotal()) +" VND");
				
				model.getDataVector().clear();
				
				for(Menu menudetail : menulist.getAllmenu()) {
					Vector<String> v = new Vector<String>();
//					System.out.println(menudetail.getId()+"");
					v.add(menudetail.getId1()+"");
					v.add(menudetail.getMdr().getDrink());
					v.add(menudetail.getMtop().getTopping());
					v.add(menudetail.getSize());
					v.add(menudetail.getSuger());
					v.add(menudetail.getIce());
					v.add(vn.format(menudetail.getTotal()) +"");					
					model.addRow(v);
				}
//				menulist.sortid();
				cleanform();
			}
		});
		btn_add.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_add.setBounds(492, 271, 84, 24);
		contentPane.add(btn_add);
		
		table = new JTable();
		model = new DefaultTableModel(

			new String[] {
				"ID","Drink", "Topping", "Size", "Suger", "Ice", "price"
			},0
		);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
//		upload();
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 305, 673, 164);
		contentPane.add(scrollPane);
		
		JLabel lbl_Total = new JLabel("Total");
		lbl_Total.setForeground(SystemColor.activeCaptionBorder);
		lbl_Total.setFont(new Font("Serif", Font.PLAIN, 35));
		lbl_Total.setBounds(32, 210, 95, 41);
		contentPane.add(lbl_Total);
		
		
		lbl_money.setForeground(SystemColor.activeCaptionBorder);
		lbl_money.setFont(new Font("Serif", Font.PLAIN, 35));
		lbl_money.setBounds(137, 210, 186, 41);
		contentPane.add(lbl_money);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txt_search.getText());
//				Menu menu = menulist.findbyid(id);

				//delete
				lbl_money.setText(menulist.gettotaldel(id)+" VND");
				menulist.deletelist(id);
				
				//refresh
				try {
					if(menulist.getAllmenu().isEmpty()) {
//						JOptionPane.showMessageDialog(null, "Không có sản phẩm nào trong danh sách");
					} else {
						model.getDataVector().clear();
						for(Menu m : menulist.getAllmenu()) {
							Vector<String> v = new Vector<String>();
//							System.out.println(m.getId()+"");
							v.add(m.getId()+"");
							v.add(m.getMdr().getDrink());
							v.add(m.getMtop().getTopping());
							v.add(m.getSize());
							v.add(m.getSuger());
							v.add(m.getIce());
							v.add(vn.format(m.getTotal())+"");
							model.addRow(v);
						}
					}
					cleanform();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_delete.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_delete.setBounds(288, 271, 84, 24);
		contentPane.add(btn_delete);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txt_search.getText());
				Menu menu = menulist.findbyid(id);

				//lấy giá trị mới
				Menu_Drink mdr = new Menu_Drink();
//				mdr.setDrink(comboBox_product.getSelectedItem().toString());
//				menu.setMdr(mdr);
//				
//				Menu_Topping mtop = new Menu_Topping();
//				mtop.setTopping(comboBox_topping.getSelectedItem().toString());
//				menu.setMtop(mtop);
				
				menu.setSize(comboBox_size.getSelectedItem().toString());
				menu.setSuger(comboBox_suger.getSelectedItem().toString());
				menu.setIce(comboBox_ice.getSelectedItem().toString());
				
				//update
				menulist.updateoder(menu);
				
				//refresh
				model.getDataVector().clear();
				for(Menu m : menulist.getAllmenu()) {
					Vector<String> v = new Vector<String>();
					v.add(m.getId()+"");
					v.add(m.getMdr().getDrink());
					v.add(m.getMtop().getTopping());
					v.add(m.getSize());
					v.add(m.getSuger());
					v.add(m.getIce());
					v.add(vn.format(m.getTotal())+"");
					model.addRow(v);
				}
			}
		});
		btn_update.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_update.setBounds(382, 271, 100, 24);
		contentPane.add(btn_update);
		
		txt_search = new JTextField();
		txt_search.setFont(new Font("Serif", Font.PLAIN, 18));
		txt_search.setBounds(10, 269, 66, 24);
		contentPane.add(txt_search);
		txt_search.setColumns(10);
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(txt_search.getText());
				Menu menu = menulist.findbyid(id);
				
				if(menu != null) {
					//gán giá trị lên gia diện
					comboBox_product.setSelectedItem(menu.getMdr().getDrink());
					comboBox_topping.setSelectedItem(menu.getMtop().getTopping());
					comboBox_size.setSelectedItem(menu.getSize());
					comboBox_suger.setSelectedItem(menu.getSuger());
					comboBox_ice.setSelectedItem(menu.getIce());
				} else {
					JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại", "Error", 0);
				}
			}
		});
		btn_search.setFont(new Font("Serif", Font.PLAIN, 18));
		btn_search.setBounds(86, 270, 85, 24);
		contentPane.add(btn_search);
		
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrLogin login = new JFrLogin();
				login.setVisible(true);
			}
		});
		btn_back.setIcon(new ImageIcon(JFrOrder.class.getResource("/manage_cafe/gui/icon/Sign-Back-icon.png")));
		btn_back.setBounds(13, 24, 63, 21);
		contentPane.add(btn_back);
		
		JLabel lblNewLabel = new JLabel(" Selling");
		lblNewLabel.setIcon(new ImageIcon(JFrOrder.class.getResource("/manage_cafe/gui/icon/Coffee_cup_drip_machine_maker_icon.png")));
		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 40));
		lblNewLabel.setBounds(242, 24, 179, 55);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 89, 673, 2);
		contentPane.add(separator);
	}
	
	public void close() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
	
	public void upload() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		menulist.ReadDB();
		
		model.getDataVector().clear();
		for(Menu m : menulist.getAllmenu()) {
			Vector<String> v = new Vector<String>();

			v.add(m.getName());
			v.add(m.getMdr().getDrink());
			v.add(m.getMtop().getTopping());
			v.add(vn.format(m.getTotal())+"");
			model.addRow(v);
		}
	}
	
	public void cleanform() {
		comboBox_product.setSelectedIndex(0);
		comboBox_topping.setSelectedIndex(0);
		comboBox_suger.setSelectedIndex(2);
		comboBox_ice.setSelectedIndex(2);
		comboBox_size.setSelectedIndex(1);
	}
}

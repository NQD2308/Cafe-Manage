package manage_cafe.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ProductList {
	private ArrayList<Product> prolist;

	public ProductList() {
		prolist = new ArrayList<Product>();
	}
	
	public void addgoodsòòòòò(Product g) {
		prolist.add(g);
	}
	
	public Product findbyname(String name) {
		for(Product g : prolist) {
			if(g.getNameg().equals(name)) {
				return g;
			}
		}
		return null;
	}
	
	public Product findbyid(String id) {
		for(Product pro : prolist) {
			if(pro.getIdg().equals(id)) {
				return pro;
			}
		}
		return null;
	}
	
	public void update(Product pro) {
		for(Product pr : prolist)
			if(pr.getIdg().equals(pro)) {
				pr.setPrb(pro.getPrb());
				pr.setQuantities(pro.getQuantities());
				pr.setInventnum(pro.getInventnum());
			}
	}
	
	public void sortid() {
		Collections.sort(prolist);
	}
	
	public void deleteproduct(String id) {
		try {
//			for(Product pro : prolist) {
//				if(pro.getIdg().equals(id)) {
//					prolist.remove(pro);
//				}
//			}
			
			Iterator<Product> iter = prolist.iterator();
			while(iter.hasNext()) {
				Product pro = iter.next();
				if(pro.getIdg().equals(id)) {
					iter.remove();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WriteDB() {
		String path = "D:\\Hoa Sen University\\IT\\Lap Trinh Huong Doi Tuong\\LAB\\Project\\Manage cafe\\src\\manage_cafe\\data\\GoodsData.txt";
		try {
			
			//2.
			File f = new File(path);
			FileWriter fw  = new FileWriter(f, false);
			PrintWriter pw = new PrintWriter(fw);
			
			//3.
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			for(Product p: prolist) {
				String s = p.getIdg()+";"+p.getNameg()+";"+(p.isUnit()? "Pakage" : "Pakage")+";"+p.getInventnum();
				pw.println(s);
			}

			//4.
			pw.close();
			fw.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ReadDB() {
		String path = "D:\\Hoa Sen University\\IT\\Lap Trinh Huong Doi Tuong\\LAB\\Project\\Manage cafe\\src\\manage_cafe\\data\\GoodsData.txt";
		try {
			File f = new File(path);
			FileReader fr= new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null) {
//				System.out.println(line);
				
				String [] temp = line.split(";");
				
//				for(int i=0;i<temp.length;i++) {
//					
//					System.out.println(" i = "+i+"-->"+temp[i]);
//				}
				
				Product p = new Product();
				
				p.setIdg(temp[0]);
				
				p.setNameg(temp[1]);
				
				if(temp[2].equals("true") || temp[2].equals("Box"))
				p.setUnit(true) ;
				
				else
					p.setUnit(false);
				
				p.setInventnum(Integer.parseInt(temp[3]));
				
				prolist.add(p);
				line=br.readLine();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> getAllgoods(){
		
		return prolist;
	}
	
}

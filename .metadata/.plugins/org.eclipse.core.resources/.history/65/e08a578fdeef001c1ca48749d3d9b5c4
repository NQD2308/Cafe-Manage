package manage_cafe.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class TimesheetList {
	private ArrayList<Timesheets> tsl;
	Locale localeVN = new Locale("vi","VN"); 
	NumberFormat vn = NumberFormat.getInstance(localeVN);
	
	public TimesheetList() {
		tsl = new ArrayList<Timesheets>();
	}
	
	public Timesheets findbyid(int id) {
		for(Timesheets tl: tsl) {
//			System.out.println("Update ==> id="+id + "  getId="+tl.getId());
			if(tl.getId() == id) {
				return tl;
			}
		}
		return null;
	}
	
	public void updatesalary(Timesheets  t) {
		for(Timesheets tl : tsl) {
//			System.out.println("Update ==> t.getid="+t.getId() + "  tl.getId="+tl.getId());
			if(tl.getId() == t.getId()) {
				tl.setDayoff(t.getDayoff());
				tl.setWorkinghour(t.getWorkinghour());
				double salary = 0d;
				salary = tl.getWorkinghour() * tl.getSalary();
				tl.setTotalsalary(salary);
//				System.out.println("Luong update = "+salary+"");
				tl.setTotalsalary(salary);
			}	
		}
	}
	
	public void sortid() {
		Collections.sort(tsl);
	}
	
	public ArrayList<Timesheets> getAlltimesheet(){
		return tsl;
	}
	
	public void ReadDB() {
		String path = "D:\\Hoa Sen University\\IT\\Lap Trinh Huong Doi Tuong\\LAB\\Project\\Manage cafe\\src\\manage_cafe\\data\\Employee.txt";
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
				
				Timesheets tl = new Timesheets();
				
				tl.setId(Integer.parseInt(temp[0]));
				
				tl.setName(temp[1]);
				tl.setIdcard(Integer.parseInt(temp[2]));
				
				if(temp[3].equals("true") || temp[3].equals("Nam"))
				
				tl.setSex(true) ;
				else
					tl.setSex(false) ;
				
				SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");
				
				tl.setAddress(temp[4]);
				tl.setEmail(temp[5]);
				tl.setDaywork(df.parse(temp[6])) ;

				Employee_position epos= new Employee_position();
				epos.setPosition(temp[7]);
				tl.setPosition(epos);
				
				tl.setSalary(Double.parseDouble(temp[10]));
				tl.setDayoff(Integer.parseInt(temp[13]));
				tl.setWorkinghour(Integer.parseInt(temp[14]));
				
				Employee_timeworking time = new Employee_timeworking();
				time.setTime(temp[8]);
				tl.setTimeworking(time);
				if(temp[9].equals("true") || temp[9].equals("Full time"))
				tl.setKoj(true);
				else
					tl.setKoj(false);
				
				tl.setSalary(Double.parseDouble(temp[10]));
				
				Account acc = new Account();
				acc.setAccount(temp[11]);
				acc.setPass(temp[12]);
				tl.setAccount(acc);
				
				double salary = 0d;
				salary = tl.getWorkinghour() * tl.getSalary();
				tl.setTotalsalary(salary);
//				System.out.println(salary+"");
				tl.setTotalsalary(salary);
				
				tsl.add(tl);
				
				line=br.readLine();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void WriteDB() {
		String path = "D:\\Hoa Sen University\\IT\\Lap Trinh Huong Doi Tuong\\LAB\\Project\\Manage cafe\\src\\manage_cafe\\data\\Employee.txt";
		try {
			
			//2.
			File f = new File(path);
			FileWriter fw  = new FileWriter(f, false);
			PrintWriter pw = new PrintWriter(fw);
			
			//3.
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			for(Timesheets tl: tsl) {
				String s = tl.getId()+";"+ tl.getName() + ";"+ tl.getIdcard()  +";"+ (tl.isSex()? "Nam" : "Nu" ) +";"+ tl.getAddress() +";"+ 
				tl.getEmail()+ ";" + df.format(tl.getDaywork()) +";"+ tl.getPosition().getPosition() +";"+ 
				tl.getTimeworking().getTime()+";"+ (tl.isKoj()? "Full time":"Part time") +";"+ tl.getSalary() +";"+ tl.getAccount().getAccount()+";"+ 
				tl.getAccount().getPass()+";"+ tl.getDayoff()+";"+ tl.getWorkinghour();
				pw.println(s);
			}

			//4.
			pw.close();
			fw.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}

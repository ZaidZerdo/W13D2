package examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;

public class Example1 {

	private static ArrayList<Employee> list = new ArrayList<>();
	private static ArrayList<Manager> list2 = new ArrayList<>();
	
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("src/examples/database.csv")));
			
			reader.readLine();
			while (reader.ready()) {
				String[] line = reader.readLine().split(",");
				
				int id = Integer.parseInt(line[0]);
				String name = line[1];
				char gender = line[2].charAt(0);
				int salary = Integer.parseInt(line[3]);
				
				list.add(new Employee(id, name, gender, salary));
			}
			
			reader = new BufferedReader(new FileReader(new File("src/examples/manager.csv")));
			
			reader.readLine();
			while (reader.ready()) {
				String[] line = reader.readLine().split(",");
				
				int id = Integer.parseInt(line[0]);
				String name = line[1];
				
				list2.add(new Manager(id, name));
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Employee e : list) {
			System.out.print(e.getName());
			
			Manager myManager = null;
			for (Manager m : list2) {
				if (e.getId() == m.getEmployeeId()) {
					myManager = m;
				}
			}
			
			if (myManager == null) {
				System.out.println(" null");
			} else {
				System.out.println(" " + myManager.getName());
			}
		}
	}

}

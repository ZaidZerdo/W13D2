package examples;

public class Manager {
	private int employeeId;
	private String name;
	
	public Manager(int employeeId, String name) {
		super();
		this.employeeId = employeeId;
		this.name = name;
	}
	
	

	public int getEmployeeId() {
		return employeeId;
	}



	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Manager [employeeId=" + employeeId + ", name=" + name + "]";
	}
	
}

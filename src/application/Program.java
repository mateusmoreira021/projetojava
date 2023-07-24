package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entites.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employee will be registered ? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			System.out.println();
			System.out.println("EMPLOYEE #" + (i + 1) + ":");
			System.out.print("ID: ");
			Integer id = sc.nextInt();
			
			while(hasId(list, id)) {
				System.out.println("ID already taken trya again: ");
				id = sc.nextInt();
			}
			
			
			System.out.print("NAME: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("SALARY: ");
			Double salary = sc.nextDouble();
			
			
			Employee emp = new Employee(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the id of the employee that will have salary increase: ");
		int idSalary = sc.nextInt();
		
		Employee empPos = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if(empPos == null) {
			System.out.println("This id does not exist");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			
			empPos.increaseSalary(percent);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
		
		sc.close();

	}
	
	public static Integer positionId(List<Employee> list, int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}

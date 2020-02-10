package heranca;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;	

public class EmployeeTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		List<Employee> func = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int num = scan.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.println("Employee #" + i + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char option = scan.next().charAt(0);
			scan.nextLine();
			System.out.print("Name: ");
			String name = scan.nextLine();
			System.out.print("Hours: ");
			int hours = scan.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = scan.nextDouble();

			if (option == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = scan.nextDouble();
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				func.add(emp);
			}
			else if (option == 'n') {
				func.add(new Employee(name, hours, valuePerHour));
			}
			else {
				System.out.println("Invalid choice.");
			}
		}
			System.out.println();
			System.out.println("PAYMENTS: ");
			for (Employee s : func) {
				System.out.println(s.getName() + " - $ " + String.format("%.2f", s.payment()));
			}
		scan.close();
	}


}



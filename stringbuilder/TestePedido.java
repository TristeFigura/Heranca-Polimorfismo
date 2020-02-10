package stringbuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestePedido {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(scan.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scan.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int quant = scan.nextInt();
		
		for (int i = 1; i <= quant; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			scan.nextLine();
			String nameProd = scan.nextLine();
			System.out.println("Product price: ");
			double priceProd = scan.nextDouble();
			
			Product product = new Product(nameProd, priceProd);
			
			System.out.println("Quantity: ");
			int quantity = scan.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, priceProd, product);
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		scan.close();
		
	}

}

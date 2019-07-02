import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bounus_Assignment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Pattern p;
		Matcher m;
		boolean loop = true;
		while (loop) {
			System.out.println("Please select an option from below:");
			System.out.println("1-Validate email address");
			System.out.println("2-Validate MAC address");
			System.out.println("3-Validate ipv4 address");
			System.out.println("4-end");
			switch (sc.nextInt()) {

			case 1:
				System.out.println("Enter email address: ");
				p = Pattern.compile("\\b[-.\\w]+@(\\w+(\\.\\w+){1,2}+)\\b");
				m = p.matcher(sc.next());
				if (m.matches()) {
					System.out.println("email is valid\n");
				} else {
					System.out.println("email is not valid\n");
				}
				break;
			case 2:
				System.out.println("Enter MAC address: ");
				p = Pattern.compile("\\b([A-Za-z0-9]{2}:){5}[A-Za-z0-9]{2}\\b");
				m = p.matcher(sc.next());
				if (m.matches()) {
					System.out.println("MAC address is valid\n");
				} else {
					System.out.println("MAC address is not valid\n");
				}
				break;
			case 3:
				System.out.println("Enter ipv4 address: ");
				p = Pattern.compile(
						"(([0-1]{0,1}[0-9]{0,1}[0-9][.])|([2]{0,1}[0-5]{0,1}[0-5][.])){3}[0-1]?[0-9]?[0-9]|[2]{0,1}[0-5]{0,1}[0-5]");
				m = p.matcher(sc.next());
				if (m.matches()) {
					System.out.println("ipv4 address is valid\n");
				} else {
					System.out.println("ipv4 address is not valid\n");
				}
				break;
			case 4:
				System.out.println("Thank you for using this program...bye bye!!!");
				loop = false;
				break;
			default:
				System.out.println("The number that was chosen is not one of the list!!");

			}

		}
		sc.close();
	}
}
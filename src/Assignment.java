import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment {
	public static void main(String[] args) throws FileNotFoundException {
		File o = new File("interfaces.txt");
		String[] patterns = { "^\\S*[\\w]+\\b", "(?<=Internet address is )((\\d{1,3}+(\\.\\d{1,3}+)*))",
				"(?<=Description: )(\\w*+( \\w*)*)", "(?<=duplex, )(\\d*\\w*\\/s)", "(\\w*-)(?=duplex)",
				"(?<=is )(\\w*+( \\w*)*)(?=, line protocol)", "(?<=line protocol is )(\\w*+( \\w*)*\\b)",
				"(?<=, address is )((\\w+(\\.\\w+)*))", "(?<=MTU )(\\d*\\b)" };
		ArrayList<String>[] info;
		Scanner in = new Scanner(o);
		String text = "";
		Pattern p_interface;
		Matcher m;
		while (in.hasNextLine()) {
			text += in.nextLine() + "\n";
		}
		in.close();

		info = new ArrayList[9];
		for (int i = 0; i < info.length; i++) {
			info[i] = new ArrayList<String>();
		}
		for (int i = 0; i < patterns.length; i++) {
			if (i == 0)
				p_interface = Pattern.compile(patterns[i], Pattern.MULTILINE);
			else
				p_interface = Pattern.compile(patterns[i]);
			m = p_interface.matcher(text);
			if (m.find()) {
				do {
					info[i].add(text.substring(m.start(), m.end()));
				} while (m.find());
			} else {
				info[i].add("");
			}

		}
		System.out.println("Matched interfaces are " + info[0].size());
		for (int i = 0; i < info[0].size(); i++) {
			try {
				info[3].get(i);
			} catch (IndexOutOfBoundsException e) {
				info[3].add("auto speed");
			}
			try {
				info[1].get(i);
				info[2].get(i);
				info[4].get(i);
				info[5].get(i);
				info[6].get(i);
				info[7].get(i);
				info[8].get(i);

			} catch (IndexOutOfBoundsException e) {
				info[1].add("");
				info[2].add("");
				info[4].add("");
				info[5].add("");
				info[6].add("");
				info[7].add("");
				info[8].add("");
			}

			System.out.println("Interface #" + (i + 1) + ":" + "\r\n\t" + "interface name: " + info[0].get(i) + "\r\n\t"
					+ "ip address: " + info[1].get(i) + "\r\n\t" + "interface description: " + info[2].get(i) + "\r\n\t"
					+ "ifSpeed: " + info[3].get(i) + "\r\n\t" + "duplex mode: " + info[4].get(i) + "duplex" + "\r\n\t"
					+ "admin status: " + info[5].get(i) + "\r\n\t" + "operation status: " + info[6].get(i) + "\r\n\t"
					+ "mac address: " + info[7].get(i) + "\r\n\t" + "mtu: " + info[8].get(i) + "\r\n");
		}

	}
}

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in;
		if (args.length != 2) {
			System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
			System.exit(0);
		}
		try {
			File input_file = new File (args[0]);
			in = new Scanner(input_file);
			File output_file = new File(args[1]);
			PrintWriter out;
			out = new PrintWriter(output_file);
			
			LazyBinarySearchTree LBST = new LazyBinarySearchTree();
			
			String operation = "";
			
			int key;
			boolean result;
			
			while(in.hasNext()) {
				operation = in.next();

				switch (operation) {
				case "Insert:":
				try {
					key = in.nextInt();
					result = LBST.insert(key);
					out.println(result ? "True" : "False");
				}
				catch (Exception e) {
					out.println("ERROR");
				}
				}
			}
			in.close();
			out.close();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

	}

}

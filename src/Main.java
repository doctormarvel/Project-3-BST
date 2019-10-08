
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner in;
		//Check for 2 arguments
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
			
			//variables used in switch case
			String operation = "";
			String colon = ":";
			int key = 0;
			String treeValues;
			int height, size, min, max;
			boolean result;
			
			while(in.hasNext()) {
				operation = in.next();
				//used to split if a colon exist
				for (int i = 0; i < operation.length() -1; i++) {
					if (operation.charAt(i) == ':') {
						String[] splitStrings = operation.split(colon);
						operation = splitStrings[0];
						key = Integer.parseInt(splitStrings[1]);
					}
				}
				switch (operation) {
				case "Insert":
					try {
						result = LBST.insert(key);
						out.println(result ? "True" : "False");
					}
					catch (Exception e) {
						out.println("Error in insert: IllegalArgumentException raised");
					}
					break;
					
				case "Delete":
					try {
						result = LBST.delete(key);
						out.println(result ? "True" : "False");
					}
					catch (Exception e) {
						out.println("Error in delete: IllegalArgumentException raised");
					}
					break;
					
				case "Contains":
					try {
						result = LBST.contains(key);
						out.println(result ? "True" : "False");
					}
					catch (Exception e) {
						out.println("Error in contains: IllegalArgumentException raised");
					}
					break;
					
				case "FindMin":
					try {
						min = LBST.findMin();
						out.println(min);
					}
					catch (Exception e) {
						out.println("ERROR in findMin");
					}
					break;
					
				case "FindMax":
					try {
						max = LBST.findMax();
						out.println(max);
					}
					catch (Exception e) {
						out.println("ERROR in findMax");
					}
					break;
					
				case "PrintTree":
					try {
						treeValues = LBST.toString();
						out.println(treeValues);
					}
					catch (Exception e) {
						out.println("ERROR in print");
					}
					break;
					
				case "Height":
					try {
						height = LBST.height();
						out.println(height);
					}
					catch (Exception e){
						out.println("ERROR in height");
					}
					break;
					
				case "Size":
					try {
						size = LBST.size();
						out.println(size);
					}
					catch (Exception e){
						out.println("ERROR in size");
					}
					break;
					
				default:
					out.println("Error in Line: " + operation);
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

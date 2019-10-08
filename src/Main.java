
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
			
			int key, height, size, min, max;
			boolean result;
			String treeValues;
			
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
						out.println("ERROR insert");
					}
					break;
				case "Delete:":
					try {
						key = in.nextInt();
						result = LBST.delete(key);
						out.println(result ? "True" : "False");
					}
					catch (Exception e) {
						out.println("ERROR in delete");
					}
					break;
				case "Contains:":
					try {
						key = in.nextInt();
						result = LBST.contains(key);
						out.println(result ? "True" : "False");
					}
					catch (Exception e) {
						out.println("ERROR in contains");
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

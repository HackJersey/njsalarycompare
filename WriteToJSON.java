

		import java.io.*;

public class WriteToJSON {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

		FileWriter outfile = new FileWriter("output.txt", false);
		PrintWriter output = new PrintWriter(outfile);

		output.println("testing");
		
		
		
		//  6 data points to output to JSON
		// Last, First, M., Pension, Location, Salary
		
		
		output.print("[");
		
		
		
		output.print("{"); // start of a new record - outer loop
		
			
			// write record fields - inner loop
			output.print("last:");
			output.print(LastName.get(x));
			output.print(","):
			output.print("first:");
			output.print(FirstName.get(x));
			output.print(","):
			output.print("middle:");
			output.print(MiddleName.get(x));
			output.print(","):	

			output.print(Pension.get(x));	
			output.print(":");
			output.print(Column[1]);
			output.print(","):
				
			
			
		
		
		output.close();
		
		System.out.println("done. yay!");
	}

}

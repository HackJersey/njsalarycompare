import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RecordScraper {
	static ArrayList LastName = new ArrayList();
	static ArrayList FirstName = new ArrayList();
	static ArrayList MiddleInitial = new ArrayList();
	static ArrayList LocationName = new ArrayList();
	static ArrayList PensionName = new ArrayList();
	static ArrayList Salary = new ArrayList();
	static ArrayList UniqueID = new ArrayList();
	static int i = 0;

	public static void main(String[] args) throws IOException{
		RecordScraper obj = new RecordScraper();
		obj.run();
		
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

		FileWriter outfile = new FileWriter("output.txt", false);
		PrintWriter output = new PrintWriter(outfile);
		
		//  6 data points to output to JSON
		// Last, First, M., Pension, Location, Salary
		int x=0;
		output.println("[");
		while(x<i)
		{
			output.print("{"); // start of a new record - outer loop
		
			output.println(x);
			// write record fields - inner loop
			output.print("MEMBER_LAST_NAME:");
			output.print(LastName.get(x));
			output.println(",");
			output.print("MEMBER_FIRST_NAME:");
			output.print(FirstName.get(x));
			output.println(",");
			output.print("MEMBER_MI:");
			output.print(MiddleInitial.get(x));
			output.println(",");
			output.print("PENSION_FUND_NAME:");
			output.print(PensionName.get(x));
			output.println(",");
			output.print("LOCATION_NAME:");
			output.print(LocationName.get(x));
			output.println(",");
			output.print("CURRENT_EMPLOYER_SALARY_AMT:");
			output.println(Salary.get(x));
			output.println("},"); 
			x+=1;
		}
		output.print("]");
	}

	public void run() {
		try {
			String csvFile = "YourMoney_Active_Pension_Members.csv";
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			String Data0, Data1;
			int Row = 0, Count = 0;
			boolean Repeat;

			br = new BufferedReader(new FileReader(csvFile));

			line = br.readLine();
			String[] Column0 = line.split(cvsSplitBy);

			UniqueID.add(Column0[1] + Column0[2] + Column0[6]);
			while ((line = br.readLine()) != null) {
				// use comma as separator
				i+=1;
				Count = 0;
				Row +=1;
				
				Repeat=false;
				
				String[] Column = line.split(cvsSplitBy);
				UniqueID.add(Column[1] + Column[2]);
				Data0 = (String) UniqueID.get(Row);
				//Searching for matches in data
				while(Row>Count){
					Data1=(String) UniqueID.get(Count);
					if(Data0==Data1){
						Repeat = true;
						System.out.println(Count);
						Count=Row+1;
					}
					System.out.println(Data0 + " : " + Data1);

					Count+=1;
				}
				
				//adding row to data if it is not repeated
				if(Repeat == false)
				{
				LastName.add(Column[1]);
				FirstName.add(Column[2]);
				MiddleInitial.add(Column[3]);
				LocationName.add(Column[8]);
				PensionName.add(Column[10]);
				Salary.add(Column[18]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
}

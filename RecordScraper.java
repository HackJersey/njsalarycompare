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
	static ArrayList LocationName = new ArrayList();
	static ArrayList PensionGroup = new ArrayList();
	static ArrayList PensionFund = new ArrayList();
	static ArrayList Salary = new ArrayList();
	static ArrayList UniqueID = new ArrayList();
	static String[] COUNTY = {"ATLANTIC COUNTY", "BERGEN COUNTY", "BURLINGTON COUNTY", "CAMBDEN COUNTY",
		"CAPE MAY COUNTY", "CUMBERLAND COUNTY", "ESSEX COUNTY", "GLOUCESTER COUNTY",
		"HUDSON COUNTY", "HUNDERTON COUNTY", "MERCER COUNTY", "MIDDLESEX COUNTY",
		"MONMOUTH COUNTY", "MORRIS COUNTY", "OCEAN COUNTY", "PASSAIC COUNTY", "SALEM COUNTY",
		"SOMERSET COUNTY", "SUSSEX COUNTY", "UNION COUNTY", "WARREN COUNTY", "Statewide"};
	static double[] COUNTY_OVERALL, COUNTY_STATEWIDE, COUNTY_PUBLIC_EMPLOYEES, COUNTY_TEACHERS, COUNTY_POLICE,COUNTY_FIRE;
	static int i = 0;

	public static void main(String[] args) throws IOException{
		RecordScraper obj = new RecordScraper();
		obj.run();
		
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

		FileWriter outfile = new FileWriter("output.txt", false);
		PrintWriter output = new PrintWriter(outfile);

		int x=0, z=0;
		double Get_Salary;
		double[] Total, Total_Avg, Total_Fire, Total_Police, Total_Teacher, Total_Public;
		String Location = null, Pension_Group = null, Pension_Fund;
		
		while (z < i) {
			Location = (String) LocationName.get(z);
			Pension_Group = (String) PensionGroup.get(z);
			Pension_Fund = (String) PensionFund.get(z);
			Get_Salary = 90;
			
			if(Location.equals(COUNTY[0])){
				if(Pension_Group.equals("FIREFIGHTER")){
					
				}
				if(Pension_Group.equals("POLICE OFFICER")){
					
				}
				if(Pension_Fund.equals("TEACHERS' PENSION AND ANNUITY FUND")){
					
				}
				if(Pension_Fund.equals("PUBLIC EMPLOYEES' RETIREMENT SYSTEM")){
					
				}
			}
			if(Location.equals(COUNTY[1])){
				
			}
			if(Location.equals(COUNTY[2])){
				
			}
			if(Location.equals(COUNTY[3])){
				
			}
			if(Location.equals(COUNTY[4])){
				
			}
			if(Location.equals(COUNTY[5])){
				
			}
			if(Location.equals(COUNTY[6])){
				
			}
			if(Location.equals(COUNTY[7])){
				
			}
			if(Location.equals(COUNTY[8])){
				
			}
			if(Location.equals(COUNTY[9])){
				
			}
			if(Location.equals(COUNTY[10])){
				
			}
			if(Location.equals(COUNTY[11])){
				
			}
			if(Location.equals(COUNTY[12])){
				
			}
			if(Location.equals(COUNTY[13])){
				
			}
			if(Location.equals(COUNTY[14])){
				
			}
			if(Location.equals(COUNTY[15])){
				
			}
			if(Location.equals(COUNTY[16])){
				
			}
			if(Location.equals(COUNTY[17])){
				
			}
			if(Location.equals(COUNTY[18])){
				
			}
			if(Location.equals(COUNTY[19])){
				
			}
			if(Location.equals(COUNTY[20])){
				
			}
			if(Location.equals(COUNTY[21])){
				
			}
		}
		
		//Creates JSON file to be implemented with other code
		output.print("[");
		while(x<22)
		{
			output.print("{ 'FIPS': '001',");
			output.println("'" + COUNTY[x] +"': ");
			output.print("{ 'Overall': ");
			output.print(COUNTY_OVERALL[x] + ", 'Statewide': ");
			output.print(COUNTY_STATEWIDE[x] + ", 'Public Employees': ");
			output.print(COUNTY_PUBLIC_EMPLOYEES[x] + ", 'Teachers': ");
			output.print(COUNTY_TEACHERS[x] + ", 'Police': ");
			output.print(COUNTY_POLICE[x] + ", 'Fire': ");
			output.println(COUNTY_FIRE[x] + "}");
			output.print("},");
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
			String Data0 = null, Data1 = null;
			int Row = 0, Count = 0;

			br = new BufferedReader(new FileReader(csvFile));
			
			//Reads data from excell file
			while ((line = br.readLine()) != null) {
				String[] Column = line.split(cvsSplitBy);
				//Creates a unique ID for each array
				UniqueID.add(Column[1] + Column[2] + Column[18]);
				
				//Stores data from excell file
				LocationName.add(Column[8]);
				PensionFund.add(Column[10]);
				PensionGroup.add(Column[12]);
				Salary.add(Column[19]+Column[20]);
				i+=1;
			}
			Row = 0;
			Count = 0;
		
			while(Row<i){
				Salary.get(Row);
			//Sort through array to check for duplicates
/*			while (Row < i) {
				Row += 1;
				Count = Row + 1;
				Data0 = (String) UniqueID.get(Row);

				// Searching for matches in data
				while (Count < UniqueID.size()) {
					Data1 = (String) UniqueID.get(Count);
					if (Data0.equals(Data1)) {
						//Removes duplicates
						System.out.println(Data0);
						UniqueID.remove(Count);
						LocationName.remove(Count);
						PensionGroup.remove(Count);
						PensionFund.remove(Count);
						Salary.remove(Count);
					}
					Count += 1;
				}
			}*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
}

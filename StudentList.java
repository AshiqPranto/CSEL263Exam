import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	
	static Constants constants = new Constants();
	
	public static BufferedReader getBufferedReader()
	{
		// BufferedReader bufferedReader;
		try {
			BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(constants.StudentsList)));
					return bufferedReader;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			public static BufferedWriter getBufferedWriter()
			{
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(constants.StudentsList, true));
						return bufferedWriter;
					} catch (Exception e) {
						System.out.println(e);
					}
					return null;
				}
				
				public static void main(String[] args) {
					//		Check arguments
					if(args.length!=1)
					{
						System.out.println("Please Enter only one argument..!");
					}
					else if(args[0].equals(constants.ShowAll)) {
						System.out.println("Loading data ...");			
						try {
							BufferedReader bufferedReader = getBufferedReader();
							String readString = bufferedReader.readLine();
							String studentList[] = readString.split(constants.StudentEntryDelimiter);			
							for(String student : studentList)
							{
								System.out.println(student);
							}
						}catch (Exception e)
						{
							
						} 
						System.out.println("Data Loaded.");
					}
					else if(args[0].equals(constants.ShowRandom)) 
					{
						System.out.println("Loading data ...");			
						try {
							BufferedReader bufferedReader = getBufferedReader();
							String readString = bufferedReader.readLine();
							// System.out.println(r);
							String studentList[] = readString.split(constants.StudentEntryDelimiter);	
							// Random x = new Random();
							// 	int y = x.nextInt();
							// 		System.out.println(i[y]);
							int randomNumber =  (int)((double)Math.random()*(int)studentList.length);
			System.out.println(studentList[randomNumber]);
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains(constants.AddEntry)){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferedWriter = getBufferedWriter();
			String newStudent = args[0].substring(1);
	        Date date = new Date();
	        String dateFormatSample = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(dateFormatSample);
	        String finalDate = dateFormat.format(date);
			bufferedWriter.write(constants.StudentEntryDelimiter+newStudent+"\nList last updated on "+finalDate);
			bufferedWriter.close();
			} catch (Exception e)
			{

			}		
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains(constants.FindEntry)) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = getBufferedReader();
			String readString = bufferedReader.readLine();
			String studentList[] = readString.split(constants.StudentEntryDelimiter);	
			boolean done = false;
			String searchStudent = args[0].substring(1);
			for(int idx = 0; idx<studentList.length && !done; idx++) 
			{
				if(studentList[idx].equals(searchStudent)) 
				{
					System.out.println("We found it!");
					done=true;
				}
			}
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains(constants.ShowCount)) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferedReader = getBufferedReader();
			String readString = bufferedReader.readLine();
			char charArray[] = readString.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char c:charArray) 
			{
				if(c ==' ') 
				{
					if (!in_word)
					{	
						count++; 
						in_word =true;
					}
					else 
					{ 
						in_word=false;
					}
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e)
			{
				
			} 
			System.out.println("Data Loaded.");			
		}
	}
}
//   Name:   Shen Tsun 
//   Student ID:  57142732
//   Lab section: T02 

import java.util.*;
// Import the FileWriter class
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class studentManagementSystem {
	public static void main(String[] args)throws IOException {
		System.out.println("");
		login();

	}
	
	//login
	static void login() throws IOException {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			//read users.txt
			FileInputStream fstream = new FileInputStream("src/users.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			//create map for users
			HashMap<String, String> users = new HashMap<String, String>();
			while ((strLine = br.readLine()) != null){
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String name = splited[0];
			  String password = splited[1];
			  users.put(name,password);
			}
			
			//Login
			boolean welcome = true;
			int count = 3;
			boolean cont = true;
			while(welcome&&count>=0) {
				System.out.println("Welcome to the student management system, please login to your account");
				count = 3;
				cont = true;
				while(cont) {
					Scanner input = new Scanner(System.in);
					System.out.println("please enter user name:");
				    String username = input.next(); 
				    System.out.println("please enter password: ");
				    String password = input.next();
				    if(users.containsKey(username)) {
				    	if(password.equals(users.get(username))) {
				    		System.out.println("");
				    		mainMenu();
				    		welcome = false;
				    		cont = false;
				    	}
				    	else {
					    	count -= 1;
					    	if(count!=0) {
					    		System.out.println("You have " + count + " attempts left");
					    	}	
					    	else {
					    		cont = false;
					    	}
					    }
				    }
				    else {
				    	count -= 1;
				    	if(count!=0) {
				    		System.out.println("You have " + count + " attempts left");
				    	}	
				    	else {
				    		cont = false;
				    	}
				    }
				}
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	//main menu
	static void mainMenu()throws IOException {
	    System.out.println("Please select the functional module you want to enter");
	    System.out.println("Press 1 to enter the student personal information management module");
	    System.out.println("Press 2 to enter the course information management module");
	    System.out.println("Press 3 to enter the student course enrollment management module");
	    System.out.println("Press 4 to perform backup (still under maintenance)");
	    System.out.println("Press 5 and you will exit the program (still under maintenance)");
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter the number corresponding to the module you want to enter");
	    int module = input.nextInt(); 
	    if(module==1) {
	    	System.out.println("");
	    	studentInformationManagementModule();
	    }
	    else if(module==2) {
	    	System.out.println("");
	    	courseInformationManagementModule();
	    }
	    else if(module==3) {
	    	System.out.println("");
	    	studentEnrollmentStatusManagementModule();
	    }
	    else if(module==4||module==5) {
	    	System.out.println("");
	    	System.out.println("Under Maintenance");
	    	System.out.println("");
	    	mainMenu();
	    }
	    else {
	    	System.out.println("");
	    	System.out.println("Please choose within 1-5 ");
	    	System.out.println("");
	    	mainMenu();
	    }
	    
	}
	
	//student information management module   
	static void studentInformationManagementModule() throws IOException{
		System.out.println("Welcome to the student personal information management module");
		System.out.println("Please select the functional module you want to enter");
	    System.out.println("Press 1 to add student personal information");
	    System.out.println("Press 2 to delete student personal information");
	    System.out.println("Press 3 to modify student personal information");
	    System.out.println("Press 4 to inquire about student's personal information");
	    System.out.println("Press 5 to display all data");
	    System.out.println("Press 6 to return");
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter the number corresponding to the module you want to enter");
	    int module = input.nextInt(); 
	    if(module==1) {
	    	System.out.println("");
	    	addStudentInformation();
	    }
	    else if(module==2) {
	    	System.out.println("");
	    	deleteStudentInformation();
	    }
	    else if(module==3) {
	    	System.out.println("");
	    	modifyStudentInformation();
	    }
	    else if(module==4) {
	    	System.out.println("");
	    	queryStudentInformation();
	    }
	    else if(module==5) {
	    	System.out.println("");
	    	displayAllData();
	    }
	    else if(module==6) {
	    	System.out.println("");
	    	mainMenu();
	    }
	    else {
	    	System.out.println("");
	    	System.out.println("Please choose within 1-6 ");
	    	System.out.println("");
	    	studentInformationManagementModule();
	    }
	}
	
	static void addStudentInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			//read students.txt
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			//create map 
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String name = splited[1];
			  String gender = splited[2];
			  
			  values.add(name);
			  values.add(gender);
			  students.put(studentID, values);
			  values = new ArrayList<String>();
			  
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter student ID");
		    String studentID = input.next(); 
		    System.out.println("Please enter the student's name");
		    String name = input.next();
		    System.out.println("Please enter the gender of the student (male/female)");
		    String gender = input.next();
		    //test if the studentid exist already
		    if(students.containsKey(studentID)) {
		    	System.out.println("This student ID already exists, please reconfirm the student information that needs to be added");
		    	System.out.println("");
		    	studentInformationManagementModule();
		    }
		    else {
		    	//add stduent information into txt
		    	try {
		    		  BufferedWriter studentsI =new BufferedWriter(new FileWriter("src/students.txt", true));
		    		  studentsI.newLine();
		    	      studentsI.append(studentID + " " + name + " " + gender);
		    	      studentsI.close();
		    	      System.out.println("Added successfully");
		    	      System.out.println("");
		    	      studentInformationManagementModule();
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }
		    }
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void deleteStudentInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String name = splited[1];
			  String gender = splited[2];
			  
			  values.add(name);
			  values.add(gender);
			  students.put(studentID, values);
			  values = new ArrayList<String>();
			}
			 
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter student ID corresponding to the student you want to delete");
		    String studentID = input.next(); 
		    System.out.println("Please enter the student you want to delete");
		    String name = input.next();
		    System.out.println("Please enter the gender of the student you want to delete(male/female)");
		    String gender = input.next();
		    
		    //test if the student information exist if exist delete the data from enrollment.txt
		    if(students.containsKey(studentID)) {
		    	if(students.get(studentID).get(0).equals(name)&&students.get(studentID).get(1).equals(gender)) {
		    		database = new String[10];
					totalLength =0;
					FileInputStream fstreamm = new FileInputStream("src/enrollment.txt");
					BufferedReader brr = new BufferedReader(new InputStreamReader(fstreamm));
					String strLinee;
					
					while ((strLinee = brr.readLine()) != null)   {
						
					  database[totalLength] = strLinee;
					  totalLength++;
					  
					  String[] splitedd = strLinee.split(" ");
					  String studentIDE = splitedd[0];
					  String courseIDE = splitedd[1];
					  if(studentIDE.equals(studentID)) {
						  File enrollmentFile = new File("src/enrollment.txt");
						  File tempFile = new File("src/temp.txt");
			
						  BufferedReader reade = new BufferedReader(new FileReader(enrollmentFile));
						  BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));
						  
						  String lineToRemove = studentIDE + " " + courseIDE;
						  String currentLine;
						  boolean isFirstLine = true;
						  
						  while((currentLine = reade.readLine()) != null) {
							  String trimmedLine = currentLine.trim();
							  if(!trimmedLine.equals(lineToRemove)) {
								  if(isFirstLine == true) {
									  isFirstLine = false;
									  write.write(currentLine);
								  }
								  else {
									  write.newLine();
									  write.write(currentLine);
								  }
							  }
						  }
						  write.close(); 
						  reade.close(); 
						  boolean successful = tempFile.renameTo(enrollmentFile);
					  }
					}
		    	}
		    	 else {
				    	System.out.println("Detection failed, please check whether the entered information is correct");
				    	System.out.println("");
				    	studentInformationManagementModule();
				    }
		    }
		    else {
		    	System.out.println("Detection failed, please check whether the entered information is correct");
		    	System.out.println("");
		    	studentInformationManagementModule();
		    }
		    
		  //test if the student information exist if exist delete the data from students.txt
		    if(students.containsKey(studentID)) {
		    	if(students.get(studentID).get(0).equals(name)&&students.get(studentID).get(1).equals(gender)) {
		    		
			    	File studentsFile = new File("src/students.txt");
			    	File tempFile = new File("src/temp.txt");
	
			    	BufferedReader reade = new BufferedReader(new FileReader(studentsFile));
			    	BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));
	
			    	String lineToRemove = studentID + " " + name + " " + gender;
			    	String currentLine;
			    	boolean isFirstLine = true;
			    	
			    	while((currentLine = reade.readLine()) != null) {
			    	    String trimmedLine = currentLine.trim();
			    	    if(!trimmedLine.equals(lineToRemove)) {
							  if(isFirstLine == true) {
								  isFirstLine = false;
								  write.write(currentLine);
							  }
							  else {
								  write.newLine();
								  write.write(currentLine);
							  }
						  }
			    	}
			    	write.close(); 
			    	reade.close(); 
			    	boolean successful = tempFile.renameTo(studentsFile);
			    	
			    	System.out.println("Successfully deleted");
			    	System.out.println("Data has been synchronized to the grade information table");
			    	System.out.println("");
			    	studentInformationManagementModule();
		    	}
		    	 else {
				    	System.out.println("Detection failed, please check whether the entered information is correct");
				    	System.out.println("");
				    	studentInformationManagementModule();
				    }
		    }
		    else {
		    	System.out.println("Detection failed, please check whether the entered information is correct");
		    	System.out.println("");
		    	studentInformationManagementModule();
		    }
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void modifyStudentInformation()throws IOException {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String name = splited[1];
			  String gender = splited[2];
			  
			  values.add(name);
			  values.add(gender);
			  students.put(studentID, values);
			  values = new ArrayList<String>();
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter student ID corresponding to the student whose information needs to be modifies");
		    String studentID = input.next(); 
		    System.out.println("Please enter the revised student name");
		    String name = input.next();
		    System.out.println("Please enter the revised gender of the student (male/female)");
		    String gender = input.next();
		    
		    if(students.containsKey(studentID)) {
		    	String filePath = "src/students.txt";
			    Scanner sc = new Scanner(new File(filePath));
			    StringBuffer buffer = new StringBuffer();
			    while (sc.hasNextLine()) {
			       buffer.append(sc.nextLine()+System.lineSeparator());
			    }
			    //modify student information
			    String fileContents = buffer.toString();
			    sc.close();
			    String bmodify = studentID + " " + students.get(studentID).get(0) + " " + students.get(studentID).get(1);
			    String amodify = studentID + " " + name + " " + gender;
			    fileContents = fileContents.replaceAll(bmodify, amodify);
			    FileWriter writer = new FileWriter(filePath);
			    System.out.println("The modification is successful");
			    writer.append(fileContents);
			    writer.flush();
			    System.out.println("");
		    	studentInformationManagementModule();
		    }
		    else {
		    	System.out.println("This student ID does not exists, please reconfirm the student ID that needs to be modified");
		    	System.out.println("");
		    	studentInformationManagementModule();
		    }
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void queryStudentInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the student ID corresponding to the student's information you want to query");
			String studentD = input.next();
			boolean canQuery = true;
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String name = splited[1];
			  String gender = splited[2];
			  //query student information
			  if(studentD.equals(studentID)) {
				  System.out.println("Student ID Name Gender");
				  System.out.println(studentID + " " + name + " " + gender);
				  System.out.println("Query is complete");
				  System.out.println("Return to the main interface after 5 seconds");
				  Thread.sleep(5000); 
				  System.out.println("");
				  studentInformationManagementModule();
			  }
			  else {
				  canQuery = false;
			  }
			}
			//student not exist because student id cannot be found
			if(canQuery == false) {
				System.out.println("The student ID you entered does not exist");
				System.out.println("Return to the main interface after 5 seconds");
				Thread.sleep(5000); 
				System.out.println("");
				studentInformationManagementModule();
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void displayAllData()throws IOException {
		System.out.println("Student ID Name Gender");
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String name = splited[1];
			  String gender = splited[2];
			  //display all student information one by one
			  System.out.println(studentID + " " + name + " " + gender);
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		//do backup in studentsBackup.txt
		try {
			File fout = new File("src/studentsBackup.txt");
			FileOutputStream fstream = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));
			
			for (int j =0; j<totalLength;j++)
			{
				bw.write(database[j]);
				bw.newLine();
			}
			bw.close();
		}catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Press Enter key to continue");
		input.nextLine();
		System.out.println("");
		studentInformationManagementModule();
	}
		
	//course information management module
	static void courseInformationManagementModule() throws IOException{
		System.out.println("Welcome to the course information management module");
		System.out.println("Please select the operation that needs to be performed");
	    System.out.println("Press 1 to add course information");
	    System.out.println("Press 2 to delete course information");
	    System.out.println("Press 3 to modify course information");
	    System.out.println("Press 4 for course information");
	    System.out.println("Press 5 to display all information");
	    System.out.println("Press 6 to return");
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter the number corresponding to the module you want to enter");
	    int module = input.nextInt(); 
	    if(module==1) {
	    	System.out.println("");
	    	addCourseInformation();
	    }
	    else if(module==2) {
	    	System.out.println("");
	    	deleteCourseInformation();
	    }
	    else if(module==3) {
	    	System.out.println("");
	    	modifyCoursetInformation();
	    }
	    else if(module==4) {
	    	System.out.println("");
	    	querycourseInformation();
	    }
	    else if(module==5) {
	    	System.out.println("");
	    	displayAllInformation();
	    }
	    else if(module==6) {
	    	System.out.println("");
	    	mainMenu();
	    }
	    else {
	    	System.out.println("");
	    	System.out.println("Please choose within 1-6 ");
	    	System.out.println("");
	    	courseInformationManagementModule();
	    }
	}
	
	static void addCourseInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			//read courses.txt
			FileInputStream fstream = new FileInputStream("src/courses.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			//create map for courses
			Map<String, List<String>> courses = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String courseID = splited[0];
			  String name = splited[1];
			  String credit = splited[2];
			  String time = splited[3];
			  
			  values.add(name);
			  values.add(credit);
			  values.add(time);
			  courses.put(courseID, values);
			  values = new ArrayList<String>();
			  
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter course ID");
		    String courseID = input.next(); 
		    System.out.println("Please enter the course name");
		    String name = input.next();
		    System.out.println("Please enter course credit");
		    String credit = input.next();
		    System.out.println("Please enter course time");
		    String time = input.next();
		    //check if the courseid exist
		    if(courses.containsKey(courseID)) {
		    	System.out.println("This course already exists, please reconfirm the course information that needs to be added");
		    	System.out.println("");
		    	courseInformationManagementModule();
		    }
		    else {
		    	//add course information
		    	try {
		    		  BufferedWriter studentsI =new BufferedWriter(new FileWriter("src/courses.txt", true));
		    		  studentsI.newLine();
		    	      studentsI.append(courseID + " " + name + " " + credit + " " + time);
		    	      studentsI.close();
		    	      System.out.println("Added successfully");
		    	      System.out.println("");
		    	      courseInformationManagementModule();
		    	    } catch (IOException e) {
		    	      System.out.println("An error occurred.");
		    	      e.printStackTrace();
		    	    }
		    }
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
			
	static void deleteCourseInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/courses.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> courses = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String courseID = splited[0];
			  String name = splited[1];
			  String credit = splited[2];
			  String time = splited[3];
			  
			  values.add(name);
			  values.add(credit);
			  values.add(time);
			  courses.put(courseID, values);
			  values = new ArrayList<String>();
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter course ID corresponding to the course you want to delete");
		    String courseID = input.next(); 
		    System.out.println("Please enter the name of the course you want to delete");
		    String name = input.next();
		    System.out.println("Please enter course corresponding to the course you want to delete");
		    String credit = input.next();
		    System.out.println("Please enter course time corresponding to the course you want to delete");
		    String time = input.next();
		    
		    //test if the course information exist if exist delete the data from enrollment.txt
		    if(courses.containsKey(courseID)) {
		    	if(courses.get(courseID).get(0).equals(name)&&courses.get(courseID).get(1).equals(credit)&&courses.get(courseID).get(2).equals(time)) {
		    		database = new String[10];
					totalLength =0;
					FileInputStream fstreamm = new FileInputStream("src/enrollment.txt");
					BufferedReader brr = new BufferedReader(new InputStreamReader(fstreamm));
					String strLinee;
					
					while ((strLinee = brr.readLine()) != null)   {
						
					  database[totalLength] = strLinee;
					  totalLength++;
					  
					  String[] splitedd = strLinee.split(" ");
					  String studentIDE = splitedd[0];
					  String courseIDE = splitedd[1];
					  
					  //delete the course information
					  if(courseIDE.equals(courseID)) {
						  File enrollmentFile = new File("src/enrollment.txt");
						  File tempFile = new File("src/temp.txt");
			
						  BufferedReader reade = new BufferedReader(new FileReader(enrollmentFile));
						  BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));
						  
						  String lineToRemove = studentIDE + " " + courseIDE;
						  String currentLine;
						  boolean isFirstLine = true;
						  
						  while((currentLine = reade.readLine()) != null) {
							  // trim newline when comparing with lineToRemove
							  String trimmedLine = currentLine.trim();
							  if(!trimmedLine.equals(lineToRemove)) {
								  if(isFirstLine == true) {
									  isFirstLine = false;
									  write.write(currentLine);
								  }
								  else {
									  write.newLine();
									  write.write(currentLine);
								  }
							  }
						  }
						  write.close(); 
						  reade.close(); 
						  boolean successful = tempFile.renameTo(enrollmentFile);
					  }
					}
		    	}
		    	 else {
				    	System.out.println("Detection failed, please check whether the entered information is correct");
				    	System.out.println("");
				    	courseInformationManagementModule();
				    }
		    }
		    else {
		    	System.out.println("Detection failed, please check whether the entered information is correct");
		    	System.out.println("");
		    	courseInformationManagementModule();
		    }
		    
		    //test if the course information exist if exist delete the data from courses.txt
		    if(courses.containsKey(courseID)) {
		    	if(courses.get(courseID).get(0).equals(name)&&courses.get(courseID).get(1).equals(credit)&&courses.get(courseID).get(2).equals(time)) {
		    		File coursesFile = new File("src/courses.txt");
			    	File tempFile = new File("src/coursestemp.txt");
	
			    	BufferedReader reade = new BufferedReader(new FileReader(coursesFile));
			    	BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));
	
			    	String lineToRemove = courseID + " " + name + " " + credit + " " + time;
			    	String currentLine;
			    	boolean isFirstLine = true;
			    	
			    	while((currentLine = reade.readLine()) != null) {
			    	    // trim newline when comparing with lineToRemove
			    	    String trimmedLine = currentLine.trim();
			    	    if(!trimmedLine.equals(lineToRemove)) {
							  if(isFirstLine == true) {
								  isFirstLine = false;
								  write.write(currentLine);
							  }
							  else {
								  write.newLine();
								  write.write(currentLine);
							  }
						  }
			    	}
			    	write.close(); 
			    	reade.close(); 
			    	boolean successful = tempFile.renameTo(coursesFile);
					  
			    	System.out.println("Successfully deleted");
			    	System.out.println("Data has been synchronized to the grade information table");
			    	System.out.println("");
			    	courseInformationManagementModule();
		    	}
		    	else {
		    		System.out.println("Detection failed, please check whether the entered information is correct");
			    	System.out.println("");
			    	courseInformationManagementModule();
		    	}
		    }
		    else {
		    	System.out.println("Detection failed, please check whether the entered information is correct");
		    	System.out.println("");
		    	courseInformationManagementModule();
		    }
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}	
	}
	
	static void modifyCoursetInformation() throws IOException{
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/courses.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> courses = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String courseID = splited[0];
			  String name = splited[1];
			  String credit = splited[2];
			  String time = splited[3];
			  
			  values.add(name);
			  values.add(credit);
			  values.add(time);
			  courses.put(courseID, values);
			  values = new ArrayList<String>();
			  
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the course ID whose information needs to be modified");
			String courseID = input.next(); 
			System.out.println("Please enter the revised course name");
			String name = input.next();
			System.out.println("Please enter the revised course credit");
			String credit = input.next();
			System.out.println("Please enter the revised course time");
			String time = input.next();
			if(courses.containsKey(courseID)) {
				String filePath = "src/courses.txt";
				Scanner sc = new Scanner(new File(filePath));
				StringBuffer buffer = new StringBuffer();
				while (sc.hasNextLine()) {
				   buffer.append(sc.nextLine()+System.lineSeparator());
				}
				//modify course information
				String fileContents = buffer.toString();
				sc.close();
				String bmodify = courseID + " " + courses.get(courseID).get(0) + " " + courses.get(courseID).get(1) + " " + courses.get(courseID).get(2);
				String amodify = courseID + " " + name + " " + credit + " " + time;
				fileContents = fileContents.replace(bmodify, amodify);
				FileWriter writer = new FileWriter(filePath);
				System.out.println("The modification is successful");
				writer.append(fileContents);
				writer.flush();
				System.out.println("");
				courseInformationManagementModule();
			}
			else {
				System.out.println("This course ID does not exists, please reconfirm the course ID that needs to be modified");
				System.out.println("");
				courseInformationManagementModule();
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void querycourseInformation() {
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/courses.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> students = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the course ID corresponding to the information you want to inquire about the course");
			String courseD = input.next();
			boolean canQuery = true;
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String courseID = splited[0];
			  String name = splited[1];
			  String credit = splited[2];
			  String time = splited[3];
			  
			  //query course information
			  if(courseD.equals(courseID)) {
				  System.out.println("Course ID Name Credit Time");
				  System.out.println(courseID + " " + name + " " + credit + " " + time);
				  System.out.println("Query is complete");
				  System.out.println("Return to the main interface after 5 seconds");
				  Thread.sleep(5000); 
				  System.out.println("");
				  courseInformationManagementModule();
			  }
			  else {
				  canQuery = false;
			  }
			}
			//course not exist because student id cannot be found
			if(canQuery == false) {
				System.out.println("The course ID you entered does not exist");
				System.out.println("Return to the main interface after 5 seconds");
				Thread.sleep(5000); 
				System.out.println("");
				courseInformationManagementModule();
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void displayAllInformation()throws IOException {
		System.out.println("Course ID Name Credit Time");
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/courses.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			Map<String, List<String>> courses = new HashMap<String, List<String>>();
			List<String> values = new ArrayList<String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String courseID = splited[0];
			  String name = splited[1];
			  String credit = splited[2];
			  String time = splited[3];
			  
			  //display all course information one by one
			  System.out.println(courseID + " " + name + " " + credit + " " + time);
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		try {
			//do backup in coursesBackup .txt
			File fout = new File("src/coursesBackup .txt");
			FileOutputStream fstream = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));
			
			for (int j =0; j<totalLength;j++)
			{
				bw.write(database[j]);
				bw.newLine();
			}
			bw.close();
		}catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Press Enter key to continue");
		input.nextLine();
		System.out.println("");
		courseInformationManagementModule();
	}
	
	//student enrollment status management module
	static void studentEnrollmentStatusManagementModule() throws IOException{
		System.out.println("Welcome to the student enrollment status management module");
		System.out.println("Please select the operation that needs to be performed");
	    System.out.println("Press 1 to add enrollment status");
	    System.out.println("Press 2 to delete enrollment status information");
	    System.out.println("Press 3 to query enrollment status information");
	    System.out.println("Press 4 to display all information");
	    System.out.println("Press 5 to return");
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter the number corresponding to the module you want to enter");
	    int module = input.nextInt(); 
	    if(module==1) {
	    	System.out.println("");
	    	addEnrollmentStatus();
	    }
	    else if(module==2) {
	    	System.out.println("");
	    	deleteEnrollmentStatus();
	    }
	    else if(module==3) {
	    	System.out.println("");
	    	queryEnrollmentStatus();
	    }
	    else if(module==4) {
	    	System.out.println("");
	    	enrollmentInformation();
	    }
	    else if(module==5) {
	    	System.out.println("");
	    	mainMenu();
	    }
	    else {
	    	System.out.println("");
	    	System.out.println("Please choose within 1-5 ");
	    	System.out.println("");
	    	studentEnrollmentStatusManagementModule();
	    }
	}
	
	static void addEnrollmentStatus(){	
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter student ID");
		String studentID = input.next(); 
		System.out.println("Please enter course ID");
		String courseID = input.next();
		 
		//course
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fistream = new FileInputStream("src/courses.txt");
			BufferedReader bu = new BufferedReader(new InputStreamReader(fistream));
			String striLine;
			
			HashMap<String, String> courses = new HashMap<String, String>();
			String courseTime = "";
			boolean containsCourse = false;
			database = new String[10];
			totalLength =0;	
			while ((striLine = bu.readLine()) != null)   {
			  database[totalLength] = striLine;
			  totalLength++;
			  
			  String[] splited = striLine.split(" ");
			  String courseIDC = splited[0];
			  String time = splited[3];
			  courses.put(courseIDC, time);
			  if(courseID.equals(courseIDC)) {
				  courseTime = time;
				  containsCourse = true;
			  }
			}
			//find the input time in details
			String inputStartTime = "";
			String inputEndTime = "";
			String inputWeek = "";
				
			for(int i = 0; i<courseTime.length(); i++) {
				if(Character.isLetter(courseTime.charAt(i))){
					inputWeek+=courseTime.charAt(i);
				}
				else if(inputStartTime.length()==4) {
					if(Character.isDigit(courseTime.charAt(i))) {
						inputEndTime+=courseTime.charAt(i);
					}
				}
				else if(inputStartTime.length()<4) {
					if(Character.isDigit(courseTime.charAt(i))) {
						inputStartTime+=courseTime.charAt(i);
					}
				}
			}
			
			//student
			FileInputStream fstream = new FileInputStream("src/students.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			database = new String[10];
			totalLength =0;	
			boolean containsStudent = false;
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentIDS = splited[0];
			  //check if the student id exist
			  if(studentID.equals(studentIDS)) {
				  containsStudent = true;
			  }
			}
			
			//create list for the course that a student already registered
			if(containsStudent==true&&containsCourse==true) {
				FileInputStream fstreamE = new FileInputStream("src/enrollment.txt");
				BufferedReader brE = new BufferedReader(new InputStreamReader(fstreamE));
				String strLineE;
				database = new String[10];
				totalLength =0;	
				List<String> enrollmentCourse = new ArrayList<String>();
				while ((strLineE = brE.readLine()) != null)   {
					  database[totalLength] = strLineE;
					  totalLength++;
					  
					  String[] splitedd = strLineE.split(" ");
					  String studentIDE = splitedd[0];
					  String courseIDE = splitedd[1];
					  if(studentIDE.equals(studentID)){
						  enrollmentCourse.add(courseIDE);
					  }
					}
				
				String enrollmentStartTime = "";
				String enrollmentEndTime = "";
				String enrollmentWeek = "";
				int noConflict = 0; 
				List<String> enrollmentTime = new ArrayList<String>();
				for(int i = 0; i<enrollmentCourse.size(); i++) {
					enrollmentTime.add(courses.get(enrollmentCourse.get(i)));
				}
				for(int j = 0; j<enrollmentTime.size(); j++) {
					String oneTime = enrollmentTime.get(j);
					
					for(int i = 0; i<oneTime.length(); i++) {
						if(Character.isLetter(oneTime.charAt(i))) {
							enrollmentWeek+=oneTime.charAt(i);
						}
						else if(enrollmentStartTime.length()==4) {
							if(Character.isDigit(oneTime.charAt(i))) {
								enrollmentEndTime+=oneTime.charAt(i);
							}
						}
						else if(enrollmentStartTime.length()<4) {
							if(Character.isDigit(oneTime.charAt(i))) {
								enrollmentStartTime+=oneTime.charAt(i);
							}
						}
					}
					if(!enrollmentWeek.equals(inputWeek)) {
						noConflict+=1;
					}
					else if(Integer.parseInt(enrollmentStartTime)>Integer.parseInt(inputEndTime)&&Integer.parseInt(inputStartTime)>Integer.parseInt(enrollmentEndTime)) {
						noConflict+=1;
					}
					enrollmentStartTime = "";
					enrollmentEndTime = "";
					enrollmentWeek = "";
				}
				//add lesson to the student
				if(noConflict==enrollmentTime.size()) {
					try {
						BufferedWriter enrollments =new BufferedWriter(new FileWriter("src/enrollment.txt", true));
						enrollments.newLine();
						enrollments.append(studentID + " " + courseID);
						enrollments.close();
						System.out.println("Added successfully");
						System.out.println("");
						studentEnrollmentStatusManagementModule();
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
			    	    }
				}
				else {
					System.out.println("The class you selected conflicts with the course you have");
					System.out.println("Please re-select the course");
					System.out.println("");
					studentEnrollmentStatusManagementModule();
				}
			}
			else {
				System.out.println("The student ID or course ID does not exists");
				System.out.println("");
				studentEnrollmentStatusManagementModule();
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void deleteEnrollmentStatus(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter student ID corresponding to the student you want to delete");
	    String studentID = input.next(); 
	    System.out.println("Please enter course ID corresponding to the student you want to delete");
	    String courseID = input.next();
		
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/enrollment.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			HashMap<String, String> enrollment = new HashMap<String, String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentIDE = splited[0];
			  String courseIDE = splited[1];
			  
			  //delete student enrollment
			  if(studentID.equals(studentIDE)&&courseID.equals(courseIDE)) {
				  
				  File enrollmentFile = new File("src/enrollment.txt");
				  File tempFile = new File("src/temp.txt");
	
				  BufferedReader reade = new BufferedReader(new FileReader(enrollmentFile));
				  BufferedWriter write = new BufferedWriter(new FileWriter(tempFile));
				  
				  String lineToRemove = studentIDE + " " + courseIDE;
				  String currentLine;
				  boolean isFirstLine = true;
				  while((currentLine = reade.readLine()) != null) {
					  // trim newline when comparing with lineToRemove
					  String trimmedLine = currentLine.trim();
					  if(!trimmedLine.equals(lineToRemove)) {
						  if(isFirstLine == true) {
							  isFirstLine = false;
							  write.write(currentLine);
						  }
						  else {
							  write.newLine();
							  write.write(currentLine);
						  }
					  }
				  }
				  write.close(); 
				  reade.close(); 
				  boolean successful = tempFile.renameTo(enrollmentFile);
				  
				  System.out.println("Successfully deleted");
				  System.out.println("Data has been synchronized to the grade information table");
				  System.out.println("");
				  studentEnrollmentStatusManagementModule();
			  }
			}
			System.out.println("Detection failed, please check whether the entered information is correct");
			System.out.println("");
			studentEnrollmentStatusManagementModule();
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void queryEnrollmentStatus(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter student ID you want to query about");
	    String studentID = input.next(); 
	    System.out.println("Please enter course ID cooresponding to the information you want to check result");
	    String courseID = input.next();
	    
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/enrollment.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			HashMap<String, String> enrollment = new HashMap<String, String>();
			boolean canQuery = false;
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentIDE = splited[0];
			  String courseIDE = splited[1];
			  
			  //query the enrollment status of a student
			  if(studentIDE.equals(studentID)&&courseIDE.equals(courseID)) {
				  System.out.println("Student ID Course ID Enrollment Status");
				  System.out.println(studentID + " " + courseID + " " + "yes");
				  System.out.println("Query is complete");
				  System.out.println("Return to the main interface after 5 seconds");
				  Thread.sleep(5000); 
				  System.out.println("");
				  canQuery = true;
				  studentEnrollmentStatusManagementModule();
			  }
			}
			if(canQuery == false) {
				System.out.println("The student ID or course ID you entered does not exist");
				System.out.println("Return to the main interface after 5 seconds");
				Thread.sleep(5000); 
				System.out.println("");
				studentEnrollmentStatusManagementModule();
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
	}
	
	static void enrollmentInformation()throws IOException{
		System.out.println("Student ID Course ID Enrollment Status");
		String [] database = new String[10];
		int totalLength =0;		
		try {
			FileInputStream fstream = new FileInputStream("src/enrollment.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			HashMap<String, String> enrollment = new HashMap<String, String>();
			
			while ((strLine = br.readLine()) != null)   {
			  database[totalLength] = strLine;
			  totalLength++;
			  
			  String[] splited = strLine.split(" ");
			  String studentID = splited[0];
			  String courseID = splited[1];
			  
			  //display all the enrollment status one by one
			  System.out.println(studentID + " " + courseID + " yes" );
			  
			}
			fstream.close();
		}
		catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		try {
			File fout = new File("src/enrollmentBackup .txt");
			FileOutputStream fstream = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fstream));
			
			for (int j =0; j<totalLength;j++)
			{
				bw.write(database[j]);
				bw.newLine();
			}
			bw.close();
		}catch (Exception e) {
			System.err.println("Error:"+e.getMessage());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Press Enter key to continue");
		input.nextLine();
		System.out.println("");
		studentEnrollmentStatusManagementModule();
	}
}
 
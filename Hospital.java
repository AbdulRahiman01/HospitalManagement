package hospitalManSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hospital {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void insertPatient() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
			
			System.out.println("Enter Patient Id");
			int id = sc.nextInt();
			
			System.out.println("Enter Patient Name");
			String name = sc.next();
			
			System.out.println("Enter Patient Age");
			int age = sc.nextInt();
			
			System.out.println("Enter Gender");
			String gender = sc.next();
			
			System.out.println("Enter Patient Mobile Number");
			long mobile = sc.nextLong();
			
			System.out.println("Enter Patient Disease");
			String disease = sc.next();
			
			System.out.println("Enter current Date");
			String date = sc.next();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setLong(5, mobile);
			ps.setString(6, disease);
			ps.setString(7, date);
			
			int count = ps.executeUpdate();
			
			System.out.println(count + " Inserted Successfully");
			
			ps.close();
			con.close();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deletePatientDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","root");
			
			PreparedStatement ps = con.prepareStatement("delete from patient where id = ?");
			System.out.println("Enter Patient ID you want to Delete");
			int id = sc.nextInt();
			
			ps.setInt(1, id);
			
			int row = ps.executeUpdate();
			
			System.out.println(row +" Deleted successfully");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void fetchPatients() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","root");
			
			Statement s = con.createStatement();
		
			ResultSet rs = s.executeQuery("select * from patient");
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getLong(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.println(rs.getString(7)+"\t");
			}
			
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateDiseaseInfo() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","root");
			
			PreparedStatement ps = con.prepareStatement("update patient set disease = ? where id = ?");
			
			System.out.println("Enter Patient id");
			int id = sc.nextInt();
			
			System.out.println("Enter Disease Info as Mentioned in Reports");
			String disease = sc.next();
			
			ps.setString(1,disease);
			ps.setInt(2, id);
			
			int count = ps.executeUpdate();
			
			System.out.println(count + " : affected.........");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		boolean b = true;
		while(true) {
			System.out.println("enter 1 for insert,2 for delete,3 for fetch , 4 for update and 5 for exit");
			int choice = sc.nextInt();
			switch(choice) {
				
			case 1 : insertPatient();
			break;
			
			case 2 : deletePatientDetails();
			break;
			
			case 3 : fetchPatients();
			break;
			
			case 4 : updateDiseaseInfo();
			break;
			
			case 5 : System.exit(5);
			default: System.out.println("Invalid Input");
			
			}
			
		}
		
	}

}

package javaScript;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new LoginFrame();

	}

}
class LoginFrame extends JFrame {
	public LoginFrame() {
		setTitle("Login");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,2));
		
		JTextField userField = new JTextField();
		JPasswordField passField = new JPasswordField();
		JButton loginButton = new JButton("Login");
		JLabel usernameButton = new JLabel("Username");
		
		add(usernameButton);
		add(userField);
		add(passField);
		add(loginButton);
		
		loginButton.addActionListener(e->{
			String user =userField.getText();
			String pass = new String(passField.getPassword());
			if (user.equals("admin")&&pass.equals("1234")) {
				new MainFrame();
				dispose();
				
			}else {
				JOptionPane.showMessageDialog(this,"Incorrect Login!");
				
			}
		});
		setVisible(true);	
	}
}

class MainFrame extends JFrame {
	static ArrayList<Employee> employees = new ArrayList<>();
	public MainFrame() {
		setTitle("Office Management System");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		JButton addBtn = new JButton("Add Employee");
		JButton showBtn =new JButton("Show Employees");
		JButton exitBtn = new JButton("Exit");
		 add(addBtn);
		 add(showBtn);
		 add(exitBtn);
		 
		 addBtn.addActionListener(e-> new
				 AddEmployeeFrame());
		 showBtn.addActionListener(e-> new 
				 ShowEmployeeFrame());
		 exitBtn.addActionListener(e-> System.exit(0));
		  setVisible(true);	
	}
}
class AddEmployeeFrame extends JFrame {
	public AddEmployeeFrame() {
		setTitle ("Add Employee");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4,2));
		
		JTextField nameField = new JTextField();
		JTextField departmentField = new JTextField();
		JTextField salaryField = new JTextField();
		
		JButton saveButton = new JButton ("Add");
		
		add(new JLabel("Name : "));
		add(nameField);
		add(new JLabel ("Department : "));
		add(departmentField);
		add(new JLabel ("Salary"));
		add(salaryField);
		add(new JLabel());
		add(saveButton);
		
		saveButton.addActionListener(e-> {
			String name =nameField.getText();
			String department = departmentField.getText();
			double salary = 
						Double.parseDouble(salaryField.getText());
			MainFrame.employees.add(new Employee(name,department,salary));
			
			JOptionPane.showMessageDialog(this, "Employee Added.");
			dispose();
			
			
		});
		setVisible(true);

		
	}
}
class ShowEmployeeFrame extends JFrame {
	public ShowEmployeeFrame() {
		setTitle("employee list ");
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		String[] columns = {	"name","department","salary"};
		DefaultTableModel model = new 
				DefaultTableModel(columns,0);
		for (Employee emp : MainFrame.employees) {
			Object [] row = {emp.name1,emp.department1,emp.salary1};
			model.addRow(row);
		}
		JTable table = new JTable(model);
		add(new JScrollPane(table));
		setVisible(true);
		
	}
}

class Employee {
	String name1,department1;
	double salary1;
	public Employee (String name,String department,double salary) {
		this.name1 = name;
		this.department1=department;
		this.salary1=salary;
	}
}
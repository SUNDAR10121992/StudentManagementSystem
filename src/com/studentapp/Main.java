package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<Student> studentlist;
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*************student managment application system**********");

		System.out.println("****************welcome**************");
		studentlist = new ArrayList<Student>();
		scanner = new Scanner(System.in);

		while (true) {

			System.out.println("Select an option ...");
			System.out.println("1.Register a student ");
			System.out.println("2.Find a student By Student ID ");
			System.out.println("3.List of all student Info");
			System.out.println("4.List of all student Info in sorted order");
			System.out.println("5.Exit ");

			int option = scanner.nextInt();
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentByID(scanner);
				break;
			case 3:
				printAllStudentsData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option selected !....Enter between 1 to 5 ");

			}
		}
	}

	private static void exit() {
		System.out.println("Good bye");
		System.exit(0);
	}

	private static void printAllStudentsData() {
		System.out.println("-----------------PrintAll student Data-----------------");
		if (studentlist.size() > 0) {
			for (Student student : studentlist) {
				student.printStudentInfo();
			}
		} else {
			System.err.println(" Student List is empty !!! No student found");
		}

	}

	private static void findStudentByID(Scanner scanner2) {
		Student studentFound = null;
		System.out.println("Enter student ID");
		String studentID = scanner2.next();

		try {
			studentFound = studentlist.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentID))
					.findFirst().orElseThrow(() -> new RuntimeException("No data found !!!"));
		} catch (Exception e) {
			System.err.println("Student with ID : " + studentID + " not found");
		}
		studentFound.printStudentInfo();
	}

	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter student name");
		String studentName = scanner2.next();

		System.out.println("Enter student age");
		int studentAge = scanner2.nextInt();

		System.out.println("Enter student ID");
		String studentID = scanner2.next();

		Student newStudent = new Student(studentName, studentAge, studentID);
		studentlist.add(newStudent);

		while (true) {
			System.out.println("Enter the course to be enrroled!!...Type done to exit from loop ");

			String courseName = scanner2.next();
			if (courseName.equalsIgnoreCase("done")) {
				break;// exit from loop
			}
			newStudent.enrollCourse(courseName);

		}

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());//
			}

		};
		Collections.sort(studentlist, studentNameComparator);
		printAllStudentsData();
		// System.out.println(studentlist);
	}



}

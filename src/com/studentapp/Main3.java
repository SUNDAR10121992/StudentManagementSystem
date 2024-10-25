package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> studentlist;

	public static void main(String[] args) {
		System.out.println("*************student managment application system**********");

		System.out.println("***************welcome**************");
		studentlist = new ArrayList<Student>();
		// Read input from Terminal

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student name.....");
		String name = sc.next();// if u want to read input in String format you u will use next methode
		System.out.println("you have entered name " + name);
		// To read integer values from terminal
		// the readint()

		System.out.println("Enter studetn Age....");
		String age = sc.next();
		System.out.println("The student age is "+age);
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());//
			}

		};
		Collections.sort(studentlist, studentNameComparator);
		System.out.println(studentlist);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;

		try {
			result = studentlist.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found !!!"));
		} catch (Exception e) {
			System.err.println("Student with ID : " + studentId + " not found");
		}
		return result;

	}

}

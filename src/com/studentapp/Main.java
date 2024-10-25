package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Student> studentlist;

	public static void main(String[] args) {
		System.out.println("*************student managment application system**********");

		System.out.println("****************welcome**************");
		studentlist = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Sundar", 22, "S-10");
		s1.enrollCourse("java");

		Student s2 = new Student("sachin", 25, "S-11");
		s2.enrollCourse("Devops");
		s2.enrollCourse("DSA");

		Student s3 = new Student("kajal", 27, "S-12");
		s3.enrollCourse("java");
		s3.enrollCourse("Devops");

		
		sortByName();
        System.out.println(s3);
        System.out.println(s2);
	}

	private static void sortByName() {

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

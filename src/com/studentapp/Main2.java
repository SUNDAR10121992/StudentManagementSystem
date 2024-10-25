package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> studentlist;

	public static void main(String[] args) {
		System.out.println("*************student managment application system**********");

		System.out.println("****************welcome**************");
		studentlist = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Sundar", 22, "S-10");
		s1.enrollCourse("java");

		Student s2 = new Student("Amir", 25, "S-11");
		s2.enrollCourse("Devops");
		s2.enrollCourse("DSA");

		Student s3 = new Student("kajal", 27, "S-12");
		s3.enrollCourse("java");
		s3.enrollCourse("Devops");
		Student s4 = new Student("Balram", 27, "S-13");
		s3.enrollCourse("java");

		studentlist.add(s1);
		studentlist.add(s2);
		studentlist.add(s3);
		studentlist.add(s4);

		Student result = findStudentById("S-10");
		//System.out.println(result);
		sortByName();

	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());//
			}

		};
		Collections.sort(studentlist,studentNameComparator);
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

package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {

		super();
		if (validateAge(age) && validatName(name) && validatestudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();// initialization of courses !!
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("student enrolled to  " + course + " succesfully !!");
			} else {
				System.err.println("student is already enrolled to the " + course);
			}
		}

	}

	public void printStudentInfo() {
		System.out.println("======student Data======");

		System.out.println("Stueent Name :" + name);
		System.out.println("Stueent age :" + age);
		System.out.println("Stueent Id :" + studentId);
		System.out.println("enrolled for :" + courses);

	}

	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// validation methods

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("  invalid age!!! age should be valid ");
			return false;
		}
	}

	public boolean validatName(String name) {

		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namepattern = Pattern.compile(nameRegex);

		Matcher nameMatcher = namepattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name !! please Enter alphabets only");
			return false;
		}

	}

	public boolean validatestudentId(String studentId) {
		String studentIDRegex = "S-[0-9]+$";// instead of [0-9] we can use \\d

		Pattern studentPattern = Pattern.compile(studentIDRegex);

		Matcher studentidmatcher = studentPattern.matcher(studentId);
		if (studentidmatcher.matches()) {
			return true;
		} else {
			System.err.println("invalid student ID...USe the format...e.g s-1234");
		}
		return false;

	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops")) {
			return true;

		} else {
			System.err.println("Invalid course name !!!  please enter Courses from list [java ,DSA , Devops]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}

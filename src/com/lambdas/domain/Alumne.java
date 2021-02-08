package com.lambdas.domain;

public class Alumne {

	private String name;
	private int age;
	private String course;
	private float grade;

	public Alumne(String name, int age, String course, float grade) {
		this.name = name;
		this.age = age;
		this.course = course;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Nom: " + name + " Edat: " + age + " Curs: " + course + " Nota: " + grade;

	}

}

package com.Day5;

import java.util.Scanner;

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

class Candidate {
    private String name;
    private String gender;
    private double expectedSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }
}

public class Main {
    public static Candidate getCandidateDetails() throws InvalidSalaryException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the candidate Details");
        Candidate candidate = new Candidate();
        System.out.print("Name: ");
        candidate.setName(scanner.nextLine());
        System.out.print("Gender: ");
        candidate.setGender(scanner.nextLine());
        System.out.print("Expected Salary: ");
        double expectedSalary = Double.parseDouble(scanner.nextLine());
        if (expectedSalary < 10000) {
            throw new InvalidSalaryException("Registration Failed. Salary cannot be less than 10000.");
        }
        candidate.setExpectedSalary(expectedSalary);
        return candidate;
    }

    public static void main(String[] args) {
        try {
            Candidate candidate = getCandidateDetails();
            if (candidate != null) {
                System.out.println("Registration Successful");
            }
        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}

package ru.alternation.Other.stepik_contest_java.functionals;

/**
 2.13 Usage of comparators and composition for sorting

 Let's assume there is class Student exists. Each student has a name and a grade for exam in computer science.

 You need to understand in what order the list will be sorted by the code below.

    List<Student> students = ...
    students.sort(comparing(Student::getCsGrade, reverseOrder())
        .thenComparing(Student::getName));

 Note. The method getName() returns name of the student, getCsGrade() returns a grade for exam.

 PS: see, the functional features in Java 8 allows us to write more concise code.
 In previous version the code would be less readable.

 */
public class Main13_new {
}

package com.javarush.test.level29.lesson15.big01.human;

import java.util.List;

public class University
{
    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade)
    {
        for (Student student : students)
        {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade()
    {
        Student bestStudent;
        if (students != null && students.size() > 0)
        {
            bestStudent = students.get(0);
            for (Student student : students)
            {
                bestStudent = (student.getAverageGrade() > bestStudent.getAverageGrade()) ? student : bestStudent;
            }
            return bestStudent;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student worseStudent;
        if (students != null && students.size() > 0)
        {
            worseStudent = students.get(0);
            for (Student student : students)
            {
                worseStudent = (student.getAverageGrade() < worseStudent.getAverageGrade()) ? student : worseStudent;
            }
            return worseStudent;
        }
        return null;
    }

    public void expel(Student student)
    {
        if (student != null && students != null)
        {
            students.remove(student);
        }
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

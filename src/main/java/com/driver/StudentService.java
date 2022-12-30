package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudentFromRepo(Student s1)
    {
        studentRepository.saveStudent(s1);
    }

    public Student getStudentByNameFromService(String x1)
    {
        return studentRepository.findStudent(x1);
    }
    public void addTeacherToDB(Teacher t1)
    {
        studentRepository.saveTeacher(t1);
    }

    public Teacher getTeacherByNameFromService(String x1)
    {
        return studentRepository.findTeacher(x1);
    }

    public List<String> getAllStudentsFromRepo()
    {
        return studentRepository.findAllStudents();
    }

    public void pairToRepo(String t1 , String student1)
    {
        studentRepository.saveStudentTeacherPair(t1 , student1);
    }

    public List<String> getStudentsByTeacherNameFromRepo(String t1)
    {
        return studentRepository.findStudentsFromTeacher(t1);
    }

    public void  deleteTeacherByNameFromRepo(String t1)
    {
        studentRepository.deleteTeacher(t1);
    }

    public void deleteAllTeachersFromRepo()
    {
        studentRepository.deleteAllTeacher();
    }
}

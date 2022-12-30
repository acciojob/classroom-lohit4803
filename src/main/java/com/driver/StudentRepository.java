package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentMap = new HashMap<>();
    HashMap<String, Teacher> teacherMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentMapping = new HashMap<>();


    public void saveStudent(Student s)
    {
        studentMap.put(s.getName() , s);
    }
    public Student findStudent(String x)
    {
        return studentMap.get(x);
    }

    public void saveTeacher(Teacher t)
    {
        teacherMap.put(t.getName() , t);
    }
    public Teacher findTeacher(String x)
    {
        return teacherMap.get(x);
    }
    public List<String> findAllStudents()
    {
        List<String> ans = new ArrayList<>();
        for(String str : studentMap.keySet())
        {
            //ans.add(studentMap.get(str));
            ans.add(str);
        }
        return ans;
    }
    public void saveStudentTeacherPair(String t , String student)
    {
        if(teacherStudentMapping.containsValue(student)) return;
        if(teacherStudentMapping.containsKey(t)) teacherStudentMapping.get(t).add(student);
        else
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(student);
            teacherStudentMapping.put(t , temp);
        }
    }
    public List<String> findStudentsFromTeacher(String t)
    {
        List<String> ans = new ArrayList<>();
        if(teacherStudentMapping.containsKey(t)) return teacherStudentMapping.get(t);
        return ans;

    }

    public void  deleteTeacher(String t)
    {
        int size = 0;
        if(teacherStudentMapping.containsKey(t)) size = teacherStudentMapping.get(t).size();
        for(int i = 0; i<size; i++)
        {
            if(studentMap.containsKey(teacherStudentMapping.get(t).get(i))) studentMap.remove(teacherStudentMapping.get(t).get(i));
        }
        if(teacherMap.containsKey(t)) teacherMap.remove(t);
        if(teacherStudentMapping.containsKey(t)) teacherStudentMapping.remove(t);
    }

    public void deleteAllTeacher()
    {
        List<String> res = new ArrayList<>();
        for(String str: teacherStudentMapping.keySet())
        {
            int size = teacherStudentMapping.get(str).size();
            for(int i = 0; i<size; i++)
                res.add(teacherStudentMapping.get(str).get(i));
        }

        teacherMap.clear();
        teacherStudentMapping.clear();
        int len = res.size();
        for(int i=0; i<len; i++)
        {
            if(studentMap.containsKey(res.get(i))) studentMap.remove(res.get(i));
        }
    }
}

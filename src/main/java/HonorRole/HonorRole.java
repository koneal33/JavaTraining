package HonorRole;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HonorRole {
    private DataSource data;

    public HonorRole(DataSource data){
        this.data = data;
    }

    public List<String> getHonorRoleStudents() {
        Double minGPA = 2D;
        return getStudentsByGPA(minGPA);
    }

    public List<String> getCumLaudeStudents() {
        Double minGPA = 3.5;
        return getStudentsByGPA(minGPA);
    }

    private List<String> getStudentsByGPA(Double minGPA) {
        List<Student> students = data.getStudents();
        List<String> studentNames = new ArrayList<>();
        for(Student student: students){
            if(student.getGPA()>=minGPA)
                studentNames.add(student.getName());
        }
        return studentNames;
    }

    public List<String> getSummaCumLaudeStudents() {
        List<Student> students = data.getStudents();
        List<String> studentNames = new ArrayList<>();

        Student topGPA = new Student();
        topGPA.setName("jack");
        topGPA.setGPA(0.0);
        Student secondGPA = new Student();
        secondGPA.setGPA(0.0);
        secondGPA.setName("Mill");
        for (Student student: students){
            if (secondGPA.getGPA() > topGPA.getGPA()){
                topGPA = secondGPA;
            }
            if (student.getGPA() > topGPA.getGPA()){
                topGPA = student;
            }else if (student.getGPA() > secondGPA.getGPA()){
                secondGPA = student;
            }

        }
        studentNames.add(topGPA.getName());
        studentNames.add(secondGPA.getName());
        return studentNames;
    }
}


package HonorRole;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HonorRole {
    private DataSource data;

    public HonorRole(DataSource data){

        this.data = data;
    }

    public List<String> getHonorRoleStudents() {
        List<Student> students = data.getStudents();
        List<String> studentNames = new ArrayList<>();
        for(Student student: students){
            if(student.getGPA()>2)
                studentNames.add(student.getName());
        }
        return studentNames;
    }
}


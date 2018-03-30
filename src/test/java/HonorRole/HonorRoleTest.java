package HonorRole;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HonorRoleTest {

    @Test
    public void whenGetHonorRoleStudentsthenGPAGreaterThan2(){

        DataSource data = mock (DataSource.class);

        ArrayList<Student> student = new ArrayList<Student>();

        Student student1 = new Student();
        Student student2 = new Student();
        student2.setName("Jackson");
        student2.setGPA(1.9);
        student1.setName("Kyle");
        student1.setGPA(4.0);
        student.add(student1);
        student.add(student2);
        when(data.getStudents()).thenReturn(student);

        HonorRole HR = new HonorRole(data);
        List<String> names = HR.getHonorRoleStudents();

        assertEquals(1,names.size());
        assertEquals("Kyle",names.get(0));

    }



}
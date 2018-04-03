package HonorRole;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HonorRoleTest {

    private ArrayList<Student> students = new ArrayList<Student>();
    private Student student1 = new Student();
    private Student student2 = new Student();
    private Student student3 = new Student();
    private Student student4 = new Student();
    private DataSource dataSourceMock;
    private HonorRole honorRole;

    @Before
    public void Before(){
        student2.setName("Jackson");
        student2.setGPA(1.9);
        student1.setName("Kyle");
        student1.setGPA(4.0);
        student3.setName("Larry");
        student3.setGPA(1.0);
        student4.setName("Karen");
        student4.setGPA(3.5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        dataSourceMock = mock(DataSource.class);
        honorRole = new HonorRole(dataSourceMock);
    }

    @Test
    public void whenGetHonorRoleStudentsthenGPAGreaterThan2(){
        when(dataSourceMock.getStudents()).thenReturn(students);
        List<String> names = honorRole.getHonorRoleStudents();
        assertEquals(2,names.size());
        assertTrue(names.contains("Kyle"));
        assertTrue(names.contains("Karen"));
    }

    @Test
    public void whenGetCumLaudeStudentsthenGPAGreaterthan35(){
        when(dataSourceMock.getStudents()).thenReturn(students);
        List<String> names = honorRole.getCumLaudeStudents();
        assertEquals(2, names.size());
        assertTrue(names.contains("Kyle"));
        assertTrue(names.contains("Karen"));
    }

    @Test
    public void whenGetSummaCumLaudeStudentsthenTopTwoGPA(){
        when(dataSourceMock.getStudents()).thenReturn(students);
        List<String> names = honorRole.getSummaCumLaudeStudents();
        assertEquals(2, names.size());
        assertTrue(names.contains("Kyle"));
        assertTrue(names.contains("Karen"));
    }



}
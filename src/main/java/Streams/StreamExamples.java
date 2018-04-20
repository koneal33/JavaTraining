package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bob", 34, 24000.00, new Date(2017, 3, 1), SecurityClearance.LevelA, "515-555-1234", "515-555-4561"),
            new Employee("Bill", 24, 24000.00, new Date(2016, 11, 25), SecurityClearance.LevelB, "515-555-8846"),
            new Employee("Tiffany", 45, 68000.09, new Date(1999, 5, 3), SecurityClearance.LevelC, "515-555-4561", "515-555-7894", "515-555-9512"),
            new Employee("Brenda", 52, 52000.00, new Date(2010, 8, 15), SecurityClearance.LevelA, "515-555-5123")
    );

    public List<String> getAllEmployeeNames(){
        Stream<String> streams = employees.stream()
                .map(employee -> employee.name)
                .filter(employeeName -> employeeName.contains("B"));

        return streams.collect(Collectors.toList());
    }

    public List<Employee> getEmployeesBySecurityClearance(SecurityClearance requestSecurityClearance){
        return employees.stream()
                .filter(employee -> employee.securityClearance.equals(requestSecurityClearance))
                .collect(Collectors.toList());
    }

    public List<String> getAllEmployeesPhoneNumbers(){
        return employees.stream()
                .flatMap(employee -> employee.phoneNumbers.stream())
                .collect(Collectors.toList());
    }

    public Double getTotalSalaries(){
        return employees.stream()
                .map(Employee::getSalary)
                .reduce((salary, acc) -> acc + salary)
                .orElse(0d);
    }

    public Employee getOldestEmployee(){
        return employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public List<Employee> getEmployeesByHireDate(){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getHireDate))
                .collect(Collectors.toList());
    }

    public class Employee{
        private String name;
        private Integer age;
        private Double salary;
        private Date hireDate;
        private SecurityClearance securityClearance;
        private List<String> phoneNumbers;

        public Employee(){

        }

        public Employee(String name, Integer age, Double salary, Date hireDate, SecurityClearance securityClearance, String... phoneNumbers){
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.hireDate = hireDate;
            this.securityClearance = securityClearance;
            this.phoneNumbers = Arrays.asList(phoneNumbers);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public SecurityClearance getSecurityClearance() {
            return securityClearance;
        }

        public void setSecurityClearance(SecurityClearance securityClearance) {
            this.securityClearance = securityClearance;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Date getHireDate() {
            return hireDate;
        }

        public void setHireDate(Date hireDate) {
            this.hireDate = hireDate;
        }
    }

    public enum SecurityClearance{
        LevelA,
        LevelB,
        LevelC
    }
}

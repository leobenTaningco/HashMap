import java.util.HashMap;

public class Employee {
    private String empNo;
    private String lastName;
    private String firstName;
    private double salary;
    private HashMap<String, Employee> employeeHashMap;

    public HashMap<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public void setEmployeeHashMap(HashMap<String, Employee> employeeHashMap) {
        this.employeeHashMap = employeeHashMap;
    }

    /*public Employee(String empNo, String lastName, String firstName){
        this.empNo = empNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.employeeHashMap = new HashMap<>();
    }*/

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

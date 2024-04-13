import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class DepartmentDA {
    private HashMap<String, Employee> employeeHashMap;
    public HashMap<String, Employee> getEmployeeHashMap() {
        return employeeHashMap;
    }

    public void setEmployeeHashMap(HashMap<String, Employee> employeeHashMap) {
        this.employeeHashMap = employeeHashMap;
    }

    public DepartmentDA(){
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        employeeHashMap = new HashMap<>();
        try {
            Integer key = 0;
            Scanner inputFile = new Scanner(new FileReader("C:\\Users\\63907\\Desktop\\intellij\\COMVersion\\LabAssignment5Hashmap\\src\\dep.csv"));
            inputFile.nextLine();
            while (inputFile.hasNext()) {

                employeeHashMap = new HashMap<>();
                String lineData = new String();
                lineData = inputFile.nextLine();
                String[] splitData = new String[3];
                splitData = lineData.split(",");

                Department department = new Department(splitData[0].trim(),splitData[1].trim());

                department.setDeptCode(splitData[0].trim());
                department.setDeptName(splitData[1].trim());

                System.out.println("Department code: " + department.getDeptCode());
                System.out.println("Department name: " + department.getDeptName());

                //deptemp
                try {
                    Scanner inputFile2 = new Scanner(new FileReader("C:\\Users\\63907\\Desktop\\intellij\\COMVersion\\LabAssignment5Hashmap\\src\\deptemp.csv"));
                    inputFile2.nextLine();
                    while (inputFile2.hasNext()) {
                        String lineData2 = new String();
                        lineData2 = inputFile2.nextLine();
                        String[] splitData2 = new String[3];
                        splitData2 = lineData2.split(",");

                        if(splitData[0].trim().equals(splitData2[0].trim())){
                            department.setDepTotalSalary(Double.parseDouble(splitData2[2].trim()));
                            EmployeeDA employeeDA = new EmployeeDA(splitData2[1].trim());
                            //employee.setSalary(Double.parseDouble(splitData2[2].trim()));
                            Employee employee = employeeDA.getEmployee();
                            employee.setSalary(Double.parseDouble(splitData2[2].trim()));
                            employeeHashMap.put(employee.getEmpNo() + key, employee);
                            key++;
                            //System.out.println("test");
                        }

                    }
                    System.out.println("Department total salary: " + df.format(department.getDepTotalSalary()));
                    System.out.println("---------------------Details -------------------------");
                    System.out.println("EmpNo\t\t\tEmployeeName\tSalary");

                    Employee employee = new Employee();

                    employee.setEmployeeHashMap(getEmployeeHashMap());
                    for (Map.Entry<String, Employee> employeeHashMap : employee.getEmployeeHashMap().entrySet()) {
                        System.out.print(employeeHashMap.getValue().getEmpNo() + "\t\t");
                        System.out.print(employeeHashMap.getValue().getLastName() + ", ");
                        System.out.print(employeeHashMap.getValue().getFirstName() + "\t\t");
                        System.out.println(df.format(employeeHashMap.getValue().getSalary()));
                    }
                    System.out.println();
                }catch(FileNotFoundException e){
                    throw new RuntimeException(e);
                }
            }

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}



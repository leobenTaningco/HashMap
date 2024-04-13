import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;
    public EmployeeDA(String empNo){
        try {
            Scanner inputFile = new Scanner(new FileReader("C:\\Users\\63907\\Desktop\\intellij\\COMVersion\\LabAssignment5Hashmap\\src\\emp.csv"));
            inputFile.nextLine();
            while (inputFile.hasNext()) {
                String lineData = new String();
                lineData = inputFile.nextLine();
                String[] splitData = new String[3];
                splitData = lineData.split(",");
                //System.out.println("test2");
                //System.out.println(splitData[0].trim() + " "+ empNo);
                if (empNo.equals(splitData[0].trim())) {

                    employee = new Employee();//(splitData[0].trim(), splitData[1].trim(), splitData[2].trim());
                    employee.setEmpNo(splitData[0].trim());
                    employee.setLastName(splitData[1].trim());
                    employee.setFirstName(splitData[2].trim());

                }

            }
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployee() {
        return employee;
    }
}

package lan.zold;

import java.util.ArrayList;

public class Main {
    static Api api = new Api();
    public static void main(String[] args) {
        getEmployees();
    }

    public static void getEmployees() {
        ArrayList<Employee> employees = api.getEmployees();
        for (Employee employee : employees) {
          System.out.println(employee.name);
        }
    }

    public static void createEmployee() {
        Employee employee = new Employee(
            "John", 
            "London", 
            1000.0);
        System.out.println(api.createEmployee(employee));       
    }

    public static void updateEmployee() {
        Employee employee = new Employee(4, "Árpád", "Szeged", 500.0);
        System.out.println(api.updateEmployee(employee));
    }

    public static void deleteEmployee() {
        System.out.println(api.deleteEmployee(5));
    }
}
package lan.zold;

import java.util.ArrayList;

public class Main {
    static Api api = new Api();
    static String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNzI3MDM0NTM4LCJleHAiOjE3MjcxMjA5Mzh9.qXRhj4yUDIW0LzD_nMTbgmDMMl8WVAIBkE-NgYu0awc";
    public static void main(String[] args) {
        // getEmployees();
        createEmployee();
        // updateEmployee();
        // deleteEmployee();
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
        System.out.println(api.createEmployee(employee, token));       
    }

    public static void updateEmployee() {
        Employee employee = new Employee(4, "Árpád", "Szeged", 500.0);
        System.out.println(api.updateEmployee(employee, token));
    }

    public static void deleteEmployee() {
        System.out.println(api.deleteEmployee(4, token));
    }
}
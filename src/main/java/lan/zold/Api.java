package lan.zold;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;

public class Api {
  
  String url = "http://[::1]:8000/employees";

  public ArrayList<Employee> getEmployees() {    
    HttpResponse<JsonNode> apiResponse = 
    Unirest.get(url).asJson();
    String json = apiResponse.getBody().toString();
    Gson gson = new Gson();
    Employee[] employeeArray = 
    gson.fromJson(json, Employee[].class);
    ArrayList<Employee> employeeList = 
    new ArrayList<>(Arrays.asList(employeeArray));
    return employeeList;
  }

  public String createEmployee(Employee employee) {
    Gson gson = new Gson();
    String json = gson.toJson(employee);
    HttpResponse<String> apiResponse = Unirest.post(url)
        .header("Content-Type", "application/json")
        .body(json)
        .asString();
    return apiResponse.getBody();
  }

  public String updateEmployee(Employee employee) {
    Gson gson = new Gson();
    String json = gson.toJson(employee);
    HttpResponse<String> apiResponse = Unirest.put(url + "/" + employee.id)
        .header("Content-Type", "application/json")
        .body(json)
        .asString();
    return apiResponse.getBody();
  }

  public String deleteEmployee(Integer id) {
    HttpResponse<String> apiResponse = Unirest.delete(url + "/" + id)
        .asString();
    return apiResponse.getBody();
  }
}

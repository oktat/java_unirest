package lan.zold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;

public class Api {
  
  String url = "http://[::1]:8000/api/employees";

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

  public String createEmployee(Employee employee, String... token) {
    Map<String, String> headers = new HashMap<>();
    if(token.length > 0) {
      headers.put("Authorization", "Bearer " + token[0]);
    }
    headers.put("Content-Type", "application/json");
    Gson gson = new Gson();
    String json = gson.toJson(employee);
    HttpResponse<String> apiResponse = Unirest.post(url)
        .headers(headers)
        .body(json)
        .asString();
    return apiResponse.getBody();
  }

  public String updateEmployee(Employee employee, String... token) {
    String fullUrl = url + "/" + employee.id;
    Map<String, String> headers = new HashMap<>();
    if(token.length > 0) {
      headers.put("Authorization", "Bearer " + token[0]);
    }
    headers.put("Content-Type", "application/json");
    Gson gson = new Gson();
    String json = gson.toJson(employee);
    HttpResponse<String> apiResponse = Unirest.put(fullUrl)
        .headers(headers)
        .body(json)
        .asString();
    return apiResponse.getBody();
  }

  public String deleteEmployee(Integer id, String... token) {
    String fullUrl = url + "/" + id;
    Map<String, String> headers = new HashMap<>();
    if(token.length > 0) {
      headers.put("Authorization", "Bearer " + token[0]);    }
    HttpResponse<String> apiResponse = Unirest.delete(fullUrl)
        .headers(headers)
        .asString();
    return apiResponse.getBody();
  }
}

package lan.zold;

public class Employee {
  Integer id;
  String name;
  String city;
  Double salary;
  public Employee(Integer id, String name, String city, Double salary) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.salary = salary;
  }
  public Employee(String name, String city, Double salary) { 
    this.name = name;
    this.city = city;
    this.salary = salary;
  }
}

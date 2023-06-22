import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

    public class EmployeeManagement {

        public static void main(String[] args) {
            String jdbcUrl = "jdbc:mariadb://localhost:3306/Employee";
            String username = "root";
            String password = "root";

            try {

                Class.forName("org.mariadb.jdbc.Driver");

                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                Statement statement = connection.createStatement();


                String query = "SELECT * FROM Employee";

                ResultSet resultSet = statement.executeQuery(query);

                List<Employee> employees = new ArrayList<>();

                while (resultSet.next()) {
                    String firstName = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    Date hireDate = resultSet.getDate("joining_date");
                    String salary = resultSet.getString("salary");
                    String department = resultSet.getString("department");
                    String phone = resultSet.getString("phone");
                    LocalDate hireLocalDate = hireDate.toLocalDate();
                    Employee employee = new Employee(firstName,email,hireLocalDate,phone,salary,department);
                    employees.add(employee);

                }

                //.........................exercise-1...............................................

//
            System.out.print("1.Employees whose name starts with d are  : ");
               employees.stream()
                       .filter(employee -> employee.getName().startsWith("d"))
                      .forEach(employee -> System.out.println(employee.getName()));

//
//                //.........................exercise-2..........................................
//
//
//
                System.out.println("2. Below candidates kindly update the mobile number : ");
                employees.stream()
                        .filter(employee -> employee.getPhone()==null)
                        .forEach(employee -> System.out.println(employee.getName()));

//
//                //,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,Exercise-3...................................

                System.out.println(" 3.List of employees in QA with salary greater than 10000 : ");

                              employees.stream().filter(employee->Integer.valueOf(employee.getSalary())>10000 && employee.getDepartment().equals("QA")).forEach((employee -> System.out.println(employee.getName())));


//
//                  //...................................Exercise-4...........................................
                System.out.println("4.employees in IT department");


                employees.stream().filter(employee->(employee.getDepartment().equals("IT"))).forEach((employee -> System.out.println(employee.getName())));

//
//
//
//                //........................................Exercise-5...............................................

                System.out.println("5.List of employees applicable for salary increment");
                employees.stream()
                        .filter(employee -> employee.getDepartment().equals("DEV"))
                        .map(employee -> {
                            double newSalary = Integer.valueOf(employee.getSalary()) + ((10/100)*(Integer.valueOf(employee.getSalary()) ));
                            String str = Double.toString(newSalary);
                            employee.setSalary(str);
                            return employee;

                        })
                .forEach(employee -> {
                    System.out.println("Name: " + employee.getName());
                    System.out.println("Department: " + employee.getDepartment());
                    System.out.println("Updated Salary: " + employee.getSalary());
                    System.out.println("-------------------------");
                });


                //...................................Exercise-6......................................
                System.out.println("6.employees join between months feb and april in the year of 2021");

                LocalDate startDate = LocalDate.of(2021, 2, 1);
                LocalDate endDate = LocalDate.of(2021, 4, 1);


                employees.stream()
                        .filter(employee -> {
                            LocalDate joiningDate = employee.getJoiningDate();
                            return joiningDate.isAfter(startDate) && joiningDate.isBefore(endDate);
                        })
                        .forEach(employee -> {
                            System.out.println("Name: " + employee.getName());
                            System.out.println("Joining Date: " + employee.getJoiningDate());
                            System.out.println("...............................");
                        });


             //   ..............................Exercisen 7............................
                System.out.println();

//                Double lowestSalary = employees.stream()
//                        .map(Employee::getSalary)
//                        .min();
//                System.out.println("lowest salary of the employee is........");
//
//                ;         System.out.println(employees.stream().map(Employee::getSalary).map(i->Integer.valueOf(i)).min(Integer::compare));
//

                        Optional<Double> lowestSalary = employees.stream()
                                .map(employee -> Double.parseDouble(employee.getSalary()))
                                .min(Double::compare);

                if (lowestSalary.isPresent()) {
                    System.out.println("7.Lowest Salary of the employee is : " + lowestSalary.get());
                } else {
                    System.out.println("No employees found.");
                }


                //.........................Exercise 8................................
//
//                LocalDate joiningDate = LocalDate.of(2021, 3, 14);
//                    double salary=0;
//                double sumOfSalaries = employees.stream()
//                        .filter(employee -> employee.getJoiningDate().isEqual(joiningDate))
//                        .forEach(employee->salary+Integer.valueOf(employee.getSalary())
//                                return salary;
//                        );

//                System.out.println("Total Sum of Salaries: " + sumOfSalaries);
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getJoiningDate).reversed())
                        .limit(3)
                        .forEach(employee -> {
                            System.out.println(" 8.Name: " + employee.getName());
                            System.out.println("Joining Date: " + employee.getJoiningDate());
                            System.out.println("-------------------------");
                        });
////
//
//
//                //,......................Exercise-9...................................
//
//
                System.out.println();

                        LocalDate startDated= LocalDate.of(2021, 2, 1);
                LocalDate endDated  = LocalDate.of(2021, 2, 28);

                double sums = employees.stream()
                        .filter(employee -> {
                            LocalDate joiningDate = employee.getJoiningDate();
                            return joiningDate.isAfter(startDated) && joiningDate.isBefore(endDated);
                        })
                        .map(Employee::getSalary)
                        .mapToDouble(Double::parseDouble)
                        .sum();

                System.out.println("9.Total Sum of Salaries of the persons joined in Feb 2021 is  " + sums);



//                //..................exercise-10..................
//
//
                System.out.println();
                        LocalDate joiningDate = LocalDate.of(2021, 3, 14);

                OptionalDouble averageSalary = employees.stream()
                        .filter(employee -> employee.getJoiningDate().isEqual(joiningDate))
                        .map(Employee::getSalary)
                        .mapToDouble(Double::parseDouble)
                        .average();

                if (averageSalary.isPresent()) {
                    System.out.println("10.Average Salary for employees joined on 14 th march 2021 " + averageSalary.getAsDouble());
                }

//
//
//                //........................Exercise-11...............................
//
//
                System.out.println();
                Map<String, Long> salaryCountMap = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));

                System.out.println("11.Salary Count Map: " + salaryCountMap);

//
//
//                //........................Exercise-12...........................
//
                System.out.println();
                Map<String, List<Employee>> employeesByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

                System.out.println("12.Employees by Department: " + employeesByDepartment);

//
//                //.......................Exercise-13................................
//
//
//
//
//
                System.out.println();
                Map<String, Double> departmentSalaryMap = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(employee -> Double.parseDouble(employee.getSalary()))));

                System.out.println("13.Department Salary Map: " + departmentSalaryMap);

//
//                //.......................Exercise 14..........................................
                System.out.println();
//
                        List<String> categories = Arrays.asList("QA", "IT", "DEV", "Manager");

                Map<String, Double> highestPaidByCategory = new HashMap<>();

                for (String category : categories) {
                    OptionalDouble highestPaidSalary = employees.stream()
                            .filter(employee -> employee.getDepartment().equals(category))
                            .mapToDouble(employee -> Double.parseDouble(employee.getSalary()))
                            .max();

                    highestPaidSalary.ifPresent(salary -> highestPaidByCategory.put(category, salary));
                }

                System.out.println("14.Highest Paid Salary by Category: " + highestPaidByCategory);

                //.................Exercise-15.....................
                System.out.println();

                Map<String, Long> salaryCoun = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getSalary, Collectors.counting()));

                System.out.println("15.Salary Count Map is " + salaryCoun);


                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


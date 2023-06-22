
    import java.time.LocalDate;
import java.util.Date;

    public class Employee {
        private String name;

        private String email;

        private LocalDate joiningDate;

        private String phone;

        private String salary;

        private String department;

        public Employee(String name, String email, LocalDate joiningDate, String phone, String salary, String department) {
            this.name = name;
            this.email = email;
            this.joiningDate = joiningDate;
            this.phone = phone;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDate getJoiningDate() {
            return joiningDate;
        }

        public void setJoiningDate(LocalDate joiningDate) {
            this.joiningDate = joiningDate;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", joiningDate=" + joiningDate +
                    ", phone='" + phone + '\'' +
                    ", salary='" + salary + '\'' +
                    ", department='" + department + '\'' +
                    '}'+"\n";
        }
    }


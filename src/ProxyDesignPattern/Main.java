package ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.delete("admin", 1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

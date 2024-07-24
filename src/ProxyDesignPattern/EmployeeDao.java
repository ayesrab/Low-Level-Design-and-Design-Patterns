package ProxyDesignPattern;

public interface EmployeeDao {
    public void create(String client, EmployeeDao employeeDao) throws Exception;
    public void delete(String client, int employeeId) throws Exception;
    public EmployeeDao getEmployee(String client, int employeeId) throws Exception;
}

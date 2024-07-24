package ProxyDesignPattern;

public class EmployeeDaoImplementation implements EmployeeDao {
    @Override
    public void create(String client, EmployeeDao employeeDao) throws Exception {
        System.out.println("Creating Employee " + client + " with " + employeeDao);
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Deleting Employee " + client + " with " + employeeId);
    }

    @Override
    public EmployeeDao getEmployee(String client, int employeeId) throws Exception {
        System.out.println("Getting Employee " + client + " with " + employeeId);
        return new EmployeeDaoImplementation();

    }
}

package ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao{
    EmployeeDao employeeDao;

    public EmployeeDaoProxy() {
        this.employeeDao = new EmployeeDaoImplementation();
    }

    @Override
    public void create(String client, EmployeeDao employeeDao) throws Exception {
        if(client.equals("admin")){
            this.employeeDao.create(client, employeeDao);
            return;
        }
        else {
            throw new Exception("ACCESS DENIED");
        }
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equals("admin")){
            this.employeeDao.delete(client, employeeId);
            return;
        }
        else {
            throw new Exception("ACCESS DENIED");
        }
    }

    @Override
    public EmployeeDao getEmployee(String client, int employeeId) throws Exception {
        if(client.equals("admin") || client.equals("user")){
            return this.employeeDao.getEmployee(client, employeeId);
        }
        else {
            throw new Exception("ACCESS DENIED");
        }
    }
}

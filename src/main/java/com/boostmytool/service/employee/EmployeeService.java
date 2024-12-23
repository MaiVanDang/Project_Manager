package com.boostmytool.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boostmytool.model.employee.Employee;
import com.boostmytool.model.employee.EmployeeDto;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Lấy tất cả nhân viên
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Lấy thông tin nhân viên theo ID
    public Employee getEmployeeById(String employeeID) throws Exception {
        return employeeRepository.findById(employeeID)
                .orElseThrow(() -> new Exception("Employee not found with ID: " + employeeID));
    }

    // Lấy danh sách nhân viên theo trạng thái
    public List<Employee> getEmployeesByStatus(String status) {
        return employeeRepository.findByEmployeeStatus(status);
    }

    // Lấy danh sách nhân viên có mức lương tối thiểu
    public List<Employee> getEmployeesWithMinSalary(float minSalary) {
        return employeeRepository.findEmployeesWithSalaryGreaterThanEqual(minSalary);
    }

    // Thêm nhân viên mới
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapDtoToEntity(employeeDto);
        return employeeRepository.save(employee);
    }

    // Cập nhật thông tin nhân viên
    public Employee updateEmployee(String employeeID, EmployeeDto employeeDto) throws Exception {
        Employee existingEmployee = getEmployeeById(employeeID);
        updateEntityWithDto(existingEmployee, employeeDto);
        return employeeRepository.save(existingEmployee);
    }

    // Xóa nhân viên
    public void deleteEmployee(String employeeID) throws Exception {
        Employee existingEmployee = getEmployeeById(employeeID);
        employeeRepository.delete(existingEmployee);
    }

    // Chuyển đổi từ DTO sang Entity
    private Employee mapDtoToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeID(employeeDto.getEmployeeID());
        employee.setName(employeeDto.getName());
        employee.setGender(employeeDto.getGender());
        employee.setDob(new java.sql.Date(employeeDto.getDob().getTime()));
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary((float) employeeDto.getSalary());
        employee.setEmployeeStatus(employeeDto.getEmployeeStatus());
        return employee;
    }

    // Cập nhật Entity bằng DTO
    private void updateEntityWithDto(Employee employee, EmployeeDto employeeDto) {
        employee.setName(employeeDto.getName());
        employee.setGender(employeeDto.getGender());
        employee.setDob(new java.sql.Date(employeeDto.getDob().getTime()));
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary((float) employeeDto.getSalary());
        employee.setEmployeeStatus(employeeDto.getEmployeeStatus());
    }
}

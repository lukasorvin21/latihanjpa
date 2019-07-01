package com.lukas.latihanjpa;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.lukas.latihanjpa.dao.EmployeeDAO;
import com.lukas.latihanjpa.model.Employee;

@Configuration
public class Action {
	
	@Autowired //memanggil ulang tanpa inisiasi lagi
	EmployeeDAO employeeDAO;
	
	//@Bean
	public List<Employee> getAll() {
		List<Employee> employees = employeeDAO.getAll();
		
		for (Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddres());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("=======================================");
		}
		
		return employees;
	}
	
	//@Bean
	public Employee getById() {
		Employee employee = employeeDAO.getById(10);
		
		System.out.println("Get By ID = 10");
		System.out.println("ID : " + employee.getId());
		System.out.println("Name : " + employee.getName());
		System.out.println("Address : " + employee.getAddres());
		System.out.println("DOB : " + employee.getDob());
		System.out.println("=======================================");
		
		return employee;
	}
	
	//@Bean
	public boolean save() {
		try {
			Employee employee = new Employee();
			
			employee.setName("ABCD");
			employee.setAddres("defg");
			
			String dateString ="2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			employee.setDob(date);
			
			employeeDAO.save(employee);
			System.out.println("Data Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean update() {
		try {
			Employee employee = new Employee();
			
			employee.setId(4);
			employee.setName("ABCD");
			employee.setAddres("defg");
			
			String dateString ="2019-07-01";
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			employee.setDob(date);
			
			employeeDAO.update(employee);
			System.out.println("Data Berhasil Tersimpan");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Tersimpan");
			e.printStackTrace();
			return false;
		}
	}
	//@Bean
	public boolean delete() {
		try {
			employeeDAO.delete(5);
			System.out.println("Data Berhasil Dihapus");
			return true;
		} catch (Exception e) {
			System.out.println("Data Gagal Dihapus");
			e.printStackTrace();
			return false;
		}
		
	}
	@Bean
	public List <Employee> getByName() {
		List<Employee> employees = employeeDAO.getByName("lukas");
		
		for (Employee employee : employees) {
			System.out.println("ID : " + employee.getId());
			System.out.println("Name : " + employee.getName());
			System.out.println("Address : " + employee.getAddres());
			System.out.println("DOB : " + employee.getDob());
			System.out.println("=======================================");
		}
		
		return employees;
	}

}

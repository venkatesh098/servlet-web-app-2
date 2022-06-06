package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.Employee;
import com.service.EmployeeServiceImpl;



/**
 * Servlet implementation class CreateEmployeeServlet
 */
public class CreateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		Double empSalary = Double.parseDouble(request.getParameter("empSal"));
		String empDept = request.getParameter("empDept");
		
		Employee employee = new Employee(empId, empName, empSalary, empDept);
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	    Optional<Employee> addedEmployee = employeeService.addEmployee(employee);
	    
	    List<Employee> employees = employeeService.getEmployees();
	    
	    PrintWriter out = response.getWriter();
	    if(addedEmployee.isPresent()) {
	    	out.print("<html>");
	    	out.print("<body bgColor='pink'>");
	    	out.print("<h1 style='color:green'>Emplyee added Successfully.. :)</h1></br>");
	    	
	    	out.print("<table border='1'>");
	    	out.print("<tr>");
	    	out.print("<th>Employee ID</th>");
	    	out.print("<th>Employee Name</th>");
	    	out.print("<th>Employee Salary</th>");
	    	out.print("<th>Employee Department</th>");
	    	out.print("<th>update</th>");
	    	out.print("</tr>");
	    	
	    	for(Employee employeeObj:employees) {
	    		out.print("<tr>");
	    		 out.print("<td>"+employeeObj.getEmpId()+"</td>");
		    	 out.print("<td>"+employeeObj.getEmpName()+"</td>");
		    	 out.print("<td>"+employeeObj.getEmpSal()+"</td>");
		    	 out.print("<td>"+employeeObj.getEmpDep()+"</td>");
		    	 out.print("<td><button type='button' name='update Empoyee'>UpdateEmpoyee</button></td>");
	    		out.print("</tr>");
	    	}
	    	out.print("</table>");
	    	
	    	out.print("</body>");
	    	out.print("</html>");
	    }
		
		
	}

}

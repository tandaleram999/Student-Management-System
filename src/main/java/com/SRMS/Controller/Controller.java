package com.SRMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SRMS.Entity.StudentEntity;
import com.SRMS.Service.StudentService;

import jakarta.servlet.http.HttpSession;

@org.springframework.stereotype.Controller 
public class Controller {
	@Autowired
	private StudentService Service;
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/about")
	public String AboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String ContactPage() {
		return "contact";
	}
	
	
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		 model.addAttribute("Students", Service.getAllStudent());
		 return "students";
		 
	}
    @GetMapping("students/new")
	public String CreateStudentForm(Model model) {
		StudentEntity student=new StudentEntity();//to hold student data 
		model.addAttribute("student",student);
		
		return "create-student";
		
	}
    @PostMapping("/students")
    public String SaveStudent(@ModelAttribute("student")StudentEntity Student) {
    	Service.saveStudent(Student);
    	return "redirect:/students";
    	
    }
  //Edit
    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {
        model.addAttribute("student", Service.getById(id));
        return "edit_student";
    }
//
//    // Delete
    @GetMapping("/students/delete/{id}")
    public String deleteById(@PathVariable int id) {
        Service.deleteById(id);
        return "redirect:/students";
    }
    
    @PostMapping("/students/edit/{id}")
    public String updateStudent( @PathVariable int id, @ModelAttribute("student") StudentEntity Student) {
    	StudentEntity exsitingStudent=Service.getById(id);
    	  
    	exsitingStudent.setFirstName(Student.getFirstName());
    	exsitingStudent.setLastName(Student.getLastName());
    	exsitingStudent.setMobileNo(Student.getMobileNo());    	
    	exsitingStudent.setMail(Student.getMail());    	 
    	exsitingStudent.setClassBranch(Student.getClassBranch());
    	
    	Service.saveStudent(exsitingStudent);
    	return "redirect:/students";
    }
    
    @GetMapping("/login")
    public String LoginPage() {
    	
    	return"login";
    	
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  
        return "redirect:/login?logout";
    }
    

}

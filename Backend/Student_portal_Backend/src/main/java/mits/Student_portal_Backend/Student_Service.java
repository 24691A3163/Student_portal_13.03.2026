package mits.Student_portal_Backend;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Student_Service {

	private final Student_Repo sr;
	
	public Student_Service(Student_Repo repo) {//constructor for service connection for repo class in ot swervice class
		this.sr=repo;
	}
	//insertion //for registration 
	public Student register(Student stu) {
		return sr.save(stu);
	}
	//login
	public Student login(String email, String password) {
		Student user = sr.findByEmail(email);
		return(user!=null && user.getPassword().equals(password))? user : null;
	}
	//retriew 
	public List<Student> allusers(){
		return sr.findAll();
	}
	//update
	public Student updateStudent(Long id,Student s) {
		Student existing = sr.findById(id).orElse(null);
		if(existing != null) {
			existing.setName(s.getName());
			existing.setEmail(s.getEmail());
			existing.setPassword(s.getPassword());
			 return sr.save(existing);
	    }
	    return null;
	}
	//delete
	public void deleteStudent(Long id) {
		sr.deleteById(id);
	}
}

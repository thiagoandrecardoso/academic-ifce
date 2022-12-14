package who.professor.academic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import who.professor.academic.model.Student;
import who.professor.academic.service.StudentService;

public class MyUserDetails implements UserDetailsService {

    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Student student = studentService.findStudentByEmail(username);

        String[] authorities = new String[1];
        authorities[0] = "ROLE_USER";

        return new org.springframework.security.core.userdetails.User(
                student.getEmail(),
                student.getPassword(),
                AuthorityUtils.createAuthorityList(authorities)
        );
    }
}

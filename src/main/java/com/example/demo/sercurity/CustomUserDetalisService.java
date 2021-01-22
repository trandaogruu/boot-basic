package com.example.demo.sercurity;

import com.example.demo.model.entities.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetalisService implements UserDetailsService {


    @Autowired
    private StudentRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {

//        Xác thực tài khoản
        StudentEntity student = studentRepo.findStudentByAccountName(accountName);
        if(student == null){
            throw  new UsernameNotFoundException(accountName);
        }

//        get quyền
        Set<GrantedAuthority> authoritySet = new HashSet<>();

        student.getRoles().forEach(temp -> authoritySet.add(new SimpleGrantedAuthority(temp.getName())));
        UserDetails userDetails = (UserDetails) new CustomUserDetail(student.getAccountName(),student.getPassword(),authoritySet);
        BeanUtils.copyProperties(student,userDetails);
        return userDetails;

    }


}

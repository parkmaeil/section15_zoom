package com.example.security.service;

import com.example.security.entity.Customer;
import com.example.security.entity.Role;
import com.example.security.repository.MemberRepository;
import com.example.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Role findByName(String name){
           return roleRepository.findByName(name);
    }
    public Customer updateCustomerPermissions(Long customerId, String newPermissions){
        //                                                                                                                  1
        Optional<Customer> optional =memberRepository.findById(customerId);
        Customer customer;
        if(optional.isPresent()){
            customer=optional.get();
        }else{
            throw new IllegalArgumentException("error");
        }
        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName(newPermissions); // ADMIN-->(3 ADMIN)
        roles.add(userRole);
        customer.setRoles(roles); // 수정?
        return memberRepository.save(customer); // update SQL~
    }

    public Customer addCustomerPermissions(Long customerId, String newPermissions) {
        Optional<Customer> optional =memberRepository.findById(customerId);
        Customer customer;
        if(optional.isPresent()){
            customer=optional.get();
        }else{
            throw new IllegalArgumentException("error");
        }
        Set<Role> roles=customer.getRoles();
        //Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName(newPermissions);
        roles.add(userRole);
        customer.setRoles(roles); // 수정?
        return memberRepository.save(customer); // update SQL~
    }

}

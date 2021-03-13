package com.sumon.xyz.Form.Design.with.MySql.Database.service;

import com.sumon.xyz.Form.Design.with.MySql.Database.model.User;
import com.sumon.xyz.Form.Design.with.MySql.Database.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;


    public List<User> listAll()
    {
        return formRepository.findAll();
    }


     public void save(User user)
     {
         formRepository.save(user);
     }


    public User get(Long id)
    {
        return formRepository.findById(id).get();
    }


    public void delete(Long id)
    {
        formRepository.deleteById(id);
    }

}

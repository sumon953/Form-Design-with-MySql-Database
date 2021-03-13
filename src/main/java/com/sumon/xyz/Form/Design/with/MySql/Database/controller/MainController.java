package com.sumon.xyz.Form.Design.with.MySql.Database.controller;

import com.sumon.xyz.Form.Design.with.MySql.Database.model.User;
import com.sumon.xyz.Form.Design.with.MySql.Database.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private FormService formService;


    @RequestMapping("/")
    public String ViewHomePage(Model model)
    {
        List<User> listUser = formService.listAll();
        model.addAttribute("listUser",listUser);
        return "index";
    }


    @GetMapping("/register")
    public String ShowForm(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);

        List professionList = Arrays.asList("Developer","Designer","Software Engineer");
        model.addAttribute("professionList",professionList);

        return "register_form";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("user") User user)
    {
        formService.save(user);
        return "redirect:/";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserForm(@PathVariable(name = "id") Long id, Model model)
    {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = formService.get(id);
        mav.addObject("user",user);

        List professionList = Arrays.asList("Developer","Designer","Software Engineer");
        model.addAttribute("professionList",professionList);

        return mav;

    }


    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id)
    {
        formService.delete(id);
        return "redirect:/";
    }

}

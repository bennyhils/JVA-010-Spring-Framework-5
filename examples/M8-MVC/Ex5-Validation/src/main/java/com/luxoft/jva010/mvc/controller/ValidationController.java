package com.luxoft.jva010.mvc.controller;

import com.luxoft.jva010.mvc.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

@Controller
@RequestMapping("login")
public class ValidationController
{
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model model)
    {
        UserForm userForm = new UserForm();
        model.addAttribute("user", userForm);

        return "user-form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("user") UserForm userForm, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "user-form";
        }

        model.addAttribute("user", userForm);

        return "success";
    }
}

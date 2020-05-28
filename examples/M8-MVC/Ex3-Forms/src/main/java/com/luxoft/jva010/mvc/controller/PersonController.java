package com.luxoft.jva010.mvc.controller;

import com.luxoft.jva010.mvc.model.Address;
import com.luxoft.jva010.mvc.model.Person;
import com.luxoft.jva010.mvc.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController
{
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable Long id, Model model)
    {
        System.out.println("#getEdit");

        model.addAttribute("personBean", personService.getById(id));
        return "person";
    }

    @RequestMapping(value = "/persons/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personBean") Person person, @PathVariable Integer id, Model model)
    {
        System.out.println("#saveEdit");

        personService.save(person);

        return "redirect:/persons/all";
    }

    @ModelAttribute("persons")
    public List<Person> getData()
    {
        return personService.getAll();
    }

    @RequestMapping(value = "/persons/all", method = RequestMethod.GET)
    public String getAll(Model model)
    {
        System.out.println("#getAll");

        return "persons";
    }

}

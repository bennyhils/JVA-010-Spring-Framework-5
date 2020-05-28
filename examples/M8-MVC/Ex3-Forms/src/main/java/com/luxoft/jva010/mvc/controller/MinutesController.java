package com.luxoft.jva010.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.luxoft.jva010.mvc.model.Work;

@Controller
public class MinutesController
{

    @Autowired
    Work sessionWork;

    @RequestMapping(value = "/minutes")
    public String addMinutes(@ModelAttribute("work") Work work, Model model)
    {
        System.out.println("Worked: " + work.getMinutes());

        sessionWork.setMinutes(sessionWork.getMinutes()
                + work.getMinutes());

        model.addAttribute("minutes",
                sessionWork.getMinutes());

        return "minutes";
    }
}

package com.luxoft.jva010.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    @RequestMapping("/exception")
    public ModelAndView ise() {
        throw new IllegalStateException("--> This is your exception message");
    }

    @ExceptionHandler(IllegalStateException.class)
    public ModelAndView handle(IllegalStateException ise) {

        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("msg", ise.getMessage());

        return mav;
    }

}

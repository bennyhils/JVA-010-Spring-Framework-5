package com.luxoft.jva010.mvc.controllers;

import com.luxoft.jva010.mvc.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NamesController
{
    @Autowired
    private NamesService namesService;

    @RequestMapping(value = "/names", method = RequestMethod.POST)
    public @ResponseBody void addName(@RequestParam String name)
    {
        namesService.add(name);
    }

    @RequestMapping(value ="/names", method = RequestMethod.GET)
	public @ResponseBody List<String> sayHello ()
	{
		return namesService.getAll();
	}

	@RequestMapping(value = "/names/check", method = RequestMethod.GET)
	public @ResponseBody Boolean checkName(@RequestParam String name)
	{
		return namesService.contains(name);
	}
}

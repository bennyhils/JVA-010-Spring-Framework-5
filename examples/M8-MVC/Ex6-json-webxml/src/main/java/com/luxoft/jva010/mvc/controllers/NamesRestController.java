package com.luxoft.jva010.mvc.controllers;

import com.luxoft.jva010.mvc.NamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/names")
public class NamesRestController
{
    @Autowired
    private NamesService namesService;

	@PostMapping
    public void addName(@RequestParam String name)
    {
        namesService.add(name);
    }

    @GetMapping
	public List<String> sayHello ()
	{
		return namesService.getAll();
	}

	@GetMapping(value = "/check")
	public Boolean checkName(@RequestParam String name)
	{
		return namesService.contains(name);
	}
}

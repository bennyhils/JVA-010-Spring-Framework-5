package com.luxoft.jva010.mvc.controller;

import com.luxoft.jva010.mvc.model.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController
{
    @ModelAttribute("addresses")
    public List<Address> getData()
    {
        return fillWithGenerated(new ArrayList<>());
    }

    @RequestMapping("/addresses")
    public String getAddresses(Model model)
    {

//        model.addAttribute("addresses", fillWithGenerated(new ArrayList<>()));

        return "addresses";
    }

    private List<Address> fillWithGenerated(List<Address> addresses)
    {
        addresses.add(new Address(1L, "Kiev", "Topoleva"));
        addresses.add(new Address(2L, "Kiev", "Soboleva"));
        addresses.add(new Address(3L, "Kiev", "Volkova"));

        return addresses;
    }
}

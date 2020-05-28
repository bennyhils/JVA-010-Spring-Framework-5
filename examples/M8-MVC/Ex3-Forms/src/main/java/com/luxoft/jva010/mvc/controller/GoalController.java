package com.luxoft.jva010.mvc.controller;

import com.luxoft.jva010.mvc.model.Goal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("goal")
public class GoalController
{

    @RequestMapping(value = "goal", method = RequestMethod.GET)
    public String addGoal(Model model, HttpSession session)
    {
        Goal goal = new Goal();
        goal.setMinutes(10);
        model.addAttribute("goal", goal);

        session.setAttribute("goal", goal);

        return "goal";
    }

    @RequestMapping(value = "goal", method = RequestMethod.POST)
    public String updateGoal(@ModelAttribute("goal") Goal goal)
    {
        System.out.println("Minutes updated: " + goal.getMinutes());

        return "redirect:minutes";
    }

}

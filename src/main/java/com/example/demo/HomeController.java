package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    OrderDateRepository orderDateRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderCombinedRepository orderCombinedRepository;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("order", new OrderCombined());

        return "home";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid OrderCombined order, BindingResult result, Model model){
        if(result.hasErrors()){
            return "home";
        }

        orderCombinedRepository.save(order);
        return "redirect:/";

    }

}

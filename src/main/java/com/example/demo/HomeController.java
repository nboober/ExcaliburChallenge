package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        model.addAttribute("orderDate", new OrderDate());

        return "home";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid OrderDate orderDate, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderDate", orderDate);
            return "home";
        }

        orderDateRepository.save(orderDate);
        return "redirect:/orderDetail";

    }

    @GetMapping("/orderDetail")
    public String orderDetail(Model model){

        model.addAttribute("orderDetail", new OrderDetail());

        return "orderDetail";
    }

    @RequestMapping("/processOrderDetails")
    public String processOrderDetails(@Valid OrderDetail orderDetail, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderDetail", orderDetail);
            return "orderDetail";
        }

        orderDetailRepository.save(orderDetail);
        return "redirect:/";

    }


}

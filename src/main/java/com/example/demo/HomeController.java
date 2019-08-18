package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("orderCombined", new OrderCombined());

        return "home";
    }

    @RequestMapping("/processOrderDate")
    public String processOrderDate(@Valid OrderDate orderDate, @ModelAttribute OrderCombined orderCombined, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderDate", orderDate);
            return "home";
        }

        orderDateRepository.save(orderDate);
        orderCombined.setOrderDate(orderDate);
        orderCombinedRepository.save(orderCombined);
        return "redirect:/orderDetail";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model){

        model.addAttribute("orderDetail", new OrderDetail());

        return "orderDetail";
    }

    @RequestMapping("/processOrderDetails")
    public String processOrderDetails(@Valid OrderDetail orderDetail, @ModelAttribute("orderCombined") OrderCombined orderCombined, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderDetail", orderDetail);
            return "orderDetail";
        }

        orderDetailRepository.save(orderDetail);
        orderCombined.setOrderDetail(orderDetail);
        orderCombined.setOrder_amount(orderDetail.getOrder_amount());
        orderCombined.setOrder_description(orderDetail.getOrder_description());
        orderCombinedRepository.save(orderCombined);

        return "redirect:/";

    }


}

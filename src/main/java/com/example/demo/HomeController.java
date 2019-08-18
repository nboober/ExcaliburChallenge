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
    public String processOrderDate(@Valid OrderDate orderDate, @RequestParam("combinedId") long order_id, @ModelAttribute OrderCombined orderCombined,
//                                   @RequestParam("orderDateId") long order_id,
                                   BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderDate", orderDate);
            return "home";
        }

        orderDateRepository.save(orderDate);
        orderCombined.setOrderDate(orderDate);
        orderCombinedRepository.save(orderCombined);
        return "redirect:/orderDetail/"+ order_id;
//        return "redirect:/orderDetail/" + order_id;

    }

//    @RequestMapping("/orderDetail/{id}")
    @RequestMapping("/orderDetail/{order_id}")
    public String orderDetail(@PathVariable("order_id") long order_id,
            //@PathVariable("id") long order_id,
                              Model model){

        model.addAttribute("orderDetail", new OrderDetail());
        model.addAttribute("orderCombined", orderCombinedRepository.findById(order_id).get());
//        model.addAttribute("orderDate", orderDateRepository.findById(order_id).get());

        return "orderDetail";
    }

    @RequestMapping("/processOrderDetails")
    public String processOrderDetails(@Valid OrderDetail orderDetail, @RequestParam("combinedId") long order_id, @ModelAttribute("orderCombined") OrderCombined orderCombined,
                                      //@RequestParam("orderDateId") long order_id,
                                      BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("orderCombined", orderCombinedRepository.findById(order_id).get());
            model.addAttribute("orderDetail", orderDetail);
            return "orderDetail";
        }

//        OrderDate orderDate = orderDateRepository.findById(order_id).get();
        OrderCombined combined = orderCombinedRepository.findById(order_id).get();


        orderDetailRepository.save(orderDetail);
//        orderCombined.setOrder_date(orderDate.getOrder_date());
        combined.setOrderDetail(orderDetail);
        combined.setOrder_amount(orderDetail.getOrder_amount());
        combined.setOrder_description(orderDetail.getOrder_description());
        orderCombinedRepository.save(combined);

        return "redirect:/";

    }


}

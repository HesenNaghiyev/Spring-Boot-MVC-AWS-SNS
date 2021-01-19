package com.aws.sns.controller;


import com.aws.sns.service.Publish_Subscriber_SNS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sns/")
public class Publisher_Subscriber_Controller {

    @Autowired
   private Publish_Subscriber_SNS service;

    @GetMapping
    public String goIndexPage(){
        return "index";
    }

    @GetMapping("addSubscriber")
    public String addSubscriberToSpecifiedTopic(@RequestParam String email, Model model){
       String subscriber=  service.addSubscriberToTopic(email);
       model.addAttribute("subscriber",subscriber);
       return "index";
    }

    @PostMapping("publishMessage")
    public String pushMessageToTopic(@RequestParam String message, @RequestParam String subject, Model model){
       String publisher =  service.pushMessageToSNSTopic(message,subject);
       model.addAttribute("publisher",publisher);

       return "index";
    }

}

package com.chat.controller;

import com.chat.model.Message;
import com.chat.model.User;
import com.chat.service.MessageService;
import com.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    private User author = null;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/enter")
    public ModelAndView signin(){
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("password", "");
        return mv;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message messaging(Message message) throws Exception {
        messageService.create(message);
        return message;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView rival(@ModelAttribute("user") User user){
        ModelAndView mv = null;
        if(userService.findByLogin(user.getLogin())==null){
            userService.create(user);
        }else {
            if (!userService.findByLogin(user.getLogin()).getPassword().equals(user.getPassword())) {
                mv = new ModelAndView("login");
                mv.addObject("password", "Wrong password");
                return mv;
            }
        }
        author = userService.findByLogin(user.getLogin());
        mv = new ModelAndView("chat");
        mv.addObject("author", author);
        mv.addObject("list", userService.findAll());
        return mv;
    }

}
package com.ylluberes.rolebasedapp;

import com.ylluberes.rolebasedapp.messages.Messages;
import com.ylluberes.rolebasedapp.messages.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @Autowired
    private final MessagesRepository messagesRepository;

    @GetMapping("/home")
    public String home (Model model) {
        model.addAttribute("msgs", messagesRepository.findAll());
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage (Messages messages) {
        messagesRepository.save(messages);
        return "redirect:/home";
    }
}

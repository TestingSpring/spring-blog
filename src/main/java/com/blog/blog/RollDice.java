package com.blog.blog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDice {

    @GetMapping("/roll-dice")
    public String rollPage() {
        return "selectNumber";
    }

    @GetMapping("/roll-dice/{number}")
    public String numberResults(@PathVariable int number, Model model) {
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        model.addAttribute("randomNumber", n);
        model.addAttribute("userNumber", number);
        return "numberResults";

    }




}

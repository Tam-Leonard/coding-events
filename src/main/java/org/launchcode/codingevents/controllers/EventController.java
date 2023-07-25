package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

   private static List<String> events = new ArrayList<>();
   //this was made b/c the list below is
    //private and can't be accessed outside of the displayAllEvents method so createEvent method can
    //access it or take data that is passed in
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", events);
        return "events/index";
    }

    //This method lives at /events/create
   @GetMapping("create")
    public String renderCreateEvent(){
        return "events/create";
    }

    //lives at /event/create
    @PostMapping("create")
    //eventName parameter comes from create.html
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
        //redirect response that instructs the browser to go to a different page
        //the colon instructs user to redirect to a specific controller, the root path-/events

    }
}

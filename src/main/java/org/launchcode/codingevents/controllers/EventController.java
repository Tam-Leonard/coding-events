package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

   //private static List<Event> events = new ArrayList<>(); removed b/c created the eventdata class
   //this was made b/c the list below is
    //private and can't be accessed outside of the displayAllEvents method so createEvent method can
    //access it or take data that is passed in
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        //updated from "events",event b/c got rid of the arraylist above b/c we created eventdata class
        return "events/index";
    }

    //This method lives at /events/create
   @GetMapping("create")
   //eventName parameter comes from create.html
   public String displayCreateEventForm(Model model) {
       model.addAttribute("title","Create Event");
       model.addAttribute(new Event());//added this to the events.java file then went to the create file
       model.addAttribute("types", EventType.values());//this will return the values in the enum type - EventType
       //to be used in the template for a dropdown
       return "events/create";
    }
    //lives at /event/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title","Create Event");
            return "events/create";
        } //go to create.html and add code at the top after this step
        EventData.add(newEvent);
        return "redirect:";
        //when the Event newEvent is called, Spring will create the new event for us
        //updated from on create.html file from eventName to just name, eventDescription to description

    /*This commented out for model binding public String processCreateEventForm(@RequestParam String eventName,
                                         @RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription));
        //this was updated from events eventdata b/c we removed the arraylist and created eventdata class
        return "redirect:";
        //redirect response that instructs the browser to go to a different page
        //the colon instructs user to redirect to a specific controller, the root path-/events*/
    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
}

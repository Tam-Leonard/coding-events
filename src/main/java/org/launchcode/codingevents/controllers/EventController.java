package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
       return "events/create";
    }
    //lives at /event/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
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
    @GetMapping("edit/{eventId}")//b/c we're displaying information 14.5. Exercises: Edit Model Classes
    public String displayEditForm(Model model, @PathVariable int eventId) {
        //eventId need to match for it to work
        //EventData.getById(eventId);commented out b/c of task 5 b. it was added below no longer needed
        Event event = EventData.getById(eventId); //task 8
        String title = "Edit Event " + event.getName() + " (id=" + event.getId() + ")"; //Task 8
        model.addAttribute("event", event );
        model.addAttribute("title", title); //task 8
        return "events/edit";
    }
    @PostMapping("edit")//b/c this is doing something after an event occurs hint: it reads process
    public String processEditForm(int eventId, String name, String description) {
        Event myEvent = EventData.getById(eventId);
        //Task 9 a) by query it means go get the data from whoever is holding it, our data layer
        //and save what it gets back into an event variable
        // controller code will go here
        myEvent.setName(name); //task 9 b
        myEvent.setDescription(description); //task 9 b
        return "redirect:/events"; //task 9 c
    }
}

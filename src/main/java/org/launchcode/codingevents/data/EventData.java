package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //need place to put events
    private static final Map<Integer, Event> events = new HashMap<>();
    //behaviors below:
    //get all events
    public static Collection<Event> getAll() {
        return events.values();
    } //Collection is an interface this will loop over collections

    //get single event
    public static Event getById(int id) {
        return events.get(id);
    }

    //add an event to collection
    public static void add(Event event) {
        events.put(event.getId(), event);
    }
    //remove an event
    public static void remove(int id) {
        events.remove(id);
    }//this will extract a single id from the events map
}

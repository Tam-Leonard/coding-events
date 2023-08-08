package org.launchcode.codingevents.models;

public enum EventType {
    //variable names or field names:
    CONFERENCE("Conference"), //there was a red line under value until the parenthesis
    //by putting the string after the value name, its saying call the constructor after this value.
    //after this page, go to the event class to make a property after that is done, go to the eventcontroller
    //to add under displayCreateEvent
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
    SOCIAL("Social");

    private final String displayName;

    //constructor (to initialze above) used, Generate/constructor then Generate Getter
    //don't create setter b/c its final.

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package org.launchcode.codingevents.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextID = 1;
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Must be between 3-50 characters.")
    private String name;
    @Size(max = 500, message = "Too long!")
    private String description;
    @NotBlank(message = "Email is required.")
    @Email(message = "Nah! Try again.")
    private String contactEmail;

    private EventType type; //added this variable then in the constructor then added getter/setter

    //this is the constructor
    public Event(String name, String description, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.type = type;
        //Line was cut b/c the disply for create event started at 0. want it to start at 1 so it was
        //added down below then added this()
        // this.id = nextID; //only use getter, no one should be able to set it
        //nextID++; //don't want this to be exposed to the public. should stay private so no getter
    }
    public Event(){
        this.id = nextID;
        nextID++;
    }//this is a no arg constructor, a constructor that takes no arguments.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

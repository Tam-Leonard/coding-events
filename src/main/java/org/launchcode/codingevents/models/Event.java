package org.launchcode.codingevents.models;


import javax.validation.constraints.*;
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
    @NotNull(message = "Location is required.")
    @NotBlank(message = "Location is required.")
    private String location;

    @AssertTrue(message="This event must have attendees register.")
    private boolean shouldRegister = true;

    @NotNull(message="At least 1 attendee is required.")
    @Min(value=1, message = "At least 1 attendee is required.")
    private Integer numOfAttendees;

    @NotNull(message = "Number of Marvels attending between 1 and 4.")
    @Min(value=1, message = "Number of Marvels attending between 1 and 4.")
    @Max(value=4, message = "Number of Marvels attending between 1 and 4.")
    private Integer numOfMarvels;

    //this is the constructor
    public Event(String name, String description, String contactEmail, String location, Integer numOfAttendees ) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numOfAttendees = numOfAttendees;
        this.id = nextID; //only use getter, no one should be able to set it
        nextID++; //don't want this to be exposed to the public. should stay private so no getter
    }
    public Event(){}//this is a no arg constructor, a constructor that takes no arguments.
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public Integer getNumOfMarvels() {
        return numOfMarvels;
    }

    public void setNumOfMarvels(Integer numOfMarvels) {
        this.numOfMarvels = numOfMarvels;
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

package org.launchcode.codingevents.models;

import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @Future(message = "Must be a future date")
    private Date dateOfEvent;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again")
    private String contactEmail;

    @NotBlank(message = "Location is required")
    private String location;

    @Min(value = 1, message = "Please enter number of attendees")
    private int numAttendees;


    public Event(Date dateOfEvent,String name, String description, String contactEmail, String location, int numAttendees) {
        this.dateOfEvent = dateOfEvent;
        this.name = name;
        this.description = description;
        this.location = location;
        this.numAttendees = numAttendees;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }

    public Event(){

    }

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

    public int getId() {
        return id;
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

    public int getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
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

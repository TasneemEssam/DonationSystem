package com.tasnim.aast;

import java.util.UUID;

public class Event {
    private String eventId;
    private String eventName;

    public Event(String eventName) {
        this.eventId = UUID.randomUUID().toString();
        this.eventName= eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}

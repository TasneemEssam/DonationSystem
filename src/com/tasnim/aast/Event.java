package com.tasnim.aast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Event {
    private String eventId;
    private String eventName;

    public Event(String eventName, Connection connection) {
        String query = " insert into event (name) values (?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, eventName);
            preparedStmt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
        return "\nEvent{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}

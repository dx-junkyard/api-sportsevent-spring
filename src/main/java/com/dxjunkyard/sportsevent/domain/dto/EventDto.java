package com.dxjunkyard.sportsevent.domain.dto;


import com.dxjunkyard.sportsevent.domain.Event;
import com.dxjunkyard.sportsevent.domain.request.AddEventRequest;
import com.sun.jdi.request.EventRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EventDto {
    public static Event event(AddEventRequest request) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime time_from;
        LocalDateTime time_to;
        try {
            time_from = LocalDateTime.parse(request.getTimeFrom(),dtf);
            time_to = LocalDateTime.parse(request.getTimeTo(),dtf);
        } catch (Exception e) {
            return null;
        }
        return Event.builder()
                .title(request.getTitle())
                .ownerId(request.getOwnerId())
                .timeFrom(time_from)
                .timeTo(time_to)
                .comment(request.getComment())
                .placeId(request.getPlaceId())
                .eventType(request.getEventType())
                .build();
    }
}

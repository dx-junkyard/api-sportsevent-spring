package com.dxjunkyard.sportsevent.domain.dto;


import com.dxjunkyard.sportsevent.domain.Event;
import com.dxjunkyard.sportsevent.domain.request.AddEventRequest;
import com.sun.jdi.request.EventRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventDto {
    public static Event event(AddEventRequest request) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date time_from;
        Date time_to;
        try {
            time_from = sdf.parse(request.getTimeFrom());
            time_to = sdf.parse(request.getTimeTo());
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

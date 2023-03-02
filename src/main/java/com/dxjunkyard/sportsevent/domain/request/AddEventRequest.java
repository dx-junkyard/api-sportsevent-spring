package com.dxjunkyard.sportsevent.domain.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AddEventRequest {
    private String title;
    private String timeFrom;
    private String timeTo;
    private String ownerId;
    private Integer placeId;
    private String comment;
    private Integer eventType;
    private List<Integer> sportEventIdList;
}

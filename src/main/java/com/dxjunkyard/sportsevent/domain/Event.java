package com.dxjunkyard.sportsevent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer eventId;
    private String title;
    private String ownerId;
    private Date timeFrom;
    private Date timeTo;
    private String comment;
    private Integer placeId;
    private Integer eventType;
    private List<SportEvent> sportEventList;
}

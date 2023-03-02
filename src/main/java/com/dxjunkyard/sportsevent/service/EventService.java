package com.dxjunkyard.sportsevent.service;

import com.dxjunkyard.sportsevent.domain.Event;
import com.dxjunkyard.sportsevent.domain.SportEvent;
import com.dxjunkyard.sportsevent.domain.response.GetEventsResponse;
import com.dxjunkyard.sportsevent.repository.dao.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EventService {
    @Autowired
    EventMapper eventMapper;

    public void addEvent(Event event) {
        eventMapper.addEvent(event);
    }

    public GetEventsResponse getEvent(Integer eventId) {
        List<SportEvent> sportEventList = eventMapper.getSportEvent(eventId);
        List<Event> eventList = eventMapper.getEvent(eventId);
        eventList.get(0).setSportEventList(sportEventList);
        return GetEventsResponse.builder()
                .eventList(eventList)
                .build();
    }
}

package com.dxjunkyard.sportsevent.service;

import com.dxjunkyard.sportsevent.controller.Controller;
import com.dxjunkyard.sportsevent.domain.Event;
import com.dxjunkyard.sportsevent.domain.SportEvent;
import com.dxjunkyard.sportsevent.domain.dto.EventDto;
import com.dxjunkyard.sportsevent.domain.request.AddEventRequest;
import com.dxjunkyard.sportsevent.domain.response.GetEventsResponse;
import com.dxjunkyard.sportsevent.repository.dao.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService {
    private Logger logger = LoggerFactory.getLogger(EventService.class);

    @Autowired
    EventMapper eventMapper;

    public void addEvent(AddEventRequest request) {
        logger.info("addEvent");
        try {
            eventMapper.addEvent(EventDto.event(request));
            for (Integer sportid : request.getSportEventIdList()) {
                eventMapper.addIncludeSportEvent(sportid);
            }
        } catch (Exception e) {
            logger.info("addEvent error");
            logger.debug("addEvent error info : " + e.getMessage());
        }
    }

    public GetEventsResponse getEvent(Integer eventId) {
        logger.info("getEvent");
        try {
            List<SportEvent> sportEventList = eventMapper.getIncludedSportEvents(eventId);
            List<Event> eventList = eventMapper.getEvent(eventId);
            eventList.get(0).setSportEventList(sportEventList);
            return GetEventsResponse.builder()
                    .eventList(eventList)
                    .build();
        } catch (Exception e) {
            logger.info("getEvent error : eventId = " + eventId.toString());
            return GetEventsResponse.builder().build();
        }
    }
}

package com.dxjunkyard.sportsevent.repository.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.dxjunkyard.sportsevent.domain.Event;
import com.dxjunkyard.sportsevent.domain.SportEvent;

import java.util.List;

@Mapper
public interface EventMapper {
    void addEvent(Event event);
    void addIncludeSportEvent(Integer sportEventId);
    List<Event> getEvent(Integer eventId);
    List<SportEvent> getIncludedSportEvents(Integer eventId);
}

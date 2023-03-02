package com.dxjunkyard.sportsevent.domain.response;

import com.dxjunkyard.sportsevent.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetEventsResponse {
    private List<Event> eventList;
}

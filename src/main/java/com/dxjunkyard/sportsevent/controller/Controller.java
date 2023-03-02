package com.dxjunkyard.sportsevent.controller;

import com.dxjunkyard.sportsevent.domain.dto.EventDto;
import lombok.extern.slf4j.Slf4j;
import com.dxjunkyard.sportsevent.domain.request.*;
import com.dxjunkyard.sportsevent.domain.response.*;
import com.dxjunkyard.sportsevent.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api")
@Slf4j
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private EventService eventService;

    /**
     * 
     */
    @PostMapping("/event")
    @ResponseBody
    public NormalResponse addEvent(
            @RequestBody AddEventRequest request){
        logger.info("event API");
        try {
            eventService.addEvent(EventDto.event(request));
            return NormalResponse.builder().result("OK").build();
        } catch (Exception e) {
            logger.info("event" + e.getMessage());
            return NormalResponse.builder().result("NG").build();
        }
    }

    /**
     * ★location
     */
    @GetMapping("/event")
    @ResponseBody
    public GetEventsResponse getEvent(
            @RequestParam("eventId") Integer eventId) {
        logger.info("event API");
        try {
            GetEventsResponse response = eventService.getEvent(eventId);
            return response;
        } catch (Exception e) {
            return GetEventsResponse.builder().build();
        }
    }


    @GetMapping("/hello")
    @ResponseBody
    public NormalResponse checkin(){
        logger.info("疎通確認 URL");
        return NormalResponse.builder().result("OK").build();
    }

}

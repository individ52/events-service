package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.EventDto;
import com.rikeventsmanager.eventsservice.Model.Event;

import java.util.*;

public class EventMapper {
    public static EventDto mapToEventDto(Event event) {
        return new EventDto(
                event.getEventId(),
                event.getName(),
                event.getDatetime(),
                event.getVenue(),
                event.getAddInfo(),
                event.getParticipants().stream().map((p)->ParticipantMapper.mapToParticipantDto(p)).toList()
        );
    }
    public static Event mapToEvent(EventDto eventDto) {
        return new Event(
                eventDto.getEventId(),
                eventDto.getName(),
                eventDto.getDatetime(),
                eventDto.getVenue(),
                eventDto.getAddInfo(),
                Collections.emptyList()
        );
    }
}

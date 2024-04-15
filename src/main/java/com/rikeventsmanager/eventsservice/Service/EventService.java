package com.rikeventsmanager.eventsservice.Service;

import com.rikeventsmanager.eventsservice.DTO.EventDto;
import com.rikeventsmanager.eventsservice.DTO.ParticipantDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);
    EventDto getEventById(Long id);
    List<EventDto> getAllEvents();
    EventDto updateEvent(Long id, EventDto eventDto);
    void deleteEvent(Long id);
    ParticipantDto addParticipant(Long id, ParticipantDto participantDto);
}

package com.rikeventsmanager.eventsservice.Controller;


import com.rikeventsmanager.eventsservice.DTO.EventDto;
import com.rikeventsmanager.eventsservice.DTO.ParticipantDto;
import com.rikeventsmanager.eventsservice.Service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {
    private EventService eventService;

    // Build Add Event REST API
    @PostMapping()
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        EventDto savedEvent = eventService.createEvent(eventDto);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    // Build Get Event REST API
    @GetMapping("{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id") Long id) {
        EventDto event = eventService.getEventById(id);

        return ResponseEntity.ok(event);
    }

    // build Get All Event REST API
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();

        return ResponseEntity.ok(events);
    }

    // Build Update Event REST API
    @PutMapping("{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long id, @RequestBody EventDto eventDto ) {
        EventDto updatedEvent = eventService.updateEvent(id, eventDto);

        return ResponseEntity.ok(updatedEvent);
    }

    // Build Update Event REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long id) {
        // TODO: only if it is future event
        // removeing event removes all participants connected
        eventService.deleteEvent(id);

        return ResponseEntity.ok("Event is successfully deleted");
    }

    // Build add participant  REST API
    @PostMapping("{id}/participants")
    public ResponseEntity<ParticipantDto> addParticipant(@PathVariable("id") Long id, @RequestBody ParticipantDto participantDto ) {
        ParticipantDto addedParticipantDto = eventService.addParticipant(id, participantDto);

        return ResponseEntity.ok(addedParticipantDto);
    }


}

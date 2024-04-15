package com.rikeventsmanager.eventsservice.Service.Impl;

import com.rikeventsmanager.eventsservice.DTO.EventDto;
import com.rikeventsmanager.eventsservice.DTO.ParticipantDto;
import com.rikeventsmanager.eventsservice.Exception.ResourceNotFoundException;
import com.rikeventsmanager.eventsservice.Mapper.EventMapper;
import com.rikeventsmanager.eventsservice.Mapper.NaturalPersonMapper;
import com.rikeventsmanager.eventsservice.Mapper.ParticipantMapper;
import com.rikeventsmanager.eventsservice.Model.*;
import com.rikeventsmanager.eventsservice.Repository.*;
import com.rikeventsmanager.eventsservice.Service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final ParticipantRepository participantRepository;
    private EventRepository eventRepository;
    private NaturalPersonRepository naturalPersonRepository;
    private LegalPersonRepository legalPersonRepository;
    private ParticipantTypeRepository participantTypeRepository;
    private PayMethodRepository payMethodRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {

        Event event = EventMapper.mapToEvent(eventDto);
        Event savedEvent = eventRepository.save(event);

        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event is not exists with given id: " + id));



        return EventMapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(
                        (event) ->EventMapper.mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event is not exists with given id: " + id));

        event.setName(eventDto.getName());
        event.setDatetime(eventDto.getDatetime());
        event.setVenue(eventDto.getVenue());
        event.setAddInfo(eventDto.getAddInfo());

        Event updatedEventObj = eventRepository.save(event);

        return EventMapper.mapToEventDto(updatedEventObj);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event is not exists with given id: " + id));
        eventRepository.deleteById(id);
    }

    @Override
    public ParticipantDto addParticipant(Long id, ParticipantDto participantDto) {
        participantDto.setEventId(id);
        Integer participantTypeCode = participantDto.getParticipantTypeCode();

        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event is not exists with given id: " + id));

        participantDto.setEventId(id);
        if(participantTypeCode == 1) { // natural
            Participant participant = getFullParticipant(participantDto);

            NaturalPerson naturalPerson = NaturalPersonMapper.mapToNaturalPerson(participantDto.getNaturalPerson());

            Participant addedParticipant = participantRepository.save(participant);

            naturalPerson.setParticipantId(addedParticipant.getParticipantId());
            naturalPerson.setParticipant(addedParticipant);
            NaturalPerson addedNaturalPerson = naturalPersonRepository.save(naturalPerson);

            addedParticipant.setNaturalPerson(addedNaturalPerson);

            event.addParticipantToEvent(addedParticipant);
            eventRepository.save(event);

            return ParticipantMapper.mapToParticipantDto(addedParticipant);

        } else if(participantTypeCode == 2) {

        }

        throw new ResourceNotFoundException("Add participant with undefined type code: " + participantTypeCode);
    }

    private Participant getFullParticipant(ParticipantDto participantDto) {
        Long participantId = participantDto.getParticipantId();
        Long eventId = participantDto.getEventId();
        Integer participantTypeCode = participantDto.getParticipantTypeCode();
        Integer payMethodCode = participantDto.getPayMethodCode();
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event is not exists with given id: " + eventId));
        ParticipantType participantType = participantTypeRepository.findById(participantTypeCode).orElseThrow(() -> new ResourceNotFoundException("Participant type code is not exists with given id: " + participantTypeCode));
        PayMethod payMethod = payMethodRepository.findById(payMethodCode).orElseThrow(() -> new ResourceNotFoundException("Participant type code is not exists with given id: " + payMethodCode));

        return new Participant(
                participantId,
//                participantTypeCode,
//                payMethodCode,
                event,
                participantType,
                payMethod,
                null,
                null
        );

    }
}

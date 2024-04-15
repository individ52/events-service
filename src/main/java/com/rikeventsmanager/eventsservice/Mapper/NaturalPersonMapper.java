package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.NaturalPersonDto;
import com.rikeventsmanager.eventsservice.Model.NaturalPerson;
import com.rikeventsmanager.eventsservice.Repository.ParticipantRepository;

public class NaturalPersonMapper {
    public static ParticipantRepository participantRepository;

    public static NaturalPersonDto mapToNaturalPersonDto(NaturalPerson naturalPerson) {
        if(naturalPerson == null) return null;

        return new NaturalPersonDto(
                naturalPerson.getParticipant().getParticipantId(),
                naturalPerson.getFirstName(),
                naturalPerson.getLastName(),
                naturalPerson.getPersonalIdCode(),
                naturalPerson.getAddInfo()
        );
    }
    public static NaturalPerson mapToNaturalPerson(NaturalPersonDto naturalPersonDto) {
        if(naturalPersonDto == null) return null;

        return new NaturalPerson(
                naturalPersonDto.getParticipantId(),
                null,
                naturalPersonDto.getFirstName(),
                naturalPersonDto.getLastName(),
                naturalPersonDto.getPersonalIdCode(),
                naturalPersonDto.getAddInfo()
        );
    }
}

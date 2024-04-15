package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.*;
import com.rikeventsmanager.eventsservice.Model.Participant;

public class ParticipantMapper {
    public static ParticipantDto mapToParticipantDto(Participant participant) {
        return new ParticipantDto(
                participant.getParticipantId(),
                participant.getParticipantType().getParticipantTypeCode(),
                ParticipantTypeMapper.mapToParticipantTypeDto(participant.getParticipantType()),
                participant.getPayMethod().getPayMethodCode(),
                PayMethodMapper.mapToPayMethodDto(participant.getPayMethod()),
                NaturalPersonMapper.mapToNaturalPersonDto(participant.getNaturalPerson()),
                LegalPersonMapper.mapToLegalPersonDto(participant.getLegalPerson()),
                participant.getEvent().getEventId()
        );
    }
}

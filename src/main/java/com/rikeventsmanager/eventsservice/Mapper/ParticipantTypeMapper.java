package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.ParticipantTypeDto;
import com.rikeventsmanager.eventsservice.Model.ParticipantType;

public class ParticipantTypeMapper {
    public static ParticipantTypeDto mapToParticipantTypeDto(ParticipantType participantType) {
        return new ParticipantTypeDto(
                participantType.getParticipantTypeCode(),
                participantType.getParticipantTypeName()
        );
    }
    public static ParticipantType mapToParticipantType(ParticipantTypeDto participantTypeDto) {
        return new ParticipantType(
                participantTypeDto.getParticipantTypeCode(),
                participantTypeDto.getParticipantTypeName()
        );
    }
}

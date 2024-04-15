package com.rikeventsmanager.eventsservice.Mapper;

import com.rikeventsmanager.eventsservice.DTO.LegalPersonDto;
import com.rikeventsmanager.eventsservice.Model.LegalPerson;

public class LegalPersonMapper {
    public static LegalPersonDto mapToLegalPersonDto(LegalPerson legalPerson) {
        if(legalPerson == null) return null;

        return new LegalPersonDto(
                legalPerson.getParticipant().getParticipantId(),
                legalPerson.getLegalName(),
                legalPerson.getRegisterCode(),
                legalPerson.getNumberOfParticipants(),
                legalPerson.getAddInfo()
        );
    }
    public static LegalPerson mapToLegalPerson(LegalPersonDto legalPersonDto) {
        if(legalPersonDto == null) return null;

        return new LegalPerson(
                legalPersonDto.getParticipantId(),
                null,
                legalPersonDto.getLegalName(),
                legalPersonDto.getRegisterCode(),
                legalPersonDto.getNumberOfParticipants(),
                legalPersonDto.getAddInfo()
        );
    }
}

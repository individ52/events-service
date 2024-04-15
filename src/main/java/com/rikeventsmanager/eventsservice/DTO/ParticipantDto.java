package com.rikeventsmanager.eventsservice.DTO;

import com.rikeventsmanager.eventsservice.Model.LegalPerson;
import com.rikeventsmanager.eventsservice.Model.NaturalPerson;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto {
    private Long participantId  = null;
    private Integer participantTypeCode  = null;
    private ParticipantTypeDto participantType  = null;
    private Integer payMethodCode  = null;
    private PayMethodDto payMethod  = null;
    private NaturalPersonDto naturalPerson  = null;
    private LegalPersonDto legalPerson  = null;
    private Long eventId  = null;
}
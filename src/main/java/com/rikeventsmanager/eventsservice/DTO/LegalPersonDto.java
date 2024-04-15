package com.rikeventsmanager.eventsservice.DTO;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalPersonDto {
    private Long participantId = null;
    private String legalName = null;
    private String registerCode = null;
    private Integer numberOfParticipants = null;
    private String addInfo = null;
}

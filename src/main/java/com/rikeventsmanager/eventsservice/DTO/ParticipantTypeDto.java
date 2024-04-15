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
public class ParticipantTypeDto {
    private Integer participantTypeCode;
    private String participantTypeName;
}

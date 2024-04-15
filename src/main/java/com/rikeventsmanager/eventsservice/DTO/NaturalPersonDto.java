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
public class NaturalPersonDto {
    private Long participantId = null;
    private String firstName = null;
    private String lastName = null;
    private String personalIdCode = null;
    private String addInfo = null;
}

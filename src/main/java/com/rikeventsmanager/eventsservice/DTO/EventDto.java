package com.rikeventsmanager.eventsservice.DTO;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @Nullable
    private Long eventId;
    @Nullable
    private String name;
    @Nullable
    private Timestamp datetime;
    @Nullable
    private String venue;
    @Nullable
    private String addInfo;
    @Nullable
    private List<ParticipantDto> participants = new ArrayList<>();
}

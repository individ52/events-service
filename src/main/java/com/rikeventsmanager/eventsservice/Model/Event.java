package com.rikeventsmanager.eventsservice.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "name")
    private String name;

    @Column(name = "datetime", nullable = false)
    private Timestamp datetime;

    @Column(name = "venue", nullable = false)
    private String venue;

    @Column(name = "add_info", nullable = false, length = 1000)
    private String addInfo;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Participant> participants;

    public void addParticipantToEvent(Participant participant) {
        participant.setEvent(this);
        this.participants.add(participant);
    }


}

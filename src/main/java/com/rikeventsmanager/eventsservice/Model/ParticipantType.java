package com.rikeventsmanager.eventsservice.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participant_types")
public class ParticipantType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_type_code")
    private Integer participantTypeCode;

    @Column(name = "participant_type_name")
    private String participantTypeName;
}

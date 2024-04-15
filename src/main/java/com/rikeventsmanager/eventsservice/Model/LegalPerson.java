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
@Table(name = "legal_persons")
public class LegalPerson {
    @Id
    @Column(name = "participant_id", nullable = false)
    private Long participantId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_id", referencedColumnName = "participant_id")
    private Participant participant;

    @Column(name = "legal_name", nullable = false)
    private String legalName;

    @Column(name = "register_code", nullable = false)
    private String registerCode;

    @Column(name = "number_of_participants", nullable = false)
    private Integer numberOfParticipants;

    @Column(name = "add_info", nullable = false, length = 5000)
    private String addInfo;

}

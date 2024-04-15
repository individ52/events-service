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
@Table(name = "natrual_persons")
public class NaturalPerson {
    @Id
    @Column(name = "participant_id", nullable = false)
    private Long participantId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_id", referencedColumnName = "participant_id")
    private Participant participant;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "personal_id_code", nullable = false)
    private String personalIdCode;

    @Column(name = "add_info", nullable = false, length = 1500)
    private String addInfo;

}

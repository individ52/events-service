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
@Table(name = "participants")
@PrimaryKeyJoinColumns({
        @PrimaryKeyJoinColumn(name="participant_id"),
        @PrimaryKeyJoinColumn(name="event_id")
})
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private Long participantId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_type_code")
    private ParticipantType participantType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pay_method_code")
    private PayMethod payMethod;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private NaturalPerson naturalPerson  = null;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private LegalPerson legalPerson  = null;
}

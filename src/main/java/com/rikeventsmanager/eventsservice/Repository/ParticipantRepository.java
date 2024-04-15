package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}

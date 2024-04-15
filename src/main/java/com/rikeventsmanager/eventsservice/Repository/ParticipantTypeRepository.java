package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.ParticipantType;
import com.rikeventsmanager.eventsservice.Model.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantTypeRepository extends JpaRepository<ParticipantType, Integer> {
}

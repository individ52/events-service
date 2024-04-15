package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.Participant;
import com.rikeventsmanager.eventsservice.Model.PayMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMethodRepository extends JpaRepository<PayMethod, Integer> {
}

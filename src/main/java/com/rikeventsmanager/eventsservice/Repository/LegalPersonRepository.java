package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {
}

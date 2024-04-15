package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {
}

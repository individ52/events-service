package com.rikeventsmanager.eventsservice.Repository;

import com.rikeventsmanager.eventsservice.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;




public interface EventRepository extends JpaRepository<Event, Long> {
}

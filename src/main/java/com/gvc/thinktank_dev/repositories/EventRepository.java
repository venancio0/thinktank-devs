package com.gvc.thinktank_dev.repositories;

import com.gvc.thinktank_dev.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}

package com.yourname.skillsharehub.service;

import com.yourname.skillsharehub.exception.ResourceNotFoundException;
import com.yourname.skillsharehub.model.Event;
import com.yourname.skillsharehub.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    // Constructor Injection is recommended over field injection
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Retrieves all events from the repository.
     *
     * @return List of all events.
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Retrieves an event by its ID.
     *
     * @param id The ID of the event.
     * @return The found event.
     * @throws ResourceNotFoundException if the event is not found.
     */
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "id", id));
    }

    /**
     * Creates a new event.
     *
     * @param event The event to create.
     * @return The created event.
     */
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Updates an existing event.
     *
     * @param id           The ID of the event to update.
     * @param eventDetails The updated event details.
     * @return The updated event.
     * @throws ResourceNotFoundException if the event is not found.
     */
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setTitle(eventDetails.getTitle());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        // Update other fields as necessary
        return eventRepository.save(event);
    }

    /**
     * Deletes an event by its ID.
     *
     * @param id The ID of the event to delete.
     * @throws ResourceNotFoundException if the event is not found.
     */
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
}

import React, { useEffect, useState } from 'react';
import { getAllEvents } from '../../services/eventService';

const EventList = () => {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const response = await getAllEvents();
        setEvents(response.data);
      } catch (error) {
        console.error('Failed to fetch events:', error);
      }
    };
    fetchEvents();
  }, []);

  return (
    <div className="container">
      <h2>Event List</h2>
      <ul className="list-group">
        {events.map((event) => (
          <li key={event.id} className="list-group-item">
            <h4>{event.title}</h4>
            <p>{event.description}</p>
            <p>Date: {new Date(event.date).toLocaleString()}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EventList;

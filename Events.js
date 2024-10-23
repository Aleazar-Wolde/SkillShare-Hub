import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Events() {
  const [events, setEvents] = useState([]);
  const [error, setError] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const token = localStorage.getItem('token');
        const response = await axios.get('http://localhost:8080/api/events', {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });
        setEvents(response.data);
      } catch (err) {
        setError('Unable to fetch events');
      }
    };

    fetchEvents();
  }, []);

  return (
    <div className="container">
      <h2>Events</h2>
      {error && <div className="alert alert-danger">{error}</div>}
      <button className="btn btn-primary mb-3" onClick={() => navigate('/create-event')}>
        Create New Event
      </button>
      <ul className="list-group">
        {events.map(event => (
          <li key={event.id} className="list-group-item">
            <h5>{event.title}</h5>
            <p>{event.description}</p>
            <small>{new Date(event.date).toLocaleString()}</small>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Events;

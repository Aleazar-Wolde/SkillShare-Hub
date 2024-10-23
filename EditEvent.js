import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getEventById, updateEvent } from '../../services/api';

function EditEvent() {
  const { eventId } = useParams();
  const [event, setEvent] = useState({
    title: '',
    description: '',
    date: '',
  });

  useEffect(() => {
    // Fetch the event data when the component mounts
    getEventById(eventId)
      .then((response) => {
        setEvent(response.data);
      })
      .catch((error) => {
        console.error('Error fetching event:', error);
      });
  }, [eventId]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setEvent({ ...event, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    updateEvent(eventId, event)
      .then((response) => {
        console.log('Event updated successfully:', response.data);
      })
      .catch((error) => {
        console.error('Error updating event:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Title</label>
        <input
          type="text"
          name="title"
          value={event.title}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label>Description</label>
        <textarea
          name="description"
          value={event.description}
          onChange={handleInputChange}
        />
      </div>
      <div>
        <label>Date</label>
        <input
          type="datetime-local"
          name="date"
          value={event.date}
          onChange={handleInputChange}
        />
      </div>
      <button type="submit">Update Event</button>
    </form>
  );
}

export default EditEvent;

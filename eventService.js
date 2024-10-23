import axios from 'axios';

const API_URL = 'http://localhost:8080/api/events';

// Fetch all events
export const getAllEvents = async () => {
  return await axios.get(API_URL);
};

// Create a new event
export const createEvent = async (eventData) => {
  return await axios.post(API_URL, eventData);
};

// Update an event
export const updateEvent = async (id, eventData) => {
  return await axios.put(`${API_URL}/${id}`, eventData);
};

// Delete an event
export const deleteEvent = async (id) => {
  return await axios.delete(`${API_URL}/${id}`);
};
// Fetch an event by ID
export const getEventById = async (id) => {
    return await axios.get(`${API_URL}/${id}`);
};
  

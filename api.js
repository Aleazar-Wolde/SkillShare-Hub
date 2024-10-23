import axios from 'axios';

const API_URL = 'http://localhost:8080/api'; // Update to match your backend

const axiosInstance = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Function to get an event by its ID
export const getEventById = (eventId) => {
  return axiosInstance.get(`/events/${eventId}`);
};

// Function to create a new event
export const createEvent = (eventData) => {
  return axiosInstance.post('/events', eventData);
};

// Function to update an existing event
export const updateEvent = (eventId, eventData) => {
  return axiosInstance.put(`/events/${eventId}`, eventData);
};

// Function to delete an event
export const deleteEvent = (eventId) => {
  return axiosInstance.delete(`/events/${eventId}`);
};

// Function to get all events
export const getEvents = () => {
  return axiosInstance.get('/events');
};

// Authentication-related functions
export const login = (credentials) => {
  return axiosInstance.post('/auth/login', credentials);
};

export const register = (userData) => {
  return axiosInstance.post('/auth/register', userData);
};

export const getUserProfile = () => {
  return axiosInstance.get('/auth/me');
};

export const setAuthToken = (token) => {
  if (token) {
    axiosInstance.defaults.headers.common['Authorization'] = `Bearer ${token}`;
  } else {
    delete axiosInstance.defaults.headers.common['Authorization'];
  }
};

import React from 'react';
import { Route, Switch } from 'react-router-dom';
import CreateEvent from '../components/Events/CreateEvent';
import EditEvent from '../components/Events/EditEvent';
import EventList from '../components/Events/EventList';

const EventPage = () => {
  return (
    <div className="container">
      <Switch>
        <Route exact path="/events" component={EventList} />
        <Route path="/events/create" component={CreateEvent} />
        <Route path="/events/edit/:id" component={EditEvent} />
      </Switch>
    </div>
  );
};

export default EventPage;

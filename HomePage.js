import React from 'react';
import { Link } from 'react-router-dom';
import { Button, Typography, Container } from '@mui/material';

const HomePage = () => {
  return (
    <Container maxWidth="md">
      <Typography variant="h2" align="center" gutterBottom>
        Welcome to SkillShare Hub
      </Typography>
      <Typography variant="h5" align="center" paragraph>
        Connect, Learn, and Collaborate with Professionals Worldwide
      </Typography>
      <div style={{ textAlign: 'center', marginTop: '2rem' }}>
        <Button
          component={Link}
          to="/register"
          variant="contained"
          color="primary"
          size="large"
          style={{ marginRight: '1rem' }}
        >
          Sign Up
        </Button>
        <Button
          component={Link}
          to="/login"
          variant="outlined"
          color="primary"
          size="large"
        >
          Log In
        </Button>
      </div>
    </Container>
  );
};

export default HomePage;
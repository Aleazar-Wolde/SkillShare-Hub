import React from 'react';
import { useNavigate } from 'react-router-dom';

function Header() {
  const navigate = useNavigate();

  const handleLogout = () => {
    // Perform logout logic
    navigate('/login'); // Redirect after logout
  };

  return (
    <header>
      {/* Header Content */}
      <button onClick={handleLogout}>Logout</button>
    </header>
  );
}

export default Header;

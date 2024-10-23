const initialState = {
    isAuthenticated: false,
    user: null,
    loading: true,
  };
  
  const authReducer = (state = initialState, action) => {
    switch (action.type) {
      case 'LOGIN_SUCCESS':
        return {
          ...state,
          isAuthenticated: true,
          user: action.payload,
          loading: false,
        };
      case 'LOGOUT':
        return {
          ...state,
          isAuthenticated: false,
          user: null,
          loading: false,
        };
      default:
        return state;
    }
  };
  
  export default authReducer;
  
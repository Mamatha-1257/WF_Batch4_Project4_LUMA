import { useState } from "react";
import { createContext } from "react";

const AuthContext = createContext({
  isAuthenticated: false,
  empId: null,
});

const AuthProvider = ({ children }) => {
  const [authState, setAuthState] = useState({
    isAuthenticated: false,
    empId: null,
  });

  const login = (empId) => {
    setAuthState({
      isAuthenticated: true,
      empId,
    });
  };

  const logout = () => {
    setAuthState({
      isAuthenticated: false,
      empId: null,
    });
  };

  return (
    <AuthContext.Provider value={{ authState, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export { AuthContext, AuthProvider };

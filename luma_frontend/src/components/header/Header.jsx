import React from "react";
import { Button } from "../button/Button";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";
import "./Header.css";

export const Header = () => {
  const navigate = useNavigate();
  const {
    authState: { isAuthenticated },
    logout,
  } = useContext(AuthContext);
  return (
    <header className="header">
      Loan User Management Application
      {isAuthenticated && (
        <Button className="logout-button" text="Logout" onClick={logout} />
      )}
    </header>
  );
};

import React from "react";
import { Button } from "../../components/button/Button";
import { useNavigate } from "react-router-dom";
import "./Dashboard.css";

export const Dashboard = () => {
  const navigate = useNavigate();

  return (
    <div className="dashboard">
      <h1>Loan Management Application</h1>
      <h2>User Dashboard</h2>
      <div className="CTA">
        <Button text="View Loans" onClick={() => navigate("/loans")}></Button>
        <Button
          text="Apply for Loan"
          onClick={() => navigate("/loan-application")}
        ></Button>
        <Button
          text="View Items Purchases"
          onClick={() => navigate("/items")}
        ></Button>
      </div>
    </div>
  );
};

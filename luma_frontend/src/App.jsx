import React from "react";
import { Router } from "./router/Router";
import { Alert } from "./components/alert/Alert";
import { useContext } from "react";
import { AlertContext } from "./context/AlertContext";
import { Header } from "./components/header/Header";

export const App = () => {
  const { showAlert } = useContext(AlertContext);

  return (
    <>
      <Header />
      {showAlert.showAlert && <Alert />}
      <Router />
    </>
  );
};

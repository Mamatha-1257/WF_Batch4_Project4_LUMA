import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Loginpage.css";

export const Loginpage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const navigate = useNavigate();

  const handleSubmit = (event) => {
    setErrorMessage(false);
    event.preventDefault();
    if (!username || !password) {
      setErrorMessage("Please enter valid details");
    }
    axios
      .post("http://localhost:8080/login", {
        employee_id: username,
        employee_password: password,
      })
      .then((response) => {
        if (response.data) {
          navigate("/dashboard");
        } else {
          setErrorMessage("Incorrect credentials");
        }
      });
  };

  return (
    <div className="login-page">
      <div className="form">
        <form className="login-form" onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="username"
            onChange={(e) => setUsername(e.target.value)}
            value={username}
          />
          <input
            type="password"
            placeholder="password"
            onChange={(e) => setPassword(e.target.value)}
            value={password}
          />
          <button>login</button>
        </form>
        {errorMessage && <p className="error">{errorMessage}</p>}
      </div>
    </div>
  );
};

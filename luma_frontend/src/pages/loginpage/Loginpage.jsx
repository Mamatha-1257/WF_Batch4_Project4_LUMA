import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import "./Loginpage.css";
import { AuthContext } from "../../context/AuthContext";

export const Loginpage = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const navigate = useNavigate();

  const { login } = useContext(AuthContext);

  const handleSubmit = (event) => {
    event.preventDefault();
    setErrorMessage("");
    if (!username || !password) {
      setErrorMessage("Please enter valid details");
      return;
    }
    axios
      .post("http://localhost:8080/login", {
        employee_id: username,
        employee_password: password,
      })
      .then((response) => {
        if (response.data) {
          login(username);
          navigate("/dashboard");
        } else {
          setErrorMessage("Incorrect credentials");
        }
      });
  };

  return (
    <div className="login-page">
      <div className="form">
        <h1>Login</h1>
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

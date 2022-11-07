import { Button } from "../../components/button/Button";
import { useNavigate } from "react-router-dom";
import "./Homepage.css";
export const Homepage = () => {
  const navigate = useNavigate();

  return (
    <main className="homepage">
      <h1>Welcome!</h1>
      <p>Purchase your favourite products in a hassle free way.</p>
      <Button
        text="Login"
        onClick={() => {
          navigate("/login");
        }}
      />
    </main>
  );
};

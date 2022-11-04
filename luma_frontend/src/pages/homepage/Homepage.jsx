import { Button } from "../../components/button/Button";
import "./Homepage.css";
export const Homepage = () => {
  return (
    <main className="homepage">
      <h1>Welcome!</h1>
      <p>Purchase your favourite products in a hassle free way.</p>
      <Button text="Login" />
    </main>
  );
};

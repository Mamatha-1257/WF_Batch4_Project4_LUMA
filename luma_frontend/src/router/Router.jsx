import { Routes, Route } from "react-router-dom";
import { Loginpage, Homepage } from "../pages";
export const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route path="/login" element={<Loginpage />} />
    </Routes>
  );
};

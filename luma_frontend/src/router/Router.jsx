import { Routes, Route } from "react-router-dom";
import {
  Loginpage,
  Homepage,
  LoanApplication,
  Dashboard,
  Loans,
  Items,
} from "../pages";
export const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route path="/login" element={<Loginpage />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/loan-application" element={<LoanApplication />} />
      <Route path="/loans" element={<Loans />} />
      <Route path="/items" element={<Items />} />
    </Routes>
  );
};

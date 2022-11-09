import { Routes, Route } from "react-router-dom";
import {
  Loginpage,
  Homepage,
  LoanApplication,
  Dashboard,
  Loans,
  Items,
} from "../pages";
import { AuthenticatedRoutes } from "../components/auth/AuthenticatedRoutes";
import { UnauthenticatedRoutes } from "../components/auth/UnauthenticatedRoutes";
export const Router = () => {
  return (
    <Routes>
      <Route path="/" element={<Homepage />} />
      <Route element={<UnauthenticatedRoutes />}>
        <Route path="/login" element={<Loginpage />} />
      </Route>
      <Route element={<AuthenticatedRoutes />}>
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/loan-application" element={<LoanApplication />} />
        <Route path="/loans" element={<Loans />} />
        <Route path="/items" element={<Items />} />
      </Route>
    </Routes>
  );
};

import { Outlet, Navigate, useLocation } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";
export const AuthenticatedRoutes = () => {
  const location = useLocation();
  const {
    authState: { isAuthenticated },
  } = useContext(AuthContext);
  return isAuthenticated ? (
    <Outlet />
  ) : (
    <Navigate to="/login" state={{ from: location }} replace />
  );
};

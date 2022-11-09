import { useLocation, Navigate, Outlet } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";

export const UnauthenticatedRoutes = () => {
  const location = useLocation();
  const {
    authState: { isAuthenticated },
  } = useContext(AuthContext);
  return (
    <div>
      {isAuthenticated ? (
        <Navigate
          to={location.state?.from?.pathname ?? "/"}
          state={{ from: location }}
          replace
        />
      ) : (
        <Outlet />
      )}
    </div>
  );
};

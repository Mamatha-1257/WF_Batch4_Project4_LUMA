import { useContext } from "react";
import { AlertContext } from "../../context/AlertContext";
import "./Alert.css";
export const Alert = () => {
  const {
    showAlert: { alertMessage, type },
  } = useContext(AlertContext);

  const alertClass = `alert-${type}`;

  return (
    <div className={`alert ${alertClass}`}>
      <span>
        {type === "danger" ? (
          <i className="fa-solid fa-diamond-exclamation"></i>
        ) : (
          <i className="fa-solid fa-check"></i>
        )}
      </span>
      <span>{alertMessage}</span>
    </div>
  );
};

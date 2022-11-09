import "./Loan.css";
import React, { useState, useContext, useEffect } from "react";
import axios from "axios";
import { AuthContext } from "../../context/AuthContext";
import { AlertContext } from "../../context/AlertContext.jsx";

export const Loans = () => {
  const {
    authState: { empId },
  } = useContext(AuthContext);

  const { setShowAlert } = useContext(AlertContext);

  const [data, setData] = useState([]);

  const fetchLoans = () => {
    axios
      .post("http://localhost:8080/loans", {
        employee_id: empId,
      })
      .then((response) => {
        if (response.status === 200) {
          setData(response.data);
        } else {
          setShowAlert({
            showAlert: true,
            alertMessage: "Error fetching details",
            type: "danger",
          });
        }
      });
  };

  useEffect(() => {
    fetchLoans();
    // eslint-disable-next-line
  }, []);

  return (
    <div className="loanapply">
      <div className="center1">
        <div>
          <h2 className="center1">Loan Cards Availed</h2>
          <div>
            <table className="showtable">
              <thead>
                <tr>
                  <th>Employee ID:</th>
                  <th>{empId}</th>
                </tr>
              </thead>
            </table>
          </div>

          <div className="table-wrapper">
            <table className="fl-table">
              <tbody>
                <tr>
                  <th>Loan Id</th>
                  <th>Loan type</th>
                  <th>Duration</th>
                </tr>

                {data.map((col) => (
                  <tr key={col}>
                    <td>{col["loan type"]}</td>
                    <td>{col["card issue date"]}</td>
                    <td>{col["Duration in years"]}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

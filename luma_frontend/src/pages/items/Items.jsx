import React, { useState, useContext, useEffect } from "react";
import axios from "axios";
import { AuthContext } from "../../context/AuthContext";
import { AlertContext } from "../../context/AlertContext.jsx";

export const Items = () => {
  const {
    authState: { empId },
  } = useContext(AuthContext);

  const { setShowAlert } = useContext(AlertContext);

  const [data, setData] = useState([]);

  const fetchItems = () => {
    axios
      .post("http://localhost:8080/items", {
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
    if (data.length === 0) {
      fetchItems();
    } // eslint-disable-next-line
  }, []);

  return (
    <div className="loanapply">
      <div className="center1">
        <div>
          <h2 className="center1">Items Purchased</h2>
          <div>
            <table className="showtable">
              <thead>
                <tr>
                  <th>Employee ID:</th>
                  <th>{empId}</th>
                </tr>
              </thead>
              <tbody>
                <tr></tr>
              </tbody>
            </table>
          </div>

          <div className="table-wrapper">
            <table className="fl-table">
              <tr>
                <th>Issue Id</th>
                <th>Item Description</th>
                <th>Item Category</th>
                <th>Item Make</th>
                <th>Item Valuation</th>
              </tr>
              {data.map((col) => (
                <tr key={col}>
                  <td>{col["issue_id"]}</td>
                  <td>{col["item_description"]}</td>
                  <td>{col["item_category"]}</td>
                  <td>{col["item_make"]}</td>
                  <td>{col["item_valuation"]}</td>
                </tr>
              ))}
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

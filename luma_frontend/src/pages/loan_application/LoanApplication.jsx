import React from "react";
import { Button } from "../../components/button/Button";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";
import "./LoanApplication.css";
import { useEffect } from "react";
import { useState } from "react";
import { AlertContext } from "../../context/AlertContext";
import axios from "axios";

export const LoanApplication = () => {
  const {
    authState: { empId },
  } = useContext(AuthContext);

  const { setShowAlert } = useContext(AlertContext);

  const [items, setItems] = useState(null);
  const [selectedItemCategory, setSelectedItemCategory] = useState("furniture");
  const [selectedItemDescription, setSelectedItemDescription] = useState("");
  const [selectedItemMake, setSelectedItemMake] = useState("");
  const [itemValuation, setItemValuation] = useState("");

  const navigate = useNavigate();

  const applyLoanSubmitHandler = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/applyloan", {
        employee_id: empId,
        item_category: selectedItemCategory,
        item_description: selectedItemDescription,
        item_valuation: itemValuation,
        item_make: selectedItemMake,
      })
      .then((response) => {
        if (response.status === 200) {
          setShowAlert({
            showAlert: true,
            alertMessage: "Loan processed successfully!",
            type: "success",
          });
          navigate("/dashboard");
        } else {
          setShowAlert({
            showAlert: true,
            alertMessage: "Error processing loan!",
            type: "danger",
          });
        }
      });
  };

  const findItemPrice = (e) => {
    e.preventDefault();
    setItemValuation(null);
    let flag = false;
    for (const currItem of items) {
      if (
        currItem["item_category"] === selectedItemCategory &&
        currItem["item_description"] === selectedItemDescription &&
        currItem["item_make"] === selectedItemMake
      ) {
        setItemValuation(currItem["item_valuation"]);
        flag = true;
      }
    }
    if (!flag) {
      setShowAlert({
        showAlert: true,
        alertMessage: "This product does not exist!",
        type: "danger",
      });
    }
  };

  const getItemData = () => {
    axios.get("http://localhost:8080/items").then((response) => {
      setItems(response?.data);
    });
  };

  useEffect(() => {
    if (!items) {
      getItemData();
    } // eslint-disable-next-line
  }, []);

  return (
    <div className="loan-page">
      <h1>Loan Management Application</h1>
      <h2>Select product and apply for loan</h2>
      <form className="loan-form">
        <div className="form-control">
          <label htmlFor="employeeId">Employee Id</label>
          <input name="employeeId" value={empId} readOnly />
        </div>
        <div className="form-control">
          <label htmlFor="itemCategory">Item Category</label>
          <select
            onChange={(event) => setSelectedItemCategory(event.target.value)}
            value={selectedItemCategory}
          >
            {[
              ...new Map(
                items?.map((item) => [item["item_category"], item])
              ).values(),
            ]?.map(({ item_category: itemCategory }, index) => {
              return (
                <option value={itemCategory} key={index}>
                  {itemCategory}
                </option>
              );
            })}
          </select>
        </div>
        <div className="form-control">
          <label htmlFor="employeeId">Item description</label>
          <input
            type="text"
            onChange={(e) => setSelectedItemDescription(e.target.value)}
            value={selectedItemDescription}
          />
        </div>
        <div className="form-control">
          <label htmlFor="employeeId">Item Make</label>
          <input
            type="text"
            onChange={(e) => setSelectedItemMake(e.target.value)}
            value={selectedItemMake}
          />
        </div>
        {itemValuation && (
          <div className="form-control highlight">
            <label htmlFor="employeeId">Item Value</label>
            <input readOnly value={itemValuation} />
          </div>
        )}
        <div className="loan-CTA">
          <Button text="Find Valuation" onClick={findItemPrice} />
          {itemValuation && (
            <Button text="Apply for Loan" onClick={applyLoanSubmitHandler} />
          )}
        </div>
      </form>
    </div>
  );
};

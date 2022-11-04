import { useState } from "react";
import axios from "axios";

export const useAxios = () => {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const apiCall = async (params) => {
    try {
      setLoading(true);
      setError(null);
      const response = await axios.request(params);
      setData(response?.data);
    } catch (error) {
      console.log(error);
      setError(error);
    } finally {
      setLoading(false);
    }
  };

  return { data, loading, error, apiCall };
};

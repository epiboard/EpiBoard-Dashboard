import axios from "axios";
import React, { useEffect, useState } from "react";
import Card from "../Card";

function Countries() {
  const [data, setData] = useState([]);
  const [capitalData, setCapitalData] = useState([]);
  const [selectedRadio, setSelectedRadio] = useState("");
  const radio = ["Africa", "America", "Asia", "Europe", "Oceania"];
  const [selectedWidget, setSelectedWidget] = useState("continent");
  const [capitalSearch, setCapitalSearch] = useState("");

  const handleForm = async () => {
    await axios({
      method: "post",
      url: `${process.env.REACT_APP_API_URL}country/capital`,
      withCredentials: true,
      data: {
        capital: capitalData,
      },
    })
      .then((res) => setCapitalData(res.data))
      .catch((err) => {
        return;
      });
  };

  useEffect(() => {
    axios.get("http://localhost:8080/country").then((res) => setData(res.data));
  }, []);

  useEffect(() => {
    if (selectedRadio) {
      axios({
        method: "post",
        url: `${process.env.REACT_APP_API_URL}country/region`,
        withCredentials: true,
        data: {
          region: selectedRadio,
        },
      }).then((res) => setData(res.data));
    }
  });

  return (
    <div className="countries">
      <ul className="radio-container">
        <select
          name="widget"
          id="widgetSelect"
          onChange={(e) => setSelectedWidget(e.target.value)}
        >
          <option value="continent" id="continent" defaultChecked>
            Continent
          </option>
          <option value="capital" id="capital">
            Capitale
          </option>
        </select>
        {selectedWidget === "continent" ? (
          <>
            {radio.map((continent) => (
              <li key={continent}>
                <input
                  type="radio"
                  id={continent}
                  key={continent}
                  name="continentRadio"
                  onChange={(e) => setSelectedRadio(e.target.id)}
                />
                <label htmlFor={continent}>{continent}</label>
              </li>
            ))}
          </>
        ) : (
          <>
            <form action="" onSubmit={handleForm}>
              <label htmlFor="capitalSearch">
                La capitale de quelle pays recherchez vous ?
              </label>
              <input
                name="capitalSearch"
                id="capitalSearch"
                value={capitalSearch}
                onChange={(e) => setCapitalSearch(e.target.value)}
              />
              <input type="submit" />
            </form>
          </>
        )}
      </ul>
      <ul>
        {selectedWidget === "continent" ? (
          <>
            {data.map((country, index) => (
              <Card key={index} country={country} />
            ))}
          </>
        ) : (
          <>
            {capitalData.map((country) => (
              <div>
                <li className="card">
                  <img
                    src={country.flags.svg}
                    alt={"drapeau" + country.translations.fra.common}
                  />
                  <div className="infos">
                    <h3>{country.translations.fra.common}</h3>
                    <h4>{country.capital}</h4>
                  </div>
                </li>
              </div>
            ))}
          </>
        )}
      </ul>
    </div>
  );
}

export default Countries;

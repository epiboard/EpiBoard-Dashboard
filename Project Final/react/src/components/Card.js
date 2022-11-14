import React from "react";

function Card({ country }) {
  return (
    <li className="card">
      <img
        src={country.flags.svg}
        alt={"drapeau" + country.translations.fra.common}
      />
      <div className="infos">
        <h3>{country.translations.fra.common}</h3>
        <h4>{country.capital}</h4>
        {/* <p>Pop {country.population.toLocaleString}</p> */}
      </div>
    </li>
  );
}

export default Card;

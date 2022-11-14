import React from "react";
import { NavLink } from "react-router-dom";

function NavBar() {
  return (
    <div className="navbar">
      <ul>
        <NavLink to="/">
          <li>Accueil</li>
        </NavLink>
        <NavLink to="/profil">
          <li>Profil</li>
        </NavLink>
        <NavLink to="/addWidget">
          <li>Ajoute tes Services</li>
        </NavLink>
      </ul>
    </div>
  );
}

export default NavBar;

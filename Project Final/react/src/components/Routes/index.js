import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "../../pages/Home";
import Profil from "../../pages/Profil";
import AddWidget from "../../pages/AddWidget";
import NavBar from "../Navbar";

const index = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profil" exact element={<Profil />} />
        <Route path="/addWidget" exact element={<AddWidget />} />
        {/* n'importe quelle url */}
        <Route path="*" element={<Home />} />
      </Routes>
    </Router>
  );
};

export default index;

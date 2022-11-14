import React, { useContext } from "react";
import { UidContext } from "../components/AppContext";
import Log from "../components/Log";
import NavBar from "../components/Navbar";

const Profil = () => {
  const uid = useContext(UidContext);

  return (
    <div className="profil-page">
      <NavBar />
      {uid ? (
        <h1>Page de profil</h1>
      ) : (
        <div className="log-container">
          <Log />
        </div>
      )}
    </div>
  );
};

export default Profil;

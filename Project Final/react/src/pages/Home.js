import React, { useState } from "react";
import NavBar from "../components/Navbar";
import Countries from "../components/Service/Countries";
import FreeDictionary from "../components/Service/FreeDictionary";
import Lol from "../components/Service/Lol";
import Raiderio from "../components/Service/Raiderio";

const Home = () => {
  const [main, setMain] = useState("");
  const services = ["lol", "wow", "steam", "flag"];

  const handlePosition = (e) => {
    console.log(e.target.className);
    setMain(e.target.className);
  };

  return (
    <>
      <NavBar />
      <br />
      <br />
      <div className="contentservice">
        <div className="sideservice">
          {services.includes("lol") ? (
            <div id="lol" className={main === "lol" ? "main" : "side"}>
              <h1>Lol</h1>
              <button className="lol" onClick={handlePosition}>
                Use
              </button>
            </div>
          ) : null}

          {services.includes("wow") ? (
            <div id="wow" className={main === "wow" ? "main" : "side"}>
              <h1>wow</h1>
              <button className="wow" onClick={handlePosition}>
                Use
              </button>
            </div>
          ) : null}

          {services.includes("steam") ? (
            <div id="steam" className={main === "steam" ? "main" : "side"}>
              <h1>steam</h1>
              <button className="steam" onClick={handlePosition}>
                Use
              </button>
            </div>
          ) : null}

          {services.includes("flag") ? (
            <div id="flag" className={main === "flag" ? "main" : "side"}>
              <h1>flag</h1>
              <button className="flag" onClick={handlePosition}>
                Use
              </button>
            </div>
          ) : null}
        </div>

        <div className="mainservice">
          <div className={main === "lol" ? "main" : "side"}>
            <Lol />
          </div>

          <div className={main === "wow" ? "main" : "side"}>
            <Raiderio />
          </div>

          <div className={main === "steam" ? "main" : "side"}>
            <FreeDictionary />
          </div>

          <div className={main === "flag" ? "main" : "side"}>
            <Countries />
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;

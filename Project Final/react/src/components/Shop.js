import React, { useState } from "react";

function Shop() {
  const [savedservice, setSavedservice] = useState(["Riot"]);
  const service = ["Riot", "Blizzard", "Steam", "Country"];
  const savedserviceInstance = savedservice;
  const handleAdd = (e) => {
    savedserviceInstance.push(e.target.className);
    setSavedservice(savedserviceInstance);
    console.log(savedservice);
  };

  return (
    <div id="service">
      {service.map((service) =>
        savedservice.includes(service) ? null : (
          <div className="service" id={service} key={service}>
            <h2>{service}</h2>
            <div className={"widget" + service}>
              <h4>widget1</h4>
              <h4>widget2</h4>
              <h4>widget3</h4>
              <h4>widget4</h4>
            </div>

            <button className={service} onClick={handleAdd}>
              AddWidget
            </button>
          </div>
        )
      )}
    </div>
  );
}

export default Shop;

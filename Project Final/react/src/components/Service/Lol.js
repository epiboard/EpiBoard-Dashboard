import axios from "axios";
import React, { useState } from "react";

function Lol() {
  const [widget, setWidget] = useState("");
  const [overviewInput, setOverviewInput] = useState("");
  const [overviewData, setOverviewData] = useState("");
  const [championsInput, setChampionsInput] = useState("");
  const [championsData, setChampionData] = useState("");
  const [rankedResumeData, setRankedResumeData] = useState("");

  const handleButton = (e) => {
    setWidget(e.target.id);
  };

  const handleOverviewForm = (e) => {
    axios
      .get("http://localhost:8080/riot/league/overview/" + overviewInput)
      .then((res) => setOverviewData(res.data))
      .catch((err) => {
        console.log(err);
      });
  };

  const handleChampionsForm = (e) => {
    axios
      .get("http://localhost:8080/riot/league/champions")
      .then((res) => setChampionData(res.data))
      .catch((err) => {
        console.log(err);
      });
  };

  const handleRankedResume = (e) => {
    axios
      .get("http://localhost:8080/riot/league/ranked/" + overviewInput)
      .then((res) => setRankedResumeData(res.data.data))
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="lolContainer">
      <div className="lolnav">
        <button
          id="overview"
          className={widget === "overview" ? "active" : null}
          onClick={handleButton}
        >
          overview
        </button>
        <button
          id="champions"
          className={widget === "champions" ? "active" : null}
          onClick={handleButton}
        >
          Champions
        </button>
        <button
          id="livegame"
          className={widget === "livegame" ? "active" : null}
          onClick={handleButton}
        >
          livegame
        </button>
      </div>

      <div className="lolContent">
        {widget === "overview" ? (
          <>
            <form action="">
              <input
                onChange={(e) => setOverviewInput(e.target.value)}
                value={overviewInput}
                placeholder="Search Summoner"
              />
              <input
                onClick={handleChampionsForm}
                onSubmit={handleOverviewForm}
              />
            </form>
            <div id="cardPlaceOverview">
              {overviewData.map((summoner) => (
                <div className="cardChampion">
                  <h2>Name : {summoner.name}</h2>
                  <h3>Level : {summoner.level}</h3>
                  <h3>Server : {summoner.platform}</h3>
                  <br />
                  <button id={overviewInput} onClick={handleRankedResume}>
                    Ranked Resume
                  </button>
                </div>
              ))}
            </div>
          </>
        ) : widget === "champions" ? (
          <>
            <form action="">
              <input
                onChange={(e) => setChampionsInput(e.target.value)}
                value={championsInput}
                placeholder="Search Champion"
              />
            </form>
            <div id="cardPlace">
              {championsData.map((champion) => (
                <div className="cardChampion">
                  <img src={champion.image["full"]} alt="aathrox"></img>
                  <h2>
                    Name : {champion.name} + {champion.title}
                  </h2>
                  <h3>Tags : {champion.tags[0]}</h3>
                  <p>Description : {champion.lore}</p>
                </div>
              ))}
            </div>
          </>
        ) : widget === "livegame" ? (
          <>
            <div id="cardPlace">
              <div className="cardChampion">
                <h2>name : {rankedResumeData.summonerName}</h2>
                <h3>Tier : {rankedResumeData.tier}</h3>
                <h3>Wins : {rankedResumeData.wins}</h3>
                <h3>losses : {rankedResumeData.losses}</h3>
              </div>
            </div>
          </>
        ) : null}
      </div>
    </div>
  );
}

export default Lol;

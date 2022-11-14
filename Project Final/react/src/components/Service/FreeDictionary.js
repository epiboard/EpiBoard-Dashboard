import React, { useState } from "react";
import axios from "axios";

function FreeDictionary() {
  const [word, setWord] = useState("");
  const [audio, setAudio] = useState("");
  const [definition, setDefinition] = useState("");
  const [openDefinition, setOpenDefinition] = useState(false);
  const handleDefinition = async () => {
    await axios({
      method: "post",
      url: `${process.env.REACT_APP_API_URL}/freedictionary/meaning`,
      withCredentials: true,
      data: {
        word,
      },
    })
      .then((res) => setDefinition(res.data))
      .catch((err) => {
        console.log(err);
      });
  };

  const handleForm = async () => {
    setOpenDefinition(false);
    await axios({
      method: "post",
      url: `${process.env.REACT_APP_API_URL}/freedictionary/phonetic`,
      withCredentials: true,
      data: {
        word,
      },
    })
      .then((res) => setAudio(res.data.audio))
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <div>
      <form action="" onSubmit={handleForm}>
        <input
          onChange={(e) => setWord(e.target.value)}
          value={word}
          placeholder="Translate your word"
        />
      </form>
      <div>
        <h2>{word} is pronounced</h2>
        <audio>{audio}</audio>
        <button onClick={handleDefinition}>definition</button>
      </div>
      {openDefinition ? (
        <div>
          {definition.definitions.map((child) =>
            child === "definition" ? (
              <>
                <p>{child}</p>
                <br />
              </>
            ) : null
          )}
        </div>
      ) : null}
    </div>
  );
}

export default FreeDictionary;

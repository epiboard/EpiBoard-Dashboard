import React, { useState } from "react";
import axios from "axios";
import SignInForm from "./SignInForm";

function SignUpForm() {
  const [formSubmit, setFormSubmit] = useState(false);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmedpassword, setConfirmedPassword] = useState("");

  const handleRegister = async (e) => {
    e.preventDefault();
    const emailError = document.querySelector(".email.error");
    const passwordError = document.querySelector(".password.error");
    const confirmedpassword = document.querySelector(
      ".confirmedpassword.error"
    );

    confirmedpassword.innerHTML = "";

    if (password !== confirmedpassword) {
      confirmedpassword.innerHTML = "Les mots de passes ne correspondent pas";
    } else {
      await axios({
        method: "post",
        url: `${process.env.REACT_APP_API_URL}api/user/signup`,
        withCredentials: true,
        data: {
          email,
          password,
        },
      })
        .then((res) => {
          if (res.data.errors) {
            emailError.innerHTML = res.data.errors.email;
            passwordError.innerHTML = res.data.errors.password;
          } else {
            setFormSubmit(true);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    }
  };

  return (
    <>
      {formSubmit ? (
        <>
          <SignInForm />
          <span></span>
          <h4 className="success">
            Enregistrement réussi, veuillez vous connecter
          </h4>
        </>
      ) : (
        <form action="" onSubmit={handleRegister} id="sign-up-form">
          <label htmlFor="email">Email</label>
          <br />
          <input
            type="text"
            name="email"
            id="email"
            onChange={(e) => setEmail(e.target.value)}
            value={email}
          />
          <div className="email error"></div>
          <br />
          <label htmlFor="password">Mot de Passe</label>
          <br />
          <input
            type="password"
            name="password"
            id="password"
            onChange={(e) => setPassword(e.target.value)}
            value={password}
          />
          <div className="password error"></div>
          <br />

          <label htmlFor="confirmedpassword">
            Confirmer votre Mot de Passe
          </label>
          <br />
          <input
            type="confirmedpassword"
            name="confirmedpassword"
            id="confirmedpassword"
            onChange={(e) => setConfirmedPassword(e.target.value)}
            value={confirmedpassword}
          />
          <div className="confirmedpassword error"></div>
          <br />

          <input type="submit" value="Se connecter" />
        </form>
      )}
    </>
  );
}

export default SignUpForm;

import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../services/api";
import "./LoginPage.css";

function LoginPage() {

  const navigate = useNavigate();

  // =========================
  // State
  // =========================

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);


  // =========================
  // Login Function
  // =========================

  const handleLogin = async (event) => {

    event.preventDefault();

    setError("");
    setLoading(true);

    try {

      // Send login details to Spring Boot
      const data = await loginUser({
        email: email,
        password: password,
      });

      console.log("Login successful:", data);


      // =========================
      // Store Login Information
      // =========================

      /*
        The exact response depends on your
        Spring Boot backend.

        Example response:

        {
          token: "...",
          user: {
            id: 1,
            name: "Harini",
            email: "harini@gmail.com"
          }
        }
      */

      if (data.token) {

        localStorage.setItem(
          "token",
          data.token
        );

      }

      if (data.user) {

        localStorage.setItem(
          "user",
          JSON.stringify(data.user)
        );

      }


      // =========================
      // Navigate After Login
      // =========================

      navigate("/home");

    } catch (error) {

      console.error(
        "Login failed:",
        error
      );


      // =========================
      // Error Handling
      // =========================

      if (error.response) {

        if (error.response.status === 401) {

          setError(
            "Invalid email or password."
          );

        } else if (error.response.status === 404) {

          setError(
            "User account not found."
          );

        } else {

          setError(
            "Something went wrong. Please try again."
          );

        }

      } else {

        setError(
          "Unable to connect to the server."
        );

      }

    } finally {

      setLoading(false);

    }
  };


  // =========================
  // JSX
  // =========================

  return (

    <div className="login-page">

      {/* =========================
          Login Card
      ========================== */}

      <div className="login-card">


        {/* =========================
            Header
        ========================== */}

        <div className="login-header">

          <Link
            to="/"
            className="login-logo"
          >
            Lendly
          </Link>


          <h1>
            Welcome Back
          </h1>


          <p>
            Login to continue using Lendly.
          </p>

        </div>


        {/* =========================
            Error Message
        ========================== */}

        {error && (

          <div className="login-error">
            {error}
          </div>

        )}


        {/* =========================
            Login Form
        ========================== */}

        <form
          className="login-form"
          onSubmit={handleLogin}
        >


          {/* =========================
              Email
          ========================== */}

          <div className="form-group">

            <label htmlFor="email">
              Email Address
            </label>


            <input
              id="email"
              type="email"
              placeholder="Enter your email"
              value={email}
              onChange={(event) =>
                setEmail(event.target.value)
              }
              required
            />

          </div>


          {/* =========================
              Password
          ========================== */}

          <div className="form-group">

            <div className="password-row">

              <label htmlFor="password">
                Password
              </label>


              <Link to="/forgot-password">
                Forgot Password?
              </Link>

            </div>


            <input
              id="password"
              type="password"
              placeholder="Enter your password"
              value={password}
              onChange={(event) =>
                setPassword(event.target.value)
              }
              required
            />

          </div>


          {/* =========================
              Login Button
          ========================== */}

          <button
            type="submit"
            className="login-button"
            disabled={loading}
          >

            {loading
              ? "Logging in..."
              : "Login"
            }

          </button>

        </form>


        {/* =========================
            Register
        ========================== */}

        <div className="register-section">

          <span>
            Don't have an account?
          </span>


          <Link to="/register">
            Create an account
          </Link>

        </div>


        {/* =========================
            Back to Landing Page
        ========================== */}

        <div className="back-home">

          <Link to="/">
            ← Back to Lendly
          </Link>

        </div>

      </div>

    </div>
  );
}

export default LoginPage;
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import LandingPage from "../pages/LandingPage";
import LoginPage from "../pages/LoginPage";
import RegisterPage from "../pages/RegisterPage";
import HomePage from "../pages/HomePage";

function AppRoutes() {
  return (
    <BrowserRouter>

      <Routes>

        {/* Landing Page */}
        <Route
          path="/"
          element={<LandingPage />}
        />

        {/* Login Page */}
        <Route
          path="/login"
          element={<LoginPage />}
        />

        {/* Register Page*/}
        <Route
          path="/register"
          element={<RegisterPage />}
        />

        {/* Home Page*/}
        <Route
          path="/home"
          element={<HomePage />}
        />

      </Routes>

    </BrowserRouter>
  );
}

export default AppRoutes;
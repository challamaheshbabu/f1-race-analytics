import { useEffect, useState } from "react";
import api from "./services/api";
import "./App.css";

export default function App() {
  const [summary, setSummary] = useState({});
  const [standings, setStandings] = useState([]);

  useEffect(() => {
    api.get("/dashboard/summary")
      .then(res => setSummary(res.data))
      .catch(err => console.log(err));

    api.get("/drivers/standings")
      .then(res => setStandings(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <div className="page">

      {/* NAVBAR */}
      <header className="navbar">
        <div className="logo">
          🏎 Formula 1 Dashboard
        </div>

        <nav>
          <a className="active">Home</a>
          <a>Features</a>
          <a>Standings</a>
          <a>About</a>
          <button>Dashboard</button>
        </nav>
      </header>

      {/* HERO */}
      <section className="hero">
        <div className="hero-content">

          <p className="tag">100% Free, No Login Required</p>

          <h1>Advanced F1 Dashboard Features</h1>

          <p className="sub">
            Explore real-time race data, technical insights, and analytics in one unified dashboard.
          </p>

          <button className="cta">Launch Dashboard →</button>

        </div>
      </section>

      {/* SUMMARY FROM API */}
      <section className="summary">

        <h2>Live Season Overview</h2>

        <div className="grid">

          <div className="card">
            🏎 Drivers
            <h3>{summary.totalDrivers ?? "-"}</h3>
          </div>

          <div className="card">
            🏁 Races
            <h3>{summary.totalRaces ?? "-"}</h3>
          </div>

          <div className="card">
            📊 Results
            <h3>{summary.totalResults ?? "-"}</h3>
          </div>

        </div>

      </section>

      {/* DRIVER STANDINGS FROM API */}
      <section className="features">

        <h2>Driver Standings</h2>

        <div className="standings">

          {standings.length === 0 ? (
            <p>Loading...</p>
          ) : (
            standings.map((d, i) => (
              <div className="row" key={i}>
                <span>{i + 1}</span>
                <span>{d.driver}</span>
                <span>{d.points} pts</span>
              </div>
            ))
          )}

        </div>

      </section>

    </div>
  );
}
import React from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './component/Dashboard';
import Header from './component/layout/Header';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AddProject from './component/project/AddProject';

function App() {
  return (
    <Router>    
      <Header />
      <Route exact path="/dashboard" component={ Dashboard }/>
      <Route exact path="/addProject" component={ AddProject }/>
    </Router>
  );
}

export default App;

import './App.css';
import 'react-toastify/dist/ReactToastify.css';
import Home from "./components/Home";
import Login from "./components/Login";
import Register from "./components/Register";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function App() {
  return (    
      <Router>
        <div className='App'>
          <Routes>
            <Route path="/" exact element={<Home />}/>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Routes>
        </div>
      </Router>
  );
}

export default App;

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css'
import { ComponentTest } from './pages/ComponentTest';

function App() {

  return (
      <>
        <BrowserRouter>
          <Routes>
            <Route path='/test' element={ <ComponentTest /> } />
          </Routes>
        </BrowserRouter>
      </>
  );
}

export default App;
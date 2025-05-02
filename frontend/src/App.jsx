import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import { SignInPage } from './pages/Signin';
import TestingPage from './pages/TestingPage';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/test' element={<TestingPage />} />
          <Route path='/signin' element={<SignInPage />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

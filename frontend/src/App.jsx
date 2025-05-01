import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css'
import { SignInPage } from './pages/Signin';
import { Home } from './pages/Home';
import { Signup } from './pages/Signup';

function App() {

  return (
      <>
        <BrowserRouter>
          <Routes>
            <Route path='/signin' element={<SignInPage />} />
            <Route path='/' element={<Home />}/>
            <Route path='/signup' element={<Signup />} />
          </Routes>
        </BrowserRouter>
      </>
  );
}

export default App;
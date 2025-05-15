import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { SignInPage } from './pages/SignInPage';
import { TestingPage } from './pages/TestingPage';
import { HomePage } from './pages/HomePage';
import { SignUpPage } from './pages/SignUpPage';
import { DashboardPage } from './pages/DashboardPage';


function App() {
  return (
      <>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={ <HomePage /> } />
            <Route path='/dashbord' element={ <DashboardPage/> } />
            <Route path='/signin' element={ <SignInPage /> } />
            <Route path='/signup' element={ <SignUpPage /> } />
            <Route path='/testing-page' element={ <TestingPage /> } />
          </Routes>
        </BrowserRouter>
      </>
  );
}

export default App;

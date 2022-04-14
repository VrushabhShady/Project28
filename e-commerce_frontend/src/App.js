import React, { useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import Products from './components/Products';
import About from './components/About';
import ContactUs from './components/ContactUs';
import Signin from './components/Signin';
import Signup from './components/Signup';
import Footer from './components/Footer';
import PageNotFound from './components/PageNotFound';
import ProductDetails from './components/ProductDetails';
import Category from './components/Category'
import Cart from './components/Cart';
import axios from 'axios';
function App() {
  // const [token, setToken]=useState();
  // if(!token){
  //   return (<>
  //    <Router>
  //       <Navbar />
  //       {<Routes>
  //         <Route exact path='/' element={<Home />} />
  //         <Route exact path='/signin' element={<Signin />} />
  //         <Route exact path='/signup' element={<Signup/>}/>
  //       </Routes>}
  //       </Router>

  //   </>)}
  // else
  const BaseUrl="http://localhost:8081/product"
    
  const [categories, setCategories]=useState([]);

   useEffect(()=>{
      axios.get(BaseUrl).then((response)=>{setCategories(response.data)});
      
    }, [])

  return (
    <>
      <Router>
        <Navbar />
        {<Routes>
          <Route exact path='/' element={<Home />} />
          {/* <Route exact path='/products' element={<Products />} /> */}
          <Route exact path='/category' element={<Category categories={categories} />} />
          <Route exact path='/about' element={<About />} />
          <Route exact path='/contact' element={<ContactUs />} />
          <Route exact path='/signin' element={<Signin />} />
          <Route exact path='/signup' element={<Signup />} />
          <Route exact path='/products/:id' element={<ProductDetails categories={categories}/>} />
          <Route exact path='/cart' element={<Cart/>} />
          <Route exact path='/cart/:id' element={<Cart/>} />
          <Route path='/*' element={<PageNotFound />} />
        </Routes>}
        <Footer />
      </Router>
      <></>
    </>
  );
}

export default App;

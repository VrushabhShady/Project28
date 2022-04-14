import React from 'react'
import { Link } from 'react-router-dom';
import '../css/Navbar.css'

const Navbar = () => {
    return (
        <>
            <div className="container-fluid topnav">
                <div className="row">
                    <div className='col-lg-3 col-sm-6 col-md-auto col1'>
                        <img src='/images/logo.png' width="150px" />
                    </div>
                    <div className='col-lg-9 col-sm-12 col-md-auto col2'>
                        <li><Link to="/" active>Home</Link></li>
                        {/* <li><Link to="/products">Products</Link></li> */}
                        <li><Link to="/category">Categories</Link></li>
                        <li><Link to="/about">About Us</Link></li>
                        <li><Link to="/contact">Contact Us</Link></li>
                        <li><Link to="/signin">Sign In</Link></li>
                        <li><Link to="/signup">Sign Up</Link></li>
                        <li><Link to="/cart">Cart</Link></li>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Navbar
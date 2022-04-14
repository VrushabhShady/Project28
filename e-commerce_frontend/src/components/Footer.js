import React from 'react'
import '../css/Footer.css';
import { Link } from 'react-router-dom';

const Footer = () => {
    return (
        <div className="container-fluid footer">
            <div className="row">
                <div className='footerdiv'>
                    <div className="col-lg-4 col-sm-12">
                        <img src="/images/logo.png" width="200px" height="80px" />
                        <p>Our Purpose is to improve and consolidate our position in the market for goods and services.</p>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <h3>Useful Links</h3>
                        <ul>
                            <li>Coupons</li>
                            <li><Link to="/contact">Contact Us</Link></li>
                            <li>Return Policy</li>
                            <li>Join Affiliate</li>
                        </ul>
                    </div>
                    <div className="col-lg-4 col-sm-6">
                        <h3>Follow Us</h3>
                        <ul>
                            <li><i className="fa fa-facebook" />&nbsp;&nbsp;Facebook</li>
                            <li><i className="fa fa-twitter" />&nbsp;&nbsp;Twitter</li>
                            <li><i className="fa fa-instagram" />&nbsp;&nbsp;Instagram</li>
                            <li><i className="fa fa-youtube" />&nbsp;&nbsp;Youtube</li>
                        </ul>
                    </div>
                </div>
                <br></br>
                <hr />
                <div className="copyright">
                    <p><i className="fas fa-copyright"></i>
                        Copyright 2020 - Group No 28</p>
                </div>
            </div>
        </div>
    )
}

export default Footer
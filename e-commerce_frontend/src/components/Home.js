import React from 'react'
import '../css/Home.css';
import { Link } from 'react-router-dom';
import Testimonial from './Testimonial';
import Offer from './Offer';

const Home = () => {
    return (
        <>
            <div className='container-fluid homediv'>
                <div className='row'>
                    <div className='col-lg-6 col-md-12 col-sm-12 div1'>
                        <h2>Everything you need available here.....<br></br>
                            Explore more!</h2>
                        <p>Success isn't always about greatness. It's about consistency. Consistent <br></br> hard work gains
                            success. Greatness will come.</p>
                        <Link to="/products" className="btn">Explore Now &#8594;</Link>
                    </div>
                    <div className='col-lg-6 col-md-12 col-sm-12 div2'>
                        <img src="/images/electronic-gadgets.png" />
                    </div>
                </div>
            </div>
            <Testimonial />
        </>
    )
}

export default Home
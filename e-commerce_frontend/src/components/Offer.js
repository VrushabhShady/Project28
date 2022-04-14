import React from 'react'
import '../css/Offer.css';
import { Link } from 'react-router-dom'

const Offer = () => {
    return (
        <div>
            <div class="offer">
                <div class="row">
                    <div class="col-2">
                        <img src="/images/exclusive.png" class="offer-img" width="300px" />
                    </div>
                    <div class="col-2">
                        <p>Exclusively Available on ShopCart</p>
                        <h1>Smart Band 4</h1>
                        <small>The Mi Smart Band 4 fearures a 39.9% larger (than Mi Band 3) <br></br> AMOLED color full-touch display
                            with adjustable brightness, so everything is clear as can be.<br></br></small>
                        <Link to="/" class="btn">Buy Now &#8594;</Link>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Offer
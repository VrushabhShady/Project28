import React from 'react'
import '../css/Testimonial.css';

const Testimonial = () => {
    return (
        <>
            <div className='container-fluid'>
                <div className='row testimonial'>
                    <div className='col-lg-4 col-md-6 col-sm-12 cardbox'>
                        <i className="fa fa-quote-left"></i>
                        <h6>A fantastic organisation! Great cutomer support from beginning to end of the process.
                            The team are really informed and go the extra mile at every stage. I would recommend them unreservedly.</h6>
                        <div className="rating">
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                        </div>
                        <img src="/images/user-1.png" />
                        <h5>Sean Parker</h5>
                    </div>
                    <div className='col-lg-4 col-md-6 col-sm-12 cardbox'>
                        <i className="fa fa-quote-left"></i>
                        <h6>A fantastic organisation! Great cutomer support from beginning to end of the process.
                            The team are really informed and go the extra mile at every stage. I would recommend them unreservedly.</h6>
                        <div className="rating">
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                        </div>
                        <img src="/images/user-2.png" />
                        <h5>Mike Smith</h5>
                    </div>
                    <div className='col-lg-4 col-md-12 align-center col-sm-12 cardbox'>
                        <i className="fa fa-quote-left"></i>
                        <h6>A fantastic organisation! Great cutomer support from beginning to end of the process.
                            The team are really informed and go the extra mile at every stage. I would recommend them unreservedly.</h6>
                        <div className="rating">
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                            <i className="fa fa-star"></i>
                        </div>
                        <img src="/images/user-3.png" />
                        <h5>Mabel Joe</h5>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Testimonial
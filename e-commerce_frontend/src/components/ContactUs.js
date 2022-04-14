import React, { useState } from 'react'

const ContactUs = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState('');

    return (
        <div className='container-fluid box'>
            <div className="card">
                <form>
                    <div className="text">
                        <h2>Welcome to ShopCart</h2>
                        <p>Please give your concern to us..</p>
                    </div>
                    <div className="input-text">
                        {/* <i class="fa fa-user"></i> */}
                        <input type="text" placeholder="Enter first name" name="firstName" id="firstName"
                            value={firstName} onChange={(e) => setFirstName(e.target.value)} />
                    </div>

                    <div className="input-text">
                        {/* <i class="fa fa-user"></i> */}
                        <input type="text" placeholder="Enter last name" name="lastName" id="lastName"
                            value={lastName} onChange={(e) => setLastName(e.target.value)} />
                    </div>

                    <div className="input-text">
                        {/* <i className="fa fa-envelope"></i> */}
                        <input type="email" placeholder="Enter email address" name="email" id="email"
                            value={email} onChange={(e) => setEmail(e.target.value)} />
                    </div>

                    <div className="input-text">
                        <textarea placeholder="Message" rows="5" cols="60" name="message" id="message"
                            value={message} onChange={(e) => setMessage(e.target.value)}></textarea>
                    </div>

                    <div className="buttons">
                        <button type="submit">Contact Us</button>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default ContactUs
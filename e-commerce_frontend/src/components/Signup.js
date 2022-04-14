import React, { useState } from 'react'
import '../css/Signup.css';
import { Link } from 'react-router-dom'
import userValidation from '../validations/UserValidation'
import registerUser from '../services/Register';

const Signup = () => {
    // const [firstName, setFirstName] = useState('');
    // const [lastName, setLastName] = useState('');
    // const [email, setEmail] = useState('');
    // const [password, setPassword] = useState('');
    // const [confirmpassword, setConfirmPassword] = useState('');
    // const [mobileNo, setMobileNo] = useState('');
    // const [address, setAddress] = useState('');
    const [user, setUser] = useState({
        "firstName": "",
        "lastName": "",
        "email": "",
        "password": "",
        "confirmpassword": "",
        "phone": "",
        "address": ""
    })

    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value })
    }

    const [errors, setErrors] = useState({})
    const [submitted, setSubmitted] = useState(false)

    const handleSubmit = (e) => {
        e.preventDefault()
        setErrors(userValidation(user))
        setSubmitted(true)
    }
    console.log(submitted)

    return (
        <div className='container-fluid box'>
            <div className="card">
                <form onSubmit={handleSubmit}>
                    <div className="text">
                        <h2>Welcome to ShopCart</h2>
                        <p>Please register yourself to enjoy shopping..</p>
                    </div>
                    <div>
                        <div className="input-text userNames">
                            {/* <i class="fa fa-user"></i> */}
                            <input type="text" placeholder="Enter first name" name="firstName" id="firstName"
                                value={user.firstName} onChange={handleInput} />
                            {errors.firstName && <small className="text-danger float-right">{errors.firstName}</small>}
                        </div>

                        <div className="input-text userNames">
                            {/* <i class="fa fa-user"></i> */}
                            <input type="text" placeholder="Enter last name" name="lastName" id="lastName"
                                value={user.lastName} onChange={handleInput} />
                            {errors.lastName && <small className="text-danger float-right">{errors.lastName}</small>}
                        </div>
                    </div>
                    <div className="input-text">
                        {/* <i className="fa fa-envelope"></i> */}
                        <input type="email" placeholder="Enter your email" name="email" id="email"
                            value={user.email} onChange={handleInput} />
                        {errors.email && <small className="text-danger float-right">{errors.email}</small>}
                    </div>

                    <div className="input-text">
                        {/* <i className="fa fa-lock"></i> */}
                        <input type="password" placeholder="Enter your password" name="password" id="password"
                            value={user.password} onChange={handleInput} />
                        {errors.password && <small className="text-danger float-right">{errors.password}</small>}
                    </div>
                    <div className="input-text">
                        {/* <i className="fa fa-lock"></i> */}
                        <input type="password" placeholder="Re-enter your password" name="confirmpassword" id="confirmpassword"
                            value={user.confirmpassword} onChange={handleInput} />
                        {errors.confirmpassword && <small className="text-danger float-right">{errors.confirmpassword}</small>}
                    </div>

                    <div className="input-text">
                        {/* <i className="fa fa-lock"></i> */}
                        <input type="tel" placeholder="Enter mobile no." name="phone" id="phone"
                            pattern="^\d{10}$"
                            value={user.phone} onChange={handleInput} />
                        {errors.phone && <small className="text-danger float-right">{errors.phone}</small>}
                    </div>

                    {/* <div className="input-text"> */}
                        {/* <i class="fa fa-address-card"></i> */}
                        {/* <input type="text" placeholder="Enter your address" name="address" id="address" */}
                            {/* value={user.address} onChange={handleInput} /> */}
                        {/* {errors.address && <small className="text-danger float-right">{errors.address}</small>} */}
                    {/* </div> */}

                    <div className="buttons">
                        <button type="submit" onClick={()=>registerUser(user)}>Sign up</button>
                    </div>
                    <br></br>
                    <p className="forgot-password text-right">
                        Already registered? <Link to="/signin">sign in</Link>
                    </p>
                </form>
            </div>
        </div>
    )
}

export default Signup

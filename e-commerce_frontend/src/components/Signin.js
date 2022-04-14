import React, { useState } from 'react'
//import { useDispatch } from "react-redux";
import { Link } from 'react-router-dom'
//import loginValidation from '../validations/LoginValidation'
import '../css/Signin.css';
import authenticateUser from '../services/Login'
//import storeUserDetails from '../services/Login'


const Signin = (props) => {
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const validateUser = () => {

        let user = {

            email: email,
            password: password

        };
        authenticateUser(user)
    }

        



        // // form submit
        // const submitHandler = (e) => {
        //     e.preventDefault();
        // }
        // const dispatch = useDispatch()

        // const [user, setUser] = useState({
        //     "email": "",
        //     "password": ""
        // })

        // const handleInput = (e) => {
        //     setUser({ ...user, [e.target.name]: e.target.value })
        // }
        //const [errors, setErrors] = useState({})
        // const [submitted, setSubmitted] = useState(false)
        // const handleSubmit = e => {
        //     e.preventDefault()
        //     setErrors(loginValidation(user))
        //     setSubmitted(true)
        // }
        return (
            <>
                <div className="container-fluid box">
                    <div className="card">
                        <div className="text">
                            <h2>Welcome Back</h2>
                            <p>Enter your credentials to access your account.</p>
                        </div>

                        <form onSubmit="">
                            <div className="input-text">
                                <i className="fa fa-envelope"></i>
                                <input type="email"
                                    placeholder="Enter your email"
                                    name="email" id="email"
                                    value={email}
                                    required
                                    onChange={(e) => setEmail(e.target.value)} />
                                {/* {errors.email && <small className="text-danger float-right">{errors.email}</small>} */}
                            </div>

                            <div className="input-text">
                                <i className="fa fa-lock"></i>
                                <input type="password"
                                    placeholder="Enter your password"
                                    name="password" id="password"
                                    required
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)} />
                                {/* {errors.password && <small className="text-danger float-right">{errors.password}</small>} */}
                            </div>

                            <div className="buttons">
                                <button type="submit" onClick={() => validateUser()}>Sign in</button>
                            </div>
                            <div className="forgot">
                                <p>Don't have an account? <Link to="/signup"> Register</Link></p>
                            </div>
                        </form>
                    </div>
                </div>
            </>
        )
    }


    export default Signin
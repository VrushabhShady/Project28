const userValidation = (values) => {
    let errors = {}
    if (!values.firstName) {
        errors.firstName = "First name is required"
    }
    if (!values.lastName) {
        errors.lastName = "Last name is required"
    }
    if (!/^[a-zA-Z]{0,30}$/.test(values.firstName)) {
        errors.firstName = "Name should contain alphabets only"
    }
    if (!/^[a-zA-Z]{0,30}$/.test(values.lastName)) {
        errors.lastName = "Name should contain alphabets only"
    }

    if (!values.email) {
        errors.email = "Email id is required"
    }
    if (!/^[a-z0-9._]+@[a-z0-9.]+\.[a-z]{2,5}$/.test(values.email)) {
        errors.email = "Invalid Email id"
    }

    if (!values.password) {
        errors.password = "Password is required"
    }
    else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$/.test(values.password)) {
        errors.password = "Minimum six characters, at least one letter and one number required"
    }

    if (!values.confirmpassword) {
        errors.confirmpassword = "Confirm password is required"
    }

    if (values.password && values.confirmpassword &&
        values.password !== values.confirmpassword) {
        errors.confirmpassword = "Password does not match"
    }

    if (!values.phone) {
        errors.phone = "Phone No. is required"
    }
    else if (values.phone.length !== 10) {
        errors.phone = "Invalid Phone No.(length should be 10 digits)"
    }
    return errors;
}
export default userValidation;
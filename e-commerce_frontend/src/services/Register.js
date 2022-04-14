import axios from "axios";


const user_base_url = "http://localhost:8081";



const registerUser= async (user)=> {
    try{
        const res= await axios.post(user_base_url+ '/signup', user)
           if(res.data === 'SUCCESS') 
             console.log("Sucess")
           else if(res.data === 'FAILURE') 
            console.log("Failure")
        } catch(err){
           console.error(err)
         }
    }

    export default registerUser

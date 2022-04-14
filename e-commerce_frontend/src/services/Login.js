import axios from "axios";
//import setToken from "../App"


const user_base_url = "http://localhost:8081";


const authenticateUser=async (user)=> {
        try {
    const res = await axios.post(user_base_url + '/signin', user);
    console.log("batao kuch",res.data.jwt)
    if (res.status === 'SUCCESS')
      console.log("Sucess");
     else if (res.status === 'FAILURE') 
      console.log("Failure");
  } catch (err) {
    console.error(err);
  }
  
    }

// const storeUserDetails=(userName, jwt)=>{
//   setupRequestInterceptor(jwt);
//   sessionStorage.setItem('user_dtls', userName);

// }

// const removeUserDetails=()=> {
//   console.log('rem user');
//   sessionStorage.removeItem('user_dtls');
// }

// const isUserLoggedIn=()=> {
//   console.log('chk user');
//   return sessionStorage.getItem('user_dtls') === null ? false : true;
// }

// const getUserName=()=> {
//   return sessionStorage.getItem('user_dtls');
// }

// const setupRequestInterceptor=(jwt)=>{
//   axios.interceptors.request.use((config)=>{
//     if(isUserLoggedIn()){
//       config.headers.authorization="Bearer"+jwt;
//     }
//     return config;
//   })
// }

//     export default {authenticateUser,storeUserDetails,removeUserDetails,isUserLoggedIn,getUserName,setupRequestInterceptor}

// export default {authenticateUser, storeUserDetails}
export default authenticateUser

import React from 'react'
//import Categories from './Categories';
import { useState , useEffect} from 'react';
import '../css/Category.css'
import { Link } from 'react-router-dom';
//import fetchProducts from '../services/topshopService';
import axios from 'axios';
import Top from '../services/topshopService';
import ProductDetails from './ProductDetails';
import UserContext from './UserContext';


export const Category = (props) => {
   

    // const BaseUrl="http://localhost:8081/product"
    
    // const [categories, setCategories]=useState([]);

    //  useEffect(()=>{
    //     axios.get(BaseUrl).then((response)=>{setCategories(response.data)});
        
    //   }, [])
      
    let [cart, setCart] = useState([])

   
    let localCart = localStorage.getItem("cart");
    
    const addItem = (item)  =>   {
      //create a copy of our cart state, avoid overwritting existing state
        let cartCopy = [...cart]; 
        
        //assuming we have an ID field in our item
        let {id} = item;
        
        //look for item in cart array
        let existingItem = cartCopy.find(cartItem => cartItem.id == id);
        
        
        //if item already exists
        if (existingItem) {
            existingItem.quantity += item.quantity
         //update item
        } else { //if item doesn't exist, simply add it
          cartCopy.push(item)
        }
        //update app state
        setCart(cartCopy)
        
        //make cart a string and store in local space
        let stringCart = JSON.stringify(cartCopy);
        localStorage.setItem("cart", stringCart)
    }
    
        
        //this is called on component mount
    useEffect(() => {
      //turn it into js
      localCart = JSON.parse(localCart);
      //load persisted cart into state if it exists
      if (localCart) setCart(localCart)
      
    }, []) //the empty array ensures useEffect only runs once

    const [data, setData] = useState(props.categories);
    const filterResult=(catItem)=>{
        const result=props.categories.filter((curData)=>{
            console.log(curData.imageName)
            return curData.categoryName===catItem;
        });
        setData(result);

    }
console.log(props.categories)


    // {
    //     "id": 1,
    //     "productName": "Lenevo IdeaPad Slim 3",
    //     "productManufacturer": "CDAC",
    //     "productDescription": "Laptop",
    //     "productPrice": 525499.0,
    //     "quantity": 5,
    //     "imageName": "/images/1.jpg/",
    //     "categoryName": "LAPTOP"
    // }
    
    return (
        <>

            <h1 className='text-center'>PRODUCTS</h1>
            <div className="container-fluid mx-2 ">
                <div className="row align-items-start" >
                    <div className="col-md-3">
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("LAPTOP")}>Laptop</button>
                        <button className="btn btn-warning  w-100 mb-3"onClick={()=>
                        filterResult("Mobiles")}>Mobiles</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Earphones")}>Earphones</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Toys")}>Toys</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Shoes")}>Shoes</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Skin Care")}>Skin Care</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Books")}>Books</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Clothes")}>Clothes</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        filterResult("Watches")}>Watches</button>
                        <button className="btn btn-warning w-100 mb-3"onClick={()=>
                        setData(props.categories)}>All</button>
                    </div>
                    <div className="col-md-9">
                        <div className="row">
                            {data.map((values)=>{
                                const{id,productName,productPrice,imageName,productDescription}=values;
                                return(
                                    <>
                                       <div className="col-md-4" key={id}>
                                <div className="card " >
                                    <img src={imageName} className="card-img-top" alt="..."/>
                                    <div className="card-body">
                                        <h5 className="card-title text-center col-md-7 col-{breakpoint}-auto">{productName}</h5>
                                        <p className="text-justify col-md-6  text-dark">{productPrice}</p>
                                        <p className="card-text">{productDescription}</p>
                                       
                                                    <Link to={`/products/${id}`} className="btn btn-dark text-center col-md-6">
                                                        Product Details
                                                         {/* <UserContext.Provider value={{
                                                             id:id,
                                                             productName: productName,
                                                    
                                                             productDescription: productDescription,
                                                             productPrice: productPrice,
                                                             
                                                             imageName: imageName
                                                             
                                                             }}>
                                                                 <ProductDetails/>
                                                                 </UserContext.Provider> */}
                                                    </Link>
                                                    <a href={`/cart/${id}`}>
                                                        <button onClick={() => addItem(values)}className="btn btn-dark text-center col-md-6">Buy Now</button>              </a>
                                                    <button onClick={() => addItem(values)}className="btn btn-dark text-center col-md-6">Add to Cart</button>
                                                </div>
                                    </div>
                                </div>
                            
                                    </>
                                )
                            })}
                         
                      
                        </div>
                    </div>
                </div>
            </div>


        </>
    )

}
export default Category;
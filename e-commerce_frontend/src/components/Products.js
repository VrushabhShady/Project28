import Items from "../data/Items"
import '../css/Products.css'
import { Link, Route } from "react-router-dom";
import { useEffect, useState } from "react";



const Products = () => {


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


    const itemsList = Items.map((data) =>
        <div className="col-lg-4 col-md-6 col-sm-12 card_block" key={data.id}>
            <img src={data.image} />
            <h4>{data.name}</h4>
            <h6>{data.currency}{data.cost}</h6>
            <h6>{data.descrption}</h6>
            <Link to={`/products/${data.id}`} >
           Product Details
             {/* Men's Shirt */}
             </Link>
             <a href={`/cart/${data.id}`} class="option2">
             <button  onClick={() => addItem(data)}>Buy Now</button>              </a>
             <button  onClick={() => addItem(data)}>Add to Cart</button>
        </div>
    )
    return (
        <div className="container-fluid product_body">
            <div className="row product_row">
                {itemsList}
            </div>
        </div>
    )
}

export default Products;
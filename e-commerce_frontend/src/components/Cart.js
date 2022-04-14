import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Items from "../data/Items";

const Cart=()=>{

    let [cart, setCart] = useState([])
    let localCart = localStorage.getItem("cart");
    console.log(localCart)
    //this is called on component mount
    let [counter, setCounter]=useState(1);
console.log(localCart)

    useEffect(() => {
        //turn it into js
        localCart = JSON.parse(localCart);
        //load persisted cart into state if it exists
        if (localCart) setCart(localCart)
        
      }, []) //the empty array ensures useEffect only runs once
  
    const removeItem = (itemID) => {//create cartCopy
        let cartCopy = [...cart]
        
        cartCopy = cartCopy.filter(item => item.id != itemID.id);
        
        //update state and local
       setCart(cartCopy)
        
        let cartString = JSON.stringify(cartCopy)
        localStorage.setItem('cart', cartString)
    }

    const incrQuan=()=>{
        setCounter(++counter);

    }
    const decrQuant=(el)=>{
        if(counter>0)
        setCounter(--counter)
        if(counter==0)
        removeItem(el)
        
    }
    const emptyCart=()=>{
        setCart([])
        localStorage.removeItem("cart");
    }
 

    

      const cartItems = cart.map((el) => (
          <table class="table table-hover">
        <tr>
        <td><img src={el.imageName} alt='' width="100"  height="100" /></td>
        <td>{el.productName}</td>
        
        <td>{el.categoryName}</td>
        <td>{el.price}</td>
        
        <td>
            <a className="btn btn-info text-success" onClick={()=>incrQuan()}>+</a>
            {counter}
            <a className="btn btn-info text-success" onClick={()=>decrQuant(el)}>-</a>

            <button className="btn btn-danger ml-2 text-danger" onClick={() => removeItem(el)}>Delete</button>
        </td>
    </tr>
    </table>
      ));


if (cart[0]!=null)
    return(<div className="container-fluid product_body">
    <div className="row product_row">
        <div className="col-md-6 card_block">{cartItems}</div>
        <div className="col-md-6">
            <a className="btn btn-info" href="">Checkout</a>
            <a className="btn btn-info" href="/category">Continue Shopping</a>
            <a className="btn btn-info" onClick={emptyCart}>Empty Cart</a>
            </div>
        
    </div>
    </div>)
    else
    return(
    <div>
        <h3>Oops! so much emptiness...looks like you need to shop</h3>
            <div className="col-lg-4 col-md-6 col-sm-12 card_block">
    <p>
    <a href="/category">Continue Shopping</a>
    </p>
    </div>
</div>)
}

export default Cart
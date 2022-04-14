import React from 'react'

const UserContext = React.createContext({
        id:null,
        productName: null,
        productManufacturer: null,
        productDescription: null,
        productPrice: null,
        quantity: null,
        imageName: null,
        categoryName: null
    }
)

export default UserContext
import { searchProducts } from "./products";


export function getProducts(){
    const data = searchProducts();
    data.then((d)=>{
        console.log(d[1]);
    }); 
}
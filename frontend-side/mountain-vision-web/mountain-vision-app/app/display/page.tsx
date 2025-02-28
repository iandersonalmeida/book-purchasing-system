
import Link from "next/link";
import { searchProducts } from "@/lib/products";
import { Suspense } from "react";
import { ProductDisplay } from "../ui/displays/product-display";

var text:string;

export function getProducts()
{
  setSearchString(text);
  const data =  searchProducts(text);
   return data;
}
 
 export function setSearchString(searchString:string){
  text = searchString;
 }

export default function Display()
  { 
    const data = getProducts()
    const books = data;
    console.log("From display: ",books);

  return(
    <>  
    <Link href="/">Go back home</Link>
      <Suspense fallback={<p>Loading products...</p>}>
       <div>
        <ProductDisplay books={books} />
       </div> 
      </Suspense>      
    </>        
    
    )

}
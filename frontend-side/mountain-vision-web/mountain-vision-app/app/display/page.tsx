
import Link from "next/link";
import { searchProducts } from "@/lib/products";
import { Suspense } from "react";
import { ProductDisplay } from "../ui/displays/product-display";
import { searchByAuthor } from "@/lib/searchByAuthor";

export function setSearchString(searchString:string){
  console.log("Search String from Display ",searchString);
}

export function getProducts()
{
  const data =  searchProducts();
   return data;
}


export default function Display()
  { 
    const data = getProducts()
    const books = data;
  

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
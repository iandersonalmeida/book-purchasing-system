'use client'

import { use } from "react"
export function ProductDisplay({
  products,
}:{
  products:Promise<any>
}
){
    const p = use(products);
   // const obj = JSON.parse(p);
   

    
    return(
        <>  {/* Using Fragment to group tags */}
        
        <h1>Product Display Page</h1>
        <div>
        <ul>
          {p.map((data:any)=>{
            return <li key={data.id}>{data}</li>
          })}
        </ul> 
        </div> 

        <div>
          
        </div>
                       
        </>
    )
}
'use client'

import { use } from "react"
export function ProductDisplay({
  books,
}:{
  books:Promise<any>
}
){
     const p = use(books);     
    
    return(
        <>          
        
        <h1>Product Display Page</h1>
        <br />
<div className="relative overflow-x-auto">
  <table className="w-100 text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
    <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
      <tr>
      <th className="px-6 py-3">
          Title
        </th>
        <th  className="px-6 py-3">
          Author
        </th>
        <th className="px-6 py-3">
          Price
        </th>
      </tr>
    </thead>
     
     <tbody> 
     {p.map((data:any)=>{
            return(
              <tr key={data.bookCode} className="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-grak-800 border-b dark:border-gray-700 border-gray-200">      
              <td className="px-6 py-4  font-bold text-black">
                 {data.title}
               </td>
               <td className="px-6 py-4 font-bold text-black">
                 {data.author}
               </td>
                 <td className="px-7 py-4 font-bold text-black">
                 {data.price}
               </td>  
             </tr>      
            )
          })}        
      </tbody>
  
  </table>
</div>

</>
    )
}
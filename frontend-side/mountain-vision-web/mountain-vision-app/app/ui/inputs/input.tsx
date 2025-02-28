'use client'
import { useState } from "react";
export function Input(){
    const[text, setText] = useState(''); 

    function handleChange(text:string){
        setText(text);         
      } 
    return(
        <input onChange={(e) => handleChange(e.target.value)} value={text} name='query' type="text" placeholder="Search your books..." 
        className='border-2 border-solid border-slate-800 rounded-lg w-72 h-10 placeholder:italic sm:text-sm' required />   
    )
}
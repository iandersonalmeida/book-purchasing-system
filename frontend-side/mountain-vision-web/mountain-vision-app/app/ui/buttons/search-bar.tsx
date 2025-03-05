
'use client'

import Link from "next/link";
import {getProducts, setSearchString } from "@/app/display/page";
import Form from 'next/form';
import { useState } from "react";

export function SearchBar(){

    const[text, setText] = useState('');   

    function handleChange(text:string){
        setText(text);            
      } 

          
    function handleClick(){
       let searchString = text;
        console.log("String assigned from SearchBar: " ,searchString);
        setSearchString(searchString);
        getProducts();
    }    

    return(
        <>  
        <Form action="/search">
        <input onChange={(e) => handleChange(e.target.value)} value={text} name='query' type="text" placeholder="Search your books..." 
        className='border-2 border-solid border-slate-800 rounded-lg w-72 h-10 placeholder:italic sm:text-sm' required />   
        <Link href='/display'>
        <button onClick={handleClick}  type="submit" className="rounded-lg border-2 border-slate-800 ml-2 w-24 h-10  hover:bg-slate-100">Search </button>
        </Link>
        </Form>
        </>
    )
}
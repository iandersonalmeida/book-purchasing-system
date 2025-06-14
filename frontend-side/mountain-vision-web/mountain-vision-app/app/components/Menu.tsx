"use client"

import Image from "next/image";
import Link from "next/link";
import { useState } from "react";
import SearchBar from "./SearchBar";
import LoginIcon from "./LoginIcon";

export default function Menu() {
    const[open, setOpen] = useState(false);
    return (
        <div>
            {/**Icon to open */}
            <div className="mr-10 lg:hidden">
                <Image 
                     src="/menu-burger.png" 
                     alt="" 
                     width={28} 
                     height={28} 
                     className="cursor-pointer hover:bg-blue-200" 
                     onClick={() => setOpen(true)}
                /> 
             
            </div>
              

                {/**Sliding menu */}    
                <div className={`fixed top-0 right-0 h-full w-70 z-50 shadow-lg transform transition-transform duration-300
                ${open ? "translate-x-0" : "translate-x-full"}`}
                >
                    {/**Close Icon and Searchbar */}
                    <div className="flex items-center bg-gray-300 w-72 h-[calc(10vh)]">

                        {/**Icon to close */}
                        <div className="flex justify-start p-5 items-start relative">
                            <Image 
                                src="/close.png" 
                                alt=""
                                width={28}
                                height={28}
                                onClick={()=> setOpen(false)}
                                className=" absolute cursor-pointer object-contain top-0 left-0 mt-2 ml-2"
                            />
                        </div>

                        {/**Search bar */}
                        <div className="">
                            <SearchBar/>
                        </div>

                    </div>                    

                    {/**Menu Links */} 
                    <div className="flex items-center p-4 ml-3 mt-7" > 
                        <div className="flex flex-col gap-6 font-bold">
                            <Link href="/" className="">Home</Link>
                            <Link href="/" className="">About</Link>
                            <Link href="/" className="">Categories</Link>
                            <Link href="/" className="">Contact</Link>
                        </div>
                    </div>
                    

                </div>
                {/**Icon to login */}
                <div className="hidden lg:block">
                    <LoginIcon/>
                </div>
        </div>
    );
}
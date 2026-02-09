"use client"

import Image from "next/image";
import Link from "next/link";
// buscar o efeito no click lento...

import { useState } from "react"

export default function MyAccount(){
    const[show, setShow] = useState(false);
    return(
        <div className="p-1" >My Account

            <div className="flex flex-col justify-center items-end">
                 {/* plus icon */}
            <div className=" ml-64 ">
                <Image 
                    src="/plus.png"
                    alt="plus"
                    width={22}
                    height={22}
                    className="cursor-pointer"
                    onClick={() =>setShow(true)}
                />
            </div>

            {/* sliding */}
            <div className={`transform transition-transform ${show ? "translate-y-0 duration-1000 ease-in-out" : "hidden"}`}>
                <Link
                 href="/login"   
                >
                    <h3 className="text-sm/10">Log in</h3>
                </Link>
                
                <Link
                href="/create-account"
                >
                    <h3 className="text-sm/10">Create account</h3>
                </Link>
                 

                {/* minus icon */}
                <div className=" ml-64">
                    <Image 
                        src="/minus.png"
                        alt="minus"
                        width={22}
                        height={22}
                        onClick={() => setShow(false)}
                        className="cursor-pointer"
                    />
                </div>
                
            </div>

            </div>

           

        </div>
    )
}
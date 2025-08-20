'use client'

import Image from "next/image";
import {useEffect, useState} from "react";
//Type definition
type ImageObject = {
    id:number;
    img:string
};

//Declare an array of images
const images:ImageObject[] = [
    {
        id: 1,
        img: "/img1.jpg"
    },
    {
        id: 2,
        img: "/img2.jpg"
    },
    {
        id: 3,
        img: "/img3.jpg"
    }    
];

//Create a component
export default function ImageSlider(){
    //State to define o index for each image
    const[index, setIndex] = useState(0);
    useEffect(
        () =>{
            const id = setInterval(() => {
                setIndex((i) => (i+1)%images.length);
            },5000);

            return () => clearInterval(id);
        },[images.length]);

    //Return images
    return(
        <>  
        <h1>Image Slider</h1>
         <div className="relative overflow-hidden rounded-xl">
             Container to hold images
             <p>Current index: {index}</p>

         </div>
        <Image 
        src="/img1.jpg"
        alt="image"
        width={450}
        height={450}
        />
               
        </>
    )
}
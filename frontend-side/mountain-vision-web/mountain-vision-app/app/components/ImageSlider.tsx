'use client'

import Image from "next/image";
import {useEffect, useState} from "react";
//Type definition
type ImageObject = {
    id:number;
    img:string;
    text:string | JSX.Element;
    color:string
};

//Declare an array of images
const images:ImageObject[] = [
    {
        id: 1,
        img: "/img1.jpg",
        text: '"Learning never exhausts the mind, it only ignites it." (Leonardo da Vinci)',
        color:"text-white"
    },
    {
        id: 2,
        img: "/img2.jpg",
        text: (
            <>
                "All truths are easy to understand<br/>once they are discovered;<br/>the point is to discover them." (Galileo Galile)
            </>
        ),
        color: "text-black"
    },
    {
        id: 3,
        img: "/img3.jpg",
          text: (
            <>
                "The important thing is not to stop questioning.<br/>Curiosity has its own reason for existing." (Albert Einstein)
            </>
        ),
        color: "text-gray-500"
    }    
];

/*
Create a component.
Since other functions will not be declared, this module just exports the ImageSlider function using 'export default'.
*/
export default function ImageSlider(){

      /*
      According to the idea of array destructuring, useState returns the initial value of a state variable
      and a function to update this value.

      A simple demonstration of this idea could be as follows:

       function useState(value){
       function updateValue(){
       return value+1;
     }
     return[value, updateValue];
      }

     const[x, setX] = useState(0);
     console.log(x); //x = 0
     z = setX(x);
     console.log(z); //z = 1
     
     The array on the right side of the last expression would represent the useState function,
     returning a variable and a function that sets the variable's new value.
     */
    const[index, setIndex] = useState(0);
    const[showText, setShowText] = useState(false);

     /*
     useEffect is a function that runs when the component mounts or is updated or removed from DOM.
     An Effect serves to connect an external system with the component.
     The useEffect function accepts a function that describes the effect to be performed and returns a cleanup function.
     */
    useEffect(
          /*
          arrow function which can also be called anonymous function evaluates an expression and returns the result.
          In this case, void is returned, meaning nothing is returned.
          */
        () =>{
            /*
            setInterval isn't part of React, so this function is considered an external system that must connect to the component
            when it appears on the screen. setInterval returns a Timeout object that is used to cancel the interval.
            */
            const id = setInterval(
                //Anonymous function called every three seconds.
                () => {
                //setIndex is called and updates the component's state, triggering a new render.
                setIndex((i) => (i+1)%images.length);
            },6000);
            /*
            The result of the anonymous function is void since clearInterval does not return anything,
            but just cancels what was established by setInterval.
            */
            return () => clearInterval(id);
        },[index]);

    //useEffect for managing the text    
    useEffect(
        () => {
            const id = setInterval(() => {
                setShowText(true);                                
            }, 5000);

            return () => clearInterval(id);

        }, [showText]);    



     /*
     The value of the expression returned by the ImageSlider function is a JavaScript object
     that acts as a container for other objects or children that are also created with React.createElement().
     */
    return(
          /*
          This div is a simple JavaScript object created by React.createElement()
          and becomes the object that should contain other objects or children also created with React.createElement().
          Just as a JavaScript function can only return multiple objects if placed inside an array,
          in the case of React, the function can only return multiple objects inside a container,
          which is represented here by this div.

          The Tailwind CSS:
          bg-sky-700 -> This is a class that sets the div's background to a darker shade of blue.

          flex -> This class defines the div as a flex container with one dimension for flex children.
          The default direction is horizontal which is also the main axis.

          items-center -> is a property that defines the position of items along the cross axis.
          Since the default direction of the flex property is horizontal, the items-center property is applied vertically.

          justify-center -> This property is applied along the main axis. The position of items can be set along the main axis.

          w-full -> Fills the entire width of the parent container's viewport.

          relative and absolute -> These properties indicate that an element that is defined as absolute
          should move relative to a parent container.

          transition-opacity and duration-100 -> Indicate the transition and duration of the animations.

          overflow -> Overflow content is clipped at the element's padding box.
                 */
        <div className="sm:flex items-center justify-center h-screen relative overflow-hidden ">

            {/*
            The map function takes an array of images and returns a new array of JSX nodes.
            Each node has a key that is represented by the id property.
            The image only becomes visible when the condition is true in ${currentIndex === index ? "opacity-100" : "opacity-0"}.
            */}
             {images.map((image, currentIndex) => (
                <div
                key={image.id}
                className={`absolute
                        transition-all duration-1000 w-full h-screen
                        ${currentIndex === index ? "opacity-100" : "opacity-0"}
                           `}
                           >
                           <Image
                             src={image.img}
                             alt={image.text}
                             fill
                             className="object-cover w-full sm:w-32 md:w-48 lg:w-64"
                             />
                            
                            <div className={`absolute ml-6 transform transition-all duration-1000 text-xl md:text-2xl 
                            md:font-semibold bottom-5 md:top-1/2 md:right-10 
                            ${image.color}    
                            ${showText && currentIndex === index
                                ? "translate-x-0 opacity-0=100" 
                                : "-translate-x-10 opacity-0"
                            } `}>
                                {image.text}
                            </div>                           
                                                         
                </div>
                       ))}
        </div>
    )
}
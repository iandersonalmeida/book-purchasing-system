// use client indicates that the component will run and be rendered on the client side.
'use client'

// import the predefined functions useState and useEffect
import {useState, useEffect} from 'react'

//Declare an array of objects
const slides = [
    { id: 1, color: "bg-red-500", text: "Slide 1" },
    { id: 2, color: "bg-green-500", text: "Slide 2" },
    { id: 3, color: "bg-blue-500", text: "Slide 3" },
];


//Since other functions will not be declared, this module just exports the LearningComponent function using 'export default'.
export  default  function LearningComponent (){

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
  console.log(x); x = 0
  z = setX(x);
  console.log(z); z = 1
  The array on the right side of the last expression would represent the useState function,
  returning a variable and a function that sets the variable's new value.
  */
    const [currentIndex, setCurrentIndex] = useState(0);

    /*
    useEffect is a function that runs when the component mounts or is updated or removed from DOM.
    An Effect serves to connect an external system with the component.
    The useEffect function accepts a function that describes the effect to be performed and returns a cleanup function.
    */
    useEffect(

        /*
        arrow function which can also be called anonymous function evaluates an expression and returns the result.
        arrow function, which can also be called an anonymous function, evaluates an expression and returns the result.
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
                //setCurrentIndex is called and updates the component's state, triggering a new render.
                setCurrentIndex((prevIndex) => (prevIndex + 1) % slides.length);
            },3000);
        /*
        The result of the anonymous function is void since clearInterval does not return anything,
        but just cancels what was established by setInterval.
        */
        return () => clearInterval(id);
    }, [currentIndex]);

    /*
   The value of the expression returned by the LearningComponent function is a JavaScript object
    that acts as a container for other objects or children that are also created with React.createElement().
     */
    return (
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
       <div className="bg-sky-700 flex items-center justify-center w-full h-64 relative overflow-hidden ">

               {/*
               The map function takes an array of slides and returns a new array of JSX nodes.
               Each node has a key that is represented by the id property.
               */}
               {slides.map((slide, index) => (
                   <div
                       key={slide.id}
                       className={` absolute
               text-white text-2xl w-full h-64 flex items-center justify-center
                transition-opacity duration-1000
                ${slide.color}
                ${index === currentIndex ? "opacity-100" : "opacity-0"}                
                   `}
                   >
                       {slide.text}
                   </div>

               ))}
       </div>
    );
}
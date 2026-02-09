import Image from "next/image";

export default function ResponsiveComponent(){
    return(
    
        /*
        This container is set with gray background color and padding with 12px.
        By default, this element is displayed in a block box, generating a line break, 
        where the next elements are placed below. It acts as a container.
        */
        <div className="bg-gray-500 p-3">

            {/*  
            This element has a green background. It acts as a container. 
            It has a 16px padding and becomes a flex container on medium screens, 
            that is, the largest at 768px.
             */}
            <div className="bg-green-600 p-4 md:flex">

                {/*
                This container is a flex item with a blue background, 
                12px padding, 384px width, 12px border-radius,
                and on medium screens, that is, with a width equal to or greater than 768px, 
                the container does not shrink.
                 */}  
                <div className="bg-blue-500 p-3 w-96 rounded-xl md:shrink-0">

                    {/* 
                    This is a Next.js component that references the <img> element. This component has some attributes, such as:
                    className - allows you to style the component using Tailwind classes.
                    src: access to the image location.
                    alt - a name for the image in case the image doesn't appear.
                    width and height - required attributes, since every object has a size.

                    In the className attribute, the classes used are:
                    object-cover - indicates a property that resizes the src content to fill its container, that is, 
                    the image container, not the div containing the image. 
                    All HTML elements such as div, p, and img 
                    exist as boxes created by CSS and can be resized. 
                    The image's content area is defined by the width and height properties, 
                    which the browser uses to reserve space for the image.

                    */}
                    <Image 
                        className="bg-amber-500 object-cover w-48 md:w-96 md:h-52 md:p-1 lg:bg-amber-700" 
                        src="/img1.jpg"
                        alt="img1"
                        width={400}
                        height={400}
                    />
                </div>
            <div className="bg-red-500 p-1 md:h-32 md:italic lg:font-serif overflow-hidden">
                <p className="text-white md:text-gray-700 lg:bg-purple-500 lg:text-black">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eget nunc ullamcorper, pulvinar leo quis, tincidunt tellus. 
                    Morbi eu porttitor nisi. Ut feugiat vehicula elit, non aliquam ipsum. Praesent eu feugiat dolor.</p>
            </div>

            </div>
           
            
        </div>
    )
}
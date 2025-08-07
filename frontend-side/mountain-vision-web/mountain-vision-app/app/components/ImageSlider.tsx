import Image from "next/image";
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

    //Return images
    return(
        <>  
        <h1>Image Slider</h1>
        <Image 
        src="/img1.jpg"
        alt="image"
        width={450}
        height={450}
        />
               
        </>
    )
}
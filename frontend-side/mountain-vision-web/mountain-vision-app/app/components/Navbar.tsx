import Link from "next/link";
import Image from "next/image";
import Menu from "./Menu";
import SearchBar from "./SearchBar";
import RightIcons from "./RightIcons";
import CartIcon from "./CartIcon";

export default function Navbar() {
    return (
        <div className="bg-gray-100 h-20 flex items-center justify-between">

              {/**LEFT SIDE..................................................................... */}
          
              {/**Mobile Screens ........................................................*/}
              <div className="h-full ml-3 flex items-center justify-between">

                <Link href="/" className="text-black font-bold text-xl tracking-wide flex items-center gap-3">
                <Image src="/mountains.png" alt="" width={22} height={22}/>                
                 Mountain Vision
                </Link> 
             
              </div>   
              {/**End of Mobile Screens ........................................................*/}  


              {/**Bigger Screens............................................................... */}
              <div className="hidden lg:block justify-center ">
                <div className="font-bold flex gap-12">
                  <Link href="/" className=" hover:bg-blue-200">Home</Link>
                  <Link href="/">About</Link>
                  <Link href="/">Categories</Link>
                  <Link href="/">Contact</Link>
                </div>
              </div>
               {/**End of Bigger Screens ........................................................*/}  


               {/**END OF LEFT SIDE..................................................................... */}

           
               {/**RIGHT SIDE..................................................................... */}
               <div className="flex justify-between gap-9">
               
                  <div className="">
                    <CartIcon/>
                  </div>

                  <div className="">
                    <Menu />
                  </div>

              </div>
               {/**END OF RIGHT SIDE..................................................................... */}

        </div>
    );
}
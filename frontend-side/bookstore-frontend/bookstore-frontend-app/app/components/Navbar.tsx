import Link from "next/link";
import Image from "next/image";
import Menu from "./Menu";
import CartIcon from "./CartIcon";
import SearchBarIcon from "./SearchBarIcon";

export default function Navbar() {
    return (
        <div className="bg-gray-100 h-20 flex items-center justify-between">

              {/**LEFT SIDE..................................................................... */}
          
              {/**Mobile Screens ........................................................*/}
              <div className="h-full ml-3 flex items-center justify-between">

                <Link href="/" className="text-black font-bold text-xl tracking-wide flex items-center gap-3">
                <Image src="/bookslogo.png" alt="" width={22} height={22}/>                
                  Bookstore Website Demo
                </Link> 
             
              </div>   
              {/**End of Mobile Screens ........................................................*/}  


              {/**Bigger Screens............................................................... */}
              <div className="relative hidden lg:block justify-center items-center ">
                <div className="absolute font-bold flex gap-12 -ml-60">
                  <Link href="/" className=" hover:bg-blue-200">Home</Link>
                  <Link href="/about" className="hover:bg-blue-200">About</Link>
                  <Link href="/" className="hover:bg-blue-200">Categories</Link>
                  <Link href="/contact" className="hover:bg-blue-200">Contact</Link>
                </div>
              </div>
               {/**End of Bigger Screens ........................................................*/}  


               {/**END OF LEFT SIDE..................................................................... */}

           
               {/**RIGHT SIDE..................................................................... */}
               <div className="flex justify-between gap-8">

                 <div className="hidden lg:flex">
                    <SearchBarIcon />
                  </div>
               
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
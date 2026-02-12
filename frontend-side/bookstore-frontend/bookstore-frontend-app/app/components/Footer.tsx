import Link from "next/link";
export default function Footer() {
    return (
        <div className=" bg-gray-200 h-1/2 p-4 ">
           
            <div className="">
                <h1 className="font-bold text-xl tracking-wide">Bookstore Website Demo</h1>

                <p className="mt-5">Duis autem vel eum iriure dolor 
                    in hendrerit in vulputate velit esse molestie consequat, 
                    vel illum dolore eu feugiat nulla facilisis.
                </p>

                <p className="mt-4 text-sm">
                    1234 Elm Street, Suite 567 
                    Altenkirchen, Westerwald, 57610
                    Germany                                        
                </p>

                <p className="mt-4 text-sm">
                    Phone: +49 123 456 789
                </p>

                <p className=" mt-4 text-sm">
                    Email: info@bookstorewebsitedemo.com
                </p>
            </div>

            <div className="bg-amber-100">
                <h1 className="mt-10 font-bold">Opening Hours</h1>
                <p className="mt-5"> Mon – Fri: 8:00 AM – 10:00 PM</p>
                <p className="mt-2">Sat: 9:00 AM – 8:00 PM</p>
                <p className="mt-2">Sun: Closed</p>
            </div>
                
            <div className="bg-blue-100">
                <h1 className="mt-10 font-bold">Quick Links</h1>
                <div className="flex flex-col ">
                    <Link href="/" className="mt-2">Home</Link>
                    <Link href="/about" className="mt-2">About</Link>
                    <Link href="/" className="mt-2">Categories</Link>
                    <Link href="/contact" className="mt-2">Contact</Link>                     
                </div>   
            </div>
               
                
                <div className="mt-6 border-t-2 border-gray-300">
                    <p><Link href="/" className="font-bold">Bookstore Website Demo</Link></p>
                    <p>All rights reserved.</p>
                </div>   

        </div>
    );
}
import Link from "next/link";
import Image from "next/image";
export default function CartIcon() {
    return (
        <div>
              <Link href="/cart" className="group relative">
              <Image 
                src="/shopping-bag.png" 
                alt="" 
                width={25} 
                height={25} 
                className="cursor-pointer group-hover:bg-blue-200 rounded-md"/>       
                <span className="absolute -top-2 text-black -right-4 font-sans text-lg font-light w-5 h-5 flex items-center justify-center">0</span>        
            </Link>
        </div>
    );
}
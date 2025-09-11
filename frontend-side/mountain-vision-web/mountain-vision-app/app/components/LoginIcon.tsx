import Link from "next/link";
import Image from "next/image";
export default function LoginIcon() {
    return (
        <div>
              <Link href="/login" className="group relative">
              <Image 
                src="/login2.png" 
                alt="" 
                width={25} 
                height={25} 
                className="cursor-pointer group-hover:bg-blue-200 rounded-md mr-2"/>
                <span className="absolute -top-2 text-black -right-4 font-sans text-lg font-light  h-5 flex items-center justify-center"></span>
            </Link>
        </div>
    );
}
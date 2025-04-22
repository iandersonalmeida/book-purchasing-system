import Link from "next/link";
import Image from "next/image";

export default function LoginIcon() {
    return (
        <div>
           <Link href="/">
              <Image src="/login.png" alt="" width={25} height={25} className="cursor-pointer"/>
           </Link> 
        </div>
    );
}
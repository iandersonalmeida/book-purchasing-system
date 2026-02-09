"use client"

import Image from "next/image";
import { useRouter } from "next/navigation";

export default function SearchBar() {
    const router = useRouter();

    const handleSearch = (e:React.FormEvent<HTMLFormElement>) =>{
        e.preventDefault();
        const formData = new FormData(e.currentTarget);
        const name = formData.get("name") as string;
        if(name){
            router.push(`/list?name=${name}`);
        }
    }

    return (    
        <form action="" className="flex justify-between gap-4 bg-gray-200 p-2 rounded-md flex-1">
            <input type="text" name="name" placeholder="search your book" className="flex-1 bg-transparent outline-none"/>
            <button className="cursor-pointer">
                <Image src="/search.png" alt="" width={17} height={17} />
            </button>
        </form>
    );
}
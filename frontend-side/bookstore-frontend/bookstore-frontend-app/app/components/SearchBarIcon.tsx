import Image from "next/image";

export default function SearchBarIcon(){
    return (
        <div className="">
            <button className="cursor-pointer">
                <Image 
                    src="/search.png" 
                    alt="" 
                    width={17} 
                    height={17}
                />
            </button>
        </div>
    )
}
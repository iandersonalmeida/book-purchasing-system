import Link from 'next/link'
import { SearchBar } from './ui/buttons/search-bar';
import { LoginButton } from './ui/buttons/login-button';
import { Input } from './ui/inputs/input';


export default function Home() {
  return (
    <div>

      <h1 className="text-2xl text-blue-600 ml-2 "></h1> 

      <div className="-translate-y-7 flex justify-end mr-2"> 
        <Link href="/login">
    
        </Link>
      </div> 

      <div className='flex justify-center mt-52'>
        
      </div> 

     
    </div>
  );
}

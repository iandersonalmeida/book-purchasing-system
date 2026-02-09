import Image from "next/image";
import Link from "next/link";
import SearchBar from "./SearchBar";
import CartIcon from "./CartIcon";
import LoginIcon from "./LoginIcon";
import Menu from "./Menu";

export default function RightIcons() {
    return (
        <div className="">
          <SearchBar/>
          <CartIcon/>
          <LoginIcon/>
          <Menu/>                   
        </div>
    );
}
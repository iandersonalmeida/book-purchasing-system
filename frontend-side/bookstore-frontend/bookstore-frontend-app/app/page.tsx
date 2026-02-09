'use client'

import Link from 'next/link'
import { SearchBar } from './ui/buttons/search-bar';
import { LoginButton } from './ui/buttons/login-button';
import { Input } from './ui/inputs/input';
import { useState, useEffect } from 'react';
import Navbar from './components/Navbar';
import ImageSlider from './components/ImageSlider';
import Footer from './components/Footer';


export default function Home() {

  return (
    <div>
       <Navbar/>
       <ImageSlider />
       <Footer />
    </div> 
  );
}

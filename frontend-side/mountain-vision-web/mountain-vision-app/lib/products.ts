"use server"
import { promises as fs } from "fs";


export async  function searchProducts(){ 

// Local file system
//const data = await fs.readFile(process.cwd() + '/app/test.json','utf8');
//const products =  await JSON.parse(data);

//-----------------------------------------------------------------------------------------
//Backend
//const data = await fetch(`http://localhost:2141/bookservice/api/v1/books/${text}`);
const data = await fetch(`http://localhost:2141/bookservice/api/v1/books`);
const books = await data.json();

//--------------------------------------------------------------
//External API
// const uri = "https://raw.githubusercontent.com/iandersonalmeida/json-data/refs/heads/main/test.json";
//const data = await  fetch(uri);
//const products = await data.json();
//const products = JSON.stringify(productData);
    return books;
}
export async function searchByAuthor(author:string){
    const data = await fetch(`http://localhost:2141/bookservice/api/v1/books/${author}`);
    const books = await data.json();
    return books;
}


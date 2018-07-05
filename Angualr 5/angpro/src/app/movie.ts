export class Movie{
    public id:string;
    public movieName:string;
    public year:number;
    public rating:number;
    

    constructor(id,movieName,year,rating){
        this.movieName=movieName;
        this.year=year;
        this.id=id;
        this.rating=rating;
    }
}
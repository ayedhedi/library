
export class Book {
    id: string;
    title: string;
    author: string;
    year: number;

    constructor(json: any) {
      this.id = json['_id'];
      this.title = json['title'];
      this.author = json['author'];
      this.year = parseInt(json['year']);
    }
}

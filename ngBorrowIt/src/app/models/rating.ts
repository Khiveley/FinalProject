export class Rating {
id: number;
rating: number;
ratingComment: string;

constructor(id: number = 0,
  rating: number = 0,
  ratingComment: string = '') {
  this.id = id;
  this.rating = rating;
  this.ratingComment = ratingComment;
}

}

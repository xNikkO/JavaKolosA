import { MovieSummary} from "./movie-summary";

export class Movie extends MovieSummary{
  adult:boolean;
  budget:number;
  overview: string;
  releaseDate: Date;
  runtime: number;
  languageId:number;
}

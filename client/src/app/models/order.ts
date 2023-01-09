import { Article } from './article';
export interface Order {
    
    reference: string,
    date: string,
    articles: Article[];
}

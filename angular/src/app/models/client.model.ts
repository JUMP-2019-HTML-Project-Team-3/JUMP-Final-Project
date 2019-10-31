import { Address } from "./address.model";

export class Client {
    constructor (
        public id?: number,
        public imagePath?: string,
        public name?: string,
        public phone?: string,
        public description?: string,
        public address?: Address
    ) {}
}
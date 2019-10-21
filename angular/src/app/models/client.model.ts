import { Address } from "./address.model";

export class Client {
    constructor (
        private id?: number,
        private imagePath?: string,
        private name?: string,
        private phone?: string,
        private description?: string,
        private address?: Address
    ) {}
}
import { User } from "~/types/User"
import { Book } from "~/types/book"

export interface List {
  id?: number
  userId?: number
  user?: User
  bookId?: number
  book?: Book
  startDate?: Date
  endDate?: Date
  actualReturnDate?: Date
}

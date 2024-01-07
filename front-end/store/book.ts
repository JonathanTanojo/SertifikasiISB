import { Action, Module, Mutation, MutationAction, VuexModule } from 'vuex-module-decorators'
import { Book } from '~/types/book'
import { $axios } from '~/utils/api'

@Module({
  name: 'book',
  stateFactory: true,
  namespaced: true,
})
export default class BookModule extends VuexModule {
  books: Array<Book> = []
  book: Book = {}

  @Mutation
  setBook(book: Book) {
    this.book = book
  }

  @MutationAction
  async fetchBook() {
    const { data } = await $axios.get('/api/books')
    return { books: data.data }
  }

  // @MutationAction
  // async fetchBookById(book: any) {
  //   const { data } = await $axios.get(`/api/books/${book.id}`)
  //   return { book: data.data }
  // }

  @MutationAction
  async updateBook(book : any) {
    await $axios.put(`/api/books/${book.id}`, book)
    const { data } = await $axios.get('/api/books')
    return { books: data.data }
  }
}

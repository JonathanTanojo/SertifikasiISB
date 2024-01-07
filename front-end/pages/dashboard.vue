<script lang="ts">
import { Component, getModule, Vue } from 'nuxt-property-decorator'
import BookModule from '~/store/book';
import ListModule from '~/store/list';
import BorrowModal from '~/components/BorrowModal.vue'
import { Book } from '~/types/book';
import { List } from '~/types/list';

@Component({
  components: {
    BorrowModal
  },
  methods: {  },
})
export default class IndexPage extends Vue {
  books: Array<Book> = []
  book: Book = {}

  lists: Array<List> = []
  list: List = {}
  listNew: List = {}

  isBorrowModalShow: boolean = false
  isReturnBook: boolean = true

  BorrowModalShow(book: any) {
    this.book = book
    this.isBorrowModalShow = !this.isBorrowModalShow
  }

  async fetch() {
    try {
      const BookModuleInstance = getModule(BookModule, this.$store)
      await BookModuleInstance.fetchBook()
      this.books = BookModuleInstance.books
    } catch (e) {
    }
  }

  async returnBook(bookId: any){
    const BookModuleInstance = getModule(BookModule, this.$store)
    await BookModuleInstance.updateBook(bookId)
    .then(() => {
      window.location.reload()
    })
    .catch(() => {

    })

  }
}
</script>

<template>
  <div class="">
    <div>
      <b-navbar toggleable="lg" style="padding: 1rem 4rem; background-color: #0066CC;">
        <b-navbar-brand href="#" style="color: white;">ISB</b-navbar-brand>
        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav class="ml-auto navigation-bar">
            <b-navbar-nav>
              <b-nav-item href="/" class="nav-text">Home</b-nav-item>
              <b-nav-item href="#" class="nav-text">Dashboard</b-nav-item>
            </b-navbar-nav>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <div class="container-fluid">
      <div class="dashboard-wrapper">
        <div v-if="$fetchState.pending" class="loading-screen">
          <div class="loader"></div>
        </div>
        <div class="history">
          <button type="button" class="btn btn-link"><a href="history">History</a></button>
        </div>
        <div class="col-12 catalog">
          <div>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Book Name</th>
                  <th scope="col">Borrowed</th>
                  <th scope="col">Return</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(book, idx) in books">
                  <th scope="row">{{ book.id }}</th>
                  <td>{{ book.bookName }}</td>
                  <td> {{ book.bookBorrowed === 0 ? "No" : "Yes"  }}</td>
                  <td> <button type="button"
                    :disabled="book.bookBorrowed === 0"
                    class="btn btn-primary"
                    @click="BorrowModalShow(book)"
                    >Return Book</button></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <BorrowModal
      v-if="isBorrowModalShow"
      :book="book"
      :returnBook="isReturnBook"
      @confirm="returnBook(book)"
      @close-modal="isBorrowModalShow = false"
    />
  </div>
</template>

<style lang="css" scoped></style>

<style>
.table .table-hover .btn{
  font-family: Roboto, sans-serif;
  font-weight: 0;
  font-size: 14px;
  color: #fff;
  background-color: #0066CC;
  padding: 10px 30px;
  border: solid #0066cc 2px;
  box-shadow: rgb(0, 0, 0) 0px 0px 0px 0px;
  border-radius: 50px;
  transform: translateY(0);
  display: flex;
  flex-direction: row;
  align-items: center;
  cursor: pointer;
}

.table .table-hover .btn:hover {
  background-color: #ffffff;
}
</style>

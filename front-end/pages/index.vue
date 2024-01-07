<script lang="ts">
import { Component, getModule, Vue } from 'nuxt-property-decorator'
import BookModule from '~/store/book';
import { Book } from '~/types/book';
import BorrowModal from '~/components/BorrowModal.vue'
import ListModule from '~/store/list';
import { List } from '~/types/list';
import { User } from '~/types/User';
@Component({
  components: {
    BorrowModal
  },
})
export default class IndexPage extends Vue {
  books: Array<Book> = []
  book: Book = {}

  users: Array<User> = []
  user: any

  lists: Array<List> = []
  list: List = {}

  isBorrowModalShow: boolean = false
  isSuccessBorrowBook: boolean = false
  isFailBorrowBook: boolean = false

  BorrowModalShow(book: any) {
    this.book = book
    this.isBorrowModalShow = true
  }

  setBooks(books: Array<Book>){
    this.books = books
  }

  async fetch() {
    try {
      const BookModuleInstance = getModule(BookModule, this.$store)
      await BookModuleInstance.fetchBook()
      this.books = BookModuleInstance.books
    } catch (e) {
    }
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
              <b-nav-item href="#" class="nav-text">Home</b-nav-item>
              <b-nav-item href="dashboard" class="nav-text">Dashboard</b-nav-item>
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
        <div v-if="isSuccessBorrowBook" class="col-12" style="display: flex;justify-content: center;margin-top: 35px;">
          <div class="alert alert-success" role="alert">
            Successfully to Borrowed Book
          </div>
        </div>
        <div v-if="isFailBorrowBook" class="col-12" style="display: flex;justify-content: center;margin-top: 35px;">
          <div class="alert alert-danger" role="alert">
            Fail to Borrowed Book
          </div>
        </div>
        <div class="col-12 catalog">
          <div v-for="(book,idx) in books" class="">
            <div class="catalog-card">
              <b-card no-body class="overflow-hidden">
                <b-row no-gutters style="display: flex; height: 100%;">
                  <b-col md="3" style="display: flex;align-items: center;justify-content: center;">
                    <b-card-img :src="require(`@/assets/images/${book.bookImage}`)" alt="Image" class="rounded-0"></b-card-img>
                  </b-col>
                  <b-col md="7">
                    <b-card-body :title="book.bookName">
                      <b-card-text>
                        {{ book.bookDescription }}
                      </b-card-text>
                      <b-card-text>
                        {{ book.bookYear }}
                      </b-card-text>
                    </b-card-body>
                  </b-col>
                  <b-col md="2" style="display: flex; align-items: center; justify-content: space-around;">
                    <button class="btn"
                      :disabled="book.bookBorrowed === 1"
                      @click="BorrowModalShow(book)"
                      >Borrow</button>
                  </b-col>
                </b-row>
              </b-card>
            </div>
          </div>
        </div>
      </div>
    </div>
    <BorrowModal
      v-if="isBorrowModalShow"
      :book="book"
      @close-modal="isBorrowModalShow = false"
    />
  </div>
</template>

<style lang="css" scoped></style>

<style>
.btn{
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

.btn:hover {
  background-color: #ffffff;
}
</style>



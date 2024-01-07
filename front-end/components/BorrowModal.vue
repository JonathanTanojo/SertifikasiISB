<script lang="ts">
import { Component, Prop, Vue, getModule } from 'nuxt-property-decorator';
import ListModule from '~/store/list';
import UserModule from '~/store/user';
import { User } from '~/types/User';
import { Book } from '~/types/book';
import { List } from '~/types/list';

@Component({
  components: {
  },
  methods: {  },
})
export default class BorrowModal extends Vue {
  users: Array<User> = []
  user: User = {}

  lists: Array<List> = []
  list: List = {}

  @Prop()
  book!: Book

  @Prop()
  returnBook!: boolean

  isNameDropdownActive: boolean = false
  isBorrowModalShow: boolean = false
  isSuccessBorrowBook: boolean = false
  isFailBorrowBook: boolean = false

  selectedUserId: User = {}

  async fetch() {
    try {
      const UserModuleInstance = getModule(UserModule, this.$store)
      await UserModuleInstance.fetchUser()
      this.users = UserModuleInstance.users
    }
     catch (e) {
    }
  }

  setUser() {
    this.user = this.selectedUserId
  }

  toggleIsBorrowerNameDropdownActive(){
    this.isNameDropdownActive = !this.isNameDropdownActive
  }

  async BorrowBook(book: any, user:any){
    const ListModuleInstance = getModule(ListModule, this.$store);
    const list: List = {...this.list}
    list.userId = user
    list.bookId = book.id
    list.startDate = new Date()
    list.endDate = new Date(new Date().setDate(new Date().getDate() + 7))


    await ListModuleInstance.createHistory(list)
    .then(() => {
      this.isSuccessBorrowBook = true
      this.isBorrowModalShow = false

      window.location.reload()
    })
    .catch(() => {
      this.isBorrowModalShow = false
      this.isFailBorrowBook = true

      setTimeout(() => {
        this.isFailBorrowBook = false;
      }, 5000);
    })

  }
}
</script>

<template>
   <div class="modal modal-status modal-campaign-approve-confirm open">
    <div class="modal-container">
      <div class="modal-outer-close"></div>
      <div class="modal-wrapper">
        <div class="modal-close-button modal-close" @click="$emit('close-modal')"><img src="@/assets/icons/close.svg"></div>
        <div class="modal-body">
          <h3 v-if="returnBook">Ingin mengembalikan buku ini?</h3>
          <h3 v-else>Ingin meminjam buku ini?</h3>
          <p><strong>Nama Buku:</strong> {{ book.bookName }}</p>
          <p><strong>Deskripsi Buku:</strong> {{ book.bookDescription }}</p>


          <div  v-if="!returnBook" style="margin-top: 15px;">
            <b-form-select v-model="selectedUserId" @change="setUser()" class="mb-3">
              <b-form-select-option disabled>Please select Borrower Name</b-form-select-option>
              <b-form-select-option v-for="(user, idx) in users" :key="user.id" :value="user.id" >{{ user.userName }}</b-form-select-option>
            </b-form-select>
          </div>

          <button v-if="returnBook" class="btn btn-main btn-medium modal-close" @click="$emit('confirm',book)">Iya</button>
          <button v-else class="btn btn-main btn-medium modal-close" @click="BorrowBook(book,selectedUserId)">Iya</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="css" scoped></style>

<style>
.modal-body .btn{
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

.modal-body .btn:hover {
  background-color: #ffffff;
  color: black;
}
</style>


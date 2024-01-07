import { Action, Module, Mutation, MutationAction, VuexModule } from 'vuex-module-decorators'
import { User } from '~/types/User'
import { $axios } from '~/utils/api'

@Module({
  name: 'user',
  stateFactory: true,
  namespaced: true,
})
export default class UserModule extends VuexModule {
  users: Array<User> = []
  user: User = {}

  @Mutation
  setBook(user: User) {
    this.user = user
  }

  @MutationAction
  async fetchUser() {
    const { data } = await $axios.get('/api/users')
    return { users: data.data }
  }

  // @MutationAction
  // async fetchBookById(book: any) {
  //   const { data } = await $axios.get(`/api/books/${book.id}`)
  //   return { book: data.data }
  // }
}

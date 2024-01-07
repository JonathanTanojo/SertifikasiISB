import { Action, Module, Mutation, MutationAction, VuexModule } from 'vuex-module-decorators'
import { Book } from '~/types/book'
import { List } from '~/types/list'
import { $axios } from '~/utils/api'

@Module({
  name: 'list',
  stateFactory: true,
  namespaced: true,
})
export default class ListModule extends VuexModule {
  lists: Array<List> = []
  list: List = {}

  @Mutation
  setList(list: List) {
    this.list = list
  }

  @MutationAction
  async fetchList() {
    const { data } = await $axios.get('/api/list')
    return { lists: data.data }
  }


  @MutationAction
  async fetchListByBook(id : any) {
    const { data } = await $axios.get(`/api/list/book/${id}`)
    return { list: data.data }
  }

  @MutationAction
  async createHistory(list : any) {
    await $axios.$post('/api/list',list)
    const { data } = await $axios.get('/api/list')
    return { lists: data.data }
  }

  @MutationAction
  async updateHistory(list : any) {
    await $axios.put(`/api/list/${list.id}`, list)
    const { data } = await $axios.get('/api/list')
    return { lists: data.data }
  }
}

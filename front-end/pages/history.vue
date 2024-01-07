<script lang="ts">
import { Component, getModule, Vue } from 'nuxt-property-decorator';
import ListModule from '~/store/list';
import { List } from '~/types/list';
import moment from 'moment';
@Component({
  components: {

  },
  methods: {  },
})
export default class IndexPage extends Vue {
  lists: Array<List> = []
  list: List = {}
  moment = moment

  async fetch() {
    try {
      const ListModuleInstance = getModule(ListModule, this.$store)
      await ListModuleInstance.fetchList()
      this.lists = ListModuleInstance.lists
      console.log("🚀 ~ file: history.vue:22 ~ IndexPage ~ fetch ~ this.lists:", this.lists)
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
              <b-nav-item href="/" class="nav-text">Home</b-nav-item>
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
        <div class="history">
          <button type="button" class="btn btn-link">History</button>
        </div>
        <div class="col-12 catalog">
          <div>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Book Name</th>
                  <th scope="col">Member Name</th>
                  <th scope="col">Start Borrow</th>
                  <th scope="col">End Borrow</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(list, idx) in lists">
                  <th scope="row">{{ list.id }}</th>
                  <td>{{ list.book?.bookName }}</td>
                  <td>{{ list.user?.userName }}</td>
                  <td>{{ list.startDate }}</td>
                  <td>{{ list.endDate }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="css" scoped></style>

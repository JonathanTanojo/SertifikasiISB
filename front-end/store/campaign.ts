import { Action, Module, Mutation, MutationAction, VuexModule } from 'vuex-module-decorators'
import { Campaign } from '~/types/campaign'
import { $axios } from '~/utils/api'

@Module({
  name: 'campaign',
  stateFactory: true,
  namespaced: true,
})
export default class CampaignModule extends VuexModule {
  campaigns: Array<Campaign> = []
  campaign: Campaign = {}

  @Mutation
  setCampaign(campaign: Campaign) {
    this.campaign = campaign
  }

  @MutationAction
  async fetchCampaigns() {
    const { data } = await $axios.get('/api/campaigns')
    return { campaigns: data.data }
  }

  @MutationAction
  async fetchCampaignsByRole(roleId: any) {
    const { data } = await $axios.get(`/api/campaigns/role/${roleId}`)
    return { campaigns: data.data }
  }

  @MutationAction
  async fetchCampaignsById(id: any) {
    const { data } = await $axios.get(`/api/campaigns/${id}`)
    return { campaign: data.data }
  }

  @MutationAction
  async fetchCampaignsByCampaignName(campaignName: any) {
    const { data } = await $axios.get(`/api/campaigns/campaignName/${campaignName}`)
    return { campaign: data.data }
  }

  @MutationAction
  async fetchCampaignsByUsername(username: any) {
    const { data } = await $axios.get(`/api/campaigns/user/${username}`)
    return { campaigns: data.data }
  }

  @MutationAction
  async fetchCampaignForRequest(username: any) {
    const { data } = await $axios.get(`/api/campaigns/user/${username}/request`)
    return { campaigns: data.data }
  }

  @MutationAction
  async createCampaign({ campaign, username }: any) {
    await $axios.post(`/api/campaigns`, campaign)
    const { data } = await $axios.get(`/api/campaigns/user/${username}/desc`)
    return { campaigns: data.data }
  }

  @MutationAction
  async updateCampaign({ campaign, username }: any) {
    await $axios.put(`/api/campaigns/${campaign.id}`, campaign)
    const { data } = await $axios.get(`/api/campaigns/user/${username}`)
    return { campaigns: data.data }
  }

  @Action
  async validateCampaign(campaignName: string) {
    await $axios.get(`/api/campaigns/validate-name/${campaignName}`)
  }
}

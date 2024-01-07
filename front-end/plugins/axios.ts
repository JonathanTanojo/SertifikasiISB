import { Context } from '@nuxt/types'

export default function ({ $axios }: Context) {
  $axios.onRequest((config) => {
    config.headers = {
      'Content-Type': 'application/json',
    }
  })
}

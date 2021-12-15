<template>
  <Tutorial />
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  middleware: ['auth'],
  data() {
    return {
      movies: [],
    }
  },
  async mounted() {
    await this.getMovies()
  },
  methods: {
    async getMovies() {
      try {
        const response = await axios.get(
          `http://localhost:8080/movie/getAllMovies`
        )
        console.log(response)
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
  },
}
</script>

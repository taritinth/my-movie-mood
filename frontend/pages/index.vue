<template>
  <div class="popular-movies">
    <h2 class="uppercase tracking-wider text-orange-500 text-lg font-semibold">
      POPULAR MOVIES
    </h2>

    <div
      class="grid grid-cols-2 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-8 mb-20"
    >
      <div v-for="movie in movies" :key="movie._id" class="mt-8">
        <router-link
          :to="{
            name: 'movie-id',
            params: { id: movie._id },
          }"
        >
          <img
            :src="movie.poster"
            :alt="movie.name"
            class="hover:opacity-75 transition ease-in-out duration-150 rounded-3xl object-cover h-80 w-full"
          />
        </router-link>
        <div class="mt-2">
          <router-link
            :to="{
              name: 'movie-id',
              params: { id: movie._id },
            }"
            class="text-lg mt-2 hover:text-gray-300 font-medium"
            >{{ movie.name }}</router-link
          >
          <div class="flex items-center text-gray-400 text-sm mt-1">
            <svg class="fill-current text-blue-400 w-4" viewBox="0 0 24 24">
              <g data-name="Layer 2">
                <path
                  d="M17.56 21a1 1 0 01-.46-.11L12 18.22l-5.1 2.67a1 1 0 01-1.45-1.06l1-5.63-4.12-4a1 1 0 01-.25-1 1 1 0 01.81-.68l5.7-.83 2.51-5.13a1 1 0 011.8 0l2.54 5.12 5.7.83a1 1 0 01.81.68 1 1 0 01-.25 1l-4.12 4 1 5.63a1 1 0 01-.4 1 1 1 0 01-.62.18z"
                  data-name="star"
                ></path>
              </g>
            </svg>
            <span class="ml-1">{{ movie.rating || 'N/A' }}</span>
            <span class="mx-2">|</span>
            <span>{{ movie.year }}</span>
          </div>
          <!-- <div class="text-gray-400">Science Fiction, Action, Adventure</div> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  // middleware: ['auth'],
  layout: 'general',
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
        const response = await axios.get(`/movie/getAllMovies`)
        console.log(response)

        this.movies = response.data
      } catch (e) {
        this.$toast.error('Sorry, Something went wrong. Please try again', {
          position: 'bottom-left',
          timeout: 2000,
        })
        console.log(e)
      } finally {
      }
    },
  },
}
</script>

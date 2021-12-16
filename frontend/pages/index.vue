<template>
  <div class="popular-movies">
    <h2 class="uppercase tracking-wider text-orange-500 text-lg font-semibold">
      POPULAR MOVIES
    </h2>

    <div
      class="grid grid-cols-2 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-6 gap-8"
    >
      <div v-for="movie in movies" :key="movie._id" class="mt-8">
        <a href="http://secure-garden-68019.herokuapp.com/movies/580489">
          <img
            :src="movie.poster"
            :alt="movie.name"
            class="hover:opacity-75 transition ease-in-out duration-150 rounded-3xl"
          />
        </a>
        <div class="mt-2">
          <a
            href="http://secure-garden-68019.herokuapp.com/movies/580489"
            class="text-lg mt-2 hover:text-gray-300 font-medium"
            >{{ movie.name }}</a
          >
          <div class="flex items-center text-gray-400 text-sm mt-1">
            <svg class="fill-current text-orange-500 w-4" viewBox="0 0 24 24">
              <g data-name="Layer 2">
                <path
                  d="M17.56 21a1 1 0 01-.46-.11L12 18.22l-5.1 2.67a1 1 0 01-1.45-1.06l1-5.63-4.12-4a1 1 0 01-.25-1 1 1 0 01.81-.68l5.7-.83 2.51-5.13a1 1 0 011.8 0l2.54 5.12 5.7.83a1 1 0 01.81.68 1 1 0 01-.25 1l-4.12 4 1 5.63a1 1 0 01-.4 1 1 1 0 01-.62.18z"
                  data-name="star"
                ></path>
              </g>
            </svg>
            <span class="ml-1">{{ movie.rating }}</span>
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
  middleware: ['auth'],
  data() {
    return {
      movies: [],
      searchTerm: '',
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

        this.movies = response.data
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
  },
}
</script>

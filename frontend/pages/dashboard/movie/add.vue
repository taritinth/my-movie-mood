<template>
  <div>
    <div class="py-4">
      <div class="flex items-center h-12">
        <h3 class="text-3xl text-gray-100 font-normal">Add new movie</h3>
      </div>
    </div>

    <hr class="border-t border-gray-800" />

    <div class="grid grid-cols-5 gap-4 mb-40">
      <div class="col-span-5">
        <div
          class="flex flex-col bg-my-movie-mood border border-gray-800 shadow-md px-5 py-8 rounded-3xl w-full mt-6 mb-40"
        >
          <div class="flex flex-row mb-4">
            <input
              @focus="showDropdown"
              @blur="hideDropdown"
              @input="onSearch"
              v-model="name"
              class="w-full p-3 pl-5 mr-4 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
              style="background-color: #151f30"
              type="text"
              placeholder="Title"
            />

            <div
              v-if="isShowSearchDropdown"
              class="z-50 absolute bg-gray-800 text-sm rounded w-1/4 mt-14"
            >
              <ul v-if="movies.length > 0">
                <li
                  v-for="movie in movies"
                  :key="movie.imdbID"
                  @click="selectMovie(movie)"
                  class="border-b border-gray-700"
                >
                  <div
                    style="cursor: pointer"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      :src="movie.Poster"
                      :alt="movie.Title"
                      class="w-8 rounded"
                    />
                    <span class="ml-4"
                      >{{ movie.Title }} | {{ movie.Year }}</span
                    >
                  </div>
                </li>
              </ul>

              <!-- <div
                  v-if="!isSearching && movies.length == 0 && name != ''"
                  class="px-3 py-3"
                >
                  No results for '{{ name }}'
                </div> -->
            </div>
            <input
              v-model="year"
              class="w-1/4 p-3 pl-5 mr-4 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
              style="background-color: #151f30"
              type="text"
              placeholder="Year"
            />
          </div>

          <div class="mb-4">
            <input
              v-model="imdbId"
              class="w-full p-3 pl-5 mr-4 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
              style="background-color: #151f30"
              type="text"
              placeholder="IMDb Id"
            />
          </div>

          <div class="mb-4">
            <input
              v-model="poster"
              class="w-full p-3 pl-5 mr-4 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
              style="background-color: #151f30"
              type="text"
              placeholder="Poster"
            />
          </div>

          <div>
            <button
              @click="addMovie"
              class="rounded-2xl group relative w-1/6 flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
            >
              Add
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  // middleware: ['auth'],
  layout: 'dashboard',
  data() {
    return {
      movies: [],
      name: '',
      year: '',
      imdbId: '',
      poster: '',
      debounceSearch: null,
      isSearching: false,
      isShowSearchDropdown: false,
    }
  },
  async mounted() {
    // await this.getMovies()
  },
  methods: {
    async searchMovie() {
      try {
        const response = await axios.get(
          `http://www.omdbapi.com/?apikey=fb38d3b5&type=movie&s=${this.name}`
        )

        console.log(response)

        if (response.data.Response == 'True') {
          this.movies = response.data.Search
        } else {
          this.movies.splice(0)
        }

        this.isSearching = false
      } catch (e) {
        this.movies.splice(0)
        console.log(e)
      } finally {
      }
    },
    async onSearch() {
      if (this.name.length >= 3) {
        this.isSearching = true
        this.isShowSearchDropdown = true

        clearTimeout(this.debounceSearch)
        this.debounceSearch = setTimeout(async () => {
          await this.searchMovie()
        }, 500)
      } else {
        this.isSearching = false
        this.isShowSearchDropdown = false
      }
    },
    selectMovie(movie) {
      //   this.$router.push({
      //     name: 'movie-id',
      //     params: { id: movieId },
      //   })
      console.log(movie)

      this.name = movie.Title
      this.year = movie.Year
      this.imdbId = movie.imdbID
      this.poster = movie.Poster
    },
    showDropdown() {
      if (this.name.length >= 3) this.isShowSearchDropdown = true
    },
    hideDropdown() {
      setTimeout(async () => {
        this.isShowSearchDropdown = false
      }, 100)
    },
    async addMovie() {
      if (
        this.name == '' ||
        this.year == '' ||
        this.imdbId == '' ||
        this.poster == ''
      )
        return

      try {
        const response = await axios.post(`/movie/addMovie`, {
          name: this.name,
          year: this.year,
          imdbId: this.imdbId,
          poster: this.poster,
          rating: 0,
        })

        console.log(response)

        if (response.data == true) {
          this.name = ''
          this.year = ''
          this.imdbId = ''
          this.poster = ''
        }
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
  },
}
</script>

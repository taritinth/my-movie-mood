<script
  src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"
  defer
></script>

<template>
  <div class="md:flex flex-col md:flex-row md:min-h-screen w-full">
    <div
      class="flex flex-col border-r border-gray-800 w-full md:w-64 text-gray-700 bg-my-movie-mood dark-mode:text-gray-200 dark-mode:bg-gray-800 flex-shrink-0 h-screen sticky top-0"
      x-data="{ open: false }"
    >
      <div
        class="flex-shrink-0 px-8 py-4 flex flex-row items-center justify-between"
      >
        <!-- <a
          href="#"
          class="text-lg font-semibold tracking-widest text-gray-900 uppercase rounded-lg dark-mode:text-white focus:outline-none focus:shadow-outline"
          >Flowtrail UI</a
        > -->
        <router-link to="/" class="flex items-center h-12">
          <img
            class="w-28"
            src="@/assets/img/logo.svg"
            alt="Movies &amp; TV Shows, Online cinema HTML Template"
          />
        </router-link>
        <button
          class="rounded-lg md:hidden rounded-lg focus:outline-none focus:shadow-outline"
          @click="open = !open"
        >
          <svg fill="currentColor" viewBox="0 0 20 20" class="w-6 h-6">
            <path
              x-show="!open"
              fill-rule="evenodd"
              d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM9 15a1 1 0 011-1h6a1 1 0 110 2h-6a1 1 0 01-1-1z"
              clip-rule="evenodd"
            ></path>
            <path
              x-show="open"
              fill-rule="evenodd"
              d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </button>
      </div>
      <nav
        :class="{ block: open, hidden: !open }"
        class="flex-grow md:block px-4 pb-4 border-t border-gray-800"
      >
        <router-link
          to="/dashboard"
          exact-active-class="text-blue-500"
          class="flex flex-row items-center block px-4 py-2 mt-2 text-md font-normal text-gray-300 rounded-lg hover:text-blue-500 focus:text-blue-500 focus:outline-none focus:shadow-outline transition ease-in-out duration-150"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            exact-active-class="text-blue-500"
            class="fill-current w-5 mr-4"
          >
            <path
              d="M20,8h0L14,2.74a3,3,0,0,0-4,0L4,8a3,3,0,0,0-1,2.26V19a3,3,0,0,0,3,3H18a3,3,0,0,0,3-3V10.25A3,3,0,0,0,20,8ZM14,20H10V15a1,1,0,0,1,1-1h2a1,1,0,0,1,1,1Zm5-1a1,1,0,0,1-1,1H16V15a3,3,0,0,0-3-3H11a3,3,0,0,0-3,3v5H6a1,1,0,0,1-1-1V10.25a1,1,0,0,1,.34-.75l6-5.25a1,1,0,0,1,1.32,0l6,5.25a1,1,0,0,1,.34.75Z"
            ></path>
          </svg>
          <span>Home</span>
        </router-link>

        <router-link
          to="/dashboard/movie"
          active-class="text-blue-500"
          class="flex flex-row items-center block px-4 py-2 mt-2 text-md font-normal text-gray-300 rounded-lg hover:text-blue-500 focus:text-blue-500 focus:outline-none focus:shadow-outline transition ease-in-out duration-150"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            active-class="text-blue-500"
            class="fill-current w-5 mr-4"
          >
            <path
              d="M19,5.5H12.72l-.32-1a3,3,0,0,0-2.84-2H5a3,3,0,0,0-3,3v13a3,3,0,0,0,3,3H19a3,3,0,0,0,3-3V8.5A3,3,0,0,0,19,5.5Zm1,13a1,1,0,0,1-1,1H5a1,1,0,0,1-1-1V5.5a1,1,0,0,1,1-1H9.56a1,1,0,0,1,.95.68l.54,1.64A1,1,0,0,0,12,7.5h7a1,1,0,0,1,1,1Z"
            ></path>
          </svg>
          <span>Movies</span>
        </router-link>

        <router-link
          to="/reviews"
          active-class="text-blue-500"
          class="flex flex-row items-center block px-4 py-2 mt-2 text-md font-normal text-gray-300 rounded-lg hover:text-blue-500 focus:text-blue-500 focus:outline-none focus:shadow-outline transition ease-in-out duration-150"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            active-class="text-blue-500"
            class="fill-current w-5 mr-4"
          >
            <path
              d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68A1,1,0,0,0,6.9,21.44L12,18.77l5.1,2.67a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.88l.72,4.2-3.76-2a1.06,1.06,0,0,0-.94,0l-3.76,2,.72-4.2a1,1,0,0,0-.29-.88l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
            ></path>
          </svg>
          <span>Reviews</span>
        </router-link>

        <router-link
          to="/"
          exact-active-class="text-blue-500"
          class="flex flex-row items-center block px-4 py-2 mt-2 text-md font-normal text-gray-300 rounded-lg hover:text-blue-500 focus:text-blue-500 focus:outline-none focus:shadow-outline transition ease-in-out duration-150"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            active-class="text-blue-500"
            class="fill-current w-5 mr-4"
          >
            <path
              d="M17,11H9.41l3.3-3.29a1,1,0,1,0-1.42-1.42l-5,5a1,1,0,0,0-.21.33,1,1,0,0,0,0,.76,1,1,0,0,0,.21.33l5,5a1,1,0,0,0,1.42,0,1,1,0,0,0,0-1.42L9.41,13H17a1,1,0,0,0,0-2Z"
            ></path>
          </svg>
          <span>Back to App</span>
        </router-link>
      </nav>
    </div>

    <div class="flex flex-col w-full px-6">
      <nuxt />
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  // middleware: ['auth'],
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

<template>
  <div>
    <nav class="border-b border-gray-800">
      <div
        class="container mx-auto px-4 flex flex-col md:flex-row items-center justify-between px-4 py-6"
      >
        <ul class="flex flex-col md:flex-row items-center">
          <li class="mr-20">
            <router-link to="/">
              <img
                class="w-28"
                src="@/assets/img/logo.svg"
                alt="Movies &amp; TV Shows, Online cinema HTML Template"
              />
            </router-link>
          </li>
          <li class="md:ml-16 mt-3 mr-10 md:mt-0">
            <a
              href="#"
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >Movies</a
            >
          </li>
          <li class="md:ml-6 mt-3 mr-10 md:mt-0">
            <a
              href="#"
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >TV Shows</a
            >
          </li>
          <li class="md:ml-6 mt-3 mr-10 md:mt-0">
            <a
              href="#"
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >Actors</a
            >
          </li>
        </ul>

        <div class="flex flex-col md:flex-row items-center">
          <div class="relative mt-3 md:mt-0">
            <div
              class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none"
            >
              <svg
                class="fill-current text-blue-500 h-5 w-5 mr-3"
                viewBox="0 0 24 24"
              >
                <path
                  class="heroicon-ui"
                  d="M16.32 14.9l5.39 5.4a1 1 0 01-1.42 1.4l-5.38-5.38a8 8 0 111.41-1.41zM10 16a6 6 0 100-12 6 6 0 000 12z"
                ></path>
              </svg>
            </div>
            <input
              @focus="showDropdown"
              @blur="hideDropdown"
              @input="onSearch"
              v-model="searchTerm"
              type="text"
              class="bg-gray-800 rounded-full w-64 px-4 pl-10 py-1 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300 text-md h-10"
              placeholder="Search"
            />

            <!-- <div wire:loading class="spinner top-0 right-0 mr-4 mt-3"></div> -->

            <div
              v-if="isShowSearchDropdown"
              class="z-50 absolute bg-gray-800 text-sm rounded w-64 mt-4"
            >
              <ul v-if="movies.length > 0">
                <li
                  @click="movieDetails(movie._id)"
                  v-for="movie in movies"
                  :key="movie._id"
                  class="border-b border-gray-700"
                >
                  <div
                    style="cursor: pointer"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      :src="movie.poster"
                      :alt="movie.name"
                      class="w-8 rounded"
                    />
                    <span class="ml-4">{{ movie.name }}</span>
                  </div>
                </li>
              </ul>

              <div
                v-if="!isSearching && movies.length == 0 && searchTerm != ''"
                class="px-3 py-3"
              >
                No results for '{{ searchTerm }}'
              </div>
            </div>
          </div>
          <div class="flex flex-row items-center md:ml-4 mt-3 md:mt-0">
            <div v-if="!$auth.loggedIn" class="relative mt-3 md:mt-0 mr-2">
              <router-link to="/login" class="font-medium">
                Sign in
              </router-link>
            </div>
            <!-- <div
              v-if="$auth.user.role == 'admin'"
              class="relative mt-3 md:mt-0 mr-2"
            >
              <router-link to="/dashboard" class="font-medium">
                Dash
              </router-link>
            </div> -->

            <a v-if="$auth.loggedIn" style="cursor: pointer" @click="logout">
              <img
                src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png"
                alt="avatar"
                class="rounded-full w-8 h-8"
              />
            </a>
          </div>
        </div>
      </div>
    </nav>

    <div class="container mx-auto px-4 pt-16">
      <nuxt />
    </div>
  </div>
</template>

<script>
import { mapMutations, mapGetters } from 'vuex'
import { axios } from '@/plugins/axios'

export default {
  data() {
    return {
      movies: [],
      searchTerm: '',
      debounceSearch: null,
      isSearching: false,
      isShowSearchDropdown: false,
    }
  },
  async mounted() {},
  created() {
    this.$nuxt.$on('testEvent', () => {
      console.log('testEvent')
    })
  },
  computed: {},
  methods: {
    async logout() {
      await this.$auth.logout()
      this.$router.push('/login')
    },
    async searchMovie() {
      try {
        const response = await axios.get(
          `/movie/getMovieByName?s=${this.searchTerm}`
        )
        console.log(response)

        this.movies = response.data

        this.isSearching = false
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
    async onSearch() {
      if (this.searchTerm.length >= 2) {
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
    movieDetails(movieId) {
      this.$router.push({
        name: 'movie-id',
        params: { id: movieId },
      })
    },
    showDropdown() {
      if (this.searchTerm.length >= 2) this.isShowSearchDropdown = true
    },
    hideDropdown() {
      setTimeout(async () => {
        this.isShowSearchDropdown = false
      }, 100)
    },
  },
}
</script>

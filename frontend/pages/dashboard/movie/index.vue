<template>
  <div>
    <div class="py-4">
      <div class="flex flex-row justify-between items-center h-12">
        <h3 class="text-3xl text-gray-100 font-normal">Movies</h3>
        <button
          @click="
            $router.push({
              name: 'dashboard-movie-add',
            })
          "
          class="rounded-2xl group relative w-40 flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
        >
          ADD MOVIE
        </button>
      </div>
    </div>

    <hr class="border-t border-gray-800" />

    <div
      class="flex flex-col bg-my-movie-mood px-6 py-2 rounded-2xl w-full mt-4 mb-2"
    >
      <div class="grid grid-cols-9 gap-4 text-gray-400 text-sm">
        <div class="col-span-3 font-light"><p>NAME</p></div>
        <div class="col-span-2"><p>YEAR</p></div>
        <div class=""><p>RATING</p></div>
        <div class=""><p>VOTES</p></div>
        <div class=""><p>IMDB ID</p></div>
        <div class=""><p>ACTIONS</p></div>
      </div>
    </div>

    <div
      v-if="movies.length == 0"
      class="flex flex-row w-full justify-center items-center text-gray-400 py-12"
    >
      No records
    </div>

    <div
      v-for="movie in movies"
      :key="movie._id"
      class="flex flex-col bg-review px-6 py-6 rounded-2xl w-full mb-3"
    >
      <div class="grid grid-cols-9 gap-4">
        <div class="col-span-3">
          <router-link :to="/movie/ + movie._id" class="font-medium">
            <p class="truncate">{{ movie.name }}</p>
          </router-link>
        </div>
        <div class="col-span-2">
          <p>{{ movie.year }}</p>
        </div>
        <div class="">
          <div class="flex flex-row items-center">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              class="fill-current text-blue-500 h-4 w-4 mr-1"
            >
              <path
                d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68A1,1,0,0,0,6.9,21.44L12,18.77l5.1,2.67a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.88l.72,4.2-3.76-2a1.06,1.06,0,0,0-.94,0l-3.76,2,.72-4.2a1,1,0,0,0-.29-.88l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
              ></path>
            </svg>
            <span>{{ movie.rating }}</span>
          </div>
        </div>
        <div class="">
          <p>{{ movie.vote }}</p>
        </div>
        <div class="">
          <p>{{ movie.imdbId }}</p>
        </div>
        <div class="">
          <div class="flex flex-row items-center">
            <router-link
              :to="/movie/ + movie._id"
              class="mr-2 rounded-1xl group relative flex justify-center p-1 border border-transparent text-sm font-medium rounded-md text-yellow-500 bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
              style="background-color: rgba(255, 195, 18, 0.2)"
              target="_blank"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                class="fill-current w-4"
              >
                <path
                  d="M21.92,11.6C19.9,6.91,16.1,4,12,4S4.1,6.91,2.08,11.6a1,1,0,0,0,0,.8C4.1,17.09,7.9,20,12,20s7.9-2.91,9.92-7.6A1,1,0,0,0,21.92,11.6ZM12,18c-3.17,0-6.17-2.29-7.9-6C5.83,8.29,8.83,6,12,6s6.17,2.29,7.9,6C18.17,15.71,15.17,18,12,18ZM12,8a4,4,0,1,0,4,4A4,4,0,0,0,12,8Zm0,6a2,2,0,1,1,2-2A2,2,0,0,1,12,14Z"
                ></path>
              </svg>
            </router-link>
            <router-link
              :to="{
                name: 'dashboard-movie-edit-id',
                params: { id: movie._id },
              }"
              class="mr-2 rounded-1xl group relative flex justify-center p-1 border border-transparent text-sm font-medium rounded-md text-blue-500 bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
              style="background-color: rgba(47, 128, 237, 0.1)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                class="fill-current w-4"
              >
                <path
                  d="M22,7.24a1,1,0,0,0-.29-.71L17.47,2.29A1,1,0,0,0,16.76,2a1,1,0,0,0-.71.29L13.22,5.12h0L2.29,16.05a1,1,0,0,0-.29.71V21a1,1,0,0,0,1,1H7.24A1,1,0,0,0,8,21.71L18.87,10.78h0L21.71,8a1.19,1.19,0,0,0,.22-.33,1,1,0,0,0,0-.24.7.7,0,0,0,0-.14ZM6.83,20H4V17.17l9.93-9.93,2.83,2.83ZM18.17,8.66,15.34,5.83l1.42-1.41,2.82,2.82Z"
                ></path>
              </svg>
            </router-link>
            <button
              @click="deleteMovie(movie)"
              class="mr-2 rounded-1xl group relative flex justify-center p-1 border border-transparent text-sm font-medium rounded-md text-red-500 bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
              style="background-color: rgba(235, 87, 87, 0.2)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 24 24"
                class="fill-current w-4"
              >
                <path
                  d="M10,18a1,1,0,0,0,1-1V11a1,1,0,0,0-2,0v6A1,1,0,0,0,10,18ZM20,6H16V5a3,3,0,0,0-3-3H11A3,3,0,0,0,8,5V6H4A1,1,0,0,0,4,8H5V19a3,3,0,0,0,3,3h8a3,3,0,0,0,3-3V8h1a1,1,0,0,0,0-2ZM10,5a1,1,0,0,1,1-1h2a1,1,0,0,1,1,1V6H10Zm7,14a1,1,0,0,1-1,1H8a1,1,0,0,1-1-1V8H17Zm-3-1a1,1,0,0,0,1-1V11a1,1,0,0,0-2,0v6A1,1,0,0,0,14,18Z"
                ></path>
              </svg>
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
  middleware: ['auth', 'isAdmin'],
  layout: 'dashboard',
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
    async deleteMovie(movie) {
      this.$toast.warning('Sorry, Service Unavailable', {
        position: 'bottom-left',
        timeout: 2000,
      })
    },
  },
}
</script>

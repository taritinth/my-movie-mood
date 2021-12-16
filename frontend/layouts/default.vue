<template>
  <div style="background-color: #131720">
    <nav class="border-b border-gray-800">
      <div
        class="container mx-auto px-4 flex flex-col md:flex-row items-center justify-between px-4 py-6"
      >
        <ul class="flex flex-col md:flex-row items-center">
          <li class="mr-20">
            <a href="http://secure-garden-68019.herokuapp.com">
              <img
                src="https://dmitryvolkov.me/demo/flixtv/main/img/logo.svg"
                alt="Movies &amp; TV Shows, Online cinema HTML Template"
              />
            </a>
          </li>
          <li class="md:ml-16 mt-3 mr-10 md:mt-0">
            <a
              href="http://secure-garden-68019.herokuapp.com "
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >Movies</a
            >
          </li>
          <li class="md:ml-6 mt-3 mr-10 md:mt-0">
            <a
              href="http://secure-garden-68019.herokuapp.com/tv"
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >TV Shows</a
            >
          </li>
          <li class="md:ml-6 mt-3 mr-10 md:mt-0">
            <a
              href="http://secure-garden-68019.herokuapp.com/actors"
              class="text-gray-300 hover:text-blue-400 font-medium transition ease-in-out duration-300"
              >Actors</a
            >
          </li>
        </ul>

        <div class="flex flex-col md:flex-row items-center">
          <div
            wire:id="ZqgwzKxyImtGKK7XkFwn"
            wire:initial-data='{"fingerprint":{"id":"ZqgwzKxyImtGKK7XkFwn","name":"search-dropdown","locale":"en"},"effects":{"listeners":[]},"serverMemo":{"children":[],"errors":[],"htmlHash":"023f9d75","data":{"search":""},"dataMeta":[],"checksum":"419b4d84d23477ee0dded4fda4755ccff24ca62f52f0e7f7875b822fde12ad1d"}}'
            class="relative mt-3 md:mt-0"
            x-data="{ isOpen: true }"
          >
            <!-- <div
              class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none"
            >
              <svg
                class="fill-current w-4 text-gray-500 mt-2 ml-2"
                viewBox="0 0 24 24"
              >
                <path
                  class="heroicon-ui"
                  d="M16.32 14.9l5.39 5.4a1 1 0 01-1.42 1.4l-5.38-5.38a8 8 0 111.41-1.41zM10 16a6 6 0 100-12 6 6 0 000 12z"
                ></path>
              </svg>
            </div> -->
            <input
              v-model="searchTerm"
              type="text"
              class="bg-gray-800 rounded-full w-64 px-4 pl-8 py-1 focus:outline-none focus:shadow-outline text-lg"
              placeholder="Search"
            />

            <!-- <div wire:loading class="spinner top-0 right-0 mr-4 mt-3"></div> -->

            <div
              v-if="searchTerm.length >= 2"
              class="z-50 absolute bg-gray-800 text-sm rounded w-64 mt-4"
              x-show.transition.opacity="isOpen"
            >
              <ul>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/512195"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//lAXONuqg41NwUMuzMiFvicDET9Y.jpg"
                      alt="Red Notice"
                      class="w-8"
                    />
                    <span class="ml-4">Red Notice</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/585245"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//ygPTrycbMSFDc5zUpy4K5ZZtQSC.jpg"
                      alt="Clifford the Big Red Dog"
                      class="w-8"
                    />
                    <span class="ml-4">Clifford the Big Red Dog</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/595743"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//6Y9fl8tD1xtyUrOHV2MkCYTpzgi.jpg"
                      alt="SAS: Red Notice"
                      class="w-8"
                    />
                    <span class="ml-4">SAS: Red Notice</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/649087"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//xZ2KER2gOHbuHP2GJoODuXDSZCb.jpg"
                      alt="Red Dot"
                      class="w-8"
                    />
                    <span class="ml-4">Red Dot</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/508947"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//pRiJaaLetmKmhDZRkrz8oy80oyQ.jpg"
                      alt="Turning Red"
                      class="w-8"
                    />
                    <span class="ml-4">Turning Red</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/146216"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//jW7bHZgkHKUtUJCsThFuqbZGVUL.jpg"
                      alt="RED 2"
                      class="w-8"
                    />
                    <span class="ml-4">RED 2</span>
                  </a>
                </li>
                <li class="border-b border-gray-700">
                  <a
                    href="http://secure-garden-68019.herokuapp.com/movies/72431"
                    class="block hover:bg-gray-700 px-3 py-3 flex items-center"
                    @keydown.tab="isOpen = false"
                  >
                    <img
                      src="https://image.tmdb.org/t/p/w92//jiORLnBsGcVcqIibkGBE213zAyh.jpg"
                      alt="Red Tails"
                      class="w-8"
                    />
                    <span class="ml-4">Red Tails</span>
                  </a>
                </li>
              </ul>

              <div class="px-3 py-3">No results for</div>
            </div>
          </div>
          <div class="md:ml-4 mt-3 md:mt-0">
            <a href="#">
              <img
                src="https://pbs.twimg.com/profile_images/1052707925037379585/LzDX7o9L_400x400.jpg"
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

export default {
  data() {
    return {
      searchTerm: '',
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
    },
  },
}
</script>

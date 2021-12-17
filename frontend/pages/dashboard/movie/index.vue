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
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  // middleware: ['auth'],
  layout: 'dashboard',
  data() {
    return {}
  },
  async mounted() {
    // await this.getMovies()
  },
  methods: {},
}
</script>

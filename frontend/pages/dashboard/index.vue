<template>
  <div>
    <div class="py-4">
      <div class="flex items-center h-12">
        <h3 class="text-3xl text-gray-100 font-normal">Dashboard</h3>
      </div>
    </div>

    <hr class="border-t border-gray-800" />
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  middleware: ['auth', 'isAdmin'],
  layout: 'dashboard',
  data() {
    return {}
  },
  async mounted() {
    this.$router.push('/dashboard/movie')
    // await this.getMovies()
  },
  methods: {},
}
</script>

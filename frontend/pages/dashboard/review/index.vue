<template>
  <div>
    <div class="py-4">
      <div class="flex flex-row justify-between items-center h-12">
        <h3 class="text-3xl text-gray-100 font-normal">Reviews</h3>
      </div>
    </div>

    <hr class="border-t border-gray-800" />

    <div
      class="flex flex-col bg-my-movie-mood px-6 py-2 rounded-2xl w-full mt-4 mb-2"
    >
      <div class="grid grid-cols-12 gap-4 text-gray-400 text-sm">
        <div class="col-span-2"><p>MOVIE</p></div>
        <div class="col-span-2"><p>AUTHOR</p></div>
        <div class="col-span-2"><p>TITLE</p></div>
        <div class="col-span-2"><p>REVIEW</p></div>
        <div class=""><p>RATING</p></div>
        <div class="col-span-2"><p>CREATED DATE</p></div>
        <div class=""><p>ACTIONS</p></div>
      </div>
    </div>

    <div
      v-if="reviews.length == 0"
      class="flex flex-row w-full justify-center items-center text-gray-400 py-12"
    >
      No records
    </div>

    <div
      v-for="review in reviews"
      :key="review._id"
      class="flex flex-col bg-review shadow-md px-6 py-6 rounded-2xl w-full mb-3"
    >
      <div class="grid grid-cols-12 gap-4">
        <div class="col-span-2 text-ellipsis">
          <router-link :to="/movie/ + review.movieId" class="font-medium">
            <p class="truncate">{{ review.movieName }}</p>
          </router-link>
        </div>
        <div class="col-span-2">
          <p>{{ review.userEmail }}</p>
        </div>
        <div class="col-span-2">
          <p class="truncate">{{ review.reviewTitle }}</p>
        </div>
        <div class="col-span-2">
          <p class="truncate">{{ review.review }}</p>
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
            <span>{{ review.rating }}</span>
          </div>
        </div>
        <div class="col-span-2">
          <p>{{ review.timestamp }}</p>
        </div>
        <div class="">
          <div class="flex flex-row items-center">
            <button
              @click="deleteReview(review)"
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
      reviews: [],
    }
  },
  async mounted() {
    await this.getReviews()
  },
  methods: {
    async getReviews() {
      try {
        const response = await axios.get(`/review/getAllReviews`)
        console.log(response)

        this.reviews = response.data
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
    async deleteReview(review) {
      try {
        const response = await axios.post(`/review/delReview`, review)
        console.log(response)

        if (response.data == true) {
          this.$toast.success('Review was deleted successfully !', {
            position: 'bottom-left',
            timeout: 2000,
          })

          setTimeout(async () => {
            await this.getReviews()
          }, 500)
        }
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

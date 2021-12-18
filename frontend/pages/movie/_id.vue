<template>
  <div>
    <div v-if="movie" class="divide-y divide-gray-800">
      <div class="flex flex-col md:flex-row">
        <div class="flex-none">
          <img
            :src="movie.poster"
            :alt="movie.name"
            class="w-64 md:w-96 rounded-3xl"
          />
        </div>
        <div class="w-full md:ml-24">
          <h2 class="text-4xl font-semibold">{{ movie.name }}</h2>
          <div class="flex flex-wrap items-center text-gray-400 text-sm mt-2">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 24 24"
              class="fill-current text-blue-500 h-5 w-5 mr-1"
            >
              <path
                d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68A1,1,0,0,0,6.9,21.44L12,18.77l5.1,2.67a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.88l.72,4.2-3.76-2a1.06,1.06,0,0,0-.94,0l-3.76,2,.72-4.2a1,1,0,0,0-.29-.88l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
              ></path>
            </svg>
            <span class="ml-1"
              >{{ movie.rating || 'N/A' }} ({{ movie.vote }})</span
            >
            <span class="mx-2">|</span>
            <span class="ml-1">IMDb : {{ movie.imdbRating || 'N/A' }}</span>
            <span class="mx-2">|</span>
            <span>{{ movie.year }}</span>
            <!-- <span class="mx-2">|</span>
        <span> Science Fiction, Action, Adventure </span> -->
          </div>
          <p v-if="movie.plot" class="text-gray-300 mt-8">
            {{ movie.plot }}
          </p>
          <div v-if="movie.director" class="mt-8">
            <h4 class="text-white font-semibold">Director</h4>
            <p class="text-gray-300">
              {{ movie.director }}
            </p>
            <!-- <div class="flex">
              <div class="mr-8">
                <div>Robert Richardson</div>
                <div class="text-sm text-gray-400">Director of Photography</div>
              </div>
              <div class="mr-8">
                <div>Andy Serkis</div>
                <div class="text-sm text-gray-400">Director</div>
              </div>
            </div> -->
          </div>
          <div v-if="movie.actors" class="mt-8">
            <h4 class="text-white font-semibold">Actors</h4>
            <p class="text-gray-300">
              {{ movie.actors }}
            </p>
            <!-- <div class="flex">
              <div class="mr-8">
                <div>Robert Richardson</div>
                <div class="text-sm text-gray-400">Director of Photography</div>
              </div>
              <div class="mr-8">
                <div>Andy Serkis</div>
                <div class="text-sm text-gray-400">Director</div>
              </div>
            </div> -->
          </div>
          <div class="mt-12">
            <button
              @click="showTrailer = true"
              class="rounded-2xl group relative w-1/6 flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
            >
              <span class="absolute left-0 inset-y-0 flex items-center pl-3">
                <svg class="w-6 fill-current" viewBox="0 0 24 24">
                  <path d="M0 0h24v24H0z" fill="none"></path>
                  <path
                    d="M10 16.5l6-4.5-6-4.5v9zM12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z"
                  ></path>
                </svg>
              </span>
              Play Trailer
            </button>
          </div>

          <div>
            <div class="mt-12">
              <button
                class="flex inline-flex items-center bg-orange-500 text-gray-900 rounded font-semibold px-5 py-4 hover:bg-orange-600 transition ease-in-out duration-150"
              >
                <svg class="w-6 fill-current" viewBox="0 0 24 24">
                  <path d="M0 0h24v24H0z" fill="none"></path>
                  <path
                    d="M10 16.5l6-4.5-6-4.5v9zM12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z"
                  ></path>
                </svg>
                <span class="ml-2">Play Trailer</span>
              </button>
            </div>

            <div
              @keydown.esc="closeTrailer"
              v-if="showTrailer"
              @click="showTrailer = false"
              style="background-color: rgba(0, 0, 0, 0.4)"
              class="fixed top-0 left-0 w-full h-full flex items-center shadow-lg overflow-y-auto"
            >
              <div
                class="container mx-auto lg:px-36 rounded-lg overflow-y-auto"
              >
                <div class="rounded">
                  <div class="flex justify-end pr-4 pt-2">
                    <button class="text-4xl leading-none hover:text-gray-300">
                      ×
                    </button>
                  </div>
                  <div class="modal-body">
                    <div
                      class="responsive-container overflow-hidden relative"
                      style="padding-top: 56.25%"
                    >
                      <iframe
                        class="responsive-iframe absolute top-0 left-0 w-full h-full"
                        :src="
                          'https://www.youtube.com/embed/' + movie.youtubeId
                        "
                        style="border: 0"
                        allow="autoplay; encrypted-media"
                        allowfullscreen=""
                      ></iframe>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="grid grid-cols-5 gap-4 mt-12">
        <div class="col-span-3 pt-12">
          <h3 class="text-2xl font-semibold">Reviews ({{ movie.vote }})</h3>
          <div
            v-for="review in reviews"
            :key="review._id"
            class="flex flex-col bg-review shadow-md px-6 py-8 rounded-3xl w-full mt-6"
          >
            <div class="divide-y divide-gray-800">
              <div class="flex flex-row mb-4 items-center">
                <div class="w-14 mr-4">
                  <img
                    src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png"
                    alt="avatar"
                    class="rounded-full w-10 h-10"
                  />
                </div>
                <div class="w-full">
                  <div class="flex flex-col">
                    <span class="text-lg font-medium">{{
                      review.reviewTitle
                    }}</span>
                    <span class="text-xs text-gray-400"
                      >{{ review.timestamp }} by {{ review.userEmail }}</span
                    >
                  </div>
                </div>

                <div class="flex flex-row items-center mr-2">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 24 24"
                    class="fill-current text-blue-500 h-5 w-5 mr-1"
                  >
                    <path
                      d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68A1,1,0,0,0,6.9,21.44L12,18.77l5.1,2.67a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.88l.72,4.2-3.76-2a1.06,1.06,0,0,0-.94,0l-3.76,2,.72-4.2a1,1,0,0,0-.29-.88l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
                    ></path>
                  </svg>
                  <span>{{ review.rating }}</span>
                </div>

                <div
                  v-if="
                    ($auth.loggedIn && $auth.user.role == 'admin') ||
                    $auth.user.id == review.reviewBy
                  "
                  class="flex flex-row items-center"
                >
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
              <div class="pt-4">
                <p class="font-light text-gray-300">
                  {{ review.review }}
                </p>
              </div>
            </div>
          </div>

          <div
            v-if="!$auth.loggedIn"
            class="flex flex-row justify-center items-center bg-my-movie-mood border border-gray-800 shadow-md p-8 rounded-3xl w-full mt-6 mb-40"
          >
            <router-link to="/login">
              <span class="font-medium text-blue-500 hover:text-blue-600">
                Sign in
              </span>
            </router-link>
            <span class="mx-2 font-light text-gray-400"> or </span>
            <router-link to="/signup">
              <span class="font-medium text-blue-500 hover:text-blue-600">
                Sign up
              </span>
            </router-link>
            <span class="mx-2 font-light text-gray-400">
              to write reviews
            </span>
          </div>

          <div
            v-else
            class="flex flex-col bg-my-movie-mood border border-gray-800 shadow-md px-5 py-8 rounded-3xl w-full mt-6 mb-40"
          >
            <div class="flex flex-row mb-4">
              <input
                v-model="title"
                class="w-full p-3 pl-5 mr-4 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
                style="background-color: #151f30"
                type="text"
                placeholder="Title"
              />
              <select
                v-model="rating"
                name="select"
                id="select"
                class="w-1/5 pl-5 rounded-2xl focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
                style="background-color: #151f30"
              >
                <option value="10">10</option>
                <option value="9">9</option>
                <option value="8">8</option>
                <option value="7">7</option>
                <option value="6">6</option>
                <option value="5">5</option>
                <option value="4">4</option>
                <option value="3">3</option>
                <option value="2">2</option>
                <option value="1">1</option>
              </select>
            </div>

            <div class="mb-4">
              <textarea
                v-model="message"
                class="h-40 w-full p-3 pl-5 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
                style="background-color: #151f30"
                placeholder="Message"
              />
            </div>

            <div>
              <button
                @click="addReview"
                class="rounded-2xl group relative w-1/6 flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
              >
                Send
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  layout: 'general',
  // middleware: ['auth'],
  data() {
    return {
      movie: null,
      reviews: [],
      rating: 10,
      message: '',
      title: '',
      showTrailer: false,
    }
  },
  async mounted() {
    await this.getMovie()
    await this.getReviews()
  },
  methods: {
    async getMovie() {
      try {
        const movie = await axios.get(
          `/movie/getMovieById/${this.$route.params.id}`
        )

        this.movie = movie.data
        console.log(this.movie)
      } catch (e) {
        this.$toast.error('Sorry, Something went wrong. Please try again', {
          position: 'bottom-left',
          timeout: 2000,
        })
        console.log(e)
      } finally {
      }
    },

    async addReview() {
      if (this.title == '' || this.rating == null || this.message == '') {
        this.$toast.error('Sorry, Please fill in all the required fields.', {
          position: 'bottom-left',
          timeout: 2000,
        })
        return false
      }

      try {
        const response = await axios.post(`/review/addReview`, {
          movieId: this.movie._id,
          reviewTitle: this.title,
          rating: this.rating,
          review: this.message,
          reviewBy: this.$nuxt.$auth.user.id,
          movieName: this.movie.name,
        })

        console.log(response)

        if (response.data == true) {
          this.$toast.success('Review was added successfully !', {
            position: 'bottom-left',
            timeout: 2000,
          })

          this.title = ''
          this.rating = 10
          this.message = ''
        } else {
          this.$toast.error(`Sorry, You've reviewed this movie already !`, {
            position: 'bottom-left',
            timeout: 3000,
          })
        }

        // await this.getReviews()

        setTimeout(async () => {
          await this.getMovie()
          await this.getReviews()
        }, 500)
      } catch (e) {
        this.$toast.error('Sorry, Something went wrong. Please try again', {
          position: 'bottom-left',
          timeout: 2000,
        })
        console.log(e)
      } finally {
      }
    },
    async getReviews() {
      try {
        const response = await axios.get(
          `/review/getReview/${this.$route.params.id}`
        )
        console.log(response)

        this.reviews = response.data
      } catch (e) {
        this.$toast.error('Sorry, Something went wrong. Please try again', {
          position: 'bottom-left',
          timeout: 2000,
        })
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
            await this.getMovie()
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
    closeTrailer() {
      this.showTrailer = false
      console.log('close')
    },
  },
}
</script>

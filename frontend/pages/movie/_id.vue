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
        <div class="md:ml-24">
          <h2 class="text-4xl font-semibold">{{ movie.name }}</h2>
          <div class="flex flex-wrap items-center text-gray-400 text-sm mt-2">
            <svg class="fill-current text-blue-500 w-4" viewBox="0 0 24 24">
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
            <!-- <span class="mx-2">|</span>
        <span> Science Fiction, Action, Adventure </span> -->
          </div>
          <p class="text-gray-300 mt-8">
            After finding a host body in investigative reporter Eddie Brock, the
            alien symbiote must face a new enemy, Carnage, the alter ego of
            serial killer Cletus Kasady.
          </p>
          <div class="mt-12">
            <h4 class="text-white font-semibold">Featured Cast</h4>
            <div class="flex mt-4">
              <div class="mr-8">
                <div>Robert Richardson</div>
                <div class="text-sm text-gray-400">Director of Photography</div>
              </div>
              <div class="mr-8">
                <div>Andy Serkis</div>
                <div class="text-sm text-gray-400">Director</div>
              </div>
            </div>
          </div>
          <div class="mt-12">
            <button
              class="rounded-1xl group relative w-1/6 flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
            >
              <span class="absolute left-0 inset-y-0 flex items-center pl-3">
                <!-- Heroicon name: solid/lock-closed -->
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

          <div x-data="{ isOpen: false }">
            <div class="mt-12">
              <button
                @click="isOpen = true"
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
              style="background-color: rgba(0, 0, 0, 0.5); display: none"
              class="fixed top-0 left-0 w-full h-full flex items-center shadow-lg overflow-y-auto"
              x-show.transition.opacity="isOpen"
            >
              <div
                class="container mx-auto lg:px-32 rounded-lg overflow-y-auto"
              >
                <div class="bg-gray-900 rounded">
                  <div class="flex justify-end pr-4 pt-2">
                    <button class="text-3xl leading-none hover:text-gray-300">
                      ×
                    </button>
                  </div>
                  <div class="modal-body px-8 py-8">
                    <div
                      class="responsive-container overflow-hidden relative"
                      style="padding-top: 56.25%"
                    >
                      <iframe
                        class="responsive-iframe absolute top-0 left-0 w-full h-full"
                        src="https://www.youtube.com/embed/j5Jq6jA1jLA"
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
      <div class="grid grid-cols-4 gap-4 mt-12">
        <div class="col-span-3 pt-12">
          <h3 class="text-3xl font-semibold">Reviews</h3>
          <div
            class="flex flex-col bg-review shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded-3xl w-full mt-6"
          >
            <div class="divide-y divide-gray-800">
              <div class="flex flex-row">
                <img
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_640.png"
                  alt="avatar"
                  class="rounded-full w-8 h-8"
                />
                <div class="flex flex-col">
                  <span class="reviews__name"
                    >Best Marvel movie in my opinion</span
                  >
                  <span class="reviews__time"
                    >24.08.2021, 17:53 by Jonathan Banks</span
                  >
                </div>

                <span class="justify-self-end"
                  ><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                    <path
                      d="M22,9.67A1,1,0,0,0,21.14,9l-5.69-.83L12.9,3a1,1,0,0,0-1.8,0L8.55,8.16,2.86,9a1,1,0,0,0-.81.68,1,1,0,0,0,.25,1l4.13,4-1,5.68A1,1,0,0,0,6.9,21.44L12,18.77l5.1,2.67a.93.93,0,0,0,.46.12,1,1,0,0,0,.59-.19,1,1,0,0,0,.4-1l-1-5.68,4.13-4A1,1,0,0,0,22,9.67Zm-6.15,4a1,1,0,0,0-.29.88l.72,4.2-3.76-2a1.06,1.06,0,0,0-.94,0l-3.76,2,.72-4.2a1,1,0,0,0-.29-.88l-3-3,4.21-.61a1,1,0,0,0,.76-.55L12,5.7l1.88,3.82a1,1,0,0,0,.76.55l4.21.61Z"
                    ></path>
                  </svg>
                  10</span
                >
              </div>
              <p class="reviews__text">
                There are many variations of passages of Lorem Ipsum available,
                but the majority have suffered alteration in some form, by
                injected humour, or randomised words which don't look even
                slightly believable. If you are going to use a passage of Lorem
                Ipsum, you need to be sure there isn't anything embarrassing
                hidden in the middle of text.
              </p>
            </div>
          </div>
        </div>
        <div></div>
      </div>
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  // middleware: ['auth'],
  data() {
    return {
      movie: null,
      reviews: [],
    }
  },
  async mounted() {
    await this.getMovie()
  },
  methods: {
    async getMovie() {
      try {
        const response = await axios.get(
          `/movie/getMovieById/${this.$route.params.id}`
        )
        console.log(response)

        this.movie = response.data
      } catch (e) {
        console.log(e)
      } finally {
      }
    },
  },
}
</script>

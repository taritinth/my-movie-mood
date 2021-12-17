<template>
  <div
    class="min-h-full flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8"
  >
    <div
      class="flex flex-col bg-my-movie-mood border border-gray-800 shadow-md px-4 sm:px-6 md:px-8 lg:px-10 py-8 rounded-3xl w-6/12 max-w-md"
    >
      <div class="flex flex-col items-center justify-center">
        <!-- <img class="mx-auto h-12 w-auto" src="https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg" alt="Workflow"> -->
        <img
          class="w-28"
          src="@/assets/img/logo.svg"
          alt="Movies &amp; TV Shows, Online cinema HTML Template"
        />
        <!-- <p class="mt-2 text-center text-sm text-gray-600">
        Or
        <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">
          start your 14-day free trial
        </a>
      </p> -->
      </div>
      <form class="mt-8" action="#" method="POST">
        <!-- <input type="hidden" name="remember" value="true" /> -->
        <div class="mb-6">
          <input
            v-model="email"
            class="w-full p-3 pl-5 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
            style="background-color: #151f30"
            type="text"
            placeholder="E-Mail"
          />
        </div>
        <div class="mb-6">
          <input
            v-model="password"
            class="w-full p-3 pl-5 rounded-2xl text-white border border-gray-900 focus:outline-none focus:ring-blue-500 focus:border-blue-500 focus:z-10 transition ease-in-out duration-300"
            style="background-color: #151f30"
            type="password"
            placeholder="Password"
          />
        </div>

        <!-- <div class="flex items-center justify-between">
          <div class="flex items-center">
            <input
              id="remember-me"
              name="remember-me"
              type="checkbox"
              class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
            />
            <label for="remember-me" class="ml-2 block text-sm text-gray-400">
              Remember me
            </label>
          </div>

          <div class="text-sm">
            <a
              href="#"
              class="font-medium text-indigo-600 hover:text-indigo-500"
            >
              Forgot your password?
            </a>
          </div>
        </div> -->

        <div class="mt-12">
          <button
            @click="login"
            type="submit"
            class="rounded-2xl group relative w-full flex justify-center p-3 border border-transparent text-sm font-medium rounded-md text-white bg-blue-600 hover:bg-blue-700 focus:outline-none transition ease-in-out duration-300"
          >
            <span class="absolute left-0 inset-y-0 flex items-center pl-3">
              <!-- Heroicon name: solid/lock-closed -->
              <svg
                class="h-5 w-5 text-blue-500 group-hover:text-blue-400"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 20 20"
                fill="currentColor"
                aria-hidden="true"
              >
                <path
                  fill-rule="evenodd"
                  d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                  clip-rule="evenodd"
                />
              </svg>
            </span>
            Sign in
          </button>
        </div>

        <div class="flex items-center justify-center mt-10">
          <!-- <div class="flex items-center">
            <input
              id="remember-me"
              name="remember-me"
              type="checkbox"
              class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
            />
            <label for="remember-me" class="ml-2 block text-sm text-gray-400">
              Remember me
            </label>
          </div> -->

          <div class="text-sm">
            <span class="font-light text-gray-300"
              >Don't have an account ?</span
            >
            <router-link to="/signup">
              <span class="font-medium text-blue-500 hover:text-blue-600"
                >Sign up</span
              >
            </router-link>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import { axios } from '@/plugins/axios'

export default {
  middleware: ['isNotLoggedIn'],
  layout: 'general',
  data() {
    return {
      email: '',
      password: '',
    }
  },
  async mounted() {
    // await this.getMovies()
  },
  methods: {
    async login(e) {
      e.preventDefault()

      if (this.email == '' || this.password == '') {
        this.$toast.error('Sorry, Please fill in all the required fields.', {
          position: 'bottom-left',
          timeout: 2000,
        })
        return false
      }

      const payload = {
        email: this.email,
        password: this.password,
      }

      try {
        await this.$auth.loginWith('local', {
          data: payload,
        })
        this.$toast.success(`Logged in as ${this.$nuxt.$auth.user.email}!`, {
          position: 'bottom-left',
          timeout: 2000,
        })
        this.$router.push('/')
      } catch (e) {
        this.$toast.error('Sorry, Something went wrong. Please try again', {
          position: 'bottom-left',
          timeout: 2000,
        })
        console.log(e)
        this.$router.push('/login')
      }
    },
  },
}
</script>

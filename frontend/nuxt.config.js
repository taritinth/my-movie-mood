export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'My Movie Mood',
    htmlAttrs: {
      lang: 'en',
    },
    bodyAttrs: {
      class: 'font-sans text-white bg-my-movie-mood',
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' },
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      {
        rel: 'stylesheet',
        href: 'https://fonts.googleapis.com/css2?family=Prompt:wght@100;200;300;400;500;600;700;800;900&display=swap',
      },
    ],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [{ src: '~/assets/css/custom.css', lang: 'css' }],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
    // https://go.nuxtjs.dev/eslint
    // '@nuxtjs/eslint-module',
    // https://go.nuxtjs.dev/tailwindcss
    '@nuxtjs/tailwindcss',
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth', // With default plugin options
    'vue-toastification/nuxt',

    // You can also pass plugin options
    [
      'vue-toastification/nuxt',
      // {
      //   timeout: 500,
      //   draggable: false,
      //   position: 'bottom-left',
      // },
    ],
  ],

  auth: {
    strategies: {
      local: {
        endpoints: {
          login: {
            url: '/auth/login',
            method: 'post',
            propertyName: 'accessToken',
          },
          user: { url: '/auth/me', method: 'get', propertyName: '' },
          logout: false,
        },
      },
      // tokenName: 'Authorization'
    },
    redirect: {
      login: '/login',
      logout: '/',
    },
  },

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    baseURL:
      process.env.NODE_ENV === 'production'
        ? 'http://localhost:8080'
        : 'http://localhost:8080',
    withCredentials: true,
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
    parallel: true,
    cache: true,
    // hardSource: true,
  },
}

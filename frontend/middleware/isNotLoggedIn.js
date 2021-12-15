export default async function ({ $auth, redirect }) {
  if ($auth.loggedIn) {
    return redirect('/')
  }
}

export default async function ({ $auth, redirect }) {
  if ($auth.user.role !== 'admin') {
    return redirect('/')
  }
}

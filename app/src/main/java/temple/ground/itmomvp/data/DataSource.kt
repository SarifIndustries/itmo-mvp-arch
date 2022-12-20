package temple.ground.itmomvp.data

import temple.ground.itmomvp.data.response.UserResponse

interface DataSource {
    fun loadUser(): UserResponse?
}
package temple.ground.itmomvp.data

import retrofit2.Call
import retrofit2.http.GET
import temple.ground.itmomvp.data.response.UserResponse


interface NetworkService {
    @GET("/api/users/2")
    fun getUser(): Call<UserResponse>
}
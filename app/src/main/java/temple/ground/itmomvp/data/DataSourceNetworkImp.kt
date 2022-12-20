package temple.ground.itmomvp.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import temple.ground.itmomvp.data.response.UserResponse

class DataSourceNetworkImp: DataSource {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: NetworkService = retrofit.create(NetworkService::class.java).also { Log.d("9000", it.javaClass.name) }

    override fun loadUser(): UserResponse? {
        val response = service.getUser().execute()
        val user = response.body()
        return user
    }
}
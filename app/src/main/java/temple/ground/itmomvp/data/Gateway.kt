package temple.ground.itmomvp.data

import temple.ground.itmomvp.data.response.UserResponse
import temple.ground.itmomvp.domain.IGateway
import temple.ground.itmomvp.domain.entity.UserEntity

class Gateway(val dataSource: DataSource): IGateway {
    override fun loadNumber(): Int {
        val user = dataSource.loadUser()
        val number = user?.data?.id ?: 0
        return number
    }

    override fun loadUserInfo(): UserEntity {
        val user = dataSource.loadUser()
        val entity = user?.toEntity() ?: emptyUser
        return entity
    }
}

private fun UserResponse.toEntity(): UserEntity =
    UserEntity(
        data?.first_name ?: "",
        data?.last_name ?: "",
        data?.id ?: 0
    )

private val emptyUser = UserEntity("", "", 0)
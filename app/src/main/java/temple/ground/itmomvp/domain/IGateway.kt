package temple.ground.itmomvp.domain

import temple.ground.itmomvp.domain.entity.UserEntity

interface IGateway {
    fun loadNumber(): Int
    fun loadUserInfo(): UserEntity
}
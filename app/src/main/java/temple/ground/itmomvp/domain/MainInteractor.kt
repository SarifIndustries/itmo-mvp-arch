package temple.ground.itmomvp.domain

import temple.ground.itmomvp.domain.entity.UserEntity

class MainInteractor(
    private val gateway: IGateway,
    private val preferenceService: ILocalStorageService
    ) {
    fun loadNumber(): Int {   // Use-case 1
        return gateway.loadNumber()
    }

    fun saveNumberLocally(number: Int) {    // Use-case 2
        preferenceService.saveNumberLocally(number)
    }

    fun loadUserInfo(): UserEntity {    // Use-case 3
        return gateway.loadUserInfo()
    }
}
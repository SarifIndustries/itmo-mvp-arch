package temple.ground.itmomvp.data

import temple.ground.itmomvp.domain.ILocalStorageService

class LocalStorageService(val preferenceService: PreferenceService): ILocalStorageService {

    companion object {
        const val NUMBER_KEY = "NUMBER_KEY"
    }

    override fun saveNumberLocally(number: Int) {
        preferenceService.saveNumber(NUMBER_KEY, number)
    }
}

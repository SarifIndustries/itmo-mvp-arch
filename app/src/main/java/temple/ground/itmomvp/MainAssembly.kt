package temple.ground.itmomvp

import temple.ground.itmomvp.data.DataSourceNetworkImp
import temple.ground.itmomvp.data.Gateway
import temple.ground.itmomvp.data.LocalStorageService
import temple.ground.itmomvp.data.PreferenceService
import temple.ground.itmomvp.domain.MainInteractor
import temple.ground.itmomvp.ui.MVPContract
import temple.ground.itmomvp.ui.MainPresenter

object MainAssembly {
    fun constructPresenter(activity: MVPContract.IView): MVPContract.IPresenter {
        val dataSource = DataSourceNetworkImp()
        val gateway = Gateway(dataSource)
        val preferenceService = PreferenceService()
        val localStorage = LocalStorageService(preferenceService)
        val interactor = MainInteractor(gateway, localStorage)
        val presenter = MainPresenter(activity, interactor)
        return presenter
    }
}
package temple.ground.itmomvp.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import temple.ground.itmomvp.domain.MainInteractor

class MainPresenter(var view: MVPContract.IView?, val interactor: MainInteractor): MVPContract.IPresenter {

    var number = 0

    override fun onScreenStart() {
        view?.hideLoading()
        view?.displayText("Please click on the button.")
    }

    override fun onLoadButtonClick() {
        view?.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            val userEntity = interactor.loadUserInfo()
            number = userEntity.id
            val text = "Name: " + userEntity.name + "   Last Name: " + userEntity.lastName
            CoroutineScope(Dispatchers.Main).launch {
                view?.displayText(text)
                view?.hideLoading()
            }
        }
    }

    override fun onSaveButtonClick() {
        interactor.saveNumberLocally(number + 1)
        view?.displayText("Save complete!")
    }

    override fun onScreenDestroy() {
        view = null
    }
}
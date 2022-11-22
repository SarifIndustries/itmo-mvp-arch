package temple.ground.itmomvp.presenter

import kotlinx.coroutines.*
import temple.ground.itmomvp.MVPContract
import temple.ground.itmomvp.data.DataSource

class MainPresenter(var view: MVPContract.IView?, val source: DataSource): MVPContract.IPresenter {

    override fun onScreenStart() {
        view?.hideLoading()
        view?.displayText("Please click on the button.")
    }

    override fun onButtonClick() {
        view?.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            val data = source.fetchData()
            CoroutineScope(Dispatchers.Main).launch {
                view?.displayText(data)
                view?.hideLoading()
            }
        }
    }

    override fun onScreenDestroy() {
        view = null
    }
}
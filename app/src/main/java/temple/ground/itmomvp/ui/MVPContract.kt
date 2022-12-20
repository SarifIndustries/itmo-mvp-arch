package temple.ground.itmomvp.ui

interface MVPContract {
    interface IView {
        fun displayText(text: String)
        fun showLoading()
        fun hideLoading()
    }

    interface IPresenter {
        fun onScreenStart()
        fun onLoadButtonClick()
        fun onSaveButtonClick()
        fun onScreenDestroy()
    }
}
package temple.ground.itmomvp

interface MVPContract {
    interface IView {
        fun displayText(text: String)
        fun showLoading()
        fun hideLoading()
    }

    interface IPresenter {
        fun onScreenStart()
        fun onButtonClick()
        fun onScreenDestroy()
    }
}
package temple.ground.itmomvp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import temple.ground.itmomvp.MVPContract
import temple.ground.itmomvp.R
import temple.ground.itmomvp.data.DataSourceImp
import temple.ground.itmomvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MVPContract.IView {

    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar

    // Dependency
    val presenter: MVPContract.IPresenter = MainPresenter(this, DataSourceImp())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initViews()

        button.setOnClickListener {
            presenter.onButtonClick()
        }
        presenter.onScreenStart()
    }

    private fun initViews() {
        button      = findViewById(R.id.button)
        textView    = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)
    }

    override fun displayText(text: String) {
        textView.text = text
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        presenter.onScreenDestroy()
        super.onDestroy()
    }
}
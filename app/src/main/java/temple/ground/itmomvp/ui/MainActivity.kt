package temple.ground.itmomvp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import temple.ground.itmomvp.MainAssembly
import temple.ground.itmomvp.R
import temple.ground.itmomvp.base.setVisible
import temple.ground.itmomvp.data.DataSourceNetworkImp

class MainActivity : AppCompatActivity(), MVPContract.IView {

    lateinit var loadButton: Button
    lateinit var saveButton: Button
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar

    // Dependency
    val presenter: MVPContract.IPresenter = MainAssembly.constructPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initViews()

        //loadButton.setVisible(true)

        loadButton.setOnClickListener {
            presenter.onLoadButtonClick()
        }

        saveButton.setOnClickListener {
            presenter.onSaveButtonClick()
        }

        presenter.onScreenStart()
    }

    private fun initViews() {
        loadButton  = findViewById(R.id.button1)
        saveButton  = findViewById(R.id.button2)
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
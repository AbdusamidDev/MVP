package developer.abdusamid.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import developer.abdusamid.mvp.contract.Contract
import developer.abdusamid.mvp.databinding.ActivityMainBinding
import developer.abdusamid.mvp.model.Model
import developer.abdusamid.mvp.presenter.Presenter

class MainActivity : AppCompatActivity(), Contract.View {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = Presenter(this, Model())
        binding.button.setOnClickListener {
            presenter.onButtonClick()
        }
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        Log.d(TAG, "hideProgress: In MainActivity")
        binding.progressBar.visibility = View.INVISIBLE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun setString(string: String?) {
        Log.d(TAG, "setString: in MainActivity")
        binding.textView.text = string
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
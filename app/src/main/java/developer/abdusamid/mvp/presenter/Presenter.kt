package developer.abdusamid.mvp.presenter

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import developer.abdusamid.mvp.contract.Contract
import kotlin.coroutines.coroutineContext

class Presenter(private var mainView: Contract.View, private var model: Contract.Model) :
    Contract.Presenter, Contract.Model.OnFinishedListener {
    private val TAG = "Presenter"
    override fun onFinished(string: String?) {
        Log.d(TAG, "onFinished: in presenter")
        if (mainView != null) {
            mainView.setString(string)
            mainView.hideProgress()
        }
    }

    override fun onButtonClick() {
        if (mainView != null) {
            mainView.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
    }
}
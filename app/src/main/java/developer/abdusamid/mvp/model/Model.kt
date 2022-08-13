package developer.abdusamid.mvp.model

import android.os.Handler
import android.os.Looper
import android.util.Log
import developer.abdusamid.mvp.contract.Contract
import java.util.*

class Model : Contract.Model {
    private val TAG = "MVP"

    //The data in Model Class can be: DATABASE, API or etc.
    private val arrayList =
        listOf(
            "Android – is a Green Alien that entered the IT field in recent years and encouraged many programmers to earn money with this operating system.",
            "Flutter - It is a Framework developed by Google. Through this course, you will be able to create Android and iOS mobile applications while simultaneously learning a new language, Dart.",
            "iOS - Apple Inc. is a mobile operating system created and produced by The operating system that currently powers many of the company's mobile devices, including the iPhone, iPad, and iPod Touch.",
            "Fronted -Fronted programming course, you can perfectly learn many programming technologies, such as HTML, CSS, JavaScript, Bootstrap, Sass, jQuery."
        )

    override fun getNextCourse(onFinishedListener: Contract.Model.OnFinishedListener?) {
        Log.d(TAG, "getNextCourse: in model")
        Handler(Looper.getMainLooper()).postDelayed({
            onFinishedListener?.onFinished(
                getRandomString
            )
        }, 1000)
    }

    private val getRandomString: String
        get() {
            val random = Random()
            val index = random.nextInt(arrayList.size)
            return arrayList[index]
        }
}
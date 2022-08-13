package developer.abdusamid.mvp.contract

//This Interface Connects 3 Parts: Model, View, Presenter.
interface Contract {

    //The Design Part Is Currently Handled By MainActivity
    interface View {
        fun showProgress()
        fun hideProgress()
        fun setString(string: String?)
    }

    //Data Stores in Model Interface
    interface Model {
        fun getNextCourse(onFinishedListener: OnFinishedListener?)
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }
    }

    //This Interface Connects and Controls Model and View Interfaces
    interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}
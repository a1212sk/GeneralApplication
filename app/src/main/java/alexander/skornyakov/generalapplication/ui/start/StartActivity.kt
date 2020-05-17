package alexander.skornyakov.generalapplication.ui.start

import alexander.skornyakov.generalapplication.BaseApplication
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.di.start.StartComponent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class StartActivity : AppCompatActivity() {

    lateinit var startComponent: StartComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        startComponent = (application as BaseApplication).appComponent.startComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
    }

}

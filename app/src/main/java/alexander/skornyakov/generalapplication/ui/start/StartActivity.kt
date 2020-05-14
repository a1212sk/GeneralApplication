package alexander.skornyakov.generalapplication.ui.start

import alexander.skornyakov.generalapplication.BaseApplication
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.di.start.StartSubcomponent
import alexander.skornyakov.generalapplication.ui.start.first.FirstFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import alexander.skornyakov.generalapplication.ui.start.first.SecondFragment
import javax.inject.Inject

class StartActivity : AppCompatActivity() {

    lateinit var startComponent: StartSubcomponent

    override fun onCreate(savedInstanceState: Bundle?) {
        startComponent = (application as BaseApplication).appComponent.startComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
    }

}

package alexander.skornyakov.generalapplication.ui.main

import alexander.skornyakov.generalapplication.BaseApplication
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.di.main.MainComponent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as BaseApplication).appComponent.mainComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

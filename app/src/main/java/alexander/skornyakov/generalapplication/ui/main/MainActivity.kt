package alexander.skornyakov.generalapplication.ui.main

import alexander.skornyakov.generalapplication.BaseApplication
import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.di.main.MainComponent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (application as BaseApplication).appComponent.mainComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()
    }

    private fun setupToolbar(){
        var navController = findNavController(R.id.nav_controller)
        NavigationUI.setupWithNavController(toolbar,navController)
    }
}

package alexander.skornyakov.generalapplication.ui.splash

import alexander.skornyakov.generalapplication.R
import alexander.skornyakov.generalapplication.data.ApplicationStorage
import alexander.skornyakov.generalapplication.ui.main.MainActivity
import alexander.skornyakov.generalapplication.ui.start.StartActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity(){

    lateinit var storage: ApplicationStorage
    val SPLASH_LATENCY = 300L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Set layout
        setContentView(R.layout.splash_activity)

        // 2. Check settings and move forward
        storage = ApplicationStorage(this)
        GlobalScope.launch {
            Thread.sleep(SPLASH_LATENCY)
            if(checked()) {
                Intent(applicationContext, MainActivity::class.java).let {
                    startActivity(it)
                    finish()
                }
            }
            else{
                Intent(applicationContext, StartActivity::class.java).let {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    fun checked():Boolean{
        val firstLaunch = storage.getString("firstLaunch")
        if(firstLaunch=="false"){
            return true
        }
        else{
            storage.putString("firstLaunch","false")
            return false
        }
    }
}
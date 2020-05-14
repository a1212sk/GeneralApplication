package alexander.skornyakov.generalapplication

import alexander.skornyakov.generalapplication.di.AppComponent
import alexander.skornyakov.generalapplication.di.DaggerAppComponent
import android.app.Application

class BaseApplication : Application(){

    val appComponent : AppComponent by lazy{
        DaggerAppComponent.create()
    }

}
package alexander.skornyakov.generalapplication.di

import alexander.skornyakov.generalapplication.di.start.StartSubcomponent
import alexander.skornyakov.generalapplication.ui.splash.SplashActivity
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppSubcomponentsModule::class])
interface AppComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }

    fun startComponent():StartSubcomponent.Factory
    fun inject(activity: SplashActivity)
}
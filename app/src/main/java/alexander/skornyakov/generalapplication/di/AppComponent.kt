package alexander.skornyakov.generalapplication.di

import alexander.skornyakov.generalapplication.di.start.StartSubcomponent
import alexander.skornyakov.generalapplication.ui.start.StartActivity
import alexander.skornyakov.generalapplication.ui.start.first.FirstFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AppSubcomponentsModule::class])
interface AppComponent{

    @Component.Factory
    interface Factory{
        fun create():AppComponent
    }

    fun startComponent():StartSubcomponent.Factory
}
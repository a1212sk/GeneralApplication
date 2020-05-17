package alexander.skornyakov.generalapplication.di.main

import alexander.skornyakov.generalapplication.ui.main.MainActivity
import alexander.skornyakov.generalapplication.ui.main.first.FirstFragment
import alexander.skornyakov.generalapplication.ui.main.second.SecondFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: FirstFragment)
    fun inject(fragment: SecondFragment)
}
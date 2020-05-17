package alexander.skornyakov.generalapplication.di.start

import alexander.skornyakov.generalapplication.ui.start.StartActivity
import alexander.skornyakov.generalapplication.ui.start.first.FirstFragment
import alexander.skornyakov.generalapplication.ui.start.first.SecondFragment
import dagger.Subcomponent

@Subcomponent(modules = [StartModule::class])
interface StartComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create():StartComponent
    }

    fun inject(activity: StartActivity)
    fun inject(fragment: FirstFragment)
    fun inject(fragment: SecondFragment)

}
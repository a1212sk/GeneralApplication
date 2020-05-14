package alexander.skornyakov.generalapplication.di.start

import alexander.skornyakov.generalapplication.di.ViewModelKey
import alexander.skornyakov.generalapplication.ui.start.StartActivity
import alexander.skornyakov.generalapplication.ui.start.first.FirstFragment
import alexander.skornyakov.generalapplication.ui.start.first.FirstViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Subcomponent
import dagger.multibindings.IntoMap

@Subcomponent(modules = [StartModule::class])
interface StartSubcomponent{

    @Subcomponent.Factory
    interface Factory{
        fun create():StartSubcomponent
    }

    fun inject(activity: StartActivity)
    fun inject(fragment: FirstFragment)

}
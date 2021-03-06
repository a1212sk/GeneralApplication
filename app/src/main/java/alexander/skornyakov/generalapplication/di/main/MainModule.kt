package alexander.skornyakov.generalapplication.di.main

import alexander.skornyakov.generalapplication.di.ViewModelKey
import alexander.skornyakov.generalapplication.ui.main.first.FirstViewModel
import alexander.skornyakov.generalapplication.ui.main.second.SecondViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    abstract fun bindFirstViewModel(vm: FirstViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    abstract fun bindSecondViewModel(vm: SecondViewModel):ViewModel
}
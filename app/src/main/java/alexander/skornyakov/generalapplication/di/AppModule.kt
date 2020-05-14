package alexander.skornyakov.generalapplication.di

import alexander.skornyakov.generalapplication.ViewModelProviderFactory
import alexander.skornyakov.generalapplication.ui.start.first.FirstViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class AppModule{
    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory):ViewModelProvider.Factory

}
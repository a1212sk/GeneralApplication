package alexander.skornyakov.generalapplication.di

import alexander.skornyakov.generalapplication.di.start.StartSubcomponent
import dagger.Module

@Module(subcomponents = [StartSubcomponent::class])
abstract class AppSubcomponentsModule
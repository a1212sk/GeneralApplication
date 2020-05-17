package alexander.skornyakov.generalapplication.di

import alexander.skornyakov.generalapplication.di.main.MainComponent
import alexander.skornyakov.generalapplication.di.start.StartComponent
import dagger.Module

@Module(subcomponents = [StartComponent::class, MainComponent::class])
abstract class AppSubcomponentsModule
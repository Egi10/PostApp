package id.buaja.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.domain.usecase.PostUseCase
import id.buaja.domain.usecase.PostUseCaseImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPostUseCase(
        postUseCaseImpl: PostUseCaseImpl
    ): PostUseCase
}
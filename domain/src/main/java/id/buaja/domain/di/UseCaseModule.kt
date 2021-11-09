package id.buaja.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.domain.usecase.post.PostUseCase
import id.buaja.domain.usecase.post.PostUseCaseImpl
import id.buaja.domain.usecase.users.UserUseCase
import id.buaja.domain.usecase.users.UserUseCaseImpl

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPostUseCase(
        postUseCaseImpl: PostUseCaseImpl
    ): PostUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUsersUseCase(
        useCaseImpl: UserUseCaseImpl
    ): UserUseCase
}
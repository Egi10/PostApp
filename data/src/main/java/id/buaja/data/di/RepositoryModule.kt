package id.buaja.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.repository.PostRepositoryImpl
import id.buaja.data.repository.UsersRepositoryImpl
import id.buaja.domain.repository.PostRepository
import id.buaja.domain.repository.UsersRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository

    @Binds
    @Singleton
    abstract fun bindsUserRepository(
        usersRepositoryImpl: UsersRepositoryImpl
    ): UsersRepository
}
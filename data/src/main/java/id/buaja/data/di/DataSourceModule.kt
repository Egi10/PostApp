package id.buaja.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.data.source.post.PostDataSource
import id.buaja.data.source.post.PostDataSourceImpl
import id.buaja.data.source.users.UsersDataSource
import id.buaja.data.source.users.UsersDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsPostDataSource(
        postDataSourceImpl: PostDataSourceImpl
    ): PostDataSource
    
    @Binds
    @Singleton
    abstract fun bindUsersDataSource(
        usersDataSourceImpl: UsersDataSourceImpl
    ): UsersDataSource
}
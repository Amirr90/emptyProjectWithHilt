package com.firebasemultiplelogins.di


import dagger.Module

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class CustomModules {/*    @Binds
        @Singleton
        abstract fun bindsUploadImage(uploadRef: UploadImagesToFirebase): UploadImages*/

    /*    @Binds
        @Singleton
        abstract fun bindsAuth(auth: ApiLogin): Authentication

        @Binds
        @Singleton
        abstract fun bindUserPagingRepo(auth: UserPagingData): UserResult

        @Binds
        @Singleton
        abstract fun bindSaveUserDatabaseRepo(userRef: SaveUserToRoomDatabase): CustomerDatabase*/

}
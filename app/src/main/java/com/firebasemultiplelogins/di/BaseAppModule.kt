package com.firebasemultiplelogins.di


import android.app.Application
import android.content.Context
import com.firebasemultiplelogins.utils.AppConstant
import com.firebasemultiplelogins.utils.redux.ApplicationState
import com.firebasemultiplelogins.utils.redux.Store
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BaseAppModule {
    @Provides
    @Singleton
    fun provideHttpLogger(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    }

    /*@Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }*/

    @Provides
    @Singleton
    fun provideStore(): Store<ApplicationState> = Store(ApplicationState())

    /*@Provides
    @Singleton
    fun provideRoomDb(application: Application) = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "com.appbase.di"
    ).build()*/


    /* @Provides
     @Singleton
     fun provideCustomerDao(appDatabase: AppDatabase) = appDatabase.customerDao()*/


    /* @Provides
     @Singleton
     fun provideFireStoreRef() = Firebase.firestore*/


    @Provides
    @Singleton
    fun provideSharedPrefs(applicationState: Application) =
        applicationState.getSharedPreferences("com.firebasemultiplelogins", Context.MODE_PRIVATE)


}

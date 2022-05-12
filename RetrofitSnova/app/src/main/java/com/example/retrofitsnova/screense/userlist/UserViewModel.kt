package com.example.retrofitsnova.screense.userlist

import androidx.lifecycle.ViewModel
import com.example.retrofitsnova.data.remote.user.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.ScheduledExecutorService

class UserViewModel: ViewModel() {

    private val compositeDisposable= CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun fetchUserList(userApi: UserApi?) {
        userApi?.let {
            compositeDisposable.add(userApi.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {

                })
            )
        }
    }

}
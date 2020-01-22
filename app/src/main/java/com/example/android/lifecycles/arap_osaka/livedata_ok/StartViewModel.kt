package com.example.android.lifecycles.arap_osaka.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception
import java.lang.IllegalStateException

class StartViewModel : ViewModel() {
    private val repository = RepositoryImpl()

    private val _nextView = MutableLiveData<Result<NextViewType>>()
    val nextView: LiveData<Result<NextViewType>> = _nextView

    fun onClickNextButton() {
        try {
            // APIレスポンスの結果によって、画面遷移を変えたい場合
            val data = repository.fetchData()
            val nextType = when (data.name) {
                "A" -> NextViewType.A
                "B" -> NextViewType.B
                else -> NextViewType.C
            }
            _nextView.value = Result.success(nextType)
        } catch (e: IllegalStateException) {
            _nextView.value = Result.failure(e)
        }
    }
}

interface Repository {
    fun fetchData(): Data
}

class RepositoryImpl : Repository {
    override fun fetchData(): Data {
        return Data("A")
    }
}

enum class NextViewType {
    A, B, C
}

data class Data(val name: String)


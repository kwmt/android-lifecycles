package com.example.android.lifecycles.arap_osaka.livedata.ok

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import com.example.android.lifecycles.arap_osaka.livedata.model.RepositoryImpl

class StartViewModel : ViewModel() {
    private val repository = RepositoryImpl()

    private val _nextLiveDate = MutableLiveData<Event<NextViewType>>()
    val nextLiveData: LiveData<Event<NextViewType>> = _nextLiveDate

    fun onClickNextButton() {
        // APIレスポンスの結果によって、画面遷移を変えたい場合
        val data = repository.fetchData()
        val nextType = when (data.name) {
            "A" -> NextViewType.A
            "B" -> NextViewType.B
            else -> NextViewType.C
        }
        _nextLiveDate.value = Event(nextType)
    }
}

package com.example.android.lifecycles.arap_osaka.livedata.ok

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import com.example.android.lifecycles.arap_osaka.livedata.model.RepositoryImpl
import java.lang.IllegalStateException

class StartViewModel : ViewModel() {
    private val repository = RepositoryImpl()

    private val _nextView = MutableLiveData<Event<NextViewType>>()
    val nextView: LiveData<Event<NextViewType>> = _nextView

    fun onClickNextButton() {
        // APIレスポンスの結果によって、画面遷移を変えたい場合
        val data = repository.fetchData()
        val nextType = when (data.name) {
            "A" -> NextViewType.A
            "B" -> NextViewType.B
            else -> NextViewType.C
        }
        _nextView.value = Event(nextType)
    }
}

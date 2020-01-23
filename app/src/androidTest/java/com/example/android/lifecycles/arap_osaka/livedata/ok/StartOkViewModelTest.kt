package com.example.android.lifecycles.arap_osaka.livedata.ok

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class StartOkViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var target: StartViewModel

    @Before
    fun setUp() {
        target = StartViewModel()
    }

    @Test
    fun onClickNextButton() {

        val observer1 = Observer<Event<Result<NextViewType>>> { event ->
            // onChangeが呼ばれる
            assertThat(event.hasBeenHandled).isFalse()
            val result = event.getContentIfNotHandled()
            // contentがnullじゃないことを確認
            assertThat(result).isEqualTo(Result.success(NextViewType.A))
            assertThat(event.hasBeenHandled).isTrue()

        }
        // 1回目observerを呼ぶ
        target.nextView.observeForever(observer1)

        target.onClickNextButton()

        val observer2 = Observer<Event<Result<NextViewType>>> { event ->
            val result = event.getContentIfNotHandled()
            // contentがnullであることを確認
            assertThat(result).isNull()
            assertThat(event.hasBeenHandled).isTrue()

        }
        // 2回目のobserveが呼ばれた時
        target.nextView.observeForever(observer2)
    }

}

package com.example.android.lifecycles.arap_osaka.livedata.ng

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.android.lifecycles.arap_osaka.livedata.model.NextViewType
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class StartNgViewModelTest {
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

        val observer = mockk<Observer<Result<NextViewType>>>(relaxed = true)

        // 最初にobserveが呼ばれたときには、
        target.nextView.observeForever(observer)
        // LiveDataのonChangedは呼ばれないが、
        verify(exactly = 0) { observer.onChanged(Result.success(NextViewType.A)) }

        // 一度LiveData#valueにデータが入ると、
        target.onClickNextButton()
        verify { observer.onChanged(Result.success(NextViewType.A)) }

        // 再度observeが呼ばれた場合に、
        target.nextView.observeForever(observer)
        // onChangedが呼ばれてしまう。
        verify { observer.onChanged(Result.success(NextViewType.A)) }
    }

}

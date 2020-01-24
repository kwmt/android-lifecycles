package com.example.android.lifecycles.arap_osaka.zipLiveData

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

// https://medium.com/@gauravgyal/combine-results-from-multiple-async-requests-90b6b45978f7
fun <A, B> zipLiveData(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> {
    return MediatorLiveData<Pair<A, B>>().apply {
        var lastA: A? = null
        var lastB: B? = null

        fun update() {
            val localLastA = lastA
            val localLastB = lastB
            if (localLastA != null && localLastB != null) {
                this.value = Pair(localLastA, localLastB)
            }
        }

        addSource(a) {
            lastA = it
            update()
        }
        addSource(b) {
            lastB = it
            update()
        }
    }
}

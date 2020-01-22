package com.example.android.lifecycles.arap_osaka.livedata.model

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


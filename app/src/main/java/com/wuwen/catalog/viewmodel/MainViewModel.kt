package com.wuwen.catalog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val hitCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    fun hit() {
        hitCount.value = hitCount.value?.plus(1)
    }
}
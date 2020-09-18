package com.wuwen.catalog.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    val hitCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    fun hit() {
        hitCount.value = hitCount.value?.plus(1)
    }
}
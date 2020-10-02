package com.example.android.tugasfragmentqomar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel:ViewModel() {
    private val _myData = MutableLiveData<MyData>()
    val myData: LiveData<MyData> = _myData

    private val _eventNextUsia = MutableLiveData<Boolean>()
    val eventNextUsia: LiveData<Boolean> = _eventNextUsia

    private val _eventNextJk = MutableLiveData<Boolean>()
    val eventNextJk: LiveData<Boolean> = _eventNextJk

    private val _eventNextHasil = MutableLiveData<Boolean>()
    val eventNextHasil: LiveData<Boolean> = _eventNextHasil

    private val _eventBack = MutableLiveData<Boolean>()
    val eventBack: LiveData<Boolean> = _eventBack


    private val _jk = MutableLiveData<Int>()
    val jk: LiveData<Int> get() = _jk

    init {
        _jk.value = 0
        _myData.value = MyData()
    }

    fun updateJk(jk: Int) {
        _jk.value = jk
    }

    fun updateJkText(jk: String){
        _myData.value?.jenisKelamin = jk
    }

    fun updateNama(nama: String){
        _myData.value?.nama = nama
    }

    fun updateUsia(usia: String){
        _myData.value?.usia = usia
    }

    fun onNextUsia(){
        _eventNextUsia.value = true
    }

    fun onNextUsiaComplete(){
        _eventNextUsia.value = false
    }


    fun onNextJk(){
        _eventNextJk.value = true
    }

    fun onNextJkComplete(){
        _eventNextJk.value = false
    }

    fun onNextHasil(){
        _eventNextHasil.value = true
    }

    fun onNextHasilComplete(){
        _eventNextHasil.value = false
    }

    fun onBack(){
        _eventBack.value = true
    }

    fun onBackComplete(){
        _eventBack.value = false
    }
}
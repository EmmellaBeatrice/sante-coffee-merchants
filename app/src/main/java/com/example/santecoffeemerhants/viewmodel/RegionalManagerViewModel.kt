package com.example.santecoffeemerhants.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.santecoffeemerhants.data.Entity.RegionalManager
import com.example.santecoffeemerhants.data.SanteRoomDatabase
import com.example.santecoffeemerhants.repository.RegionalManagerRepository

class RegionalManagerViewModel(application: Application): AndroidViewModel(application) {
    private val repository: RegionalManagerRepository


    val allRegionalManagers: LiveData<List<RegionalManager>>

    init {
        val regionalManagerDao = SanteRoomDatabase.getDatabase(application).regionalManagerDao()
        repository = RegionalManagerRepository(regionalManagerDao)
        allRegionalManagers = repository.allRegionalManagers
    }
    fun insert(regionalManager: RegionalManager){
        repository.insertRegionalManager(regionalManager)
    }
    fun getRegionalMangerByEmail(email: String){
        repository.getRegionalManagerByEmail(email)
    }
    fun checkIfValidAccount(email: String, password: String): Boolean{
        return repository.isValidAccount(email, password)
    }


}
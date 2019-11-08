package com.android.example.kinrai

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.example.kinrai.Database.RestsDatabaseDao



import kotlinx.coroutines.*


class RestsViewModel(dataSource: RestsDatabaseDao, application: Application) : ViewModel() {


    val database = dataSource


    private val viewModelJob = Job()


    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)



    val rests = database.getAllRests()

    init {


        initializeRests()
        Log.i("RestsViewModel", rests.toString())
    }

    private fun initializeRests() {
        uiScope.launch {
//            tonight.value = getCardFromDatabase()
        }
    }


    private suspend fun insert(rest: Resterant) {
        withContext(Dispatchers.IO) {
            database.insert(rest)
        }
    }

    private suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun addRest(rest:Resterant){
        uiScope.launch {

            insert(rest)

        }
    }

    fun clearAllRest(){
        uiScope.launch {
            clearAll()
        }
    }

}
package buu.s59160937.savemycards.ViewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.kinrai.Database.RestsDatabaseDao
import com.android.example.kinrai.RestsViewModel


class RestsViewModelFactory (
    private val dataSource: RestsDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestsViewModel::class.java)) {
            return RestsViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

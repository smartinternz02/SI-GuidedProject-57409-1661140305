
package com.example.amphibians.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class AmphibianApiStatus {LOADING, ERROR, DONE}

class AmphibianViewModel : ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for the API status
  private  val _status :MutableLiveData<AmphibianApiStatus> = MutableLiveData()
            val status:LiveData<AmphibianApiStatus> = _status
    // TODO: Create properties to represent MutableLiveData and LiveData for a list of amphibian objects
private val _amphibians: MutableLiveData<List<Amphibian>> = MutableLiveData()
    val amphibians:LiveData<List<Amphibian>> = _amphibians

    // TODO: Create properties to represent MutableLiveData and LiveData for a single amphibian object.
    //  This will be used to display the details of an amphibian when a list item is clicked
private val _amphibian: MutableLiveData<Amphibian> = MutableLiveData()
val amphibian:LiveData<Amphibian> = _amphibian




    // TODO: Create a function that gets a list of amphibians from the api service and sets the
    //  status via a Coroutine
fun getAmphibianList(){
    viewModelScope.launch {
        _status.value = AmphibianApiStatus.LOADING
        try {
            _amphibians.value = AmphibianApi.retrofitService.getAmphibianList()
            _status.value= AmphibianApiStatus.DONE
        }catch (e: Exception){
      _amphibians.value = emptyList()
            _status.value = AmphibianApiStatus.ERROR
        }
    }
}


    fun onAmphibianClicked(amphibian: Amphibian) {
        // TODO: Set the amphibian object
  _amphibian.value = amphibian
    }
}

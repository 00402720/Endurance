package com.endurance.medkids.ui.infoView.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.endurance.medkids.RetrofitApplication
import com.endurance.medkids.SystemViewReviewerApplication
import com.endurance.medkids.network.dto.BodySystemModel
import com.endurance.medkids.repositories.SystemViewRepository
import com.endurance.medkids.ui.createuser.viewmodel.CreateUserViewModel

class SystemViewModel(private val repository: SystemViewRepository) : ViewModel() {


    var title = MutableLiveData("")
    var section_image = MutableLiveData<Int>()
    var puzzle_image = MutableLiveData<Int>()
    var color = MutableLiveData<Int>()
    var status = MutableLiveData("")

    fun getSystems() = repository.getSystems()

    fun setSelectedSystem(system: BodySystemModel) {
        title.value = system.name
        section_image.value = system.section_image
        puzzle_image.value = system.puzzle_image
        color.value = system.color
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RetrofitApplication
                SystemViewModel(app.systemViewRepository)
            }
        }
    }

}

package com.endurance.medkids.ui.infoView.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.endurance.medkids.SystemViewReviewerApplication
import com.endurance.medkids.data.model.BodySystemModel
import com.endurance.medkids.repositories.SystemViewRepository

class SystemViewModel(private val repository: SystemViewRepository) : ViewModel() {

    var title = MutableLiveData("")
    var section_image = MutableLiveData("")
    var puzzle_image = MutableLiveData("")
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
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SystemViewReviewerApplication
                SystemViewModel(app.systemViewRepository)
            }
        }
        const val SYSTEM_CREATED = "SYSTEM created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}

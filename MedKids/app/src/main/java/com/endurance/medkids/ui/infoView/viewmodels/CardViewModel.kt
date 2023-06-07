package com.endurance.medkids.ui.infoView.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.endurance.medkids.CardReviewerApplication
import com.endurance.medkids.data.model.CardInfoModel
import com.endurance.medkids.repositories.CardInfoRepository

class CardViewModel(private val repository: CardInfoRepository) : ViewModel() {

    var title = MutableLiveData("")
    var img = MutableLiveData<Int>()
    var color = MutableLiveData<Int>()
    var status = MutableLiveData("")

    fun getCards() = repository.getCards()

    fun setSelectedCard(card: CardInfoModel) {
        title.value = card.tittle
        img.value = card.img
        color.value = card.color
    }

    companion object {


        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as CardReviewerApplication
                CardViewModel(app.cardInfoRepository)
            }
        }
        const val CARD_CREATED = "CARD created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}

package com.endurance.medkids.ui.infoView.recyclerview

import android.animation.AnimatorInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.endurance.medkids.R
import com.endurance.medkids.network.dto.BodySystemModel
import com.endurance.medkids.databinding.ItemCardInfoBinding

class SystemRecyclerViewAdapter(private val clickListener: (BodySystemModel) -> Unit) :
    RecyclerView.Adapter<SystemRecyclerViewHolder>() {

    private val systems = ArrayList<BodySystemModel>()

    fun setData(systemList: List<BodySystemModel>) {
        systems.clear()
        systems.addAll(systemList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemRecyclerViewHolder {
        val binding =
            ItemCardInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SystemRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return systems.size
    }

    override fun onBindViewHolder(holder: SystemRecyclerViewHolder, position: Int) {
        val system = systems[position]
        holder.bind(system, clickListener)
       

        val cardClickAnimation = AnimatorInflater.loadAnimator(holder.itemView.context, R.animator.card_click_animation)
        cardClickAnimation.setTarget(holder.binding.root) // Accede a la vista raíz mediante root en el binding

        holder.binding.root.setOnClickListener {
            // Inicia la animación cuando se hace clic en la tarjeta
            cardClickAnimation.start()

            // Llama al clickListener y pasa el objeto BodySystemModel correspondiente
            clickListener.invoke(system)

            // Aquí puedes agregar el código adicional que deseas ejecutar cuando se hace clic en la tarjeta
            // Por ejemplo, puedes iniciar una actividad o realizar alguna otra acción
        }
    }
}


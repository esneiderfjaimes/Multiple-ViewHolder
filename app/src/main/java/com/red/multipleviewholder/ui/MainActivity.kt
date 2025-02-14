package com.red.multipleviewholder.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.red.multipleviewholder.databinding.ActivityMainBinding
import com.red.multipleviewholder.v2.CardInfo
import com.red.multipleviewholder.v2.ComponentsV2Adapter
import com.red.multipleviewholder.v2.cardInfoToComponentV2
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardInfos = listOf(
            CardInfo("000", LocalDateTime.now()),
            CardInfo("100", LocalDateTime.of(2024, 2, 13, 10, 30)), // Mismo día, diferente hora
            CardInfo("200", LocalDateTime.of(2024, 2, 13, 23, 59)), // Mismo día, otra hora
            CardInfo("300", LocalDateTime.of(2024, 2, 12, 8, 15)),  // Día anterior
            CardInfo("400", LocalDateTime.of(2024, 2, 11, 14, 45)),  // Dos días antes
            CardInfo("500", LocalDateTime.of(2024, 2, 10, 9, 20)),   // Tres días antes
            CardInfo("600", LocalDateTime.of(2024, 2, 9, 12, 55)),   // Cuatro días antes
            CardInfo("600", LocalDateTime.of(2024, 2, 9, 12, 55)),   // Cuatro días antes
            CardInfo("700", LocalDateTime.of(2024, 2, 8, 7, 10)),    // Cinco días antes
            CardInfo("800", LocalDateTime.of(2024, 2, 7, 11, 40)),   // Seis días antes
            CardInfo("800", LocalDateTime.of(2024, 2, 7, 11, 40)),   // Seis días antes
            CardInfo("800", LocalDateTime.of(2024, 2, 7, 11, 40)),   // Seis días antes
            CardInfo("800", LocalDateTime.of(2024, 2, 7, 11, 40)),   // Seis días antes
        )

        val components2 = cardInfoToComponentV2(cardInfos)

        binding.componentsRecycler.adapter = ComponentsV2Adapter(components2)
        binding.componentsRecycler.layoutManager = LinearLayoutManager(this)
    }
}
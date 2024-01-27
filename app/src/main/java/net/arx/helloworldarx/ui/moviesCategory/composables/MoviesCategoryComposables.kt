package net.arx.helloworldarx.ui.moviesCategory.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState


@Composable
fun MoviesCategoryUI(numberToShow: MutableState<Int>){
    //TODO YOUR UI GOES HERE
    Row(){
        Text(text="Hello world")
        Text(text = "This number is from the viewmodel $numberToShow")
    }

}
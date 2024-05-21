package com.example.composepritices.ui.compoments

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun SearchItemState(
    modifier:Modifier=Modifier,
    onChange:(String) -> Unit={}
    ){
    var search by remember{
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = search,
        onValueChange = {
            search=it
            onChange(it.text)
        },
        leadingIcon = {
           Icon(imageVector = Icons.Default.Search, contentDescription =null )
        },
        placeholder = {
         Text(text ="Search" )
        },
        colors= TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.small,
        modifier =modifier.fillMaxWidth()
        )
}


package com.example.myapplication.screen

import android.widget.CheckBox
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.SignUp
import org.jetbrains.annotations.ApiStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpSheet(onClose: () -> Unit, onDone: () -> Unit) {
    ModalBottomSheet(
        onDismissRequest = onClose,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ) {
        Column(Modifier.padding(16.dp)){
FormField("Имя", SignUp.name) {SignUp.name = it }
FormField("Email", SignUp.email) {SignUp.email = it }

            Row {
                Checkbox(
                    checked = SignUp.agreed,
                    onCheckedChange = {SignUp.agreed = it}
                )
                Text("Согласие на обработку данных")
            }
            Text(SignUp.error)
            AppButton("Подтвердить запись") {
                if (SignUp.submit()) onDone()
            }
        }
    }

}
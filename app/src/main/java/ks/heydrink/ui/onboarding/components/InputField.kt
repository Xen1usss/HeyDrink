package ks.heydrink.ui.onboarding.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ks.heydrink.R
import ks.heydrink.ui.theme.MontserratAlternates
import ks.heydrink.ui.theme.colorBlue
import ks.heydrink.ui.theme.colorPurple

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        value = "", // то что введет пользователь
        onValueChange = onValueChange, // колбэк при изменении текста
        placeholder = {
            Text(
                text = stringResource(R.string.take_name_placeholder), // текст-подсказка
                color = colorPurple.copy(alpha = 0.7f),
                fontFamily = MontserratAlternates,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        },
        textStyle = TextStyle( // стиль вводимого текста
            color = colorPurple,
            fontFamily = MontserratAlternates
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorPurple, // цвет рамки в фокусе
            unfocusedBorderColor = colorPurple,
            focusedContainerColor = colorBlue.copy(alpha = 0.2f), // цвет фона поля в фокусе
            unfocusedContainerColor = colorBlue.copy(alpha = 0.2f),
            cursorColor = colorPurple, // цвет мигающего курсора
            focusedTextColor = Color.Black, // цвет текста когда поле в фокусе
            unfocusedTextColor = Color.Black,
            focusedPlaceholderColor = colorPurple.copy(alpha = 0.7f), // цвет подсказки когда поле в фокусе
            unfocusedPlaceholderColor = colorPurple.copy(alpha = 0.7f),
        ),
        shape = RoundedCornerShape(31.dp),
        modifier = modifier
            .width(287.dp)
            .height(63.dp),
        singleLine = true
    )
}
package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.OnboardingButton
import ks.heydrink.ui.theme.AdventPro

@Preview
@Composable
fun TakeName() {
    Box(modifier = Modifier.fillMaxSize()) {
        var text by remember { mutableStateOf("Анна") }
        Image(
            painter = painterResource(R.drawable.background_gradient_first),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Здесь вы можете ввести реальное \n" +
                        "имя или придумать псевдоним, в \n" +
                        "будущем оно отобразится в общем " +
                        "рейтинге\n",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = AdventPro,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
            )
            SimpleInput(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.padding(16.dp)
            )
            OnboardingButton(
                text = "Вперед",
                onClick = { },
                modifier = Modifier
                    .padding(top = 15.dp)
            )
        }
    }
}

@Composable
fun SimpleInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    val color = Color(0xFFA3A0C7)

    OutlinedTextField(
        value = value, // то что введет пользователь
        onValueChange = onValueChange, // колбэк при изменении текста
        placeholder = { Text("Ваше имя", color = color.copy(alpha = 0.7f)) }, // текст-подсказка
        textStyle = TextStyle(color = Color.Black), // стиль вводимого текста
        colors = OutlinedTextFieldDefaults.colors( // цвета компонентов
            focusedBorderColor = color, // цвет рамки в фокусе
            unfocusedBorderColor = color, // цвет рамки не в фокусе
            focusedContainerColor = color.copy(alpha = 0.2f), // цвет фона поля в фокусе
            unfocusedContainerColor = color.copy(alpha = 0.2f), // цвет фона поля не в фокусе
            cursorColor = Color.Black, // цвет мигающего курсора
            focusedTextColor = Color.Black, // цвет текста когда поле в фокусе
            unfocusedTextColor = Color.Black, // цвет текста когда поле не в фокусе
            focusedPlaceholderColor = color.copy(alpha = 0.7f), // цвет подсказки когда поле в фокусе
            unfocusedPlaceholderColor = color.copy(alpha = 0.7f),
        ),
        shape = RoundedCornerShape(31.dp),
        modifier = modifier
            .width(287.dp)
            .height(63.dp),
        singleLine = true
    )
}

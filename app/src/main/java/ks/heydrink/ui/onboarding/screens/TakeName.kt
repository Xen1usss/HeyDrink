package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.BasicOnboardingTextStyle
import ks.heydrink.ui.onboarding.components.OnboardingButton
import ks.heydrink.ui.theme.MontserratAlternates


@Composable
fun TakeName(onFinishClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        var text by remember { mutableStateOf("Анна") }
        Image(
            painter = painterResource(R.drawable.background_gradient_second),
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
            BasicOnboardingTextStyle(
                text = stringResource(R.string.take_name_hint),
                modifier = Modifier
                    .padding(24.dp)
            )
            SimpleInput(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.padding(16.dp)
            )
            OnboardingButton(
                text = stringResource(R.string.take_name_button),
                onClick = onFinishClick, // { },
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
    val colorPurple = Color(0xFFA3A0C7)
    val colorBlue = Color(0xFF99C4FF)

    OutlinedTextField(
        value = "", // то что введет пользователь
        onValueChange = onValueChange, // колбэк при изменении текста
        placeholder = {
            Text(
                text = "Ваше имя...", // текст-подсказка
                color = colorPurple.copy(alpha = 0.7f),
                fontFamily = MontserratAlternates,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontFamily = MontserratAlternates
        ), // стиль вводимого текста
        colors = OutlinedTextFieldDefaults.colors(
            // цвета компонентов
            focusedBorderColor = colorPurple, // цвет рамки в фокусе
            unfocusedBorderColor = colorPurple, // цвет рамки не в фокусе
            focusedContainerColor = colorBlue.copy(alpha = 0.2f), // цвет фона поля в фокусе
            unfocusedContainerColor = colorBlue.copy(alpha = 0.2f), // цвет фона поля не в фокусе
            cursorColor = Color.Black, // цвет мигающего курсора
            focusedTextColor = Color.Black, // цвет текста когда поле в фокусе
            unfocusedTextColor = Color.Black, // цвет текста когда поле не в фокусе
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

@Preview
@Composable
fun Test() {
    TakeName({})
}
package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.OnboardingButton
import ks.heydrink.ui.theme.AdventPro
import ks.heydrink.ui.theme.MontserratAlternates
import ks.heydrink.ui.theme.text

@Preview
@Composable
fun Greeting() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background_gradient),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Привет!",
                    fontSize = 24.sp,
                    fontFamily = AdventPro,
                    modifier = Modifier
                        .padding(24.dp)
                )
                Text(
                    text = "HeyDrink!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MontserratAlternates,
                    color = text
                )
                Text(
                    text = "это Ваш персональный \n" +
                            "гид по водному балансу",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MontserratAlternates
                )
                Text(
                    text = "Здесь Вы можете отслеживать потребление \n" +
                            "воды, получать умные напоминания и даже \n" +
                            "соревноваться в еженедельном рейтинге \n" +
                            "пользователей",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = AdventPro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(24.dp)
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Давайте познакомимся \n" +
                            "и настроим Ваш профиль!",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MontserratAlternates,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(24.dp)
                )
                OnboardingButton(
                    text = "Приступить",
                    onClick = { },
                    modifier = Modifier
                        .padding(top = 48.dp)
                )
            }
        }
    }
}
package ks.heydrink.ui.onboarding.components

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ks.heydrink.ui.theme.MontserratAlternates

@Composable
fun TitleOnboardingTextStyle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = MontserratAlternates,
        textAlign = TextAlign.Center,
        modifier = modifier.wrapContentWidth()
    )
}
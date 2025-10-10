package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.BasicOnboardingTextStyle
import ks.heydrink.ui.onboarding.components.LoginInputField
import ks.heydrink.ui.onboarding.components.OnboardingButton
import ks.heydrink.ui.onboarding.components.TitleOnboardingTextStyle

@Composable
fun TakePassword(
    onFinishClick: () -> Unit,
    onBackClick: () -> Unit
) {
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background_gradient_second),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(start = 16.dp, top = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                tint = androidx.compose.ui.graphics.Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterVertically)
        ) {
            TitleOnboardingTextStyle(
                text = stringResource(id = R.string.take_password_title)
            )
            BasicOnboardingTextStyle(
                text = stringResource(id = R.string.take_password_description)
            )
            LoginInputField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier,
                hint = stringResource(id = R.string.take_password_hint)
            )
        }
        OnboardingButton(
            text = stringResource(id = R.string.onboarding_button_forward),
            onClick = onFinishClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp)
        )
    }
}

@Preview
@Composable
fun TakePasswordScreenPreview() {
    TakePassword(onFinishClick = {}, onBackClick = {})
}
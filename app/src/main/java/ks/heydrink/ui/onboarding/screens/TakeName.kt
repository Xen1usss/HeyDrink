package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import ks.heydrink.ui.onboarding.components.InputField
import ks.heydrink.ui.onboarding.components.OnboardingButton


@Composable
fun TakeName(
    onFinishClick: () -> Unit
) {

    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background_gradient_second),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterVertically)
        ) {
            BasicOnboardingTextStyle(
                text = stringResource(R.string.take_name_hint)
            )
            InputField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
            )
            OnboardingButton(
                text = stringResource(R.string.take_name_button),
                onClick = onFinishClick,
                modifier = Modifier
            )
        }
    }
}

@Preview
@Composable
fun TakeNameScreenPreview() {
    TakeName(onFinishClick = {})
}
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ks.heydrink.R
import ks.heydrink.domain.model.ChangeUsernameIntent
import ks.heydrink.domain.model.UsernameStep
import ks.heydrink.ui.onboarding.RegistrationViewModel
import ks.heydrink.ui.onboarding.components.BasicOnboardingTextStyle
import ks.heydrink.ui.onboarding.components.InputField
import ks.heydrink.ui.onboarding.components.OnboardingButton
import ks.heydrink.ui.onboarding.components.TitleOnboardingTextStyle
import ks.heydrink.ui.theme.MontserratAlternates
import ks.heydrink.ui.theme.colorDarkBlue


@Composable
fun TakeNameScreen(
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    currentState: UsernameStep,
    viewModel: RegistrationViewModel
) {

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
                tint = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
        ) {
            TitleOnboardingTextStyle(
                text = stringResource(id = R.string.take_name_title)
            )
            BasicOnboardingTextStyle(
                text = stringResource(id = R.string.take_name_description)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                InputField(
                    value = currentState.username,
                    onValueChange = { viewModel.onNewIntent(ChangeUsernameIntent(it)) },
                    hint = stringResource(id = R.string.take_name_hint)
                )
                if (currentState.isUsernameValid == false) {
                    Text(
                        text = "Не хватает буков"
                    )
                }
                TextButton(
                    onClick = { }
                ) {
                    Text(
                        text = stringResource(id = R.string.i_have_account),
                        color = colorDarkBlue,
                        style = TextStyle(
                            fontFamily = MontserratAlternates,
                            fontSize = 15.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
            }
        }
        OnboardingButton(
            text = stringResource(id = R.string.onboarding_button_forward),
            onClick = onNextClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp),
            enabled = currentState.isUsernameValid == true
        )
    }
}

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.BasicOnboardingTextStyle

@Composable
fun TakeAvatarScreen(
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background_gradient_third),
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

            BasicOnboardingTextStyle(
                text = stringResource(id = R.string.take_avatar_description)
            )
        }
    }
}

@Preview
@Composable
fun TakeAvatarScreenPreview() {
    TakeAvatarScreen(onNextClick = {}, onBackClick = {})
}


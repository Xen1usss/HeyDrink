package ks.heydrink.ui.onboarding.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ks.heydrink.R
import ks.heydrink.ui.onboarding.components.BasicOnboardingTextStyle
import ks.heydrink.ui.onboarding.components.OnboardingButton


@Composable
fun TakeAvatarScreen(
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {

    var selectedAvatarId by remember { mutableStateOf<Int?>(null) }

    // Список аватаров с их ID и ресурсами
    val avatars: List<Pair<Int, Int>> = listOf(
        Pair(1, R.drawable.ic_avatar_dolphin),
        Pair(2, R.drawable.ic_avatar_octopus),
        Pair(3, R.drawable.ic_avatar_seahorse),
        Pair(4, R.drawable.ic_avatar_turtle),
        Pair(5, R.drawable.ic_avatar_ray),
        Pair(6, R.drawable.ic_avatar_jellyfish)
    )

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
        ) {
            BasicOnboardingTextStyle(
                text = stringResource(R.string.take_avatar_description),
                modifier = Modifier)

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
                userScrollEnabled = false
            ) {
                items(avatars.size) { index ->
                    val (avatarId, avatarResId) = avatars[index]
                    AvatarItem(
                        avatarResId = avatarResId,
                        isSelected = selectedAvatarId == avatarId,
                        onClick = { selectedAvatarId = avatarId }
                    )
                }
            }
        }
        OnboardingButton(
            text = stringResource(id = R.string.onboarding_button_forward),
            onClick = onNextClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 140.dp)
        )
    }

}

@Composable
fun AvatarItem(
    avatarResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    //val backgroundColor = Color(0xFFE8F4F8)
    val borderColor = if (isSelected) Color(0xFF4A90E2) else Color.Transparent
    val borderWidth = if (isSelected) 3.dp else 0.dp

    Box(
        modifier = Modifier
            .size(107.dp)
            .clip(CircleShape)
            .border(BorderStroke(borderWidth, borderColor), CircleShape)
            //.background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = avatarResId),
            contentDescription = "Avatar",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TakeAvatarScreenPreview() {
    androidx.compose.material3.MaterialTheme {
        androidx.compose.material3.Surface {  // <-- Добавили Surface
            TakeAvatarScreen(
                onNextClick = {},
                onBackClick = {}
            )
        }
    }
}

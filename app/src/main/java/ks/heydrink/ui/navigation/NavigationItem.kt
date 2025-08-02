package ks.heydrink.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ks.heydrink.R

sealed class NavigationItem(
    val route: String,
    @StringRes val titleResId: Int,
    @DrawableRes val iconResId: Int
) {

    object Home : NavigationItem(
        "home",
        titleResId = R.string.home_title,
        iconResId = R.drawable.ic_main
    )
    object Rating : NavigationItem(
        "rating",
        titleResId = R.string.rating_title,
        iconResId = R.drawable.ic_star
    )
    object Science : NavigationItem(
        "science",
        titleResId = R.string.research_title,
        iconResId = R.drawable.ic_research
    )
    object Profile : NavigationItem(
        "profile",
        titleResId = R.string.profile_title,
        iconResId = R.drawable.ic_person
    )
}
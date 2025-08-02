package ks.heydrink.ui.navigation

import ks.heydrink.R

sealed class NavigationItem(
    val route: String,
    val title: String,
    val iconResId: Int
) {

    object Home : NavigationItem(
        "home",
        "Главная",
        iconResId = R.drawable.ic_main
    )
    object Rating : NavigationItem(
        "rating",
        "Рейтинг",
        iconResId = R.drawable.ic_star
    )
    object Science : NavigationItem(
        "science",
        "Исследования",
        iconResId = R.drawable.ic_research
    )
    object Profile : NavigationItem(
        "profile",
        "Профиль",
        iconResId = R.drawable.ic_person
    )
}
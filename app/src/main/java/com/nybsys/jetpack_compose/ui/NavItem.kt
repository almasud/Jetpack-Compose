package com.nybsys.jetpack_compose.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nybsys.jetpack_compose.*

/**
 * Created by Md. Abdullah Al Masud on 24/11/22.
 * Email: dev.almasud@gmail.com
 */

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: BottomNavItem(R.string.home, R.drawable.ic_home, NAV_HOME)
    object Favorite: BottomNavItem(R.string.favorite, R.drawable.ic_favorite, NAV_FAVORITE)
    object Feed: BottomNavItem(R.string.feed, R.drawable.ic_dynamic_feed, NAV_FEED)
    object Profile: BottomNavItem(R.string.profile, R.drawable.ic_person, NAV_PROFILE)
}
package com.masdika.fighterrankcompose.data.source

import android.content.Context
import com.masdika.fighterrankcompose.R
import com.masdika.fighterrankcompose.data.model.SocialMediaItem
import com.masdika.fighterrankcompose.ui.components.icons.EmailIcon
import com.masdika.fighterrankcompose.ui.components.icons.GithubIcon
import com.masdika.fighterrankcompose.ui.components.icons.InstagramIcon
import com.masdika.fighterrankcompose.ui.components.icons.LinkedinIcon

fun loadSocialMediaItems(context: Context): List<SocialMediaItem> {
    val r = context.resources
    val socialMediaItemList = listOf(
        SocialMediaItem(
            icon = EmailIcon,
            socialMediaName = r.getString(R.string.email),
            socialMediaAccount = r.getString(R.string.email_address),
        ),
        SocialMediaItem(
            icon = LinkedinIcon,
            socialMediaName = r.getString(R.string.linkedin),
            socialMediaAccount = r.getString(R.string.linkedin_username),
            url = r.getString(R.string.linkedin_url)
        ),
        SocialMediaItem(
            icon = GithubIcon,
            socialMediaName = r.getString(R.string.github),
            socialMediaAccount = r.getString(R.string.github_username),
            url = r.getString(R.string.github_url)
        ),
        SocialMediaItem(
            icon = InstagramIcon,
            socialMediaName = r.getString(R.string.instagram),
            socialMediaAccount = r.getString(R.string.instagram_username),
            url = r.getString(R.string.instagram_url)
        )
    )
    return socialMediaItemList
}
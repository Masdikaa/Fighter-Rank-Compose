package com.masdika.fighterrankcompose.data.source

import com.masdika.fighterrankcompose.data.model.SocialMediaItem
import com.masdika.fighterrankcompose.ui.components.icons.EmailIcon
import com.masdika.fighterrankcompose.ui.components.icons.GithubIcon
import com.masdika.fighterrankcompose.ui.components.icons.InstagramIcon
import com.masdika.fighterrankcompose.ui.components.icons.LinkedinIcon

object SocialMediaDataProvider {
    val socialMediaItems =
        listOf(
            SocialMediaItem(
                icon = EmailIcon,
                socialMediaName = "Email",
                socialMediaAccount = "masdikailhanmansiz@gmail.com"
            ),
            SocialMediaItem(
                icon = LinkedinIcon,
                socialMediaName = "LinkedIn",
                socialMediaAccount = "Masdika Ilhan Mansiz",
                url = "https://www.linkedin.com/in/masdikailhanmansiz"
            ),
            SocialMediaItem(
                icon = GithubIcon,
                socialMediaName = "GitHub",
                socialMediaAccount = "Masdikaa",
                url = "https://github.com/Masdikaa"

            ),
            SocialMediaItem(
                icon = InstagramIcon,
                socialMediaName = "Instagram",
                socialMediaAccount = "@masdikailhannn",
                url = "https://www.instagram.com/masdikailhannn"
            )
        )
}
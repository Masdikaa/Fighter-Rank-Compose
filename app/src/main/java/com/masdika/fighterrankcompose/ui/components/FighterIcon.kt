package com.masdika.fighterrankcompose.ui.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.masdika.fighterrankcompose.ui.theme.FighterRankComposeTheme
import com.masdika.fighterrankcompose.ui.theme.MainRed

@Suppress("ObjectPropertyName")
private var _FighterIcon: ImageVector? = null
val FighterIcon: ImageVector
    get() {
        if (_FighterIcon != null) {
            return _FighterIcon!!
        }
        _FighterIcon = ImageVector.Builder(
            name = "FighterIcon",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 540f,
            viewportHeight = 540f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(133f, 71f)
                    lineTo(429f, 71f)
                    lineTo(429f, 500.09f)
                    lineTo(133f, 500.09f)
                    close()
                    moveTo(133f, 71f)
                }
            ) {
                path(
                    fill = SolidColor(MainRed),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(257.77f, 150.66f)
                    curveTo(258.05f, 149.46f, 258.88f, 147.56f, 259.53f, 147.93f)
                    curveTo(260.19f, 148.3f, 264.45f, 152.59f, 267.97f, 153.04f)
                    curveTo(271.5f, 153.5f, 273.26f, 149.21f, 273.71f, 147.85f)
                    curveTo(274.17f, 146.48f, 273.91f, 145.46f, 275.85f, 145.12f)
                    curveTo(277.78f, 144.75f, 278.8f, 143.84f, 278.92f, 143.3f)
                    curveTo(279f, 142.77f, 279.12f, 142.48f, 279.66f, 142.57f)
                    curveTo(280.22f, 142.65f, 280.96f, 143.48f, 281.7f, 142.57f)
                    curveTo(282.44f, 141.66f, 283.38f, 138.28f, 284.03f, 138.08f)
                    curveTo(284.69f, 137.91f, 286.62f, 139.36f, 289.41f, 139.9f)
                    curveTo(292.19f, 140.44f, 293.21f, 138.71f, 293.38f, 136.8f)
                    curveTo(293.58f, 134.88f, 293.02f, 127.21f, 294.04f, 125.68f)
                    curveTo(295.06f, 124.12f, 297.65f, 124.48f, 298.39f, 121.68f)
                    curveTo(299.13f, 118.84f, 302.57f, 110.63f, 302.93f, 103.51f)
                    curveTo(303.3f, 96.38f, 299.98f, 83.98f, 293.1f, 77.96f)
                    curveTo(286.25f, 71.94f, 272.32f, 68.65f, 260.1f, 74.3f)
                    curveTo(247.85f, 79.95f, 245.63f, 91.81f, 244.72f, 95.47f)
                    curveTo(243.79f, 99.14f, 242.14f, 103.14f, 239.89f, 107.34f)
                    curveTo(237.68f, 111.54f, 235.06f, 113.36f, 235.06f, 113.36f)
                    curveTo(235.06f, 113.36f, 225.79f, 108.08f, 215.02f, 115f)
                    curveTo(204.28f, 121.93f, 197.97f, 127.78f, 195.75f, 139.47f)
                    curveTo(193.54f, 151.17f, 192.8f, 162.46f, 192.05f, 167.95f)
                    curveTo(191.32f, 173.42f, 189.84f, 179.64f, 189.84f, 182.2f)
                    curveTo(189.84f, 184.75f, 189.27f, 204.11f, 193.73f, 221.99f)
                    curveTo(198.2f, 239.88f, 202.26f, 244.45f, 206.89f, 250.29f)
                    curveTo(211.53f, 256.14f, 216.16f, 280.95f, 216.16f, 280.95f)
                    curveTo(216.16f, 280.95f, 212.83f, 290.43f, 213f, 297.93f)
                    curveTo(213.2f, 305.42f, 213.74f, 303.41f, 215.05f, 309.43f)
                    curveTo(216.36f, 315.44f, 216.16f, 313.63f, 215.79f, 318.73f)
                    curveTo(215.42f, 323.84f, 209.31f, 347.57f, 208.2f, 354.5f)
                    curveTo(207.09f, 361.43f, 206.35f, 360.89f, 205.05f, 366.74f)
                    curveTo(203.74f, 372.59f, 203.2f, 373.13f, 202.26f, 375.51f)
                    curveTo(201.32f, 377.89f, 199.11f, 378.6f, 200.58f, 380.25f)
                    curveTo(202.06f, 381.89f, 203f, 383.91f, 203f, 383.91f)
                    curveTo(203f, 383.91f, 195.58f, 413.66f, 194.47f, 424.62f)
                    curveTo(193.36f, 435.57f, 193f, 438.13f, 192.05f, 438.13f)
                    curveTo(191.12f, 438.13f, 174.26f, 444.88f, 167.39f, 459.14f)
                    curveTo(160.54f, 473.39f, 162.18f, 480.85f, 159.6f, 490.73f)
                    curveTo(157.01f, 500.58f, 154.03f, 508.61f, 151.44f, 513.92f)
                    curveTo(148.85f, 519.2f, 146.61f, 519.03f, 146.24f, 522.69f)
                    curveTo(145.87f, 526.36f, 145.3f, 526.89f, 144.93f, 528.34f)
                    curveTo(144.56f, 529.79f, 139.93f, 546.96f, 136.4f, 552.61f)
                    curveTo(132.88f, 558.26f, 133.25f, 561.02f, 133.45f, 563.37f)
                    curveTo(133.65f, 565.75f, 134.39f, 566.01f, 134.64f, 568.93f)
                    curveTo(134.9f, 571.86f, 134.64f, 572.03f, 135.75f, 572.48f)
                    curveTo(136.86f, 572.94f, 137.23f, 572.77f, 137.23f, 572.77f)
                    curveTo(137.23f, 572.77f, 136.43f, 575.41f, 137.6f, 576.88f)
                    curveTo(138.76f, 578.33f, 139.27f, 578.47f, 139.27f, 578.47f)
                    curveTo(139.27f, 578.47f, 138.39f, 581.17f, 139.59f, 582.16f)
                    curveTo(140.78f, 583.16f, 141.07f, 583.16f, 141.07f, 583.16f)
                    curveTo(141.07f, 583.16f, 140.13f, 585.26f, 142.37f, 586.36f)
                    curveTo(144.59f, 587.47f, 145.61f, 586.65f, 145.61f, 586.65f)
                    curveTo(145.61f, 586.65f, 146.81f, 589.12f, 150.98f, 589.57f)
                    curveTo(155.16f, 590.03f, 158.04f, 586.11f, 158.32f, 582.45f)
                    curveTo(158.6f, 578.79f, 159.06f, 575.78f, 160.36f, 573.22f)
                    curveTo(161.67f, 570.66f, 164.54f, 565.84f, 163.43f, 558.71f)
                    curveTo(162.32f, 551.59f, 161.96f, 546.85f, 163.43f, 543.19f)
                    curveTo(164.91f, 539.53f, 165.65f, 540.63f, 165.48f, 537.17f)
                    curveTo(165.31f, 533.71f, 165.85f, 531.32f, 165.85f, 531.32f)
                    curveTo(165.85f, 531.32f, 168.64f, 526.75f, 169.75f, 522.38f)
                    curveTo(170.85f, 518.01f, 182.16f, 499.76f, 192.54f, 489.51f)
                    curveTo(202.91f, 479.29f, 205.53f, 467.42f, 206.44f, 466.14f)
                    curveTo(207.38f, 464.87f, 223.49f, 456.1f, 228.13f, 444.97f)
                    curveTo(232.76f, 433.84f, 241.48f, 410.11f, 248.16f, 395.49f)
                    curveTo(254.84f, 380.9f, 259.28f, 371.76f, 259.28f, 371.76f)
                    curveTo(259.28f, 371.76f, 275.96f, 367.02f, 277.81f, 362.62f)
                    curveTo(279.66f, 358.25f, 281.13f, 349.85f, 283.38f, 346.18f)
                    curveTo(285.6f, 342.52f, 285.96f, 332.67f, 290.8f, 330.49f)
                    curveTo(295.63f, 328.3f, 312.68f, 328.3f, 320.1f, 329.04f)
                    curveTo(327.52f, 329.78f, 331.59f, 331.59f, 332.35f, 329.41f)
                    curveTo(333.09f, 327.22f, 334.57f, 322.11f, 334.57f, 322.11f)
                    lineTo(347.56f, 321.2f)
                    curveTo(347.56f, 321.2f, 334.57f, 335.8f, 331.61f, 339.66f)
                    curveTo(328.66f, 343.49f, 327.52f, 344.77f, 323.46f, 344.59f)
                    curveTo(319.36f, 344.43f, 307.71f, 342.21f, 305.09f, 347.32f)
                    curveTo(302.51f, 352.43f, 303.79f, 359.55f, 306.57f, 363.02f)
                    curveTo(309.36f, 366.48f, 310.1f, 368.13f, 310.84f, 369.95f)
                    curveTo(311.57f, 371.76f, 308.25f, 378.35f, 307.68f, 388.73f)
                    curveTo(307.11f, 399.15f, 310.84f, 400.97f, 310.84f, 402.98f)
                    curveTo(310.84f, 405f, 313.25f, 408.46f, 315.67f, 409f)
                    curveTo(318.08f, 409.54f, 318.63f, 405f, 318.63f, 405f)
                    curveTo(318.63f, 405f, 320.47f, 402.08f, 320.3f, 399.15f)
                    curveTo(320.1f, 396.23f, 320.1f, 395.49f, 320.5f, 394.04f)
                    curveTo(320.87f, 392.6f, 335.34f, 369.57f, 340.91f, 362.82f)
                    curveTo(346.48f, 356.06f, 355.18f, 348.94f, 357.79f, 346.38f)
                    curveTo(360.38f, 343.83f, 373.17f, 334.52f, 383.2f, 329.04f)
                    curveTo(393.21f, 323.56f, 392.84f, 327.22f, 404.71f, 319.19f)
                    curveTo(416.57f, 311.16f, 417.71f, 306.05f, 421.77f, 300.57f)
                    curveTo(425.86f, 295.09f, 429.19f, 291.43f, 428.45f, 282.68f)
                    curveTo(427.71f, 273.91f, 424.36f, 271.36f, 414.35f, 268.43f)
                    curveTo(404.35f, 265.51f, 368.73f, 263.69f, 365.41f, 262.59f)
                    curveTo(362.08f, 261.48f, 353.93f, 261.85f, 348.72f, 263.32f)
                    curveTo(343.52f, 264.77f, 331.3f, 264.77f, 331.3f, 264.77f)
                    lineTo(321.66f, 265.51f)
                    curveTo(321.66f, 265.51f, 318.14f, 257.84f, 314.98f, 256.74f)
                    curveTo(311.83f, 255.63f, 308.68f, 256.91f, 307.2f, 256.91f)
                    curveTo(305.72f, 256.91f, 299.98f, 255.8f, 299.98f, 255.8f)
                    curveTo(299.98f, 255.8f, 298.3f, 250.86f, 296.45f, 248.31f)
                    curveTo(294.61f, 245.75f, 292.93f, 242.46f, 292.93f, 242.46f)
                    curveTo(292.93f, 242.46f, 293.67f, 237.52f, 294.61f, 236.81f)
                    curveTo(295.54f, 236.07f, 302.39f, 232.81f, 308.14f, 231.33f)
                    curveTo(313.88f, 229.88f, 312.4f, 232.24f, 319.45f, 229.15f)
                    curveTo(326.5f, 226.05f, 330.56f, 225.14f, 335.2f, 218.56f)
                    curveTo(339.83f, 211.97f, 333.71f, 198.29f, 328.71f, 193.18f)
                    curveTo(323.71f, 188.07f, 320.55f, 187.53f, 317.03f, 188.24f)
                    curveTo(313.51f, 188.98f, 309.44f, 192.07f, 307.2f, 194.26f)
                    curveTo(304.98f, 196.45f, 306.26f, 197.55f, 302.73f, 197.55f)
                    curveTo(299.21f, 197.55f, 295.89f, 197.55f, 293.27f, 199.94f)
                    curveTo(290.68f, 202.32f, 286.79f, 204.88f, 286.79f, 204.88f)
                    lineTo(286.36f, 201.24f)
                    curveTo(286.36f, 201.24f, 291.73f, 196.87f, 292.67f, 196.67f)
                    curveTo(293.61f, 196.5f, 298.41f, 196.67f, 302.68f, 193.95f)
                    curveTo(306.94f, 191.22f, 313.25f, 184.64f, 314.56f, 183.73f)
                    curveTo(315.87f, 182.82f, 324.02f, 177.14f, 328.46f, 175.86f)
                    curveTo(332.92f, 174.59f, 333.66f, 175.86f, 340.31f, 171.13f)
                    curveTo(346.99f, 166.38f, 349.41f, 156.34f, 347.53f, 153.04f)
                    curveTo(345.68f, 149.75f, 335.68f, 134.96f, 327.89f, 133.51f)
                    curveTo(320.1f, 132.07f, 316.21f, 136.61f, 312.51f, 136.61f)
                    curveTo(308.82f, 136.61f, 304.36f, 137.14f, 299.15f, 141.71f)
                    curveTo(293.95f, 146.29f, 292.47f, 149.38f, 293.58f, 154.32f)
                    curveTo(294.69f, 159.26f, 294.32f, 160.17f, 294.32f, 160.17f)
                    curveTo(294.32f, 160.17f, 285.96f, 163.83f, 282.44f, 167.09f)
                    curveTo(278.92f, 170.39f, 278.18f, 173.68f, 277.61f, 174.96f)
                    curveTo(277.04f, 176.23f, 274.82f, 175.32f, 274.82f, 175.32f)
                    curveTo(274.82f, 175.32f, 275.02f, 172.03f, 269.99f, 165.64f)
                    curveTo(264.99f, 159.26f, 260.36f, 158.15f, 259.62f, 156.5f)
                    curveTo(258.91f, 154.86f, 257.77f, 150.66f, 257.77f, 150.66f)
                    close()
                    moveTo(257.77f, 150.66f)
                }
            }
            group(
                clipPathData = PathData {
                    moveTo(0.5f, 0f)
                    lineTo(539.5f, 0f)
                    lineTo(539.5f, 539f)
                    lineTo(0.5f, 539f)
                    close()
                    moveTo(0.5f, 0f)
                }
            ) {
            }
            group(
                clipPathData = PathData {
                    moveTo(270f, 0f)
                    curveTo(121.16f, 0f, 0.5f, 120.66f, 0.5f, 269.5f)
                    curveTo(0.5f, 418.34f, 121.16f, 539f, 270f, 539f)
                    curveTo(418.84f, 539f, 539.5f, 418.34f, 539.5f, 269.5f)
                    curveTo(539.5f, 120.66f, 418.84f, 0f, 270f, 0f)
                    close()
                    moveTo(270f, 0f)
                }
            ) {
                path(
                    stroke = SolidColor(MainRed),
                    strokeLineWidth = 70f
                ) {
                    moveTo(270f, -0f)
                    curveTo(121.16f, -0f, 0.5f, 120.66f, 0.5f, 269.5f)
                    curveTo(0.5f, 418.34f, 121.16f, 539f, 270f, 539f)
                    curveTo(418.84f, 539f, 539.5f, 418.34f, 539.5f, 269.5f)
                    curveTo(539.5f, 120.66f, 418.84f, -0f, 270f, -0f)
                    close()
                    moveTo(270f, -0f)
                }
            }
        }.build()

        return _FighterIcon!!
    }

@Preview(showBackground = true)
@Composable
private fun FighterIconPreview() {
    FighterRankComposeTheme {
        Icon(
            imageVector = FighterIcon,
            contentDescription = null
        )
    }
}


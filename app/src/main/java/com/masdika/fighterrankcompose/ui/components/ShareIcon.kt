import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("ObjectPropertyName")
private var _ShareIcon: ImageVector? = null

val ShareIcon: ImageVector
    get() {
        if (_ShareIcon != null) {
            return _ShareIcon!!
        }
        _ShareIcon = ImageVector.Builder(
            name = "Share",
            defaultWidth = 100.dp,
            defaultHeight = 100.dp,
            viewportWidth = 100f,
            viewportHeight = 5f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(453.34f, 512f)
                lineTo(58.67f, 512f)
                curveToRelative(-32.36f, 0f, -58.66f, -26.31f, -58.66f, -58.66f)
                lineTo(0f, 144f)
                curveToRelative(0f, -32.36f, 26.3f, -58.66f, 58.66f, -58.66f)
                horizontalLineToRelative(74.67f)
                curveToRelative(8.83f, 0f, 16f, 7.17f, 16f, 16f)
                reflectiveCurveToRelative(-7.17f, 16f, -16f, 16f)
                lineTo(58.67f, 117.34f)
                curveToRelative(-14.7f, 0f, -26.66f, 11.97f, -26.66f, 26.66f)
                lineTo(32f, 453.34f)
                curveToRelative(0f, 14.69f, 11.97f, 26.66f, 26.66f, 26.66f)
                horizontalLineToRelative(394.67f)
                curveToRelative(14.7f, 0f, 26.67f, -11.97f, 26.67f, -26.66f)
                lineTo(480f, 272f)
                curveToRelative(0f, -8.83f, 7.17f, -16f, 16f, -16f)
                reflectiveCurveToRelative(16f, 7.17f, 16f, 16f)
                lineTo(512f, 453.34f)
                curveToRelative(0f, 32.36f, -26.31f, 58.66f, -58.67f, 58.66f)
                close()
                moveTo(453.34f, 512f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(143.98f, 341.06f)
                arcToRelative(
                    14.09f,
                    14.09f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -3.52f,
                    -0.43f
                )
                curveToRelative(-7.23f, -1.68f, -12.46f, -7.87f, -12.46f, -15.29f)
                verticalLineToRelative(-32f)
                curveToRelative(0f, -114.69f, 93.31f, -208f, 208f, -208f)
                horizontalLineToRelative(5.33f)
                lineTo(341.34f, 16f)
                arcToRelative(
                    16.02f,
                    16.02f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    10.03f,
                    -14.85f
                )
                arcToRelative(
                    15.98f,
                    15.98f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    17.49f,
                    3.75f
                )
                lineToRelative(138.67f, 144f)
                curveToRelative(5.97f, 6.19f, 5.97f, 16f, 0f, 22.19f)
                lineToRelative(-138.67f, 144f)
                curveToRelative(-4.52f, 4.72f, -11.5f, 6.17f, -17.49f, 3.75f)
                arcToRelative(
                    16.02f,
                    16.02f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = true,
                    -10.03f,
                    -14.85f
                )
                verticalLineToRelative(-69.33f)
                horizontalLineToRelative(-25.34f)
                curveToRelative(-67.11f, 0f, -127.43f, 37.29f, -157.42f, 97.3f)
                curveToRelative(-2.75f, 5.55f, -8.53f, 9.09f, -14.59f, 9.09f)
                close()
                moveTo(336f, 117.34f)
                curveToRelative(-89.6f, 0f, -163.8f, 67.31f, -174.66f, 154.02f)
                curveToRelative(38.78f, -43.26f, 94.4f, -68.69f, 154.64f, -68.69f)
                horizontalLineToRelative(41.34f)
                curveToRelative(8.83f, 0f, 16f, 7.17f, 16f, 16f)
                verticalLineToRelative(45.65f)
                lineToRelative(100.46f, -104.32f)
                lineToRelative(-100.46f, -104.32f)
                verticalLineToRelative(45.66f)
                curveToRelative(0f, 8.83f, -7.17f, 16f, -16f, 16f)
                close()
                moveTo(336f, 117.34f)
            }
        }.build()

        return _ShareIcon!!
    }
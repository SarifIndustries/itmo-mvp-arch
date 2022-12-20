package temple.ground.itmomvp.base

import android.view.View

fun View.setVisible(isVisible: Boolean) {
    if (isVisible) {
        visibility = View.VISIBLE
    } else {
        visibility = View.INVISIBLE
    }
}
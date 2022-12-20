package temple.ground.itmomvp.base

import android.app.Application
import java.util.concurrent.Executor

class ItmoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        // Do smt
        //
        f {
            ///.....
        }
        this.apply {

        }
    }

    inline fun f(lam: () -> Unit) {
        //d
    }

    fun d(lam: () -> Unit) {
        lam.invoke()
        if (5.isGreaterThanZero()) {

        }
    }
}

fun Int.isGreaterThanZero(): Boolean {
    return this > 0
}

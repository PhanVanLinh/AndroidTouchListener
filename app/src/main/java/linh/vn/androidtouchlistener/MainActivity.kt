package linh.vn.androidtouchlistener

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.view.MotionEvent

/**
 *  val ACTION_DOWN = 0
 *  val ACTION_UP = 1
 *  val ACTION_MOVE = 2
 *  val ACTION_CANCEL = 3
 */
class MainActivity : AppCompatActivity() {
    val TAG = "TAG"

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<LinearLayout>(R.id.linearlayout_root).setOnTouchListener { v, event ->
            Log.i(TAG, "LinearLayout onTouch event " + getDisplayAction(event.action))
            true
        }

        findViewById<Button>(R.id.button_click).setOnTouchListener { v, event ->
            Log.i(TAG, "Button onTouch event " + getDisplayAction(event.action))
            false
        }

        findViewById<TextView>(R.id.textview_click).setOnTouchListener { v, event ->
            Log.i(TAG, "TextView onTouch event " + getDisplayAction(event.action))
            false
        }
    }

    private fun getDisplayAction(action: Int): String {
        return when (action) {
            MotionEvent.ACTION_DOWN -> "DOWN"
            MotionEvent.ACTION_MOVE -> "MOVE"
            MotionEvent.ACTION_UP -> "UP"
            MotionEvent.ACTION_CANCEL -> "CANCEL"
            MotionEvent.ACTION_OUTSIDE -> "OUTSIDE"
            else -> "UNKNOWN"
        }
    }
}

package alexander.skornyakov.generalapplication.ui.start

import alexander.skornyakov.generalapplication.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import alexander.skornyakov.generalapplication.ui.start.first.FirstFragment

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commitNow()
        }
    }


}

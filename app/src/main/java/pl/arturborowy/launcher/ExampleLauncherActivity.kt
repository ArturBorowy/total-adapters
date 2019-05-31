package pl.arturborowy.launcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_example_launcher.*
import org.jetbrains.anko.startActivity
import pl.arturborowy.R
import pl.arturborowy.examples.recyclerview.base.BaseRecyclerAdapterExampleActivity
import pl.arturborowy.examples.recyclerview.clickable.ClickableViewRecyclerAdapterExampleActivity

class ExampleLauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_launcher)

        showExampleBtn.setOnClickListener { showExample() }
    }

    private fun showExample() {
        val isRecyclerViewChecked = recyclerViewRadio.isChecked
        val isGridViewChecked = gridViewRadio.isChecked

        val isBaseChecked = baseAdapterRadio.isChecked
        val isClickableViewChecked = clickableViewAdapterRadio.isChecked
        val isWholeViewClickableChecked = wholeViewClickableAdapterRadio.isChecked

        when {
            isRecyclerViewChecked -> showRecyclerViewExample(isBaseChecked,
                    isClickableViewChecked, isWholeViewClickableChecked)
            isGridViewChecked -> showGridViewExample(isBaseChecked,
                    isClickableViewChecked, isWholeViewClickableChecked)
        }
    }

    private fun showRecyclerViewExample(isBaseChecked: Boolean,
                                        isClickableViewChecked: Boolean,
                                        isWholeViewClickableChecked: Boolean) {
        when {
            isBaseChecked -> startActivity<BaseRecyclerAdapterExampleActivity>()
            isClickableViewChecked ->
                startActivity<ClickableViewRecyclerAdapterExampleActivity>()
            isWholeViewClickableChecked -> TODO()
        }
    }

    private fun showGridViewExample(isBaseChecked: Boolean,
                                    isClickableViewChecked: Boolean,
                                    isWholeViewClickableChecked: Boolean) {
        when {
            isBaseChecked -> TODO()
            isClickableViewChecked -> TODO()
            isWholeViewClickableChecked -> TODO()
        }
    }
}
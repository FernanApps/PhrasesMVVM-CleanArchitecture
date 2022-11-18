package practice.phrases.mvvm.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import practice.phrases.mvvm.R

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity(){

    protected val binding: VB by lazy {
        inflateViewBinding(layoutInflater)
    }
    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    abstract fun initObserves()
    abstract fun initActions()


}
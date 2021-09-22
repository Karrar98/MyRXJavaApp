package com.example.myrxjavaapp

import android.content.Context
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.myrxjavaapp.databinding.FragmentTopBinding
import io.reactivex.rxjava3.core.Observable
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit

class TopFragment : BaseFragment<FragmentTopBinding>() {

    override val LOG_TAG: String = "TOP_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentTopBinding =
        FragmentTopBinding::inflate
    private var listener: FragmentListener? = null

    override fun setup() {
        val observable = Observable.create<String> { emitter ->
            binding?.inputData?.doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())
            }
        }.debounce(1500, TimeUnit.MILLISECONDS)
        observable.subscribe { t ->
            listener?.onInputSent(t)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
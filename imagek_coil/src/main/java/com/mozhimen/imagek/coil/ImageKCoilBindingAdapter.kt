package com.mozhimen.imagek.coil

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mozhimen.basick.utilk.android.util.dp2px

/**
 * @ClassName ImageKCoilBindingAdapter
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/16
 * @Version 1.0
 */
object ImageKCoilBindingAdapter {
    @JvmStatic
    @BindingAdapter(value = ["loadImageWhenCoil", "loadImageWhenCoil_statusTrue", "loadImageWhenCoil_statusFalse"], requireAll = true)
    fun loadImageWhenCoil(imageView: ImageView, loadImageWhenCoil: Boolean, loadImageWhenCoil_statusTrue: Any, loadImageWhenCoil_statusFalse: Any) {
        if (loadImageWhenCoil) {
            ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil_statusTrue)
        } else {
            ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil_statusFalse)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageWhenCoil2", "loadImageWhenCoil2_condition2", "loadImageWhenCoil2_status1", "loadImageWhenCoil2_status2", "loadImageWhenCoil2_status3", "loadImageWhenCoil2_status4"], requireAll = true)
    fun loadImageWhenCoil2(
        imageView: ImageView,
        loadImageWhenCoil2: Boolean,
        loadImageWhenCoil2_condition2: Boolean,
        loadImageWhenCoil2_status1: Any,
        loadImageWhenCoil2_status2: Any,
        loadImageWhenCoil2_status3: Any,
        loadImageWhenCoil2_status4: Any
    ) {
        when {
            loadImageWhenCoil2 && loadImageWhenCoil2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil2_status1)
            loadImageWhenCoil2 && !loadImageWhenCoil2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil2_status2)
            !loadImageWhenCoil2 && loadImageWhenCoil2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil2_status3)
            !loadImageWhenCoil2 && !loadImageWhenCoil2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhenCoil2_status4)
        }
    }

    @JvmStatic
    @BindingAdapter("loadImageCoil")
    fun loadImageCoil(imageView: ImageView, loadImageCoil: Any) {
        ImageKCoil.loadImageCoil(imageView, loadImageCoil)
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageBlurCoil", "placeholder"], requireAll = true)
    fun loadImageBlurCoil(imageView: ImageView, loadImageBlurCoil: Any, placeholder: Int) {
        ImageKCoil.loadImageBlurCoil(imageView, loadImageBlurCoil, placeholder)
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageRoundedCornerCoil", "roundedCornerRadius"], requireAll = true)
    fun loadImageRoundedCornerCoil(imageView: ImageView, loadImageRoundedCornerCoil: Any, roundedCornerRadius: Int) {
        ImageKCoil.loadImageRoundedCornerCoil(imageView, loadImageRoundedCornerCoil, roundedCornerRadius.dp2px())
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageRoundedCornerCoil", "roundedCornerRadius"], requireAll = true)
    fun loadImageRoundedCornerCoil(imageView: ImageView, loadImageRoundedCornerCoil: Any, roundedCornerRadius: Float) {
        ImageKCoil.loadImageRoundedCornerCoil(imageView, loadImageRoundedCornerCoil, roundedCornerRadius.dp2px())
    }
}
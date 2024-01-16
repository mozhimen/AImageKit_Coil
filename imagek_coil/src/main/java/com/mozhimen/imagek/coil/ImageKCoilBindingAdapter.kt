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
    @BindingAdapter(value = ["loadImageWhen", "loadImageWhen_statusTrue", "loadImageWhen_statusFalse"], requireAll = true)
    fun loadImageWhen(imageView: ImageView, loadImageWhen: Boolean, loadImageWhen_statusTrue: Any, loadImageWhen_statusFalse: Any) {
        if (loadImageWhen) {
            ImageKCoil.loadImageCoil(imageView, loadImageWhen_statusTrue)
        } else {
            ImageKCoil.loadImageCoil(imageView, loadImageWhen_statusFalse)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageWhen2", "loadImageWhen2_condition2", "loadImageWhen2_status1", "loadImageWhen2_status2", "loadImageWhen2_status3", "loadImageWhen2_status4"], requireAll = true)
    fun loadImageWhen2(
        imageView: ImageView,
        loadImageWhen2: Boolean,
        loadImageWhen2_condition2: Boolean,
        loadImageWhen2_status1: Any,
        loadImageWhen2_status2: Any,
        loadImageWhen2_status3: Any,
        loadImageWhen2_status4: Any
    ) {
        when {
            loadImageWhen2 && loadImageWhen2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhen2_status1)
            loadImageWhen2 && !loadImageWhen2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhen2_status2)
            !loadImageWhen2 && loadImageWhen2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhen2_status3)
            !loadImageWhen2 && !loadImageWhen2_condition2 -> ImageKCoil.loadImageCoil(imageView, loadImageWhen2_status4)
        }
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(imageView: ImageView, res: Any) {
        ImageKCoil.loadImageCoil(imageView, res)
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageBlur", "placeholder"], requireAll = true)
    fun loadImageBlur(imageView: ImageView, res: Any, placeholder: Int) {
        ImageKCoil.loadImageBlurCoil(imageView, res, placeholder)
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageRoundedCorner", "roundedCornerRadius"], requireAll = true)
    fun loadImageRoundedCorner(imageView: ImageView, res: Any, roundedCornerRadius: Int) {
        ImageKCoil.loadImageRoundedCornerCoil(imageView, res, roundedCornerRadius.dp2px())
    }

    @JvmStatic
    @BindingAdapter(value = ["loadImageRoundedCorner", "roundedCornerRadius"], requireAll = true)
    fun loadImageRoundedCorner(imageView: ImageView, res: Any, roundedCornerRadius: Float) {
        ImageKCoil.loadImageRoundedCornerCoil(imageView, res, roundedCornerRadius.dp2px())
    }
}
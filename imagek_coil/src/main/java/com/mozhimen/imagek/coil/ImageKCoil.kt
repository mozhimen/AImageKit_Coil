package com.mozhimen.imagek.coil

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.annotation.Px
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.mozhimen.imagek.coil.cons.CCoilBlurCons
import com.mozhimen.basick.manifestk.cons.CPermission
import com.mozhimen.basick.manifestk.annors.AManifestKRequire
import com.mozhimen.imagek.coil.temps.BlurTransformation
import com.mozhimen.imagek.coil.temps.ColorFilterTransformation
import com.mozhimen.imagek.coil.temps.CropTransformation
import com.mozhimen.imagek.coil.temps.GrayscaleTransformation
import com.mozhimen.basick.utilk.android.util.dp2px

/**
 * @ClassName UtilKImageLoader
 * @Description TODO
 * @Author mozhimen / Kolin Zhao
 * @Date 2022/11/6 0:25
 * @Version 1.0
 */
fun ImageView.loadImageCoil(res: Any) {
    ImageKCoil.loadImageCoil(this, res)
}

fun ImageView.loadImageComplexCoil(
    res: Any, placeholder: Int, error: Int,
    crossFadeEnable: Boolean = true, crossFadeTime: Int = 1500
) {
    ImageKCoil.loadImageComplexCoil(this, res, placeholder, error, crossFadeEnable, crossFadeTime)
}

fun ImageView.loadImageBlurCoil(
    res: Any, placeholder: Int,
    crossFadeEnable: Boolean = true, crossFadeTime: Int = 1500,
    @FloatRange(from = 0.0, to = 25.0) radius: Float = CCoilBlurCons.RADIUS,
    @FloatRange(from = 0.0, to = Double.MAX_VALUE) sampling: Float = CCoilBlurCons.SAMPLING
) {
    ImageKCoil.loadImageBlurCoil(this, res, placeholder, crossFadeEnable, crossFadeTime, radius, sampling)
}

fun ImageView.loadImageGrayCoil(res: Any) {
    ImageKCoil.loadImageGrayCoil(this, res)
}

fun ImageView.loadImageColorFilterCoil(res: Any, @ColorInt color: Int) {
    ImageKCoil.loadImageColorFilterCoil(this, res, color)
}

fun ImageView.loadImageCircleCoil(res: Any) {
    ImageKCoil.loadImageCircleCoil(this, res)
}

fun ImageView.loadImageCircleComplexCoil(
    res: Any, placeholder: Int, error: Int,
    crossFadeEnable: Boolean = true, crossFadeTime: Int = 1000
) {
    ImageKCoil.loadImageCircleComplexCoil(this, res, placeholder, error, crossFadeEnable, crossFadeTime)
}

fun ImageView.loadImageRoundedCornerCoil(
    res: Any, @Px cornerRadius: Float = 6f.dp2px()
) {
    ImageKCoil.loadImageRoundedCornerCoil(this, res, cornerRadius)
}

fun ImageView.loadImageCropCoil(
    res: Any, cropType: CropTransformation.ECropType = CropTransformation.ECropType.CENTER
) {
    ImageKCoil.loadImageCropCoil(this, res, cropType)
}

object ImageKCoil {

    @JvmStatic
    fun loadImageCoil(imageView: ImageView, res: Any) {
        imageView.load(res)
    }

    @JvmStatic
    fun loadImageComplexCoil(
        imageView: ImageView, res: Any, placeholder: Int, error: Int,
        crossFadeEnable: Boolean = true,
        crossFadeTime: Int = 1000
    ) {
        imageView.load(res) {
            crossfade(crossFadeEnable)
            crossfade(crossFadeTime)
            placeholder(placeholder)
            error(error)
        }
    }

    /**
     * 加载高斯模糊图
     */
    @JvmStatic
    fun loadImageBlurCoil(
        imageView: ImageView, res: Any, placeholder: Int,
        crossFadeEnable: Boolean = true, crossFadeTime: Int = 1500,
        @FloatRange(from = 0.0, to = 25.0) radius: Float = CCoilBlurCons.RADIUS,
        @FloatRange(from = 0.0, to = Double.MAX_VALUE) sampling: Float = CCoilBlurCons.SAMPLING
    ) {
        imageView.load(res) {
            crossfade(crossFadeEnable)
            crossfade(crossFadeTime)
            placeholder(placeholder)
            transformations(BlurTransformation(imageView.context, radius, sampling))
        }
    }

    /**
     * 加载灰度图
     */
    @JvmStatic
    fun loadImageGrayCoil(imageView: ImageView, res: Any) {
        imageView.load(res) {
            transformations(GrayscaleTransformation())
        }
    }

    /**
     * 加载颜色过滤图片
     */
    @JvmStatic
    fun loadImageColorFilterCoil(imageView: ImageView, res: Any, @ColorInt color: Int) {
        imageView.load(res) {
            transformations(ColorFilterTransformation(color))
        }
    }

    /**
     * 加载圆形图片
     */
    @JvmStatic
    fun loadImageCircleCoil(imageView: ImageView, res: Any) {
        imageView.load(res) {
            transformations(CircleCropTransformation())
        }
    }

    /**
     * 加载圆形图片
     */
    @JvmStatic
    fun loadImageCircleComplexCoil(
        imageView: ImageView, res: Any, placeholder: Int, error: Int,
        crossFadeEnable: Boolean = true, crossFadeTime: Int = 1000
    ) {
        imageView.load(res) {
            transformations(CircleCropTransformation())
            crossfade(crossFadeEnable)
            crossfade(crossFadeTime)
            placeholder(placeholder)
            error(error)
        }
    }


    /**
     * 加载圆角图片
     */
    @JvmStatic
    fun loadImageRoundedCornerCoil(
        imageView: ImageView, res: Any,
        @Px roundedCornerRadius: Float = 6f.dp2px()
    ) {
        imageView.load(res) {
            transformations(RoundedCornersTransformation(roundedCornerRadius))
        }
    }

    /**
     * 加载裁剪图片
     */
    @JvmStatic
    fun loadImageCropCoil(
        imageView: ImageView, res: Any,
        cropType: CropTransformation.ECropType = CropTransformation.ECropType.CENTER
    ) {
        imageView.load(res) {
            transformations(CropTransformation(cropType))
        }
    }
}
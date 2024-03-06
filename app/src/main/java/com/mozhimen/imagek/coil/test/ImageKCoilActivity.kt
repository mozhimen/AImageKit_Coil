package com.mozhimen.imagek.coil.test

import android.os.Bundle
import com.mozhimen.basick.elemk.androidx.appcompat.bases.viewbinding.BaseActivityVB
import com.mozhimen.imagek.coil.loadImageCoil
import com.mozhimen.imagek.coil.test.databinding.ActivityImagekCoilBinding

class ImageKCoilActivity : BaseActivityVB<ActivityImagekCoilBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        vb.imagekCoilImg1.loadImageCoil(R.drawable.imagek_img_test)
    }
}
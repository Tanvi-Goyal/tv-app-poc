package com.embibe.app.embibetvapp.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import com.bumptech.glide.load.Key

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

import java.security.MessageDigest


class BlurTransformation @JvmOverloads constructor(
    private val radius: Int = MAX_RADIUS,
    private val sampling: Int = DEFAULT_DOWN_SAMPLING
) : BitmapTransformation() {

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap? {
        val width = toTransform.width
        val height = toTransform.height
        val scaledWidth = width / sampling
        val scaledHeight = height / sampling

        var bitmap: Bitmap? = pool.get(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888)

        setCanvasBitmapDensity(toTransform, bitmap!!)

        val canvas = Canvas(bitmap)
        canvas.scale(1 / sampling.toFloat(), 1 / sampling.toFloat())
        val paint = Paint()
        paint.flags = Paint.FILTER_BITMAP_FLAG
        canvas.drawBitmap(toTransform, 0f, 0f, paint)

        bitmap = FastBlur.blur(bitmap, radius, true)

        return bitmap
    }


    override fun toString(): String {
        return "BlurTransformation(radius=$radius, sampling=$sampling)"
    }

    override fun equals(o: Any?): Boolean {
        return o is BlurTransformation &&
                o.radius == radius &&
                o.sampling == sampling
    }

    override fun hashCode(): Int {
        return ID.hashCode() + radius * 1000 + sampling * 10
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update((ID + radius + sampling).toByteArray(Key.CHARSET))
    }

    private fun setCanvasBitmapDensity(toTransform: Bitmap, canvasBitmap: Bitmap) {
        canvasBitmap.density = toTransform.density
    }

    companion object {

        private val VERSION = 1
        private val ID = "jp.wasabeef.glide.transformations.BlurTransformation.$VERSION"

        private val MAX_RADIUS = 25
        private val DEFAULT_DOWN_SAMPLING = 1
    }
}


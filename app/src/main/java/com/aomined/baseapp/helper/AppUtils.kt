package com.aomined.baseapp.helper

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Base64
import android.view.View
import android.widget.ImageView
import android.widget.Toast.LENGTH_SHORT
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.squareup.picasso.Picasso
import es.dmoral.toasty.Toasty
import jp.wasabeef.picasso.transformations.BlurTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import java.io.File
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {

   fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t:T) -> Unit){
       liveData.observe(this){ obj ->
           obj?.let{
               t -> action(t)
           }
       }
   }

    fun String.toBitmap():Bitmap{
        val imageBytes = Base64.decode(this, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    /**
     * TOAST ==============================================================
     */
    fun Context.toastWarn(txt:String){
        Toasty.warning(this, txt, LENGTH_SHORT, true).show()
    }

    fun View.toastWarn(txt:String){
        Toasty.warning(this.context, txt, LENGTH_SHORT, true).show()
    }

    fun Context.toastSuccess(txt:String){
        Toasty.success(this, txt, LENGTH_SHORT, true).show()
    }


    /**
     * Change lottie anim easily
     */
    fun LottieAnimationView.changeTo(animId:Int, repeat:Int = LottieDrawable.INFINITE){
        setAnimation(context.getString(animId))
        repeatCount = repeat
        playAnimation()
    }

    /**
     * Time and date converters
     */

    fun Long.toDate(): String = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(this))

    fun Long.toTime(): String = SimpleDateFormat("h:mm a", Locale.getDefault()).format(Date(this)).uppercase()

    fun Long.toDateAndTime(): String = SimpleDateFormat("dd/MM/yyyy h:mm a", Locale.getDefault()).format(
        Date(this)
    ).uppercase()


    /**
     * Pixels to SP
     */
    fun Float.pixelsToSp(context: Context): Float {
        val screenPixelDensity = context.resources.displayMetrics.scaledDensity // scaled for SP
        return this / screenPixelDensity
    }

    /**
     * Pixels to DP
     */
    fun Float.pixelsToDp(context: Context): Float {
        val screenPixelDensity = context.resources.displayMetrics.density // scaled for DP
        return this / screenPixelDensity
    }

    fun ImageView.blur(context: Context?, res:Int) {
        Picasso.get().load(res)
            .fit()
            .transform(BlurTransformation(context, 24))
            .transform(RoundedCornersTransformation(10, 0))
            .into(this)
    }

    fun Drawable.toUri(context: Context):Uri{
        val uri =
            Uri.fromFile(File.createTempFile("temp_file_name", ".jpg", context.cacheDir))
        val outputStream = context.contentResolver.openOutputStream(uri)
        toBitmap().compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream?.close()
        return uri
    }


    fun <T> mutableListWithCapacity(capacity: Int): MutableList<T> =
        ArrayList(capacity)

    fun String.isNumeric(): Boolean {
        val r = replace(("[^\\d.]").toRegex(), "")
        return r.toDoubleOrNull() != null
    }
}
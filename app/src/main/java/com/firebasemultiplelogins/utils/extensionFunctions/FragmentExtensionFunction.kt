package com.firebasemultiplelogins.utils.extensionFunctions

import android.net.Uri
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import java.io.File


fun Fragment.showToast(msg: String) {
    Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
}

fun showDatePicker(callBack: (Long) -> Unit): MaterialDatePicker<Long> {
    val picker = MaterialDatePicker.Builder.datePicker()
        .setTitleText("Select date")
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build()


    picker.addOnPositiveButtonClickListener {
        callBack.invoke(it)
    }
    return picker
}

fun Fragment.goBack() {
    findNavController().navigateUp()
}

fun Fragment.createImageUri(id: String): Uri {
    requireActivity().apply {
        val image =
            File(applicationContext.filesDir, "$id-${System.currentTimeMillis()}.png")
        return FileProvider.getUriForFile(
            applicationContext,
            "com.firebasemultiplelogins.utils.fileProvider",
            image
        )
    }

}



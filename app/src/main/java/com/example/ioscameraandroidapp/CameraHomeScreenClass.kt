package com.example.ioscameraandroidapp

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.ioscameraandroidapp.databinding.CameraHomeScreenBinding
import com.example.ioscameraandroidapp.viewModel.ViewModelClass
import kotlinx.android.synthetic.main.beauty_mode.*
import kotlinx.android.synthetic.main.camera_home_screen.*
import kotlinx.android.synthetic.main.video.*
import java.io.File
import kotlin.properties.Delegates

class CameraHomeScreenClass : Fragment(R.layout.camera_home_screen) {
    companion object {
        val requestcode = 121
    }

    lateinit var photopath: String
    var camera: Camera? = null
    private val viewModeClass: ViewModelClass by activityViewModels()
    var preview: Preview? = null
    var imageCapture: ImageCapture? = null
    var cameraSelector: CameraSelector? = null
    private val REQUEST_PERMISSION = 100
    private val REQUEST_IMAGE_CAPTURE = 1
    private val REQUEST_PICK_IMAGE = 2

    //    private var lensFacing = CameraX.LensFacing.BACK
    var message: String = "hello my name mubashar"
    lateinit var binding: CameraHomeScreenBinding
    private var imageint by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.CAMERA
                )
            } == PERMISSION_GRANTED) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                0
            )

            if (context?.let {
                    ContextCompat.checkSelfPermission(
                        it,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                } == PERMISSION_GRANTED) {
                makeText(context, "file permission ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModeClass.beautyImages.observe(viewLifecycleOwner, { beautyImage ->
            binding.beautymodeid.setBackgroundResource(beautyImage)
        })

        binding =
            inflate(layoutInflater, R.layout.camera_home_screen, container, false)
        binding.beautymodeid.setOnClickListener {
            viewModeClass.saveBeautyImage(binding.beautymodeid.)
            findNavController().navigate(R.id.action_cameraHomeScreenClass_to_beautyModeClass)
        }
        binding.galleryIconId.setOnClickListener {
            gallery()
        }
//        binding.beautymodeid.setOnClickListener {
//            beautyMode()
//        }
        binding.cameraid.setOnClickListener {
            takePhoto()
        }
        binding.lensDirectionId.setOnClickListener {
            chnageDireaction()
        }
        return binding.root
    }

    private fun chnageDireaction() {
//            lensFacing = if (CameraX.LensFacing.FRONT == lensFacing) {
//                CameraX.LensFacing.BACK
//            } else {
//                CameraX.LensFacing.FRONT
//            }
//            bindCamera()
    }


    private fun beautyMode() {
        Log.e(message, "hello")
//        Picasso.with(activity).load(photopath).into(beautymodepreviewid)
//        Glide.with(this).load(photopath).into(beautymodepreviewid)
        val action = CameraHomeScreenClassDirections.actionCameraHomeScreenClassToBeautyModeClass()
        findNavController().navigate(action)
    }

    fun takePhoto() {
        val photoFile = File(
            requireActivity().externalMediaDirs.firstOrNull(),
            "abc- ${System.currentTimeMillis()}.jpg"
        )
        val output = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        imageCapture?.takePicture(
            output, ContextCompat.getMainExecutor(context),
            object : ImageCapture.OnImageCapturedCallback(),
                ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    photopath = photoFile.absolutePath
                    Glide.with(this@CameraHomeScreenClass).load(photopath).into(beautymodeid)
                    makeText(context, "save the image", Toast.LENGTH_SHORT).show()
                }

                override fun onError(exception: androidx.camera.core.ImageCaptureException) {
                    makeText(
                        context,
                        "image not store ",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
    }
//        inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
//        val fragmentTransaction = beginTransaction()
//        fragmentTransaction.func()
//        fragmentTransaction.commit()

    private fun gallery() {
        Intent(Intent.ACTION_GET_CONTENT).also { intent ->
            intent.type = "image/*"
            intent.resolveActivity(requireActivity().packageManager)?.also {
                startActivityForResult(intent, REQUEST_PICK_IMAGE)
//       val pickPhoto  = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//        startActivityForResult(pickPhoto, 111)
//        context?.let {
//            Glide.with(it)
//                .load(pickPhoto)
//                .placeholder(R.drawable.beauty_icon)
//                .error(R.drawable.camera_lens)
//                .into(beautyeditid)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                val bitmap = data?.extras?.get("data") as Bitmap
                beautymodeid.setImageBitmap(bitmap)
            } else if (requestCode == REQUEST_PICK_IMAGE) {
                val uri = data?.getData()
                beautymodeid.setImageURI(uri)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) =
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PERMISSION_GRANTED
        ) {
            startCamera()
        } else {
            makeText(requireContext(), "please accept camera permission", Toast.LENGTH_LONG)
                .show()
        }

    private fun startCamera() {
        //start camera
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener(kotlinx.coroutines.Runnable {
            val cameraProvider = cameraProviderFuture.get()
            preview = Preview.Builder().build()
            preview!!.setSurfaceProvider(binding.previewId.surfaceProvider)
            imageCapture = ImageCapture.Builder().build()
            cameraSelector =
                CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()
            cameraProvider.unbind()
            camera = cameraProvider.bindToLifecycle(
                viewLifecycleOwner,
                cameraSelector!!, preview, imageCapture
            )
        }, ContextCompat.getMainExecutor(context))
    }
}

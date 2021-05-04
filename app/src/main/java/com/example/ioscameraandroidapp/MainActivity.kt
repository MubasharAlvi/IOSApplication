package com.example.ioscameraandroidapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
//    var fotoapparat: Fotoapparat? = null
//    private val filename = "test.png"
//    private lateinit var dialog: MaterialDialog
//    private lateinit var dialog1: MaterialDialog
//    private val sd = Environment.getExternalStorageState()
//    private val dest = File(sd, filename)
//    private var fotoapparatState : FotoapparatState? = null
//    var cameraStatus : CameraState? = null
//    var flashState: FlashState? = null
//    private val permissions = arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        createFotoapparat()
//
//        cameraStatus = CameraState.BACK
//        flashState = FlashState.OFF
//        fotoapparatState = FotoapparatState.ON
//
//        video.setOnClickListener {
//            val intent = Intent(this, com.example.ioscameraandroidapp.video::class.java)
//            startActivity(intent)
//        }
//        square.setOnClickListener {
//            val intent = Intent(this, com.example.ioscameraandroidapp.square::class.java)
//            startActivity(intent)
//        }
//        gallery_icon.setOnClickListener {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
//                    PackageManager.PERMISSION_DENIED
//                ) {
////permission denied
//                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
//                    requestPermissions(permissions, 1001)
//                } else {
////permission already granted
//                    pickImageFromGallery()
//                }
//            } else {
////SYSTEM OPERATING SYSTEM< Marshmallow
//            }
//        }
//        fab_camera.setOnClickListener {
//            takePhoto()
//        }
//
//        flip_icon.setOnClickListener {
//            switchCamera()
//        }
//
//        flash_icon.setOnClickListener {
//            showFlashDialog()
////            changeFlashState()
//        }
//        timer_icon.setOnClickListener {
//            showFilterDialog()
//        }
//        beauty_icon.setOnClickListener {
//            val intent = Intent(this,editor::class.java)
//            startActivity(intent)
//        }
//    }
//    private fun pickImageFromGallery() {
//        /*val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, 1000)*/
//
//         */
//        ImagePicker.with(this)
//            // User can only capture image from Camera
//            .galleryOnly()
//            // Image size will be less than 1024 KB
//            .start()
//    }
//    private fun showFilterDialog() {
//        dialog = MaterialDialog(this)
//                .noAutoDismiss()
//                .customView(R.layout.timerview)
////        dialog.capture_img.isEnabled = false
////        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
////            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 111)
////        } else {
////            dialog.capture_img.isEnabled = true
////            dialog.capture_img.setOnClickListener {
////                /* val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
////
////                 startActivityForResult(i, 101)*/
////                pickCameraImage(it)
//////                val intent = Intent(this)
//////                startActivityForResult(intent, REQ_CAMERA_IMAGE)
////            }
//         dialog.show()
//        }
//    private fun showFlashDialog() {
//        dialog1 = MaterialDialog(this)
//                .noAutoDismiss()
//                .customView(R.layout.flashview)
////        dialog.capture_img.isEnabled = false
////        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
////            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 111)
////        } else {
////            dialog.capture_img.isEnabled = true
////            dialog.capture_img.setOnClickListener {
////                /* val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
////
////                 startActivityForResult(i, 101)*/
////                pickCameraImage(it)
//////                val intent = Intent(this)
//////                startActivityForResult(intent, REQ_CAMERA_IMAGE)
////            }
//        dialog1.show()
//    }
//    private fun createFotoapparat(){
//        val cameraView = findViewById<CameraView>(R.id.camera_view)
//
//        fotoapparat = Fotoapparat(
//            context = this,
//            view = cameraView,
//            scaleType = ScaleType.CenterCrop,
//            lensPosition = back(),
//            logger = loggers(
//                logcat()
//            ),
//            cameraErrorCallback = { error ->
//                println("Recorder errors: $error")
//            }
//        )
//    }
//
//    private fun changeFlashState() {
//        fotoapparat?.updateConfiguration(
//            CameraConfiguration(
//                flashMode = if(flashState == FlashState.TORCH) off() else torch()
//            )
//        )
//
//        if(flashState == FlashState.TORCH) flashState = FlashState.OFF
//        else flashState = FlashState.TORCH
//    }
//
//    private fun switchCamera() {
//        fotoapparat?.switchTo(
//            lensPosition =  if (cameraStatus == CameraState.BACK) front() else back(),
//            cameraConfiguration = CameraConfiguration()
//        )
//
//        if(cameraStatus == CameraState.BACK) cameraStatus = CameraState.FRONT
//        else cameraStatus = CameraState.BACK
//    }
//    private fun takeVideo(){
//
//    }
//    private fun takePhoto() {
//        if (hasNoPermissions()) {
//            requestPermission()
//        }else{
//            fotoapparat
//                ?.takePicture()
//                ?.saveToFile(dest)
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        if (hasNoPermissions()) {
//            requestPermission()
//        }else{
//            fotoapparat?.start()
//            fotoapparatState = FotoapparatState.ON
//        }
//    }
//
//    private fun hasNoPermissions(): Boolean{
//        return ContextCompat.checkSelfPermission(this,
//            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
//            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//    }
//
//    fun requestPermission(){
//        ActivityCompat.requestPermissions(this, permissions,0)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        fotoapparat?.stop()
//        FotoapparatState.OFF
//    }
//
//    override fun onResume() {
//        super.onResume()
//        if(!hasNoPermissions() && fotoapparatState == FotoapparatState.OFF){
//            val intent = Intent(baseContext, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }
//
//}
//
//enum class CameraState{
//    FRONT, BACK
//}
//
//enum class FlashState{
//    TORCH, OFF
//}
//
//enum class FotoapparatState{
//    ON, OFF
//}
    }
}
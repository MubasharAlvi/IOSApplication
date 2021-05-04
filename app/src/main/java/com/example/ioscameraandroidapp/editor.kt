//package com.example.ioscameraandroidapp
//
//import android.content.Intent
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import androidx.appcompat.app.AppCompatActivity
//import com.mukesh.image_processing.ImageProcessor
//import kotlinx.android.synthetic.main.editor.*
//
//class editor:AppCompatActivity() {
////    // creating a bitmap for our original
////    // image and all image filters.
////    internal lateinit var bitmap: Bitmap
////    // creating a variable for image view.
//    internal lateinit var oneIV: ImageView
////    internal lateinit var twoIV: ImageView
////    internal lateinit var threeIV: ImageView
////    internal lateinit var fourIV: ImageView
////    internal lateinit var fiveIV: ImageView
////    internal lateinit var sixIV: ImageView
////    internal lateinit var sevenIV: ImageView
////    internal lateinit var eightIV: ImageView
////    internal lateinit var nineIV: ImageView
////    internal lateinit var tenIV: ImageView
////    internal lateinit var originalIV: ImageView
////    internal lateinit var oneBitMap: Bitmap
////    internal lateinit var twoBitMap: Bitmap
////    internal lateinit var threeBitmap: Bitmap
////    internal lateinit var fourBitMap: Bitmap
////    internal lateinit var fiveBitMap: Bitmap
////    internal lateinit var sixBitMap: Bitmap
////    internal lateinit var sevenBitMap: Bitmap
////    internal lateinit var eightBitMap: Bitmap
////    internal lateinit var nineBitMap: Bitmap
////    internal lateinit var tenBitMap: Bitmap
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.editor)
//    share_ic.setOnClickListener {
//        val intent= Intent()
//        intent.action=Intent.ACTION_SEND
//       intent.type="type/jpg"
//        val img="this is my snap"
//        intent.putExtra(Intent.EXTRA_TEXT,img)
//        startActivity(Intent.createChooser(intent,"Share app"))
//    }
////        // creating a variable for our image processor.
////        val processor = ImageProcessor()
////        // initializing bitmap with our image resource.
////        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1)
////        // initializing image views for our filters
////        // and original image on which we will
////        // be applying our filters.
////        oneIV = findViewById(R.id.idIVOne)
////        twoIV = findViewById(R.id.idIVTwo)
////        threeIV = findViewById(R.id.idIVThree)
////        fourIV = findViewById(R.id.idIVFour)
////        fiveIV = findViewById(R.id.idIVFive)
////        sixIV = findViewById(R.id.idIVSix)
////        sevenIV = findViewById(R.id.idIVSeven)
////        eightIV = findViewById(R.id.idIVEight)
////        nineIV = findViewById(R.id.idIVNine)
////        tenIV = findViewById(R.id.idIVTen)
////        originalIV = findViewById(R.id.idIVOriginalImage)
////        // below line is use to add tint effect to our original
////        // image bitmap and storing that in one bitmap.
////        oneBitMap = processor.tintImage(bitmap, 90)
////        // after storing it to one bitmap
////        // we are setting it to imageview.
////        oneIV.setImageBitmap(oneBitMap)
////        // below line is use to apply gaussian blur effect
////        // to our original image bitmap.
////        twoBitMap = processor.applyGaussianBlur(bitmap)
////        twoIV.setImageBitmap(twoBitMap)
////        // below line is use to add sepia toing effect
////        // to our original image bitmap.
////        threeBitmap = processor.createSepiaToningEffect(bitmap, 1, 2.0, 1.0, 5.0)
////        threeIV.setImageBitmap(threeBitmap)
////        // below line is use to apply saturation
////        // filter to our original image bitmap.
////        fourBitMap = processor.applySaturationFilter(bitmap, 3)
////        fourIV.setImageBitmap(fourBitMap)
////        // below line is use to apply snow effect
////        // to our original image bitmap.
////        fiveBitMap = processor.applySnowEffect(bitmap)
////        fiveIV.setImageBitmap(fiveBitMap)
////        // below line is use to add gray scale
////        // to our image view.
////        sixBitMap = processor.doGreyScale(bitmap)
////        sixIV.setImageBitmap(sixBitMap)
////        // below line is use to add engrave effect
////        // to our image view.
////        sevenBitMap = processor.engrave(bitmap)
////        sevenIV.setImageBitmap(sevenBitMap)
////        // below line is use to create a contrast
////        // effect to our image view.
////        eightBitMap = processor.createContrast(bitmap, 1.5)
////        eightIV.setImageBitmap(eightBitMap)
////        // below line is use to add shadow effect
////        // to our original bitmap.
////        nineBitMap = processor.createShadow(bitmap)
////        nineIV.setImageBitmap(nineBitMap)
////        // below line is use to add flea
////        // effect to our image view.
////        tenBitMap = processor.applyFleaEffect(bitmap)
////        tenIV.setImageBitmap(tenBitMap)
////        // below line is use to call on click
////        // listener for our all image filters.
////        initializeOnCLickListerns()
////    }
////    private fun initializeOnCLickListerns() {
////        oneIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                // on clicking on each filter we are
////                // setting that filter to our original image.
////                originalIV.setImageBitmap(oneBitMap)
////            }
////        })
////        twoIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(twoBitMap)
////            }
////        })
////        threeIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(threeBitmap)
////            }
////        })
////        fourIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(fourBitMap)
////            }
////        })
////        fiveIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(fiveBitMap)
////            }
////        })
////        sixIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(sixBitMap)
////            }
////        })
////        sevenIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(sevenBitMap)
////            }
////        })
////        eightIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(eightBitMap)
////            }
////        })
////        nineIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(nineBitMap)
////            }
////        })
////        tenIV.setOnClickListener(object: View.OnClickListener {
////            override fun onClick(v: View) {
////                originalIV.setImageBitmap(tenBitMap)
////            }
////        })
//    }
//}
package com.example.playground.content.camera

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.Recorder
import androidx.camera.video.VideoCapture
import androidx.core.content.ContextCompat
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityCameraBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class CameraActivity : BaseActivity<ActivityCameraBinding, CameraViewModel>(
    R.layout.activity_camera
) {

    override val viewModel: CameraViewModel by viewModel()

    private var imageCapture: ImageCapture? = null

    private var videoCapture: VideoCapture<Recorder>? = null

    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (allPermissionsGranted()) {
            startCamera()
        } else {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSION)
        }

        cameraExecutor = Executors.newSingleThreadExecutor()

        setClickListener()

        subscribeEvent()
    }

    private fun setClickListener() {
        binding.tvImageCapture.setOnClickListener {
            takePhoto()
        }

        binding.tvVideoCapture.setOnClickListener {
            captureVideo()
        }
    }

    private fun subscribeEvent() {
    }

    private fun takePhoto() {
        // 이미지 캡처에 대한 참조를 가져오고 만약 널이면 종료.
        val imageCapture = imageCapture ?: return

        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.KOREA)
            .format(System.currentTimeMillis())

        // 캡처한 이미지를 저장할 ContentValue 값을 만들어 준다.
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
            }
        }

        // 저장할 곳을 지정. 다른앱에서 표시할 수 있도록 MediaStore에 저장
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(contentResolver, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            .build()

        // takePicture 함수 호출
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    val msg = "Photo capture 성공: ${outputFileResults.savedUri}"
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                }

                override fun onError(exception: ImageCaptureException) {
                    Log.e(TAG,"Photo capture 실패: ${exception.message}", exception)
                }

            }
        )

    }
    private fun captureVideo() { }

    private fun startCamera() {
        // 카메라 수명주기를 바인딩하는데 사용. CameraX는 수명 주기를 인식하므로 카메라를 열고 닫는 작업이 필요 없음.
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        // 리스너 추가.
        cameraProviderFuture.addListener({

            // 애플리케이션 프로세스 내에서 카메라의 수명 주기를 LifecycleOwner에 바인딩하는 데 사용됩니다.
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview 객체를 초기화하고, ViewFinder에서 surfaceProvider를 Preview에 설정합니다.
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.pvViewFinder.surfaceProvider)
                }

            // ImageCapture 객체 생성
            imageCapture = ImageCapture.Builder()
                .build()


            // CameraSelector 객체 생성
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                // 현재 열려있는 카메라를 unBinding.
                cameraProvider.unbindAll()

                // cameraSelector와 Preview 객체를 바인딩.
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture
                )
            } catch (exception: Exception) {
                Log.e(TAG, "Use case binding failed", exception)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    // 권한 체크
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(this, "Permissions not grated by the user.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    companion object {
        private const val TAG = "CameraActivity"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSION = 10
        private val REQUIRED_PERMISSIONS = mutableListOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.RECORD_AUDIO
        ).apply {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }.toTypedArray()
    }
}

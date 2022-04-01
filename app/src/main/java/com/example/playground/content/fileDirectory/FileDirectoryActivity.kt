package com.example.playground.content.fileDirectory

import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.example.playground.R
import com.example.playground.base.BaseActivity
import com.example.playground.databinding.ActivityFileDirectoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File


class FileDirectoryActivity : BaseActivity<ActivityFileDirectoryBinding, FileDirectoryViewModel>(
    R.layout.activity_file_directory
) {

    override val viewModel: FileDirectoryViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setListener()
        subscribeLiveData()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setListener() {
        // Preferences DataStore
        binding.tvDownloadDirectory.setOnClickListener {
            val targetDir = "/storage/emulated/0/Download"

            val files = File(targetDir).list()
            var tmpFilename: String? = null

            println("!!! DEBUG targetDir [$targetDir] !!!")
            println("!!! DEBUG files size [${files.size}] !!!")

            files.forEachIndexed { index, s ->
                println("!!! DEBUG file number $index [$s] !!!")
            }
        }

        binding.tvDownloadInnerFolderDirectory.setOnClickListener {
            val targetDir = "/storage/emulated/0/Download/Mailplug"

            val files = File(targetDir).listFiles()
            var tmpFilename: String? = null

            println("!!! DEBUG targetDir [$targetDir] !!!")
            println("!!! DEBUG files size [${files?.size}] !!!")

            files?.forEachIndexed { index, s ->
                println("!!! DEBUG file number $index [${s.name}] !!!")
            }
        }

        binding.tvDownloadInnerFolderDirectoryTest.setOnClickListener {
            val targetDir = "/storage/emulated/0/Download/Mailplug"

            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE).apply {
                putExtra(DocumentsContract.EXTRA_INITIAL_URI, targetDir)
            }

            startActivityForResult(intent, 100)
        }

        binding.tvFileListQ.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val resolver = applicationContext.contentResolver

                val PROJECTION = arrayOf(MediaStore.Downloads.TITLE)
                val SORT_ORDER = MediaStore.Downloads.TITLE

                val files = resolver.query(
//                    MediaStore.Downloads.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),
                    MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL),
                    PROJECTION,
                    null,
                    null,
                    SORT_ORDER
                )?.use { cursor ->
                    cursor.mapToList { it.getString(0) }
                }

                println("!!! DEBUG file size ${files?.size} !!!")
                files?.forEachIndexed { index, s ->
                    println("!!! DEBUG file number $index [$s] !!!")
                }
            }
        }

        binding.tvFileListLegacy.setOnClickListener {
            val path = Environment.getExternalStorageDirectory().absolutePath + File.separator + "Download" + File.separator + "Mailplug"

            val files = File(path).list()?.toList()
//            val files = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
//                .listFiles()
//                ?.map { it.name }
//                ?.sorted() ?: listOf()


            println("!!! DEBUG file size ${files?.size} !!!")
            files?.forEachIndexed { index, s ->
                println("!!! DEBUG file number $index [$s] !!!")
            }
        }

        binding.tvCreateFolder.setOnClickListener {
            val dir = File("${Environment.DIRECTORY_DOWNLOADS}${File.separator}Mailplug")
            dir.mkdirs()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }

    private fun subscribeLiveData() {

    }

    private fun <T : Any> Cursor.mapToList(predicate: (Cursor) -> T): List<T> =
        generateSequence { if (moveToNext()) predicate(this) else null }
            .toList()
}
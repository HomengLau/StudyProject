package com.homeng.logger.utils

import android.annotation.SuppressLint
import android.os.Environment
import com.tencent.mars.xlog.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

open class LogManager {
    private val TAG = LogManager::class.simpleName
    companion object {

    }
    //读取安卓机器外部存储路径下的日志文件，隔天去压缩前一天的日志文件，原日志文件名形同“2019-02-03Log”

    fun readFolder(){
        var path = Environment.getExternalStorageDirectory().getPath() + File.separator + "logs";
        var file = File(path)
        var files = file.listFiles()
        for (fileChild in files){
            val fileName = fileChild.name
            val strings = fileName.split("L")
            val dateName = strings[0].replace("-","")
            val dateNow = Date()
            val sdf2 = SimpleDateFormat("yyyyMMdd")
            val dateNowValue = sdf2.format(dateNow)
            val result = dateNowValue.toInt() - dateName.toInt()
            Log.i(TAG,"result is $result")
            Log.i(TAG,"path is $path")
            if (result >= 0){
                Log.i(TAG, "fileName is $fileName")
                ZipFile(path + File.separator + fileName,
                    path + File.separator + dateName + "-Log.zip")
            }
        }
    }
    //创建zip文件
    fun ZipFile(filePath: String,  zipFilePath:String)  {
        try {
            val outZip = ZipOutputStream(FileOutputStream(zipFilePath));
            val file = File(filePath);
            Log.i(TAG, "file.getParent() is %s",file.parent);
            Log.i(TAG, "file.getAbsolutePath() is %s",file.absolutePath);
            ZipFiles(file.parent.plus(File.separator), file.name, outZip);
            outZip.finish();
            outZip.close();
        }catch (e: Exception){
            e.stackTrace;
        }
    }

    //压缩文件到zip文件中
   fun ZipFiles(filePath: String, fileName: String, zipOutputSteam: ZipOutputStream){
        Log.i(TAG, "folderString is %s" ,filePath + "\n" +
                "fileString is %s" , "$fileName\n=========================="
        );
        if (zipOutputSteam == null)
            return;
        var file = File(filePath+ fileName);
        if (file.isFile()) {
            var zipEntry = ZipEntry(fileName);
            var inputStream = FileInputStream(file);
            zipOutputSteam.putNextEntry(zipEntry);
            var buffer = ByteArray(4096)
            var len = inputStream.read(buffer)
            while ( len != -1) {
                zipOutputSteam.write(buffer, 0, len);
            }
            zipOutputSteam.closeEntry();
        }}

}
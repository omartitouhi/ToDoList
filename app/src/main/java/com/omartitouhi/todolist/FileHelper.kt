package com.omartitouhi.todolist

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInput
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {

    val FILENAME = "listeinfo.dat"

    fun writeData(items: ArrayList<String>,context: Context){
        var fos : FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)
        var oas = ObjectOutputStream(fos)
        oas.writeObject(items)
        oas.close()
    }

    fun readData(context: Context) : ArrayList<String>
    {
        try{
        var itemList : ArrayList<String>
        var fis : FileInputStream = context.openFileInput(FILENAME)
        var ois = ObjectInputStream(fis)
        itemList = ois.readObject() as ArrayList<String>
        ois.close()
        return itemList}
        catch(e: Exception){
            return ArrayList<String>()
        }
    }
}
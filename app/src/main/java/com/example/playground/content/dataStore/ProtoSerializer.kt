package com.example.playground.content.dataStore

import androidx.datastore.core.Serializer
import com.example.playground.ExampleInfo
import java.io.InputStream
import java.io.OutputStream

object ProtoSerializer: Serializer<ExampleInfo> {
    override val defaultValue: ExampleInfo
        get() = ExampleInfo.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ExampleInfo {
        try {
            return ExampleInfo.parseFrom(input)
        } catch (exception: Exception) {
            throw Exception("failed readFrom", exception)
        }
    }

    override suspend fun writeTo(t: ExampleInfo, output: OutputStream) {
        try {
            t.writeTo(output)
        } catch (exception: Exception) {
            throw Exception("failed writeTo", exception)
        }
    }
}

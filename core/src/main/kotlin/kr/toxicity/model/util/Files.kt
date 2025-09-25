/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.util

import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream

inline fun File.getOrCreateDirectory(name: String, initialConsumer: (File) -> Unit = {}) = File(this, name).also { target ->
    if (!target.exists()) {
        target.mkdirs()
        initialConsumer(target)
    }
}

inline fun copyResourceAs(name: String, block: (InputStream) -> Unit) {
    PLUGIN.getResource(name)?.use(block)
}

fun File.fileTreeList(): Stream<Path> = Files.find(
    toPath(),
    Int.MAX_VALUE,
    { _, attr ->
        !attr.isDirectory
    }
)

fun File.addResource(name: String) {
    copyResourceAs(name) { input ->
        File(this, name).outputStream().use {
            it.buffered().use { output -> input.copyTo(output) }
        }
    }
}
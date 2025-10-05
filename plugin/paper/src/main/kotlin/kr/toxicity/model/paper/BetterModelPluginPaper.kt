/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.paper

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIPaperConfig
import kr.toxicity.model.BetterModelPluginImpl

@Suppress("UNUSED")
class BetterModelPluginPaper : BetterModelPluginImpl() {
    override fun onLoad() {
        super.onLoad()
        CommandAPI.onLoad(CommandAPIPaperConfig(this).fallbackToLatestNMS(true).silentLogs(true))
    }
}
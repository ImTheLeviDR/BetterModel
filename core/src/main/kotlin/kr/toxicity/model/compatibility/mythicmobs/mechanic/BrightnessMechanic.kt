/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.compatibility.mythicmobs.mechanic

import io.lumine.mythic.api.config.MythicLineConfig
import io.lumine.mythic.api.skills.INoTargetSkill
import io.lumine.mythic.api.skills.SkillMetadata
import io.lumine.mythic.api.skills.SkillResult
import kr.toxicity.model.api.tracker.TrackerUpdateAction
import kr.toxicity.model.compatibility.mythicmobs.*

class BrightnessMechanic(mlc: MythicLineConfig) : AbstractSkillMechanic(mlc), INoTargetSkill {

    private val model = mlc.modelPlaceholder
    private val predicate = mlc.bonePredicateNullable
    private val block = mlc.toPlaceholderInteger(arrayOf("block", "b")) {
        (it ?: -1).coerceAtLeast(-1).coerceAtMost(15)
    }
    private val sky = mlc.toPlaceholderInteger(arrayOf("sky", "s")) {
        (it ?: -1).coerceAtLeast(-1).coerceAtMost(15)
    }

    override fun cast(p0: SkillMetadata): SkillResult {
        val args = p0.toPlaceholderArgs()
        return p0.toTracker(model(args))?.let {
            it.update(
                TrackerUpdateAction.brightness(block(args), sky(args)),
                predicate(args)
            )
            SkillResult.SUCCESS
        } ?: SkillResult.CONDITION_FAILED
    }
}
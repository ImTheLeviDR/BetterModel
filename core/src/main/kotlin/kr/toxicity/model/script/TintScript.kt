/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.script

import kr.toxicity.model.api.script.AnimationScript
import kr.toxicity.model.api.tracker.EntityTracker
import kr.toxicity.model.api.tracker.Tracker
import kr.toxicity.model.api.tracker.TrackerUpdateAction
import kr.toxicity.model.api.util.function.BonePredicate

class TintScript(
    val predicate: BonePredicate,
    val color: Int,
    val damageTint: Boolean
) : AnimationScript {

    override fun accept(tracker: Tracker) {
        if (damageTint && tracker is EntityTracker) {
            tracker.damageTintValue(color)
        } else {
            if (tracker is EntityTracker) tracker.cancelDamageTint()
            tracker.update(
                TrackerUpdateAction.tint(color),
                predicate
            )
        }
    }

    override fun isSync(): Boolean = false
}
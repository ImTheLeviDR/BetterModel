/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.api.data.blueprint;

import kr.toxicity.model.api.animation.AnimationIterator;
import kr.toxicity.model.api.animation.AnimationModifier;
import kr.toxicity.model.api.animation.AnimationMovement;
import kr.toxicity.model.api.bone.BoneName;
import kr.toxicity.model.api.script.BlueprintScript;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Map;

/**
 * A model animation.
 * @param name animation name
 * @param loop loop mode
 * @param length frame length
 * @param override override
 * @param animator group animator
 * @param emptyAnimator empty animation ([0, 0, 0]).
 * @param script script
 */
public record BlueprintAnimation(
        @NotNull String name,
        @NotNull AnimationIterator.Type loop,
        float length,
        boolean override,
        @NotNull @Unmodifiable Map<BoneName, BlueprintAnimator> animator,
        @Nullable BlueprintScript script,
        @NotNull List<AnimationMovement> emptyAnimator
) {

    /**
     * Gets animation script
     * @param modifier modifier
     * @return script or null
     */
    public @Nullable BlueprintScript script(@NotNull AnimationModifier modifier) {
        return modifier.override(override) || modifier.player() != null ? null : script;
    }

    /**
     * Gets iterator.
     * @param type type
     * @return iterator
     */
    public @NotNull AnimationIterator<AnimationMovement> emptyIterator(@NotNull AnimationIterator.Type type) {
        return type.create(emptyAnimator);
    }
}

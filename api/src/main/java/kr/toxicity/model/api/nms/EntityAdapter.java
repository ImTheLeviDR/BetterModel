/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.api.nms;

import kr.toxicity.model.api.BetterModel;
import kr.toxicity.model.api.tracker.EntityTrackerRegistry;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Optional;

/**
 * An adapter of entity
 */
public interface EntityAdapter {
    /**
     * Gets a source
     * @return source entity
     */
    @NotNull Entity entity();

    /**
     * Gets custom name of this entity
     * @return custom name
     */
    @Nullable Component customName();

    /**
     * Gets vanilla entity
     * @return vanilla entity
     */
    @NotNull Object handle();

    /**
     * Gets entity id
     * @return entity id
     */
    int id();

    /**
     * Checks source entity is dead
     * @return dead
     */
    boolean dead();

    /**
     * Checks source entity is on the ground
     * @return on the ground
     */
    boolean ground();

    /**
     * Checks source entity is invisible
     * @return invisible
     */
    boolean invisible();

    /**
     * Check source entity is on a glow
     * @return glow
     */
    boolean glow();

    /**
     * Check source entity is on a walk
     * @return walk
     */
    boolean onWalk();

    /**
     * Check source entity is on the fly
     * @return fly
     */
    boolean fly();

    /**
     * Gets entity's scale
     * @return scale
     */
    double scale();

    /**
     * Gets entity's pitch (x-rot)
     * @return pitch
     */
    float pitch();

    /**
     * Gets entity's body yaw (y-rot)
     * @return body yaw
     */
    float bodyYaw();

    /**
     * Gets entity's yaw (y-rot)
     * @return yaw
     */
    float headYaw();

    /**
     * Gets entity's damage tick
     * @return damage tick
     */
    float damageTick();

    /**
     * Gets entity's walk speed
     * @return walk speed
     */
    float walkSpeed();

    /**
     * Gets entity's passenger point
     * @return passenger point
     */
    @NotNull Vector3f passengerPosition();

    /**
     * Gets tracker registry of this adapter
     * @return optional tracker registry
     */
    default @NotNull Optional<EntityTrackerRegistry> registry() {
        return BetterModel.registry(entity().getUniqueId());
    }

    /**
     * Checks this entity has controlling passenger
     * @return has controlling passenger
     */
    default boolean hasControllingPassenger() {
        var registry = registry().orElse(null);
        return registry != null && registry.hasControllingPassenger();
    }
}

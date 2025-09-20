/**
 * This source file is part of BetterModel.
 * Copyright (c) 2024–2025 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */
package kr.toxicity.model.api.skin;

import com.mojang.authlib.GameProfile;
import org.jetbrains.annotations.NotNull;

public interface AuthLibAdapter {
    @NotNull SkinProfile adapt(@NotNull GameProfile profile);
}

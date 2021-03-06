/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.rendercore.visibility;

import android.graphics.Rect;
import android.view.View;

public final class VisibleIncrementalModuleItem implements IncrementalModuleItem {
  private final VisibilityOutput mVisibilityOutput;

  VisibleIncrementalModuleItem(VisibilityOutput visibilityOutput) {
    this.mVisibilityOutput = visibilityOutput;
  }

  @Override
  public String getId() {
    return "v_" + mVisibilityOutput.getId();
  }

  @Override
  public Rect getBounds() {
    return mVisibilityOutput.getBounds();
  }

  @Override
  public float getEnterRangeTop() {
    return mVisibilityOutput.getVisibilityTop();
  }

  @Override
  public float getEnterRangeBottom() {
    return mVisibilityOutput.getVisibilityBottom();
  }

  @Override
  public void onEnterVisibleRange() {
    VisibilityModuleInput.processVisible(mVisibilityOutput);
  }

  @Override
  public void onExitVisibleRange() {
    VisibilityModuleInput.processInvisible(mVisibilityOutput);
  }

  @Override
  public void onLithoViewAvailable(View view) {}
}

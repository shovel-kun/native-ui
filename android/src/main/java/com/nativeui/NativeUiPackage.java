package com.nativeui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.uimanager.ViewManager;
import com.margelo.nitro.nativeui.*;
import com.margelo.nitro.nativeui.views.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NativeUiPackage extends TurboReactPackage {
  @Nullable
  @Override
  public NativeModule getModule(@NonNull String name, @NonNull ReactApplicationContext reactContext) {
    return null;
  }

  @NonNull
  @Override
  public ReactModuleInfoProvider getReactModuleInfoProvider() {
    return HashMap::new;
  }

  @NonNull
  @Override
  public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
    return Arrays.asList(
      new HybridTextInputManager(),
      new HybridDropdownMenuManager(),
      new HybridTriStateCheckboxManager(),
      new HybridNitroTextManager()
    );
  }

  static {
    NativeUiOnLoad.initializeNative();
  }
}

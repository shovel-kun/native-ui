#include <jni.h>
#include "NativeUiOnLoad.hpp"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
  return margelo::nitro::nativeui::initialize(vm);
}

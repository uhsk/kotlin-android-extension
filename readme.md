# Kotlin Android Extension

## 说明

安卓开发中常用的轮子，全部都是Kotlin的[拓展函数](https://kotlinlang.org/docs/extensions.html), 比如常见的有下面的API，但是却<font color=red>远远不止</font>这些。

```kotlin
val md5 = "test".md5()
val sha1 = "test".sha1()
```

## 使用

最新版本：[![](https://jitpack.io/v/uhsk/kotlin-android-extension.svg)](https://jitpack.io/#uhsk/kotlin-android-extension)

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
dependencies {
    implementation 'com.github.uhsk:kotlin-android-extension:latest'
}
```

## Q&A

如遇到您项目中使用的kotlin版本和当前项目的kotlin版本不一致导致的冲突，可使用：
```groovy
dependencies {
    implementation ('com.github.uhsk:kotlin-android-extension:latest') {
        exclude group: 'org.jetbrains.kotlin'   // 过滤此项目使用的kotlin版本，使用您项目的kotlin版本
    }
}
```

## LICENSE

```c++
/*
 * Copyright (C) 2022. sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
```

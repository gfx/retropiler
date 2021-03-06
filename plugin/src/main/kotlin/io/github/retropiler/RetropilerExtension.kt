/*
 * Copyright (c) 2017 FUJI Goro (gfx).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.retropiler

import javassist.CtClass
import java.util.function.BiFunction

open class RetropilerExtension {

    companion object {
        val NAME = "retropiler"
    }

    var runtimePackage = "io.github.retropiler.runtime"

    fun runtimePackage(name: String) {
        runtimePackage = name
    }

    var defaultMapClassName = BiFunction { extension: RetropilerExtension, ctClass: CtClass ->
        "${extension.runtimePackage}.${ctClass.packageName}._${ctClass.simpleName}"
    }

    var mapClassName = defaultMapClassName

    fun mapClassName(function: BiFunction<RetropilerExtension, CtClass, String>) {
        mapClassName = function
    }
}

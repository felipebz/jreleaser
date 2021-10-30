/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020-2021 The JReleaser authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jreleaser.gradle.plugin.dsl

import groovy.transform.CompileStatic
import org.gradle.api.Action
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property

/**
 *
 * @author Andres Almiray
 * @since 0.1.0
 */
@CompileStatic
interface Brew extends RepositoryTool {
    Property<String> getFormulaName()

    Property<Boolean> getMultiPlatform()

    ListProperty<String> getLivecheck()

    MapProperty<String, String> getDependencies()

    void addDependency(String key, String value)

    void addDependency(String key)

    Tap getTap()

    void tap(Action<? super Tap> action)

    void tap(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = Tap) Closure<Void> action)

    Cask getCask()

    void cask(Action<? super Cask> action)

    void cask(@DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = Cask) Closure<Void> action)
}
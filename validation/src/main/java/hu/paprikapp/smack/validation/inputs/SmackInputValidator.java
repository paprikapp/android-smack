/*
 * Copyright (C) 2014 Paprikapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hu.paprikapp.smack.validation.inputs;

import java.util.List;

import hu.paprikapp.smack.validation.SmackValidator;

/**
 * @author Balazs Varga
 */
public interface SmackInputValidator {

    void addValidator(SmackValidator validator);

    List<SmackValidator> validators();

    boolean validate();

    void showError(String message);

    void hideError();
}

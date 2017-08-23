/*
 * Copyright 2004 - 2012 Mirko Nasato and contributors
 *           2016 - 2017 Simon Braconnier and contributors
 *
 * This file is part of JODConverter - Java OpenDocument Converter.
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

package org.jodconverter.job;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all source document specifications implementations.
 *
 * @see SourceDocumentSpecs
 */
public abstract class AbstractSourceDocumentSpecs extends AbstractDocumentSpecs
    implements SourceDocumentSpecs {

  private Map<String, Object> customLoadProperties;

  protected AbstractSourceDocumentSpecs(final File file) {
    super(file);
  }

  @Override
  public Map<String, Object> getCustomLoadProperties() {
    return customLoadProperties;
  }

  /**
   * Sets the custom properties that will be applied when a document is loaded during the conversion
   * task.
   *
   * <p>Custom load properties are applied after the default load properties of the {@link
   * org.jodconverter.DocumentConverter} (only if the converter is a subclass of {@link
   * org.jodconverter.job.AbstractConverter}) and after the load properties of the {@link
   * org.jodconverter.document.DocumentFormat} of this SourceDocumentSpecs.
   *
   * @param customLoadProperties A map containing the custom properties to apply when loading a
   *     document.
   */
  void setCustomLoadProperties(final Map<String, Object> customLoadProperties) {

    this.customLoadProperties = new HashMap<>(customLoadProperties);
  }
}

/* **************************************************************************************
 * Copyright (c) 2026 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keypop.genericcard;

import org.eclipse.keypop.reader.selection.spi.CardSelectionExtension;

/**
 * Card specific {@link CardSelectionExtension} providing means to add successful status word.
 *
 * @since 3.0.0
 */
public interface GenericCardSelectionExtension extends CardSelectionExtension {

  /**
   * Adds a status word to the list of those that should be considered successful for the Select
   * Application APDU.
   *
   * <p>Note: initially, the list contains the standard successful status word {@code 9000h}.
   *
   * @param statusWord A positive int &le; {@code FFFFh}.
   * @return The current instance.
   * @since 2.0.0
   */
  GenericCardSelectionExtension addSuccessfulStatusWord(int statusWord);
}

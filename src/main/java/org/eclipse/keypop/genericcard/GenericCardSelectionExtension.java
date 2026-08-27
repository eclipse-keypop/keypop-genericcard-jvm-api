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
 * Extends the {@link CardSelectionExtension} interface of the Reader API to expose a way to declare
 * additional successful status words for the Select Application APDU, obtained via {@link
 * GenericCardApiFactory#createGenericCardSelectionExtension()}.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#type_GenericCardSelectionExtension">GenericCardSelectionExtension</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface GenericCardSelectionExtension extends CardSelectionExtension {

  /**
   * Adds a status word to the list of those that should be considered successful for the Select
   * Application APDU.
   *
   * <p>Note: initially, the list contains the standard successful status word {@code 9000h}; each
   * call adds to the existing set and never removes that implicit entry.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_GenericCardSelectionExtension_addSuccessfulStatusWord">GenericCardSelectionExtension.addSuccessfulStatusWord</a>
   * for the normative contract.
   *
   * @param statusWord A positive int &le; {@code FFFFh}.
   * @return The current instance.
   * @since 1.0.0
   */
  GenericCardSelectionExtension addSuccessfulStatusWord(int statusWord);
}

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

import org.eclipse.keypop.reader.CardReader;
import org.eclipse.keypop.reader.selection.spi.SmartCard;

/**
 * Factory used by the application to obtain instances of the public types provided by the API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#type_GenericCardApiFactory">GenericCardApiFactory</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface GenericCardApiFactory {

  /**
   * Creates a new instance of {@link GenericCardSelectionExtension}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_GenericCardApiFactory_createGenericCardSelectionExtension">GenericCardApiFactory.createGenericCardSelectionExtension</a>
   * for the normative contract.
   *
   * @return A not null reference
   * @since 1.0.0
   */
  GenericCardSelectionExtension createGenericCardSelectionExtension();

  /**
   * Creates an instance of {@link CardTransactionManager} bound to the supplied reader and to the
   * initial card data provided by the selection process.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_GenericCardApiFactory_createCardTransaction">GenericCardApiFactory.createCardTransaction</a>
   * for the normative contract.
   *
   * @param reader The reader through which the card communicates.
   * @param card The initial card data provided by the selection process.
   * @return A not null reference.
   * @throws IllegalArgumentException If one of the provided parameters is null.
   * @since 1.0.0
   */
  CardTransactionManager createCardTransaction(CardReader reader, SmartCard card);
}

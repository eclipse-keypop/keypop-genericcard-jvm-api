/* **************************************************************************************
 * Copyright (c) 2025 Calypso Networks Association https://calypsonet.org/
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
 * Generic Card API Factory.
 *
 * @since 1.0.0
 */
public interface GenericCardApiFactory {

  /**
   * Creates a new instance of {@link GenericCardSelectionExtension}.
   *
   * @return A not null reference
   * @since 1.0.0
   */
  GenericCardSelectionExtension createGenericCardSelectionExtension();

  /**
   * Creates an instance of {@link CardTransactionManager}.
   *
   * @param reader The reader through which the card communicates.
   * @param card The initial card data provided by the selection process.
   * @return A not null reference.
   * @since 1.0.0
   */
  CardTransactionManager createCardTransaction(CardReader reader, SmartCard card);
}

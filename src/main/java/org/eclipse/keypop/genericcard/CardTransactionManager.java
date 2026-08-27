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

import java.util.List;
import org.eclipse.keypop.reader.transaction.spi.IsoCardTransactionManager;

/**
 * Basic operations to prepare, identify and process APDU exchanges with an ISO 7816-4 card,
 * obtained via {@link GenericCardApiFactory#createCardTransaction}.
 *
 * <p>Commands are prepared with the {@code prepareCommand} overloads and processed through the
 * inherited {@link IsoCardTransactionManager#processCommands()} operation.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#type_CardTransactionManager">CardTransactionManager</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public interface CardTransactionManager extends IsoCardTransactionManager {

  /**
   * Prepares an APDU command without command identifier nor duration bound.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_CardTransactionManager_prepareCommand_apdu">CardTransactionManager.prepareCommand</a>
   * for the normative contract.
   *
   * @param apdu A not empty byte array containing the raw APDU command.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or empty.
   * @since 2.0.0
   */
  CardTransactionManager prepareCommand(byte[] apdu);

  /**
   * Prepares an APDU command with an application-supplied identifier, usable to retrieve the
   * corresponding response via {@link #getLastExecutionResponse(int)}.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_CardTransactionManager_prepareCommand_withId">CardTransactionManager.prepareCommand</a>
   * for the normative contract.
   *
   * @param apdu A not empty byte array containing the raw APDU command.
   * @param idCommand The application-supplied identifier of this command.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or empty.
   * @since 2.0.0
   */
  CardTransactionManager prepareCommand(byte[] apdu, int idCommand);

  /**
   * Prepares an APDU command with an application-supplied identifier and a maximum tolerated
   * exchange duration, used to detect a relay attack at the individual command level.
   *
   * <p>The duration check is performed at processing time: an {@code InvalidCardResponseException}
   * is raised if the effective duration exceeds the declared bound, the message identifying the
   * offending command.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_CardTransactionManager_prepareCommand_withDuration">CardTransactionManager.prepareCommand</a>
   * for the normative contract.
   *
   * @param apdu A not empty byte array containing the raw APDU command.
   * @param idCommand The application-supplied identifier of this command.
   * @param maxDuration The maximum tolerated duration of the APDU exchange, in milliseconds.
   * @return The current instance.
   * @throws IllegalArgumentException If the provided array is null or empty.
   * @since 2.0.0
   */
  CardTransactionManager prepareCommand(byte[] apdu, int idCommand, long maxDuration);

  /**
   * Returns the responses collected during the last call to {@link
   * IsoCardTransactionManager#processCommands()}, in the order in which the commands were prepared.
   *
   * <p>This method does not alter the internal state of the manager: the list remains available
   * until {@code processCommands()} is invoked again, at which point it is replaced by the new set
   * of responses.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_CardTransactionManager_getLastExecutionResponses">CardTransactionManager.getLastExecutionResponses</a>
   * for the normative contract.
   *
   * @return A non-null but possibly empty list of byte arrays.
   * @since 2.0.0
   */
  List<byte[]> getLastExecutionResponses();

  /**
   * Returns the response of the command identified by the provided identifier, the response of the
   * last matching command if several prepared commands share that identifier.
   *
   * <p>See <a
   * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#op_CardTransactionManager_getLastExecutionResponse">CardTransactionManager.getLastExecutionResponse</a>
   * for the normative contract.
   *
   * @param idCommand The application-supplied identifier of the command whose response is
   *     requested.
   * @return Null if no command with the supplied identifier produced a response.
   * @since 2.0.0
   */
  byte[] getLastExecutionResponse(int idCommand);
}

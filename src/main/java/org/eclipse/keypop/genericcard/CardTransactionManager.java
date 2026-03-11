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

/**
 * Provides basic methods to prepare and process APDU exchange with a card.
 *
 * @since 1.0.0
 */
public interface CardTransactionManager
    extends org.eclipse.keypop.reader.transaction.spi.CardTransactionManager<
        CardTransactionManager> {

  /**
   * Prepares an APDU to be transmitted the next time {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)} is invoked.
   *
   * @param apduCommand A not empty hexadecimal string containing a raw APDU command.
   * @return This instance.
   * @since 1.0.0
   */
  CardTransactionManager prepareApdu(String apduCommand);

  /**
   * Prepares an APDU to be transmitted the next time {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)} is invoked.
   *
   * @param apduCommand A not empty byte arrays containing raw APDU commands.
   * @return This instance.
   * @since 1.0.0
   */
  CardTransactionManager prepareApdu(byte[] apduCommand);

  /**
   * Prepares an APDU to be transmitted the next time {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)} is invoked.
   *
   * @param cla The class byte.
   * @param ins The instruction byte.
   * @param p1 The P1 parameter.
   * @param p2 The P2 parameter.
   * @param dataIn The APDU data, null if there is no data.
   * @param le The expected output length, 0 if the output length is unspecified, null if no output
   *     data is expected.
   * @return This instance.
   * @since 1.0.0
   */
  CardTransactionManager prepareApdu(byte cla, byte ins, byte p1, byte p2, byte[] dataIn, Byte le);

  /**
   * Returns the list of responses corresponding to the commands executed by the last call to {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)}, represented as byte arrays.
   *
   * <p>Each element in the returned list represents the response of one command, in the same order
   * as the commands were prepared. The returned list is never {@code null}. <br>
   * This method does not alter the internal state of the manager: the list of responses remains
   * available for later calls until {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)} is invoked again, at which point it
   * is replaced by the new set of responses.
   *
   * @return A not {@code null} list of byte arrays representing the command responses, in the same
   *     order as the commands were sent.
   * @since 1.0.0
   */
  List<byte[]> getResponsesAsByteArrays();

  /**
   * Returns the list of responses corresponding to the commands executed by the last call to {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)}, represented as hexadecimal
   * strings.
   *
   * <p>Each element in the returned list represents the response of one command, in the same order
   * as the commands were prepared. The returned list is never {@code null}. <br>
   * This method does not alter the internal state of the manager: the list of responses remains
   * available for later calls until {@link
   * #processCommands(org.eclipse.keypop.reader.ChannelControl)} is invoked again, at which point it
   * is replaced by the new set of responses.
   *
   * @return A not {@code null} list of hexadecimal strings representing the command responses, in
   *     the same order as the commands were sent.
   * @since 1.0.0
   */
  List<String> getResponsesAsHexStrings();
}

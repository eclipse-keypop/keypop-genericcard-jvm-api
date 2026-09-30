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

/**
 * Immutable properties of the Generic Card API.
 *
 * <p>See <a
 * href="https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/2.0.0-SNAPSHOT/YYMMDD-SP-CNATerminalAPI-GenericCard_v2.0.0-SNAPSHOT.html#type_GenericCardApiProperties">GenericCardApiProperties</a>
 * for the normative contract.
 *
 * @since 1.0.0
 */
public final class GenericCardApiProperties {

  /**
   * Version of the API implemented by this binding, as a "MAJOR.MINOR" dotted decimal: {@value}
   *
   * @since 1.0.0
   */
  public static final String VERSION = "2.0";

  /** Private constructor */
  private GenericCardApiProperties() {}
}

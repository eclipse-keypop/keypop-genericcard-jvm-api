# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
:warning: Major version aligning the API with version `2.0` of the
[CNA Terminal Generic Card API specification](https://docs.terminal-api.calypsonet.org/calypsonet-terminal-genericcard-uml-api/).
This release is **not** backward compatible with `1.x`.
### Added
- `CardTransactionManager.prepareCommand(byte[], int)`: prepares a command with an application-supplied identifier.
- `CardTransactionManager.prepareCommand(byte[], int, long)`: adds a maximum tolerated exchange duration, used to
  detect a relay attack at the individual command level.
- `CardTransactionManager.getLastExecutionResponse(int)`: retrieves a response by command identifier.
### Changed
- `CardTransactionManager` now extends `IsoCardTransactionManager` (Reader API 3.0) instead of the generic
  `CardTransactionManager<T>`, which grants access to `asMultichannelCardTransactionManager()`.
- `prepareApdu(byte[])` -> `prepareCommand(byte[])`.
- `getResponsesAsByteArrays()` -> `getLastExecutionResponses()`.
- Upgraded the `keypop-reader-java-api` dependency to `3.0.0`.
### Removed
- `CardTransactionManager.prepareApdu(String)` and `prepareApdu(byte, byte, byte, byte, byte[], Byte)`: only the
  raw byte array form is retained by the specification.
- `CardTransactionManager.getResponsesAsHexStrings()`: responses are exposed as byte arrays only.

## [1.0.0] - 2026-03-11
This is the initial release.

[unreleased]: https://github.com/eclipse-keypop/keypop-genericcard-jvm-api/compare/1.0.0...HEAD 
[1.0.0]: https://github.com/eclipse-keypop/keypop-genericcard-jvm-api/releases/tag/1.0.0

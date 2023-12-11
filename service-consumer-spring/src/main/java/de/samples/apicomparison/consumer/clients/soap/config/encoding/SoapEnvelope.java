package de.samples.apicomparison.consumer.clients.soap.config.encoding;

/**
 * Use an object of this class to specify headers.
 */
public record SoapEnvelope(
  String header,
  Object body
) {

}

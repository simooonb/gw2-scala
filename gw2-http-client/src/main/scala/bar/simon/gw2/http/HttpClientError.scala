package bar.simon.gw2.http

import scala.util.control.NoStackTrace

sealed trait HttpClientError extends Exception

case class WrongStatusError(got: Int, expected: Int)
  extends RuntimeException(s"Wrong status: got $got, expected $expected")
    with HttpClientError
    with NoStackTrace

case class WrongStatusesError(got: Int, expected: List[Int])
  extends RuntimeException(s"Wrong status: got $got, expected one of ${expected.mkString(", ")}")
    with HttpClientError
    with NoStackTrace

case class DecodeResponseError(error: Throwable, response: String)
  extends RuntimeException(s"Failed to decode: $error. Received $response", error)
    with HttpClientError
    with NoStackTrace


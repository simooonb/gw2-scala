package bar.simon.gw2.http

import cats.effect.Sync
import cats.implicits._
import io.circe.Decoder
import io.circe.parser.decode
import requests.Response

import scala.concurrent.duration.Duration

final case class HttpClientConfig[F[_]](
    baseUrl: String,
    timeout: Duration
)(implicit F: Sync[F]) {

  def /(path: String): HttpClientConfig[F] =
    copy(baseUrl = getFullUrl(path))

  def get[T](
      path: String,
      query: Map[String, String] = Map.empty,
      additionalHeaders: Map[String, String] = Map.empty
  )(implicit decoder: Decoder[T]): F[T] =
    getRequest(path, query, additionalHeaders).flatMap(parseResponse(_)(decoder))

  def getRequest(
      path: String,
      query: Map[String, String] = Map.empty,
      additionalHeaders: Map[String, String] = Map.empty
  ): F[Response] =
    F.delay(
      requests.get(
        url = getFullUrl(path),
        headers = ("Accept", "application/json") :: additionalHeaders.toList,
        params = query.toList,
        readTimeout = timeout.toMillis.toInt,
        connectTimeout = timeout.toMillis.toInt,
        check = false
      )
    )

  def parseResponse[T](response: Response)(implicit decoder: Decoder[T]): F[T] =
    decode[T](response.text()) match {
      case Right(a)    => F.pure(a)
      case Left(error) => F.raiseError(DecodeResponseError(error, response.text()))
    }

  private def getFullUrl(path: String): String =
    s"$baseUrl/$path"
}

package biz.neumann.url

import java.net.{URLDecoder, URLEncoder}

import scala.util.matching.Regex

/**
  * Andreas Neumann
  * Date: 08.07.16
  */
object NiceURLCodecs {

  implicit val utf8: String = "utf-8"
  val whitespacePlus: Regex = "\\+".r
  val whiteSpaceEscape: String = "%20"

  implicit class NotURLEncodedString(val notEncoded: String) extends AnyVal{
    def encode(implicit encoding: String): URLEncodedString =  NiceURLCodecs.URLEncodedString(
      whitespacePlus.replaceAllIn( URLEncoder.encode(notEncoded, encoding), whiteSpaceEscape)
    )
    override def toString: String = notEncoded
  }

  implicit class URLEncodedString(val encodedString: String) extends AnyVal{
    def decode(implicit encoding: String): String = URLDecoder.decode(encodedString, encoding)
    override def toString: String = encodedString
  }

  implicit def decodedString(encoded: URLEncodedString) : String = encoded.decode
}

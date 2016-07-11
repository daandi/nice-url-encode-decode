package biz.neumann.url

import java.net.{URLDecoder, URLEncoder}

import scala.util.matching.Regex

/**
  * Andreas Neumann
  * Email: andreas@neumann.biz
  * Date: 08.07.16
  * Time: 13:22
  */
object NiceURLCodecs {

  implicit val utf8: String = "utf-8"
  val whitespacePlus: Regex = "\\+".r
  val whiteSpaceEscape: String = "%20"

  implicit class UnencodedURLString(val unencoded: String) extends AnyVal{
    def encode(implicit encoding: String) =  NiceURLCodecs.URLEncodedString(
      whitespacePlus replaceAllIn( URLEncoder.encode(unencoded, encoding), whiteSpaceEscape)
    )
    override def toString = encode
  }

  implicit class URLEncodedString(val encodedString: String) extends AnyVal{
    def decode(implicit encoding: String): String = URLDecoder.decode(encodedString, encoding)
    override def toString = decode
  }

  implicit def decodedString(encoded: URLEncodedString) : String = encoded.decode

}

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

  val utf8: String = "utf-8"
  val whitespacePlus: Regex = "\\+".r
  val whiteSpaceEscape: String = "%20"

  implicit class UnencodedURLString(val unencoded: String) extends AnyVal{
    def encode =  NiceURLCodecs.URLEncodedString(
      whitespacePlus replaceAllIn( URLEncoder.encode(unencoded, utf8), whiteSpaceEscape)
    )
    override def toString = encode
  }

  implicit class URLEncodedString(val encodedString: String) extends AnyVal{
    def decode: String = URLDecoder.decode(encodedString, utf8)
    override def toString = decode
  }

  implicit def decodedString(encoded: URLEncodedString) : String = encoded.decode

}

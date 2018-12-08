package biz.neumann.url
import org.scalatest.{FunSpec, Matchers}
import NiceURLCodecs._
/**
  * Andreas Neumann
  * Email: andreas@neumann.biz
  * Date: 08.07.16
  * Time: 13:43
  */

class NiceURLCodecsSpec extends FunSpec with Matchers{
  case class EncodedDecoded(encoded: String, decoded: String)

  val data : List[EncodedDecoded] = List(
    EncodedDecoded("",""),
    EncodedDecoded("%20"," "),
    EncodedDecoded("%C3%9Co","Üo"),
    EncodedDecoded("B%C3%B6hmerwald", "Böhmerwald"),
    EncodedDecoded("%C3%84%C3%96%C3%9C%C3%A4%C3%B6%C3%BC%C3%9F%25%3F%C3%A9%C3%A8%C3%A2%C3%82", "ÄÖÜäöüß%?éèâÂ"),
    EncodedDecoded("playa%20de%20palma","playa de palma"),
    EncodedDecoded("%CB%88bal%C9%90%CB%8Cman", "ˈbalɐˌman"),
    EncodedDecoded("%E1%BC%9C%CF%81%CF%89%CF%82", "Ἔρως")
  )

  describe("The nice URL Decoder") {
    data.foreach{ case EncodedDecoded(enc,dec) =>
      it(s"The encoded '$enc' should be decoded as '$dec'.") {
        enc.decode shouldEqual dec
      }
    }

    it("The toString method of notURLEncodedString returns teh not encoded string") {
      val epos = "Ἔρως"
      new NotURLEncodedString(epos).toString shouldEqual epos
    }
  }

  describe("The nice URL Encoder") {
    data.foreach{ case EncodedDecoded(enc,dec) =>
      it(s"The plain '$dec' should be encoded as '$enc'.") {
        dec.encode.encodedString shouldEqual URLEncodedString(enc).encodedString
      }
    }

    it("has an implicit conversion that transforms an URLEncodedString to an unescaped String whenever it is used in place of a String") {
      val ballamann = "ˈbalɐˌman"
      implicitly[String](URLEncodedString(ballamann.encodedString)) shouldEqual(ballamann)
    }

  }

  describe("The nice URL Codecs") {
    data.foreach{ case EncodedDecoded(_,dec) =>
      it(s"Encoding '$dec' and then decodig it should return an unchanged result.") {
        dec.encode.decode shouldEqual dec
      }
    }
  }

  describe("toString methods") {
    it("returns the encoded string in the toString for 'URLEncodedString'") {
      "München".encode.toString should be("M%C3%BCnchen")
    }
    it("returns the decoded string in the toString for 'DecodedURLString'") {
      "M%C3%BCnchen".decode.toString should be("München")
    }
  }

}


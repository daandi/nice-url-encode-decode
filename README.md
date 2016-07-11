# Nice Encoding and Decoding of String in URL Query Parameters

This library wants to put back the fun in working with URL-Encoded Strings.

# Adding to your project

# Remarks

* The library is biased towards using `%20` to escape ` ` instead of `+`.
* The library is biased towards `utf-8`. You can circumvent this though by supplying a different Encoding though as implicit parameter.

# Usage
```scala
scala> import biz.neumann.url.NiceURLCodecs._
import biz.neumann.url.NiceURLCodecs._

scala> "ˈbalɐˌman".encode
res0: biz.neumann.url.NiceURLCodecs.URLEncodedString = %CB%88bal%C9%90%CB%8Cman

scala> "ˈbalɐˌman".encode.decode
res1: String = ˈbalɐˌman

scala> "x%20x+x".decode
res3: String = x x x

```


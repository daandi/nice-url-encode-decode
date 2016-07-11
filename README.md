# Nice Encoding and Decoding of String in URL Query Parameters

This library wants to put back the fun in working with URL-Encoded Strings.

# State

[![Codeship](https://codeship.com/projects/68fa7440-298a-0134-be9b-0ae2ebcae286/status?branch=master)](https://codeship.com/projects/162626/status?branch=master)

[![Codacy Badge](https://api.codacy.com/project/badge/grade/777d4db9b275411881fadaba9c7da222)](https://www.codacy.com/app/andreas-neumann/nice-url-encode-decode)


# Adding to your project

# Remarks

* The `Pimp my library` pattern is use to make this extension possible. It is implemented using `value classes` to keep the overhead low.
* The library is biased towards using `%20` to escape ` ` instead of `+`.
* The library is biased towards `utf-8`. You can circumvent this though by supplying a different Encoding though as implicit parameter.


# Usage
Import the implicits to get your strings pimped:

```scala
scala> import biz.neumann.url.NiceURLCodecs._
import biz.neumann.url.NiceURLCodecs._
```

## Encoding

```scala
scala> "ˈbalɐˌman".encode
res0: biz.neumann.url.NiceURLCodecs.URLEncodedString = %CB%88bal%C9%90%CB%8Cman
```

Using some other encoding:
```
scala> "ˈbalɐˌman".encode("latin1")
res1: biz.neumann.url.NiceURLCodecs.URLEncodedString = %3Fbal%3F%3Fman
```
## Decoding

```scala
scala> "ˈbalɐˌman".encode.decode
res1: String = ˈbalɐˌman

scala> "x%20x+x".decode
res3: String = x x x
```


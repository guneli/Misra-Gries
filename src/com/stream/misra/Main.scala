package com.stream.misra
import scala.collection.mutable.{Map => MutableMap}
object Main {
def main( args:Array[String] ):Unit={

  var  b1=new Book("Martin ed", "1909","Jack London")
  var  b2=new Book("Martin edi", "1909","Jack London")
  var  b3=new Book("Martin ed", "1909","Jack London")
  var  b4=new Book("Martin eden", "1909","Jack London")
  var  b5=new Book("Martin edi", "1909","Jack London")
  var  b6=new Book("Martin edi", "1909","Jack London")

  var b=new Book()

  print(b.stream(3,b1,b2,b3,b4,b5,b6))

}

}

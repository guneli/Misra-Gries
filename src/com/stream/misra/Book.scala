package com.stream.misra
import java.util.Date
import scala.collection.mutable.{Map => MutableMap}


class Book (var name:String,var year:String, var author:String){
  def this(){
    this("","","")
  }
  def stream(k:Int,s:Book*): MutableMap[Book, Int]={
    val A = MutableMap[Book, Int]()
    for (i<-0 to s.length-1){
      if(A.contains(s(i))) {

        A += s(i) -> (A(s(i)) + 1)
      }
      else if (A.keys.size < (k - 1)) {
        A += s(i) -> 1

      }
      else {
        for(j<-A.keys){

          A(j)=A(j)-1
          if(A(j)==0) {
            A.subtractOne(j)

          }
        }
      }
    }
    return A;
  }
  override def equals(that: Any): Boolean =
    that match {
      case that: Book => {
        that.canEqual(this) &&
          this.name == that.name &&
          this.year == that.year &&
          this.author == that.author
      }
      case _ => false
    }
  def canEqual(a: Any) = a.isInstanceOf[Book]
  // Step 8 - implement a corresponding hashCode c=method
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (name == null) 0 else name.hashCode)
    result
  }
  override def toString() : String = {

    return "Book:  name =  " + name + ", year ="+ year+
      ",  author = " + author;
  }
}

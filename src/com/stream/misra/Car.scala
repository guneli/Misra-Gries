package com.stream.misra
import scala.collection.mutable.{Map => MutableMap}
class Car(var name:String,var year:String, var color:String) {
  def this(){
    this("","","")
  }
  def stream(k:Int,s:Car*): MutableMap[Car, Int]={
    val A = MutableMap[Car, Int]()
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
      case that: Car => {
        that.canEqual(this) &&
          this.name == that.name &&
          this.year == that.year &&
          this.color == that.color
      }
      case _ => false
    }
  def canEqual(a: Any) = a.isInstanceOf[Car]
  // Step 8 - implement a corresponding hashCode c=method
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (name == null) 0 else name.hashCode)
    result
  }
  override def toString() : String = {

    return "Car:  name =  " + name + ", year ="+ year+
      ",  author = " + color;
  }
}

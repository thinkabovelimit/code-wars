object CorelationAnalysis {
  def main(args: Array[String]): Unit = {
    val arr1=List(43, 21, 25, 42, 57, 59)
    val arr2=List(99, 65, 79, 75, 87, 81)
    /*
    * If correlation value is positive -> Positive correlation
    * else negative correlation*/
    if(corelationScore(arr1,arr2)<0) println("Negative correlation")
    else println("Positive correlation")

  }


  /*
  * function to find the correlation score
  * calculates the correlation score and returns the value
  * */
  def corelationScore(arr1:List[Int],arr2:List[Int]):Double={
    val arrlen=arr1.length
    val sum1=arr1.sum
    val sum2=arr2.sum
    val sumxy=(arr1,arr2).zipped.map(_ * _).sum
    val squareSum1=arr1.map(Math.pow(_, 2)).sum.toInt
    val squareSum2=arr2.map(Math.pow(_,2)).sum.toInt
    ((arrlen*sumxy)-(sum1*sum2))/math.sqrt(((arrlen*squareSum1)-sum1*sum1)*((arrlen*squareSum2)-sum2*sum2))
  }

}

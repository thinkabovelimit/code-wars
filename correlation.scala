object test {

  def main(args: Array[String]): Unit = {

    val arr1 = List(43, 21, 25, 42, 57, 59)
    val arr2 = List(99, 65, 79, 75, 87, 81)

    val r = correlation(arr1, arr2)
    println("Correlation : ", r)
    if (r < 0) println("Negative Correlation") else println("Positive Correlation")
  }

  def correlation(arr1: List[Int], arr2: List[Int]): Double = {

    val mean_arr1 = arr1.map(v => v - arr1.sum / arr1.length)
    val mean_arr2 = arr2.map(v => v - arr2.sum / arr2.length)
    (((mean_arr1, mean_arr2).zipped.map(_ * _).sum) / math.sqrt(((mean_arr1, mean_arr1).zipped.map(_ * _).sum) * ((mean_arr2, mean_arr2).zipped.map(_ * _).sum)))


  }
}
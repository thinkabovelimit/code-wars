object InterQuartile {
  def main(args: Array[String]): Unit = {
    /*
    * Sample input
    * {1,19,7,6,5,9,12,27,18,2,15}
    * Sample output 13
    * */
    println("Enter the list of integer without separation....")
    println("..................................................")
    //    val input_list= scala.io.StdIn.readLine()
    val input_list=List(1,19,7,6,5,9,12,27,18,2,15)
    val sorted_array= msort((x: Int, y: Int) => x < y)(input_list)
    println(sorted_array)
    println("Inter Quartile range is \n")
    println(IQR(sorted_array,sorted_array.length+1))

  }
  /*
  * Function to find the median
  * */
  def median[T](arr: List[T], lower_value: Int, upper_value: Int): Int = {
    (upper_value - lower_value + 1) / 2
  }

  /*
  * Function to find the inter quartile range
  * Find the 3rd and 1st quartile
  * Find the difference between third and first quartile*/
  def IQR(arr:List[Int],arr_length:Int):Int={
    val mid_index = median(arr, 0, arr_length)
    val q1=arr(median(arr, 0, mid_index))
    val q3=(arr(mid_index + median(arr, mid_index + 1, arr_length)))
    (q3-q1)

  }

  /*
  * Function to sort the array
  * Merge sort is the function used for sorting*/
  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

}

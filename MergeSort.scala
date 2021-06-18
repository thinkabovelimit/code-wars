import scala.util.Random
object MergeSort{
  def main(args: Array[String]): Unit = {
    /*
    * Input is taken and msort function is applied
    * Samle input 54321
    * Sample output List(1,2,3,4,5)*/
      println("Enter the list of integer without separation....")
      println("Sample 54321")
      println("...................................................")
      val input_list= scala.io.StdIn.readLine()
      println("\n\n")
      println("Sorted list is......")
      println(msort((x: Int, y: Int) => x < y)(input_list.map(_.toString.toInt).toList))
//    val list = Seq.fill(5000)(Random.nextInt(500)).toList
//    println(msort((x: Int, y: Int) => x < y)(list))
  }
/*
* Inputs- An array of of type T
* If size of the arrray is less than zero or one
* then no need to be sorted return the array
* if size is greater than 1
* Split the List and sort recursively*/
  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x::merge(xs1, ys)
          else y::merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}
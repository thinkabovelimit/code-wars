

object quartile {

  def main(args:Array[String])={
    println("Welcoming to IQR")
    var num_list=List(1,19,7,6,5,9,12,27,18,2,15)
    //var med=(0+num_list.length)/2
    num_list = num_list.sorted
    println(num_list)
    var med=find_median(0,num_list.length)
    println("The median is",num_list(med))
    var q1= num_list(find_median(0,med))
    //println(find_median(med+1,num_list.length))
    var q3=num_list(find_median(med+1,num_list.length))
    var IQR=q3-q1
    println("IQR is",IQR)
    var outliers=List(q1-(1.5*IQR),q3+(1.5*IQR))
    println(outliers)
    //find_outlier(outliers,num_list)

  }
  def find_median(first:Int,last:Int):Int={
    (first+last)/2
  }
  //def find_outlier(outlier_list: List[Double], num_list: List[Int])={
  // var a=outlier_list(0)
  //var b=outlier_list(1)
  //um_list.foreach(num=>num match{
  //case a to b contains num: println(num)})}scscal
  //[q1-1.5*IQR,q3-



}

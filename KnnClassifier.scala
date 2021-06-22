import scala.collection.mutable.ListBuffer
import scala.math._
object KnnClassifier {
  /*
  * Classified data set
  * class1-> values
  * class2-> values
  * K-> nearest neighbors to be classified
  * Try to create for multidimentional arrays */
  val  arr=Map(1->Seq(1,2,3,3,2,2,1),0->Seq(5,12,10,9,20,21,22,23))
  val p=9
  val k=3
  val labels=2
  //  val distance=new ListBuffer[ListBuffer(Int)]()
  //  val ll = scala.collection.mutable.ListBuffer.empty[List[Int]]
  val distance = scala.collection.mutable.ListBuffer.empty[List[Int]]
  distance += List(1,2)
  def main(args: Array[String]): Unit = {
    val ret_list=pre_classify(arr,distance,k,labels,p)
    println(classify(ret_list,arr))
  }
  def classify(ret_list:ListBuffer[List[Int]],arr:Map[Int,Seq[Int]]):String={
    var freq1=0
    var freq2=0
    for(i<- 0 until ret_list.length){
      if (arr.contains(ret_list(i)(0))) freq1=freq1+1
      else freq2=freq2+1
    }
    if (freq1>freq2) "Class1"
    else "Class2"
  }
  def pre_classify(arr:Map[Int,Seq[Int]],distance:ListBuffer[List[Int]],k:Int,labels:Int,p:Int):ListBuffer[List[Int]]={
    for(i <- 0 until labels){
      for(j <- 0 until arr(i).length) {
        val k=arr(i)(j)
        val dist=sqrt(pow(arr(i)(j)-p, 2))
        distance += List(k,dist.toInt)

      }
    }
    distance.sortBy(_(1)).take(k)
  }

}

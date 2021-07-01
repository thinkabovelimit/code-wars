/*
* Scala program for linear regression
* Linear regression is a statistical model used to plot the relation b/w dependent variable and a set of independent variable
* X -> is a feature vector
* Y -> is a response vector
*
* Plot a graph between x and y
* Our aim is to fnd a regression line
* which is h(i)=b0+b1x
* where b0 and b1 are y intercept and slope respectively*/

object LinearRegression {
  def main(args: Array[String]): Unit = {
    val feature_vector=List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val response_vector=List(1, 3, 2, 5, 7, 8, 8, 9, 10, 12)
    println(getPredictionVector(feature_vector,calculateCoefficient(feature_vector,response_vector)))

  }
  def getPredictionVector(feature_vector:List[Int],values:List[Double]):List[Double]={
    feature_vector.map(_*values(1)+values(0))
  }
  def calculateCoefficient(feature_vector:List[Int],response_vector:List[Int]):List[Double]={
    val mean_feature=feature_vector.sum.toDouble/feature_vector.length
    val mean_response=response_vector.sum.toDouble/response_vector.length
    /*
    * Calculate cross deviation and deviation on x
    * */
    val cross_deviation_helper=feature_vector.length* mean_feature * mean_response
    val feature_deviation_helper=feature_vector.length * mean_feature* mean_feature
    val cross_deviation=(response_vector,feature_vector).zipped.map(_ * _).sum -cross_deviation_helper
    val feature_deviation=(feature_vector,feature_vector).zipped.map(_ * _).sum - feature_deviation_helper
    val b_1= cross_deviation/feature_deviation
    val b_0= mean_response-b_1*mean_feature
    List(b_0,b_1)
  }

}

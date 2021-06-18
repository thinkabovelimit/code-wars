object WordCount {
  def main(args: Array[String]): Unit = {
    /*
    * Read input from user sample -> one one three
    * Sample output will be - Map(one -> 2, three -> 1)*/
    println("Enter the string to find the wordcount....")
    println("Sample one one three")
    println("...................................................")
    val input_string= scala.io.StdIn.readLine()
    println("\n\n")
    println("Wordcount is......")
    println(wcount(input_string))

  }
  /*
  * Function to find the number of occurances in a word
  * sample input -> one one three
  * sample output- Map(one -> 2, three -> 1)
  * */
  def wcount(sentence: String):Map[String,Int]= {
    sentence.split(" ")
      .foldLeft(Map.empty[String, Int]) {
        (count, word) =>
          count + (word -> (count.getOrElse(word, 0) + 1))

      }
  }
}
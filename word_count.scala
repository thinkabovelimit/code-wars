object sample {
  def main(args:Array[String])={
    println("Enter the string..")
    var input_string=scala.io.StdIn.readLine()
    println(word_count(input_string))
  }
  def word_count(sentence: String):Map[String,Int]={

    sentence.split(" ").groupBy(x=>x).transform((k,v)=>v.length)



  }

}
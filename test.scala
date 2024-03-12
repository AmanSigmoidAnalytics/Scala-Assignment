object BucketizeArray { 
  def main(args: Array[String]): Unit = { 
    // Sample array 
    val arr: Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.50) 
    
    // Defining bucket interval 
    val intervalSize: Double = 0.05 
 
    // Bucketizing the array 
    val bucketizedArray = bucketize(arr, intervalSize) 
 
    // Printing the result 
    println(bucketizedArray.mkString(", ")) 
  } 
 
  def bucketize(arr: Array[Double], intervalSize: Double): Array[String] = { 
    arr.map(value => { 
      val lowerBound = ((value+0.001)/ intervalSize).floor * intervalSize 
      val upperBound = lowerBound + intervalSize-0.001 
      f"$lowerBound%.3f - $upperBound%.3f" 
    }) 
  } 
} 

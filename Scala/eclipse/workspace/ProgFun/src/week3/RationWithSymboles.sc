package week3

object RationWithSymboles {
 
 def makeString(r: Rational1) =
    r.numer + "/" + r.denom                       //> makeString: (r: week3.Rational1)String


  val x1 = new Rational1(1, 3)                    //> x1  : week3.Rational1 = week3.Rational1@36d64342
  val y = new Rational1(5, 7)                     //> y  : week3.Rational1 = week3.Rational1@39ba5a14
  val z = new Rational1(3, 2)                     //> z  : week3.Rational1 = week3.Rational1@511baa65
  val b = x1 - y -z                               //> b  : week3.Rational1 = week3.Rational1@340f438e
  makeString(b)                                   //> res0: String = -79/42

  x1 < y                                          //> res1: Boolean = true

  makeString(x1 max y)                            //> res2: String = 5/7
  
  //val st= new Rational(1,0)
  //makeString(st.add(st))
  
}

class Rational1(x: Int, y: Int) {
  require(y != 0, "Denominator must be non Zero")
  
  def this(x : Int) = this(x,1)
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def <(that: Rational1) = numer * that.denom < that.numer * denom
  def max(that: Rational1) = if (this < that) that else this
  
  def + (that: Rational1) =
    new Rational1(
      numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- : Rational1 =
    new Rational1(-numer, denom)

  def - (that: Rational1) = this + -that
  //new Rational(
  //numer * that.denom - that.numer * denom, denom * that.denom)
}
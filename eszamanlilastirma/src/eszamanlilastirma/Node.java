package eszamanlilastirma;

public class Node {
public int id;
public int cocuk_sayisi;
public int[] cocuk_idleri;
public int cocuk_var_mi;
public int yarismaci_sahip;
public double[] output;

public Node(  int id,
  int cocuk_sayisi,
  int[] cocuk_idleri,
  int cocuk_var_mi,
  int yarismaci_sahip,
  double[] output)
{
	this.id= id;
	this.cocuk_idleri=cocuk_idleri;
	this.cocuk_sayisi=cocuk_sayisi;
	this.cocuk_var_mi=cocuk_var_mi;
	this.yarismaci_sahip=yarismaci_sahip;
	this.output=output;
}

public Node( )
{}
}

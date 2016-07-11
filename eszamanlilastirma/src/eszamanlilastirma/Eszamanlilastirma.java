package eszamanlilastirma;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
public class Eszamanlilastirma {
	public static Node[] tree_array;
	public static int node_sayisi;
	public Object[][] eszaman_matrisi;
	public int toplam_strateji_sayisi;
	public int cocuklu_nodlar;
	public int n;
	public  int[][] komsuluk_matrisi ;
	public void agac_doldurma()
	{int id; int yarismaci_sahip = 0; int cocuk_var_mi;int cocuk_sayisi = 0 ;int[] cocuk_idleri = null;  double[] output = null; int i,j;
		Scanner klavye = new Scanner(System.in);
		System.out.printf("Node sayisi girin:");		
		Eszamanlilastirma.node_sayisi = klavye.nextInt();	
		//Sequential to simultaneous
		System.out.printf("\n");
	 tree_array= new Node[node_sayisi]; 
		for(  i =0; i<node_sayisi;i ++ ) 
		{
			System.out.printf("node icin id girin:");			
			 id = klavye.nextInt();
			System.out.printf("\n");			
			
			System.out.printf("node'un cocugu var mi:");			
			 cocuk_var_mi = klavye.nextInt();
			System.out.printf("\n");
			
		if(cocuk_var_mi == 1 )
		{
			System.out.printf("node'un yarismaci sahibi kim:");			
			 yarismaci_sahip = klavye.nextInt();
			System.out.printf("\n");
			
			System.out.printf("node icin cocuk sayisi girin:");			
			 cocuk_sayisi = klavye.nextInt();
		     cocuk_idleri = new int[cocuk_sayisi];
		     
			for(j=0; j<cocuk_sayisi; j++ ) 
			{  System.out.printf("node icin cocuk id'lerini girin:");		
				cocuk_idleri[j]= klavye.nextInt();				
				System.out.printf("\n");
			}
		}
		else
		{	cocuk_idleri=null;
		    cocuk_sayisi=0;
		    yarismaci_sahip=0;
		
			 output = new double[2];
			System.out.printf("node'un cocugu yok, 1. output girin:");			
			
			 output[0] = klavye.nextDouble();
			 System.out.printf("\n");
			 System.out.printf("node'un cocugu yok, 2. output girin:");			
			 output[1] = klavye.nextDouble();
			System.out.printf("\n");
		}
			
			
			
			Node node = new Node( id,cocuk_sayisi, cocuk_idleri, cocuk_var_mi, yarismaci_sahip, output);
			tree_array[i] = node; 
			System.out.printf("\n");
			 
		}
		
		klavye.close();
		
	
		System.out.printf("\n");
	}
	
	public void agac_doldurma_ultimatom()
	{
		int id; int yarismaci_sahip = 0; int cocuk_var_mi;int cocuk_sayisi = 0 ;int[] cocuk_idleri = null;  double[] output = null; int i;
		Scanner klavye = new Scanner(System.in);
		 	
	
		
		
		System.out.printf("n girin:");		
		this.n = klavye.nextInt();	
		Eszamanlilastirma.node_sayisi =  3*n -2;
		
		System.out.printf("\n");
	 tree_array= new Node[node_sayisi]; 
		for(  i =0; i<node_sayisi;i ++ ) 
		{
			 		
			 id = i+1;		
			
			 	if(i<n)
			 	{
			 		 cocuk_var_mi=1;
			 	}
			 	else
			 	{
			 		 cocuk_var_mi=0;
			 	}
			 
			
		if(cocuk_var_mi == 1 )
		{
			if(i ==0 ) {
				cocuk_sayisi = n-1;
				cocuk_idleri = new int[n-1];
				for(int hh =0; hh < n-1; hh++)
				{
					cocuk_idleri[hh]=hh+2;
				}
			}
			else{
				cocuk_sayisi =2;
			  cocuk_idleri = new int[2];
		     
		     cocuk_idleri[0]=2*i+n-1;
		     cocuk_idleri[1] =2*i+n;
		     
		}
		}
		else
		{	cocuk_idleri=null;
		    cocuk_sayisi=0;
		    yarismaci_sahip=0;
		
			 output = new double[2];
			 		
			if((i-n) % 2 ==1)
			{
				 output[0] = 0;
						  
				output[1] =  0;
			}
			else
			{
				int temp = i-n;
				
				temp= temp /2 + 1; 
				output[0] = n-temp;
						  
				output[1] = temp; 
			}
			
			 
		}
			
			
			
			Node node = new Node( id,cocuk_sayisi, cocuk_idleri, cocuk_var_mi, yarismaci_sahip, output);
			tree_array[i] = node; 
			 
			 
		}
		
		klavye.close();
		
	
		 
		
	}
	
	public void agac_doldurma_ultimatom_budanmis()
	{
		int id; int yarismaci_sahip = 0; int cocuk_var_mi;int cocuk_sayisi = 0 ;int[] cocuk_idleri = null;  double[] output = null; int i;
		Scanner klavye = new Scanner(System.in);
		 	 
		System.out.printf("sayi girin:");		
		double sayi;
	 sayi = klavye.nextDouble();	
	 
		Eszamanlilastirma.node_sayisi =  ((int) Math.ceil(sayi/2))*3+1;
		
		System.out.printf("\n");
	 tree_array= new Node[node_sayisi]; 
		
	 for(  i =0; i<node_sayisi;i ++ ) 
		{
			 		
			 id = i+1;		
			
			 	if(i<(int) Math.ceil(sayi/2)+1)
			 	{
			 		 cocuk_var_mi=1;
			 	}
			 	else
			 	{
			 		 cocuk_var_mi=0;
			 	}
			 
			
		if(cocuk_var_mi == 1 )
		{
			if(i ==0 ) {
				cocuk_sayisi = (int) Math.ceil(sayi/2);
				cocuk_idleri = new int[cocuk_sayisi];
				for(int hh =0; hh < cocuk_sayisi; hh++)
				{
					cocuk_idleri[hh]=hh+2;
				}
			}
			else{
				cocuk_sayisi =2;
			  cocuk_idleri = new int[2];
		     
		     cocuk_idleri[0]= (int) Math.ceil(sayi/2)+1+2*(i-1)+1;
		     cocuk_idleri[1] =(int) Math.ceil(sayi/2)+1+2*(i-1)+2;
		     
		}
		}
		else
		{	cocuk_idleri=null;
		    cocuk_sayisi=0;
		    yarismaci_sahip=0;
		
			 output = new double[2];
			 		
			if((i-(int) Math.ceil(sayi/2)-1) % 2 ==1)
			{
				 output[0] = 0;
						  
				output[1] =  0;
			}
			else
			{
				int temp = i-(int) Math.ceil(sayi/2)-1;
				
				temp= temp /2 + 1; 
				output[0] = sayi-temp;
						  
				output[1] = temp; 
			}
			
			 
		}
			
			
			
			Node node = new Node( id,cocuk_sayisi, cocuk_idleri, cocuk_var_mi, yarismaci_sahip, output);
			tree_array[i] = node; 
			 
			 
		}
		tree_array[node_sayisi-2].output[0]=sayi/2;
		tree_array[node_sayisi-2].output[1]=sayi/2;
		klavye.close();
		
	
		 
		
	}
	public void matris_olusturma()
	{
		int i=0; int j=0;
		Object[] atama = new Object[2];
		int cocuklu_node_sayisi=0;
		this.toplam_strateji_sayisi=1;
		
		for(i=0; i< Eszamanlilastirma.tree_array.length;i++)
		{
			
		if(	Eszamanlilastirma.tree_array[i].cocuk_var_mi == 1)
		{
			cocuklu_node_sayisi++; //kac tane cocuklu node var
		    toplam_strateji_sayisi = toplam_strateji_sayisi * Eszamanlilastirma.tree_array[i].cocuk_sayisi; // matrisin kenar ve köþe boyutu
		}
		}
		
		this.cocuklu_nodlar = cocuklu_node_sayisi;
		int[][] cocuksayisi_ve_node_Sayisi= new int[cocuklu_node_sayisi][2];
		int k=0;
		for(i=0; i< Eszamanlilastirma.tree_array.length;i++)
		{
			if(	Eszamanlilastirma.tree_array[i].cocuk_var_mi == 1)
			{
				cocuksayisi_ve_node_Sayisi[k][0] =k+1; //id leri dolduruyoruz
		     cocuksayisi_ve_node_Sayisi[k][1] =Eszamanlilastirma.tree_array[i].cocuk_sayisi;
		     k++;
			}
		}
		
		
		
		
		
		int[][] temporary_array = new int[toplam_strateji_sayisi][cocuklu_node_sayisi];
		this.eszaman_matrisi = new Object [toplam_strateji_sayisi+1][toplam_strateji_sayisi+1];
		 
		
		
		
		int kk=1; int xx;
		int aralik=0;  int ex_aralik=0;
		aralik = toplam_strateji_sayisi;
		ex_aralik=toplam_strateji_sayisi;
		
		
		
		for(i =0; i	< cocuklu_node_sayisi; i++ )
		{  
		   aralik = aralik / cocuksayisi_ve_node_Sayisi[i][1];
			for(j=0; j< toplam_strateji_sayisi ; j++)
			{
				temporary_array[j][i]=kk;
			     xx = j+1;
				if(xx % aralik == 0)
					kk++;
			if( xx  %  ex_aralik == 0)
				kk=1;
			
			}
			ex_aralik= aralik;
			
			
			
		}
		
		for(i=1; i< toplam_strateji_sayisi+1; i ++)
		{
			
			 
			this.eszaman_matrisi[i][0] = temporary_array[i-1] ;
			this.eszaman_matrisi[0][i] = temporary_array[i-1] ;
		}
		
		Eszamanlilastirma.tree_array[0].yarismaci_sahip =1;
		for(int gg = 0; gg < Eszamanlilastirma.node_sayisi; gg++)
		{
			for(int ff = 0; ff< Eszamanlilastirma.tree_array[gg].cocuk_sayisi; ff++) 
				{
				int cocuk = 0;
				cocuk =Eszamanlilastirma.tree_array[gg].cocuk_idleri[ff];
				if(Eszamanlilastirma.tree_array[gg].yarismaci_sahip == 1)
				{
					Eszamanlilastirma.tree_array[cocuk -1].yarismaci_sahip =2;
				}
				else 
				{
					Eszamanlilastirma.tree_array[cocuk -1].yarismaci_sahip =1;
				}
				 
						
				}
		}
		
		
	
		
		
		//int[] S1 = new int[cocuklu_node_sayisi];
		//int[] S2 = new int[cocuklu_node_sayisi];
		int[] Sonuc1 = new int[cocuklu_node_sayisi];
		int[] Sonuc2 = new int[cocuklu_node_sayisi];
		 kk=0;
		// System.out.println();
		for(i =1; i< toplam_strateji_sayisi+1;i++)
		{
			for(j =1; j< toplam_strateji_sayisi+1;j++)
			{
				//matriste karþýlaþtýrýlacak iki strateji S1 ve S2
				Sonuc1 = (int[]) this.eszaman_matrisi[i][0];			
				Sonuc2 = (int[]) this.eszaman_matrisi[0][j];
		///	*****************************************************************************************************************
			/*
			for(kk=0; kk< cocuklu_node_sayisi; kk++)
			{
				
				if(kk % 2 ==0)
				{
					Sonuc1[kk]=S1[kk];
					
					Sonuc2[kk] = S2[kk];
				}
				else
				{
					Sonuc1[kk]=S2[kk];
					
					Sonuc2[kk] = S1[kk];
				}
				
			}
		///	
			*/
			Node n; int uu=0;
			int[] Sonuc1_id_toplama = new int[cocuklu_node_sayisi];
			int[] Sonuc2_id_toplama = new int[cocuklu_node_sayisi];
			for(kk=0; kk< Eszamanlilastirma.node_sayisi; kk++)//sonuclarý bulduk. treede gezip hangi outputa ulaþacaðýmýzý bulacaðýz.
			{
				n= Eszamanlilastirma.tree_array[kk];
				if(n.cocuk_var_mi == 1)
				{
					Sonuc1_id_toplama[uu] = n.cocuk_idleri[Sonuc1[uu]-1];
					Sonuc2_id_toplama[uu] = n.cocuk_idleri[Sonuc2[uu]-1];
					
					
				uu++;	
				}	
				else
				{
					continue;
				}
			}
			uu=0;
		
			double[] output1=null; double[] output2=null;
			int anne1=1; int flag1 =0;
			
		 
			int[] dizi1 = new int[cocuklu_node_sayisi];
			int[] dizi2 = new int[cocuklu_node_sayisi];
			int d1 = 0;  int a, b;
			for(int oo=0; oo < cocuklu_node_sayisi; oo++)
			{
				
				a = Sonuc1_id_toplama[oo];
				b = Sonuc2_id_toplama[oo];
			 
				if(Eszamanlilastirma.tree_array[a-1].yarismaci_sahip ==2)
				{
					dizi1[d1]= a;
					dizi2[d1]= b;
					d1++;
				}
				else
				{
					dizi1[d1] = b;
					dizi2[d1]= a;
					d1++;
				}
				 
			}
			
			for(int oo=0; oo < cocuklu_node_sayisi; oo++)
			{
				Sonuc1_id_toplama[oo]=	dizi1[oo];
				Sonuc2_id_toplama[oo]= dizi2[oo];
			}
			
			/*
			int[] dizi1 = new int[cocuklu_node_sayisi];
			int[] dizi2 = new int[cocuklu_node_sayisi];
			int d1 = 0; int d2 = 0; int e1 = 1; int e2 = 1; int a, b;
			
			dizi1[0] = Sonuc2_id_toplama[0] ;
			dizi2[0] = Sonuc1_id_toplama[0] ;
			
			for(int oo=0; oo < cocuklu_node_sayisi; oo++)
			{

				a= Sonuc1_id_toplama[d1];
				b = Sonuc2_id_toplama[d2];
				
				if(Eszamanlilastirma.tree_array[a-1].yarismaci_sahip ==1)
				{
					
					 
					a= Sonuc1_id_toplama[d1];
					b = Sonuc2_id_toplama[d2];
					
					
				}
				else
				{
					 
					b= Sonuc1_id_toplama[d1];
					a = Sonuc2_id_toplama[d2];
				}
				
			 
				
				if(Eszamanlilastirma.tree_array[a-1].cocuk_var_mi ==1) //a'nýn varsa b'nin de vardýr
				{
				for(int pp =0; pp< Eszamanlilastirma.tree_array[a-1].cocuk_sayisi; pp++)
				{
					int cocuk = Eszamanlilastirma.tree_array[a-1].cocuk_idleri[pp];
					int rr;
					for( rr =0; rr< cocuklu_node_sayisi; rr++)
					{
						if(Sonuc2_id_toplama[rr] == cocuk)
						{
							break;
						}
					}
					if(rr != cocuklu_node_sayisi)
					{
					dizi1[e1] = Sonuc2_id_toplama[rr] ;
					e1++;
					}
					
				}
				for(int pp =0; pp< Eszamanlilastirma.tree_array[b-1].cocuk_sayisi; pp++)
				{
					int cocuk = Eszamanlilastirma.tree_array[b-1].cocuk_idleri[pp];
					int rr;
					for( rr =0; rr< cocuklu_node_sayisi; rr++)
					{
						if(Sonuc1_id_toplama[rr] == cocuk)
						{
							break;
						}
					}
					
					if(rr != cocuklu_node_sayisi)
					{	dizi2[e2] = Sonuc1_id_toplama[rr] ;
					e2++;
					}
				}
				
				
				
				d1++;d2 ++;
				
				}
				 
					
				
				
				
				
			}
			
			*/
			
			
			for(kk=0; kk<cocuklu_node_sayisi;kk++)
			{
				for(int tt =0 ; tt< Eszamanlilastirma.tree_array[anne1-1].cocuk_sayisi; tt++) //annenin bütün çocuklarýna bakýyoruz kk onun çocuðu mu diye
				{
					if(Eszamanlilastirma.tree_array[anne1-1].cocuk_idleri[tt] == Sonuc1_id_toplama[kk])
					{
						flag1 =1;
						anne1= Sonuc1_id_toplama[kk]; //yeni anne
						break;
						
					}
						
				}
			//	System.out.println();
				 
				if(flag1 == 1) //kk annenin çocuðu ise
				{
					 flag1=0;
				if(Eszamanlilastirma.tree_array[Sonuc1_id_toplama[kk]-1].cocuk_var_mi == 1)
				{
					continue;
				}
				else
				{
					//sadece listede çocuðu olaný takip etmek lazým
					 output1=new double[2];
					 
					 output1[0]= Eszamanlilastirma.tree_array[Sonuc1_id_toplama[kk]-1].output[0];
					 output1[1]= Eszamanlilastirma.tree_array[Sonuc1_id_toplama[kk]-1].output[1];
					
					 break;
				}
					
				}
				
			}
			
			
			int anne2=1; int flag2 =0;
			for(kk=0; kk<cocuklu_node_sayisi;kk++)
			{
				for(int tt =0 ; tt< Eszamanlilastirma.tree_array[anne2-1].cocuk_sayisi; tt++) //annenin bütün çocuklarýna bakýyoruz kk onun çocuðu mu diye
				{
					if(Eszamanlilastirma.tree_array[anne2-1].cocuk_idleri[tt] == Sonuc2_id_toplama[kk])
					{
						flag2 =1;
						anne2= Sonuc2_id_toplama[kk]; //yeni anne
						break;
						
					}
						
				}
				
				if(flag2 == 1 ) //kk annenin çocuðu ise
				{
					flag2 =0;
				if(Eszamanlilastirma.tree_array[Sonuc2_id_toplama[kk]-1].cocuk_var_mi == 1)
				{
					continue;
					
				}
				else
				{   //sadece listede çocuðu olaný takip etmek lazým
					 output2=new double[2];
					 //////////////////////output x y yer deðiþtirmemeli ***********************************************
					 output2[0]= Eszamanlilastirma.tree_array[Sonuc2_id_toplama[kk]-1].output[1];
					 output2[1]= Eszamanlilastirma.tree_array[Sonuc2_id_toplama[kk]-1].output[0];
					
					 
					
					 break;
				}
				}
				
				
			}
			
			atama = new Object[3];//sonuncusuna seçilen output konulacak
			atama[0] = output1;
			atama[1] = output2;
			 this.eszaman_matrisi[i][j]= atama;
			 
			
			//System.out.printf("i: %d j: %d output1: ( %.1f , %.1f )\n",i,j,output1[0],output1[1]);
			//System.out.printf("i: %d j: %d output2: ( %.1f , %.1f )\n",i,j,output2[0],output2[1]);
			// S1 = new int[cocuklu_node_sayisi];
			 //S2 = new int[cocuklu_node_sayisi];
			}
		}
		
		
		//matrisi yazdýralým
		int[] output_kenar=new int[2];
		double[] output_1=new double[2];
		double[] output_2=new double[2];
		//System.out.println();
		for(i=0; i<toplam_strateji_sayisi+1;i++)
		{
			for(j=0;j< toplam_strateji_sayisi+1; j++)				
			{
				if(i==0 || j == 0)
				{
					if(i==0 && j==0)
				    {System.out.printf("                 ");
				     continue;
				     }
					else
					{
						output_kenar=new int[2];
						output_kenar =    (int[]) this.eszaman_matrisi[i][j];
						 /////////////////// sadece 1 kiþi oynayýnca hata veriyor
						System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
						 
						  
						  
					}
					
					
				}
				else {
				 atama = new Object[2];
				  atama =    (Object[]) this.eszaman_matrisi[i][j];
				 output_1=new double[2];
				 output_1 = (double[]) atama [0];
				 
				 output_2=new double[2];
				 output_2 = (double[]) atama [1];
				 
				System.out.printf("( %.1f , %.1f ) ( %.1f , %.1f ) ", output_1[0],output_1[1],output_2[0],output_2[1]);
			}
			}
			System.out.println();
		}
		
		System.out.println();
		
			
	}
	
	public void strictly_dominant_yoksa_farki_büyük_olan()
	{
		double[] output_1=new double[2]; int i,j; double fark1,fark2;
		double[] output_2=new double[2];
		int[] output_kenar=new int[2];
		Object[] atama = new Object[3];
		System.out.println("Stcrictly dominant");
		for(i=0; i<toplam_strateji_sayisi+1;i++)
		{
			for(j=0;j< toplam_strateji_sayisi+1; j++)				
			{
				if(i==0 || j == 0)
				{
					if(i==0 && j==0)
				    {System.out.printf("                 ");
				     continue;
				     }
					else
					{
						output_kenar=new int[2];
						output_kenar =    (int[]) this.eszaman_matrisi[i][j];
						 
						System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
						 
						  
						  
					}
					
					
				}
				else {
				 atama = new Object[3];
				  atama =    (Object[]) this.eszaman_matrisi[i][j];
				 output_1=new double[2];
				 output_1 = (double[]) atama [0];
				 
				 output_2=new double[2];
				 output_2 = (double[]) atama [1];
				 
				 if(output_1[0] < output_2[0] && output_1[1]< output_2[1])  
				 {
					 atama[2]= output_2;
					 System.out.printf("| ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1], output_2[0],output_2[1], output_2[0],output_2[1]);
				 }
				 else if(output_1[0] > output_2[0] && output_1[1] > output_2[1])
				 {
					 atama[2]= output_1;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
				 }
				 else if (output_1[0] == output_2[0] && output_1[1] == output_2[1])
				 {
					 atama[2]= output_1;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
						
				 }
				 else if(output_1[0] == output_2[1] && output_1[1] == output_2[0])
				 {   double[] output_3=new double[2];
					 double toplam = output_1[0] + output_1[1] ;
					 toplam = toplam /2;
					 output_3[0] = toplam;
					 
					 output_3[1] =toplam; 
					 
					 atama[2]=output_3;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_3[0],output_3[1]);
						
				 }
				 else
				 {
					 fark1= Math.abs(output_1[0]-output_1[1]);
					 fark2=Math.abs(output_2[0]-output_2[1]);
					
					 if(fark1< fark2)
					 {
						 atama[2]= output_2;
						 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_2[0],output_2[1]);
							
					 }
					 else
					 {
						 atama[2]= output_1;
						 System.out.printf("| ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1], output_2[0],output_2[1], output_1[0],output_1[1]);
							
					 }
					  
				 }
				 
				 this.eszaman_matrisi[i][j]=atama;
		
				
				 
			}
			}
			System.out.println();
		}
	}
	public void strictly_dominant_yoksa_farki_kücük_olan()  
	{
		double[] output_1=new double[2]; int i,j; double fark1,fark2;
		double[] output_2=new double[2];
		int[] output_kenar=new int[2];
		Object[] atama = new Object[3];
		System.out.println("Stcrictly dominant");
		for(i=0; i<toplam_strateji_sayisi+1;i++)
		{
			for(j=0;j< toplam_strateji_sayisi+1; j++)				
			{
				if(i==0 || j == 0)
				{
					if(i==0 && j==0)
				    {System.out.printf("                 ");
				     continue;
				     }
					else
					{
						output_kenar=new int[2];
						output_kenar =    (int[]) this.eszaman_matrisi[i][j];
						 
						System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
						 
						  
						  
					}
					
					
				}
				else {
				 atama = new Object[3];
				  atama =    (Object[]) this.eszaman_matrisi[i][j];
				 output_1=new double[2];
				 output_1 = (double[]) atama [0];
				 
				 output_2=new double[2];
				 output_2 = (double[]) atama [1];
				 
				 if(output_1[0] < output_2[0] && output_1[1]< output_2[1])  
				 {
					 atama[2]= output_2;
					 System.out.printf("| ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1], output_2[0],output_2[1], output_2[0],output_2[1]);
				 }
				 else if(output_1[0] > output_2[0] && output_1[1] > output_2[1])
				 {
					 atama[2]= output_1;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
				 }
				 else if (output_1[0] == output_2[0] && output_1[1] == output_2[1])
				 {
					 atama[2]= output_1;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
						
				 }
				 else if(output_1[0] == output_2[1] && output_1[1] == output_2[0])
				 {   double[] output_3=new double[2];
					 double toplam = output_1[0] + output_1[1] ;
					 toplam = toplam /2;
					 output_3[0] = toplam;
					 
					 output_3[1] =toplam; 
					 
					 atama[2]=output_3;
					 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_3[0],output_3[1]);
						
				 }
				 else
				 {
					 fark1= Math.abs(output_1[0]-output_1[1]);
					 fark2=Math.abs(output_2[0]-output_2[1]);
					
					 if(fark1<= fark2)
					 {
						 atama[2]= output_1;
						 System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
							
					 }
					 else
					 {
						 atama[2]= output_2;
						 System.out.printf("| ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1], output_2[0],output_2[1], output_2[0],output_2[1]);
							
					 }
					  
				 }
				 
				 this.eszaman_matrisi[i][j]=atama;
		
				
				 
			}
			}
			System.out.println();
		}
	}
	public void farki_kücük_olan()
	{
		double[] output_1=new double[2]; int i,j; double fark1,fark2;
		double[] output_2=new double[2];
		int[] output_kenar=new int[2];
	
		Object[] atama = new Object[3];
		//System.out.println();
		for(i=0; i<toplam_strateji_sayisi+1;i++)
		{
			for(j=0;j< toplam_strateji_sayisi+1; j++)				
			{
				if(i==0 || j == 0)
				{
					if(i==0 && j==0)
				    {System.out.printf("                 ");
				     continue;
				     }
					else
					{
						output_kenar=new int[2];
						output_kenar =    (int[]) this.eszaman_matrisi[i][j];
						 
						System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
						 
						  
						  
					}
					
					
				}
				else {
				 atama = new Object[3];
				  atama =    (Object[]) this.eszaman_matrisi[i][j];
				 output_1=new double[2];
				 output_1 = (double[]) atama [0];
				 
				 output_2=new double[2];
				
				 output_2 = (double[]) atama [1];
				  
				 fark1= Math.abs(output_1[0]-output_1[1]);
				 fark2=Math.abs(output_2[0]-output_2[1]);
				// eðer ab ile cd eþitse toplam payoff eþit bölüþülsün
				 if(output_1[0] == output_2[1] && output_1[1] == output_2[0]  ) 
				 {   double[] output_3=new double[2];
					 double toplam = output_1[0] + output_1[1] ;
					 toplam = toplam /2;
					 output_3[0] = toplam;
					 
					 output_3[1] =toplam; 
					 
					 atama[2]=output_3;
					 System.out.printf(" ( %.1f , %.1f ) ", output_3[0],output_3[1]);
				 }
				 else
				 {
					 if(fark1<= fark2)
				 {
					 atama[2]= output_1;
					 System.out.printf(" ( %.1f , %.1f ) ", output_1[0],output_1[1]);
				 }
				 else
				 {
					 atama[2]= output_2;
					 System.out.printf(" ( %.1f , %.1f ) ", output_2[0],output_2[1]);
				 } 
				 }
			
				 this.eszaman_matrisi[i][j]=atama;
				
				 
			}
			}
			System.out.println();
		}
	}
	public void farki_büyük_olan()
	{

		double[] output_1=new double[2]; int i,j; double fark1,fark2;
		double[] output_2=new double[2];
		int[] output_kenar=new int[2];
	
		Object[] atama = new Object[3];
		//System.out.println();
		for(i=0; i<toplam_strateji_sayisi+1;i++)
		{
			for(j=0;j< toplam_strateji_sayisi+1; j++)				
			{
				if(i==0 || j == 0)
				{
					if(i==0 && j==0)
				    {System.out.printf("                 ");
				     continue;
				     }
					else
					{
						output_kenar=new int[2];
						output_kenar =    (int[]) this.eszaman_matrisi[i][j];
						 
						System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
						 
						  
						  
					}
					
					
				}
				else {
				 atama = new Object[3];
				  atama =    (Object[]) this.eszaman_matrisi[i][j];
				 output_1=new double[2];
				 output_1 = (double[]) atama [0];
				 
				 output_2=new double[2];
				
				 output_2 = (double[]) atama [1];
				  
				 fark1= Math.abs(output_1[0]-output_1[1]);
				 fark2=Math.abs(output_2[0]-output_2[1]);
				// eðer ab ile cd eþitse toplam payoff eþit bölüþülsün
				 if(output_1[0] == output_2[1] && output_1[1] == output_2[0]  ) 
				 {   double[] output_3=new double[2];
					 double toplam = output_1[0] + output_1[1] ;
					 toplam = toplam /2;
					 output_3[0] = toplam;
					 
					 output_3[1] =toplam; 
					 
					 atama[2]=output_3;
					 System.out.printf(" ( %.1f , %.1f ) ", output_3[0],output_3[1]);
				 }
				 else
				 {
					 if(fark1< fark2)
				 {
					 atama[2]= output_2;
					 System.out.printf(" ( %.1f , %.1f ) ", output_2[0],output_2[1]);
				 }
				 else
				 {
					 atama[2]= output_1;
					 System.out.printf(" ( %.1f , %.1f ) ", output_1[0],output_1[1]);
				 } 
				 }
			
				 this.eszaman_matrisi[i][j]=atama;
				
				 
			}
			}
			System.out.println();
		}
	}
	
	
	
	
public double[] rabin_fairness_sabitler(int oyuncu)
	{ int i=0; int j =0;
	int cocuksuz_nodlar = Eszamanlilastirma.node_sayisi - this.cocuklu_nodlar;
		double[][] output_elenmemis =new double[cocuksuz_nodlar][3];
		//3.hücrede bir sonucun pareto optimal olup olmadýðýný iþaretliyoruz. 1 pareto optimal deðil, 0 pareto optimal
		for(i =0; i< Eszamanlilastirma.node_sayisi; i++)
		{
			output_elenmemis[j][2] =0;
			//bütün outputlarý bir diziye at
			if(Eszamanlilastirma.tree_array[i].cocuk_var_mi == 0)
			{
			output_elenmemis[j][0] = Eszamanlilastirma.tree_array[i].output[0];
			output_elenmemis[j][1] = Eszamanlilastirma.tree_array[i].output[1];
					j++;
			}
		}
		
		for(i=0; i< cocuksuz_nodlar;i++)
		{
			for(j= 0; j< cocuksuz_nodlar; j ++)
			{
				if(i == j)
				{
					continue;
				}
				else
				{	
				if((output_elenmemis[i][0] < output_elenmemis[j][0] && output_elenmemis[i][1] <= output_elenmemis[j][1] )
						|| 
				   (output_elenmemis[i][0] <= output_elenmemis[j][0] && output_elenmemis[i][1] < output_elenmemis[j][1] ))
				{
					output_elenmemis[i][2] = 1;
					break;
				}
			    }
			}
		}
		
		double pareto_max = Double.MIN_VALUE;
		
		double pareto_min = Double.MAX_VALUE;
		double min = Double.MAX_VALUE;
		
		double equitable;
		for(i=0; i< cocuksuz_nodlar; i++)
		{
			if(output_elenmemis[i][2] == 0) // sadece paretolar arasýnda min ve max bulmak için
			{
				
				
				if(output_elenmemis[i][oyuncu] > pareto_max)
				{
					pareto_max = output_elenmemis[i][oyuncu];
				}
				if(output_elenmemis[i][oyuncu] < pareto_min)
				{
					pareto_min = output_elenmemis[i][oyuncu];
				}
				
			}
			
			if(output_elenmemis[i][oyuncu]< min)
			{
				min = output_elenmemis[i][oyuncu];
			}
		}
		
		equitable = (pareto_max + pareto_min )/ 2;
		
		double[] result = new double[4];
		result[0] =pareto_max;
		result[1] = pareto_min;
		result[2] = min;
		result[3] = equitable;
		
		return result;
		
		
	}
	
	public double rabin_kindness(int oyuncu , double[] output) // "oyuncu" nun diðer oyuncuya kibarlýðý
	{
	
		double[] sabitler = new double[4]; double f_kindness;
		sabitler = rabin_fairness_sabitler(Math.abs(oyuncu-1));//formülde diðer oyuncuya ait sabitler alýnýyor ***önemli
		double payda = sabitler[0] - sabitler[2] ;
		if(payda == 0)
		{
			f_kindness = 0;
		}
		else
		{
			f_kindness = (output[Math.abs(oyuncu-1)]-sabitler[3]) / payda;
		}
		
		
		return f_kindness;
	}
	
	public void rabin_fair(int argument)
	{
		int i,j;
		Object[] atama = new Object[3]; double f1 = 0; double f_yildiz1 = 0; double f2 = 0; double f_yildiz2 = 0 ;
		double f3 = 0; double f_yildiz3 = 0; double f4 = 0; double f_yildiz4 = 0 ;
		 
			
			 
				double[] output_1=new double[2];
				double[] output_2=new double[2];
			//	System.out.println();
				for(i=0; i<toplam_strateji_sayisi+1;i++)
				{
					for(j=0;j< toplam_strateji_sayisi+1; j++)				
					{
						if(i==0 || j == 0)
						{
							continue;
							
						}
						else 
						{
						 atama = new Object[3];
						  atama =    (Object[]) this.eszaman_matrisi[i][j];
						 output_1=new double[2];
						 output_1 = (double[]) atama [0];
						 
						 output_2=new double[2];
						 output_2 = (double[]) atama [1];
						 
						
						
						
							f1= this.rabin_kindness(0, output_1); //ben 0 im ben a istiyorum sen b istiyosun
					    	f_yildiz1 = this.rabin_kindness(1, output_1);  //sen 1sin. ben a olayým isiyosun sen b ol istiyosun
						
					    	f3= this.rabin_kindness(0, output_2);  //ben 0ým ben c istiyorum sen d istiyosun
					    	f_yildiz3 = this.rabin_kindness(1, output_2);  //sen 1sin. ben c olayým isiyosun sen d ol istiyosun
						
							f2= this.rabin_kindness(1, output_1); //ben 1 im ben b istiyorum sen a istiyosun
						    f_yildiz2 = this.rabin_kindness(0, output_1);  //sen 0sin. ben b olayým isiyosun sen a ol istiyosun
						    	
						    f4= this.rabin_kindness(1, output_2);  //ben 1 im ben d istiyorum sen c istiyosun
						    f_yildiz4 = this.rabin_kindness(0, output_2);   //sen 0sýn. ben d olayým isiyosun sen c ol istiyosun
					
						
						 
						 output_1[0]= output_1[0] + f_yildiz1 * (1+ f1);//1.oyuncu (a,b)yi istiyor 2.si (c,d)yi
						 output_1[1] = output_1[1] + f_yildiz2 * (1+ f2); 
						 output_2[0] = output_2[0] + f_yildiz3 * (1+ f3);
						 output_2[1] = output_2[1] + f_yildiz4 * (1+ f4); 
						 
						
						
						atama = new Object[3];//sonuncusuna seçilen output konulacak
						atama[0] = output_1;
						
						 
						 
					 
						
						atama[1] = output_2;
						 this.eszaman_matrisi[i][j]= atama;
						
						
					}
					}
					 
				}
				
				
				
				
				if(argument == 0)
				{
					strictly_dominant_yoksa_farki_kücük_olan(); 
				}
				else
				{
					strictly_dominant_yoksa_farki_büyük_olan(); 
				}
				
				
				 
	}
	public void Nash_dengeleri()
	{
		int flag1 =0; int flag2 =0;Object[] atama ; double[] output_1; double[] output_2;double[] output_3;double[] output_4;
		System.out.println();
		for(int i =1; i< this.toplam_strateji_sayisi+1; i ++)
			{
				for(int j =1; j< this.toplam_strateji_sayisi+1; j++)
				{
					 atama = new Object[3];
					 atama =    (Object[]) this.eszaman_matrisi[i][j];
					 output_1=new double[2];
					 output_1 = (double[]) atama [2];
					 
					for(int k =1; k< this.toplam_strateji_sayisi+1; k++)
					{ 
						 
						 atama = new Object[3];
						 atama =    (Object[]) this.eszaman_matrisi[i][k];
						 output_2=new double[2];
						 output_2 = (double[]) atama [2];
						 
						if(  output_2[1]>  output_1[1])
						{
							flag1 =1;
							break;
						}
					}
					
					
					for(int k =1; k< this.toplam_strateji_sayisi+1; k++)
					{
						
						 atama = new Object[3];
						 atama =    (Object[]) this.eszaman_matrisi[k][j];
						 output_2=new double[2];
						 output_2 = (double[]) atama [2];
						 
						if(  output_2[0]> output_1[0])
						{
							flag2 =1;
							break;
						}
					}
					
					
					if(flag1==0 && flag2 ==0)
					{
                        int[] yazdirma1  = (int[]) this.eszaman_matrisi[i][0];
                        int[] yazdirma2  = (int[]) this.eszaman_matrisi[0][j];
                        
                        atama = new Object[3];
						 atama =    (Object[]) this.eszaman_matrisi[i][j];
						 
						 output_3=(double[]) atama[0];
						 output_4=(double[]) atama[1];
                      
						  System.out.printf("satýr:");
                        
						for(int ff=0; ff<  this.cocuklu_nodlar; ff++)
						{
							 System.out.printf(" %d ", yazdirma1[ff]);
						}
						 System.out.printf(" sütun:");
						for(int ff=0; ff<  this.cocuklu_nodlar; ff++)
						{
							 System.out.printf(" %d ", yazdirma2[ff]);
						}
						
						 
						 System.out.printf(" ( %.1f, %.1f )( %.1f, %.1f ):( %.1f, %.1f )\n", output_3[0], output_3[1], output_4[0], output_4[1],output_1[0], output_1[1]);
						 	  
						 
						
					}
					flag1=0 ; flag2 =0;
				}
			}
	}
	
public  void RandomTreeCreation()
{	
	
	
	@SuppressWarnings("resource")
	Scanner klavye = new Scanner(System.in);
	System.out.printf("Rasgele oluþacak aðaçtaki düðüm sayýsýný girin:");		
	int dugum_sayisi = klavye.nextInt();	
	
	RandomTree tree= new RandomTree();
	komsuluk_matrisi = new int [dugum_sayisi][dugum_sayisi];
	 
	
	   Graph   G= tree.tree(dugum_sayisi);
	 
	 
	  
	   for(int i=0; i< dugum_sayisi; i ++)
	   {
		 Iterable<Integer> o = G.adj(i);
		 Iterator<Integer> itr = o.iterator();
		 while(itr.hasNext())
		 {
			 komsuluk_matrisi[i][(int) itr.next()] =1;
			 
			 
		 }
		 
	   }
	   
	 int root = 0;
	 int cocuk_sayisi=0;
	 int max_cocuk_sayisi=0;
	   for(int i=0; i< dugum_sayisi; i++)
	   {
		   
		   for(int j=0; j< dugum_sayisi; j++)
		   {
			   if(komsuluk_matrisi[i][j]==1)
			   {
			   cocuk_sayisi++;
			   }
		   }
		   if(max_cocuk_sayisi< cocuk_sayisi)
		   {
			   max_cocuk_sayisi = cocuk_sayisi ;
			   root = i;
		   }
		   cocuk_sayisi=0;
	   }
	  
	 
	BreadthFirstPaths breadthfirstpaths = new BreadthFirstPaths(G, root);
	 
	  breadthfirstpaths.bfs_ozel(G, root, dugum_sayisi);
	  //cocugu olanlarý iþaretleyeleim
	  
	  Random r = new Random();
	  double rangeMin=0;
	  double rangeMax=10;
	  double randomValue;
	  
	  
	  
for(int oo=0; oo< Eszamanlilastirma.node_sayisi; oo++)
{
	Eszamanlilastirma.tree_array[oo].output = new double[2];
	if(	Eszamanlilastirma.tree_array[oo].cocuk_sayisi >0)
	{
	Eszamanlilastirma.tree_array[oo].cocuk_var_mi =1;
	}
	else
	{
		 
		randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		Eszamanlilastirma.tree_array[oo].output[0] =  randomValue;
		randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		Eszamanlilastirma.tree_array[oo].output[1] =  randomValue;
		
	}
}

     System.out.printf("AÐAÇ: \n");
	 for(int oo=0; oo< Eszamanlilastirma.node_sayisi; oo++)
	 {
		System.out.printf( "%d : ", Eszamanlilastirma.tree_array[oo].id);
		for(int uu =0; uu < Eszamanlilastirma.tree_array[oo].cocuk_sayisi; uu++)
		{
			System.out.printf( " %d", Eszamanlilastirma.tree_array[oo].cocuk_idleri[uu]);
		}
		System.out.printf("\n");
	 }
	
	//System.out.printf("sdffs");
	   
}
	

public void cezalandirma()
{
	
	double[] output_1=new double[2]; int i,j; 
	double[] output_2=new double[2];
	int[] output_kenar=new int[2];
	Object[] atama = new Object[3];
	 
	for(i=0; i<toplam_strateji_sayisi+1;i++)
	{
		for(j=0;j< toplam_strateji_sayisi+1; j++)				
		{
			if(i==0 || j == 0)
			{
				if(i==0 && j==0)
			    {System.out.printf("                 ");
			     continue;
			     }
				else
				{
					output_kenar=new int[2];
					output_kenar =    (int[]) this.eszaman_matrisi[i][j];
					 
					System.out.printf("____( %d , %d )____", output_kenar[0],output_kenar[1]);
					 
				}
				
				
			}
			else {
			 atama = new Object[3];
			  atama =    (Object[]) this.eszaman_matrisi[i][j];
			 output_1=new double[2];
			 output_1 = (double[]) atama [0];
			 
			 output_2=new double[2];
			 output_2 = (double[]) atama [1];
			 
			 if(output_1[0] < output_2[0] && output_1[1]< output_2[1])  
			 {
				 double[] output = new double[2];
				 output[0]=output_2[0];
				 output[1]=output_2[1];
				 atama[2]= output;
				// System.out.printf("| ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1], output_2[0],output_2[1], output_2[0],output_2[1]);
				 System.out.printf(" ( %.1f , %.1f )", output[0],output[1]);
				 
			 }
			 else  if(output_1[0] > output_2[0] && output_1[1] > output_2[1])
			 {
				 double[] output = new double[2];
				 output[0]=output_1[0];
				 output[1]=output_1[1];
				 atama[2]= output;
				  
				 //System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_1[0],output_1[1]);
				 System.out.printf(" ( %.1f , %.1f )", output[0],output[1]);
					
			 }
			 else if (output_1[0] == output_2[0] && output_1[1] == output_2[1] && output_1[0] != output_1[1])
			 {
				
				 //karþý tarafa fazla veren kazansýn,  
				 if(output_2[0] <= output_1[1] )
				 {
					 
					 double[] output = new double[2];
					 
					 output[1]= output_1[1];
					 output[0]= output_1[0];
					 
					 
					 
					 atama[2]= output;
					// System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output[0],output[1]);
					 System.out.printf(" ( %.1f , %.1f )", output[0],output[1]);
						
				 }
				 
				 else
				 {

					 double[] output = new double[2];
					 
					 output[1]= output_2[1];
					 output[0]= output_2[0];
					 
					 
					 
					 atama[2]= output;
					// System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output[0],output[1]);
					 System.out.printf(" ( %.1f , %.1f )", output[0],output[1]);
						
				 }
				 
				 
				 	
			 }
			 else if(output_1[0] == output_2[1] && output_1[1] == output_2[0] && output_1[0] != output_1[1] )
			 {   double[] output_3=new double[2];
				 double toplam = output_1[0] + output_1[1] ;
				 if((2*output_1[1] )> toplam)
				 {
					 output_3[0] = toplam/2;
					 
					 output_3[1] =toplam/2; 
					 
				 }
				 else
				 {
                     output_3[0] = output_1[1];
					 
					 output_3[1] = output_1[1]; 
				 }
				 
				 
				 
				 atama[2]=output_3;
				// System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_3[0],output_3[1]);
				 System.out.printf(" ( %.1f , %.1f )", output_3[0],output_3[1]);
						
			 }
			 else if (output_1[0] == output_2[1] && output_1[1] == output_2[0] && output_1[0] == output_1[1] )
			 {
				 //hepsi birbirine eþit
				 double[] output_3=new double[2];
				  
				 	 output_3[0] = output_1[0];
					 
					 output_3[1] = output_1[1]; 
					 
					// System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_3[0],output_3[1]);
					 System.out.printf(" ( %.1f , %.1f )", output_3[0],output_3[1]);
					 atama[2]= output_3;
				 
			 }
			 else
			 {
				 double[] output_3=new double[2];
				 
				 //cezalandýrma burda 
				if(output_1[1] > output_2[0])
				{
					output_3[0] =   output_1[0];
				    output_3[1]	=	output_1[1];
				}
				else
				{
					output_3[0] =   output_2[0];
				    output_3[1]	=	output_2[1];
				}
				// System.out.printf(" | ( %.1f , %.1f )  ( %.1f , %.1f )  :( %.1f , %.1f ) | ", output_1[0],output_1[1],  output_2[0],output_2[1], output_3[0],output_3[1]);
				 System.out.printf(" ( %.1f , %.1f )", output_3[0],output_3[1]);
				 atama[2]= output_3;
			 }
			 
			 this.eszaman_matrisi[i][j]=atama;
	
			
			 
		}
		}
		System.out.println();
	}

}


public static void main(String[] args) {
	Eszamanlilastirma e = new Eszamanlilastirma();
	 System.out.printf("elle agac doldurma 1,\notomatik ultimatom 2,\nrastgele agac doldurma 3,\nbudanmis ultimatom 4: ");
	
	@SuppressWarnings("resource")
	Scanner secenek= new Scanner(System.in);
	int secenek_ = secenek.nextInt();
	
	//1 elle doldurma 2 otomatik doldurma ama sadece ultimatom
	switch(secenek_)
	{
	case 1:
		e.agac_doldurma();
		break;
	case 2:e.agac_doldurma_ultimatom();
		break;
	case 3: e.RandomTreeCreation();
	break;
	case 4: e.agac_doldurma_ultimatom_budanmis();
	break;
	
	}
	System.out.printf("\n");
	
	
	
		
		e.matris_olusturma();
		//---------------------------------
		 
		 Object[][] eszaman_matrisi_temp = new Object [ e.toplam_strateji_sayisi+1][e.toplam_strateji_sayisi+1];
		 
		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					eszaman_matrisi_temp[i][j] = e.eszaman_matrisi[i][j] ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) e.eszaman_matrisi[i][j] ;
					eszaman_matrisi_temp[i][j] =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) e.eszaman_matrisi[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				 
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
					eszaman_matrisi_temp[i][j] =temp_atama2;
					
				}
		      
		  
		
		  
			}
			
		}
		/*
		//------------------------------------------------
		
		e.farki_kücük_olan();
		System.out.printf("f=(1) iken Nash Dengeleri\n");
		e.Nash_dengeleri();
		
		
		 
		 
		 
			for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
			{
			 
				for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
				{
					
				 
					if(i==0 && j ==0)
					{
						e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
					}
					else if(i==0 || j ==0)
					{
						int[] temp = new int[e.cocuklu_nodlar];
						temp =  (int[]) eszaman_matrisi_temp[i][j] ;
						e.eszaman_matrisi[i][j]  =temp;
					}
					 
					else
					{

						Object[] temp_atama = new Object [3];
						Object[] temp_atama2 = new Object [3];
						temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
						double [] output1 = new double[2];
						double [] output2 = new double[2];
						 
						double [] output4 = new double[2];
						double [] output5 = new double[2];
						 
						 
					 output1 = (double[]) temp_atama[0];
				     output2 =(double[]) temp_atama[1];
					  
					 output4[0] = output1[0]; 	 output4[1] = output1[1];
					 output5[0] = output2[0]; 	 output5[1] = output2[1];
					  
					 
						 
					 temp_atama2[0]=output4;
					 temp_atama2[1]=output5;
					 temp_atama2[2]=null;
						
					  e.eszaman_matrisi[i][j]=temp_atama2;
						
					}
			      
			  
			
			  
				}
				
			}
			
		
		//------------------------------------------------
		
		
		e.strictly_dominant_yoksa_farki_kücük_olan();
		System.out.printf("f=(2) iken Nash Dengeleri\n");
		e.Nash_dengeleri();
		

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
				}
		      
		  
		
		  
			}
			
		}
		
		
		
		//------------------------------------------------
		
	
		e.rabin_fair(0);	
		System.out.printf("f=(2) iken Rabin adalet tanýmý ile birlikte Nash Dengeleri\n");
		e.Nash_dengeleri();
		

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
				}
		      
		  
		
		  
			}
			
		}
		
		
		//------------------------------------------------
		
		
		e.farki_büyük_olan();
		System.out.printf("f=(4) iken Nash Dengeleri\n");
		e.Nash_dengeleri();
		

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
				}
		      
		  
		
		  
			}
			
		}
		
		
		
		//------------------------------------------------
		
		
		
		e.strictly_dominant_yoksa_farki_büyük_olan();
		System.out.printf("f=(5) iken Nash Dengeleri\n");
		e.Nash_dengeleri();
		

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
					
				}
		      
		  
		
		  
			}
			
		}
		
		
		
		//------------------------------------------------
		
		
		e.rabin_fair(1);	
		System.out.printf("f=(5) iken Rabin adalet tanýmý ile birlikte Nash Dengeleri\n");
		e.Nash_dengeleri();

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
					
				}
		      
		  
		
		  
			}
			
		}
		
		
		*/
		//------------------------------------------------
		System.out.printf("CEZALANDIRMA\n");
		e.cezalandirma();
		
		System.out.printf("f=CEZALANDIRMA iken  Nash Dengeleri\n");
		e.Nash_dengeleri();

		for(int i = 0; i < e.toplam_strateji_sayisi+1; i++)
		{
		 
			for(int j=0; j< e.toplam_strateji_sayisi+1; j++)				
			{
				
			 
				if(i==0 && j ==0)
				{
					e.eszaman_matrisi[i][j] =	eszaman_matrisi_temp[i][j]  ;
				}
				else if(i==0 || j ==0)
				{
					int[] temp = new int[e.cocuklu_nodlar];
					temp =  (int[]) eszaman_matrisi_temp[i][j] ;
					e.eszaman_matrisi[i][j]  =temp;
				}
				 
				else
				{
					Object[] temp_atama = new Object [3];
					Object[] temp_atama2 = new Object [3];
					temp_atama = (Object[]) eszaman_matrisi_temp[i][j];
					double [] output1 = new double[2];
					double [] output2 = new double[2];
					 
					double [] output4 = new double[2];
					double [] output5 = new double[2];
					 
					 
				 output1 = (double[]) temp_atama[0];
			     output2 =(double[]) temp_atama[1];
				  
				 output4[0] = output1[0]; 	 output4[1] = output1[1];
				 output5[0] = output2[0]; 	 output5[1] = output2[1];
				  
				 
					 
				 temp_atama2[0]=output4;
				 temp_atama2[1]=output5;
				 temp_atama2[2]=null;
					
				  e.eszaman_matrisi[i][j]=temp_atama2;
					
				}
		      
		  
		
		  
			}
			
		}
		
		
		
		//------------------------------------------------
		
	}

}

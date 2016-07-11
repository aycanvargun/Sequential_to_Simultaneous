package eszamanlilastirma;

import java.util.Scanner;

public class Bidding_for_Dictatorship {

	
	public int money;
	public void f()
	{
		
		@SuppressWarnings("resource")
		Scanner klavye = new Scanner(System.in);
		System.out.printf("money:");		
		money = klavye.nextInt();
		int size = (money+1)*(money+1);
		int[][] eleme= new int[size][3];
		int[][] eleme2= new int[size][3];
		double toplam;
		int count =0;
		for(int i=0; i< size ; i++)
		{
			 
				eleme[i][1]= i % (money+1);
				eleme[i][0] =i/(money+1);
				toplam=eleme[i][1] + eleme[i][0];
				//kendime kalan karþýdakine verdiðimden küçükse eliyorum
				if(toplam <= money && eleme[i][1] <= (money - eleme[i][1]-eleme[i][0]) )
				{
				eleme[i][2]=1;
				count++;
				}
			 
		}
		
		for(int i=0; i< size ; i++)
		{
			//kendime kalan karþýdakine verdiðimden küçükse eledim aþada kullancaðým için yer deðiþtiriyorum
			eleme2[i][1] =eleme[i][0];
			eleme2[i][0] =eleme[i][1];
			eleme2[i][2] =eleme[i][2];
		}
		
		
		Object[][] dizi = new Object[count+1][count+1];
		
		int kk=1;
		dizi[0][0] = null;
		
		for(int i=0; i< size; i ++)
		{
			if(eleme[i][2]==1)				
			{
					dizi[kk][0] =eleme[i];
					dizi[0][kk] =eleme2[i];	
					kk++;
			}
		}
		
		
		
		double[] sonuc = new double[3];
		for(int i=1; i< count +1; i ++)
		{
			for(int j =1; j< count +1;j ++) 
			{
				
				int[] dizi1  = new int[2];
				int[] dizi2  = new int[2];
				 sonuc = new double[3];
				dizi1 = (int[]) dizi[i][0];
				dizi2 = (int[]) dizi[0][j];
				
				int x1,x2,y1,y2;
				
				x1 = dizi1[0];
				x2 = dizi2[0];
				y1 = dizi1[1];
				y2 = dizi2[1]; 
				
				if(x1 == y2)
				{
					if(y1 == x2)
					{
						
							sonuc[0]= y1/2;
							sonuc[1]= y1/2;
							sonuc[2]= x1;
						
						
					}
					else if (y1>x2)
					{
						 
						sonuc[0]= money-x1-y1;
						sonuc[1]= y1;
						sonuc[2]= x1;
					}
					else
					{
						 
						sonuc[0]= x2 ;
						sonuc[1]= money-x2-y2;
						sonuc[2]= y2;
					}
				}
				else if (x1 > y2)
				{
					 
					sonuc[0]= money-x1-y1;
					sonuc[1]= y1;
					sonuc[2]= x1;
							
				}
				else if (y2 > x1)
				{
					 
					sonuc[0]= x2;
					sonuc[1]= money-x2-y2;
					sonuc[2]= y2;
				}
				
				
				
				dizi[i][j] = sonuc;
				 
			}
		}
			
		
		//diziyi yazdýralým
		 
		
		for(int i =0; i< count+1; i ++)
		{
			for(int j =0; j< count+1; j++)
			{
				if(i==0 && j ==0)
				{
					System.out.printf("       ");
				}
				else if (i ==0 || j==0)
				{
					int[] a = new int[3];
					a= (int[]) dizi[i][j];
					System.out.printf(" || %d %d %d || ", a[0],a[1],a[2]);
				}
				else
				{
					double[] a = new double[3];
					a= (double[]) dizi[i][j];
					System.out.printf(" ( %.1f , %.1f ) ", a[0],a[1]);
				}
				
			
			}
			System.out.println();
		}
		
		int flag1 =0; int flag2 =0;
			//nash dengeleri
		System.out.println();
	 sonuc = new double[3];
		double[] sonuc2 = new double[3];
		for(int i =1; i< count+1; i ++)
			{
				for(int j =1; j< count+1; j++)
				{
					sonuc = new double[3];
					sonuc =    (double[]) dizi[i][j];
					 
					 
					for(int k =1; k<count+1; k++)
					{ 
						sonuc2 = new double[3];
						 
						sonuc2 =    (double[]) dizi[i][k];
						  
						 
						if(  sonuc2[1]>  sonuc[1])
						{
							flag1 =1;
							break;
						}
					}
					
					
					for(int k =1; k< count+1; k++)
					{
						
						sonuc2 = new double[3];
						 
						sonuc2 =    (double[]) dizi[k][j];
						 
						 
						if(  sonuc2[0]> sonuc[0])
						{
							flag2 =1;
							break;
						}
					}
					
					
					if(flag1==0 && flag2 ==0)
					{
                        int[] yazdirma1  = (int[]) dizi[i][0];
                        int[] yazdirma2  = (int[]) dizi[0][j];
                        
                        sonuc = new double[3];
                        sonuc =    (double[]) dizi[i][j];
						 
						 
                      
						  System.out.printf("satýr:");
                        
						for(int ff=0; ff<  3; ff++)
						{
							 System.out.printf(" %d ", yazdirma1[ff]);
						}
						 System.out.printf(" sütun:");
						for(int ff=0; ff<  3; ff++)
						{
							 System.out.printf(" %d ", yazdirma2[ff]);
						}
						
						 
						 System.out.printf(" ( %.1f, %.1f, %.1f ) ( %d, %d )\n", sonuc[0], sonuc[1],money - sonuc[0]-sonuc[1],i,j);
						 	  
						 
						
					}
					flag1=0 ; flag2 =0;
				}
			}
		
		
		//weakly dominating strateji var mý
		System.out.printf("dgfdgd");
		
		
	}
	public static void main(String[] args) {
		 Bidding_for_Dictatorship b = new Bidding_for_Dictatorship();
b.f();
	}

}

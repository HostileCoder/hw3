
public class hw3 {
	
    public static void main(String[] args) {
    	
    	int S[]=new int[256];
    	int K[]=new int[256];
    	int k[]={0x1A,0x2B,0x3C,0x4D,0x5E,0x6F,0x77};
    	
    	init(S,K,k);
    	for(int i=0;i<16;i++){
    		for(int j=i*16;j<16*(i+1);j++){
    			 //System.out.print(S[j]+" ");
    			 System.out.print(Integer.toHexString(S[j])+" ");
    		}
    		System.out.println("");
    	}
    	
    	System.out.println("");
    	keyStream(S,K,100);
    	for(int i=0;i<16;i++){
    		for(int j=i*16;j<16*(i+1);j++){
    			 System.out.print(Integer.toHexString(S[j])+" ");
    		}
    		System.out.println("");
    	}
    	
    	System.out.println("");
    	keyStream(S,K,1000);
    	for(int i=0;i<16;i++){
    		for(int j=i*16;j<16*(i+1);j++){
    			 System.out.print(Integer.toHexString(S[j])+" ");
    		}
    		System.out.println("");
    	}
    	
//    	byte x=127;
//        System.out.println(x);
//        System.out.println(Integer.toBinaryString(x));
//        int anUnsignedByte = (int) x & 0xFF;       
//        int i = 200;                    // some value between 0 and 255
//        byte b = (byte) i; 
//        System.out.println((int) b & 0xFF);          
//        int value = 0x65;                            // we can declare it in hex
//        int sameValue = 101;                         // or in decimal
//        System.out.println(value);                         // output in base 10; prints "101"
//        System.out.println(Integer.toHexString(value));    // output in base 16; prints "65"
//        System.out.println(Integer.toBinaryString(value)); // output in base 2; prints "1100101"
//        System.out.println(""+(value == sameValue));       // prints "true"
    }

    
    
    public static void init(int[] S,int[] K,int k[]){
    	int i=0;
    	int j=0;
    	for(i=0;i<256;i++){
    		S[i]=i;
    		K[i]=k[i%7];
    	}
    	
    	for(i=0;i<256;i++){
    		j=(j+S[i]+K[i])%256;    		  		
    		int temp = S[j];
    		S[j] = S[i];
    		S[i] = temp;
    	}
    	System.out.println("i:"+i+" "+"j:"+j);

    }
    
    public static int keyStream(int[] S,int[] K,int n){
    	int i=0;
    	int j=0;
    	int t=0;
    	int streamBytes;
    	for(int c=0;c<n;c++){
    		i=(i+1)%256;
    		j=(j+S[i])%256;
    	
    		int temp = S[j];
    		S[j] = S[i];
    		S[i] = temp;
		
    		t=(S[j] + S[i])%256;
    	}
    		
    	streamBytes=S[t];
    	System.out.println("i:"+i+" "+"j:"+j);
    	
    	return streamBytes;
    }
}
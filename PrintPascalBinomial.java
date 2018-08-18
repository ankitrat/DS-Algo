class PascalTriangle{
    public void printPascal(int line){
        for(int i=0;i<line;i++){
            for(int j=0;j<=i;j++){
                System.out.print(binomialCoeficient(i,j)+" "); 
            }
            System.out.println();
        }
    }
    public void hockeyLength(int row,int col){
        int sum=0;
        for(int i=0;i<col;i++){
            sum=sum+binomialCoeficient(row,i);
            row++;
        }
        System.out.println(sum);
    }
    public int binomialCoeficient(int n,int k){
		if(k>n-k){
			k=n-k;
		}
        int res=1;
		// Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for(int i=0;i<k;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return res;
    }
    public static void main(String[] args){
        PascalTriangle p=new PascalTriangle();
        p.printPascal(15);
        p.hockeyLength(2,10);
        System.out.println(p.binomialCoeficient(14,1));
    }
}
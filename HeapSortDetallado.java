package heapsortdetallado;

public class HeapSortDetallado {
    private static int[] a;
    private static int n;
    private static int hijoIzquierdo;
    private static int hijoDerecho;
    private static int mayor;

   public static void construirMontículo(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            obtenerMayor(a,i);
        }
    }
    
    public static void obtenerMayor(int[] a, int i){ 
        hijoIzquierdo=2*i;
        hijoDerecho=2*i+1;
        if(hijoIzquierdo <= n && a[hijoIzquierdo] > a[i]){
            mayor=hijoIzquierdo;
        }
        else{
            mayor=i;
        }
        
        if(hijoDerecho <= n && a[hijoDerecho] > a[mayor]){
            mayor=hijoDerecho;
        }
        if(mayor!=i){
            intercambiar(i,mayor);
            obtenerMayor(a, mayor);
        }
    }
    
    public static void intercambiar(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void ordenarArreglo(int []desordenado){
        a=desordenado;
        construirMontículo(a);
        
        for(int i=n;i>0;i--){
            intercambiar(0, i);
            n=n-1;
            obtenerMayor(a, 0);
        }
    }
    
    public static void main(String[] args) {
        int []a1={4,1,3,2,16,9,10,14,8,7};
        ordenarArreglo(a1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");}
    }
}
package estruturaDeDados;

public class TesteL implements Lista{

    int[] list = new int[20];
    int tamanho = 0;

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int minimo() {
        int min = list[0];
        for (int i = 0; i < tamanho; i++) {
            if (list[i] < min) {
                min = list[i];
            }
        }
        return min;
     }
        
    @Override
    public int maximo() {
        int max = list[0];
        for (int i = 0; i < tamanho; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
    
    @Override
    public int predecessor(int valor) {
        int predecessor = Integer.MIN_VALUE;
        for (int i = 0; i < tamanho; i++) {
            if (list[i] < valor && list[i] > predecessor) {
                predecessor = list[i];
            }
        }
        return predecessor;
    }

    @Override
    public int sucessor(int valor) {
        int sucessor = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > valor && list[i] < sucessor) {
                sucessor = list[i];      
            }   
        }
        return sucessor;
    }

    @Override
    public void insereElemento(int valor) {
        if (tamanho < list.length) {
            list[tamanho++] = valor;
        }
    }

    @Override
    public void remove(int valor) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == valor) {
                list[i] = 0;
            }
        }
    }

    @Override
    public int buscaIndice(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (list[i] == valor ) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (tamanho == list.length || buscaIndice < 0 || buscaIndice > tamanho) {
            return;
        }
    
        for (int i = tamanho; i > buscaIndice; i--) {
            list[i] = list[i - 1];
        } 
    
        list[buscaIndice] = valor;
        tamanho++;
    }

    @Override
    public void insereInicio(int valor) {
       for (int i = tamanho; i > 0; i--) {
        list[i] = list[i - 1];
       }
       list[0] = valor;
       tamanho++;
    }

    @Override
    public void insereFim(int valor) {
        list[tamanho] = valor;
        tamanho++;
    }

    @Override
    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return;
        }
        for (int i = indice; i < tamanho - 1; i++) {
            list[i] = list[i + 1];
        }
        tamanho--;
    }

    @Override
    public void removeInicio() {
        if (tamanho == 0) {
            return;
        }
        for (int i = 0; i < tamanho - 1; i++) {
            list[i] = list[i + 1];
        }
        list[tamanho - 1] = 0;
        tamanho--; 
    }

    @Override
    public void removeFim() {
        if (tamanho == 0) {
            return;
        }
        list[tamanho - 1] = 0;
        tamanho--; 
    }
}
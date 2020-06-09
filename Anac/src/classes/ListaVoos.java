package classes;

/**
 * A classe ListaVoos representa uma classe que armazena uma lista com todos os voos cadastrados.
 * Instâncias desta classe permitem a manutenção desses voos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */
import classes.ListaAeroportos.No;

public class ListaVoos implements Cloneable // Lista contendo objeto Destino
{
    protected class No
    {
        protected Destino destino;
        protected No prox;
        protected No ante;

        public No (Destino destino, No p, No ante)
        {
            this.destino = destino;
            this.prox = p;
            this.ante = ante;
        }

        public No (Destino destino)
        {
            this.destino = destino;
            this.prox = null;
        }

        public Destino getDestino ()
        {
            return this.destino;
        }

        public No getProx ()
        {
            return this.prox;
        }
        
        public No getAnte ()
        {
        	return this.ante;
        }

        public void setDestino (Destino destino)
        {
            this.destino = destino;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
        
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }
    
    /**No Contendo o primeiro e o ultimo voo da lista. */
    protected No primeiro, ultimo;

    public void insiraNoInicio (Destino destino) throws Exception
    {
    	if (destino == null)
            throw new Exception ("Informacao ausente");

        this.primeiro = new No (destino, this.primeiro, this.primeiro);

        if (this.ultimo == null) {
            this.ultimo = this.primeiro;
        }
    }

    public void insiraNoFim (Destino destino) throws Exception
    {
    	if (destino == null)
            throw new Exception ("Informacao ausente");

        if (this.ultimo == null)
        {
            No novo = new No (destino);
            this.primeiro = novo;
            this.primeiro.setAnte(null);
            this.ultimo = this.primeiro;
            this.ultimo.setAnte(this.primeiro);
        }
        else
        {
            No valor = new No (destino, null, this.ultimo);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
        }
    }

    /**
     * Gera uma representação textual de todo conteúdo da ListaVoos.
     * Produz e resulta um String representando a lista de voos.
     * @return um String contendo representando a lista de voos.
     */
    public String toString ()
    {
        String ret = "Voos: ";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
                ret = ret + aux.getDestino() + "; ";
            else
                ret = ret + aux.getDestino();

            aux = aux.getProx();
        }

        return ret + "";
    }
    
    /**
     * Calcula o código de espalhamento (ou código de hash).
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) da classe ListaVoos representada pela instância à qual o método for aplicado.
     * @return o código de espalhamento do objeto chamante da classe ListaVoos.
     */
    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDestino().hashCode();

            aux = aux.getProx();
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Verifica a igualdade entre dois ListaVoos.
     * Verifica se o Object fornecido como parâmetro representa um
     * ListaVoos igual àquele representado pela instância à qual este
     * método for aplicado, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem ListaVoos iguais, ou false, caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaVoos lis = (ListaVoos)obj;

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getDestino().equals(aux2.getDestino()) == false)
                return false;

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }

    public void removaDoInicio () throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        No aux = this.primeiro.getProx();
        this.primeiro = null;
        this.primeiro = aux;
    }

    public void remova (int numeroDoVoo) throws Exception
    {
        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (this.primeiro.getDestino().getNumeroVoo() == numeroDoVoo)
        {
            No guardado = this.primeiro;
            this.primeiro = guardado.getProx();
            this.primeiro.setAnte(null);
            return;
        }

        if (this.ultimo.getDestino().getNumeroVoo() == numeroDoVoo)
        {
        	No guardado = this.ultimo.getAnte();
        	this.ultimo.getAnte().setProx(null);
        	this.ultimo = guardado;
        	return;
        }
        
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().getDestino().getNumeroVoo() == numeroDoVoo)
            {
                No guardado = aux.getProx().getProx();
                guardado.setAnte(aux);
                aux.setProx(guardado);
                break;
            }
            aux = aux.getProx();
        }
    }

    public void removaDoFim () throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().equals(this.ultimo))
            {
                this.ultimo = aux;
                aux.setProx(null);
                break;
            }

            aux = aux.getProx();
        }
    }

    public boolean tem (Destino destino) throws Exception
    {
        if (destino == null)
            throw new Exception("Parametro ausente");

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getDestino() == null)
                aux = aux.getProx();
            else
            {
                if (aux.getDestino().equals(destino) == true)
                {
                    return true;
                }
                else
                    aux = aux.getProx();
            }
        }

        return false;
    }

    public boolean tem (int numeroVoo)
    {
         No aux = this.primeiro;

         while (aux != null)
         {
             if (aux.getDestino() == null)
                 aux = aux.getProx();
             else
             {
                 if (aux.getDestino().getNumeroVoo() == numeroVoo)
                 {
                     return true;
                 }
                 else
                     aux = aux.getProx();
             }
         }

         return false;
    }
    
    /**
     * Constroi uma cópia deste ListaVoos.
     * Utiliza o construtor de cópia para gerar uma cópia de this e a retorna.
     * @return a cópia deste ListaVoos como Object.
     */
    public Object clone ()
    {
        ListaVoos ret = null;
        try
        {
            ret = new ListaVoos(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    /**
     * Constroi uma cópia da instância da classe ListaVoos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaVoos para ser
     * utilizada como modelo para a construção da nova instância criada.
     * @param modelo a instância da classe ListaVoos a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public ListaVoos (ListaVoos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setDestino(aux2.getDestino());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    public ListaVoos ()
    {}

    public Destino getDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDestino();
    }
    
    public Destino getProxDestino (Destino destino)
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDestino().equals(destino))
    		{
    			if (aux.getProx() != null)
    			   return aux.getProx().getDestino();
    			else
    				return null;
    		}
    		else
    		{
    			aux = aux.getProx();
    		}
    	}
    	
    	return null;
    }
    
    public Destino getAnteDestino (Destino destino)
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDestino().equals(destino))
    		{
    			return aux.getAnte().getDestino();
    		}
    		else
    		{
    			aux = aux.getProx();
    		}
    	}
    	
    	return null;
    }

    public Destino getDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDestino();
    }

    public boolean isVazia()
    {
        if (this.ultimo == null && this.primeiro == null)
            return true;
        else
            return false;
    }

    public int getQtd ()
    {
        No aux = this.primeiro;
        int qtd = 0;
        while (aux != null)
        {
            qtd++;
            aux = aux.getProx();
        }

        return qtd;
    }

    public void invertaSe ()
    {
        if (this.primeiro==null)
            return;

        if (this.primeiro.getProx() == null)
            return;

        No anterior=null, atual=this.primeiro, seguinte=atual.getProx();
        while (seguinte!=null)
        {
            atual.setProx (anterior);
            anterior = atual;
            atual    = seguinte;
            seguinte = seguinte.getProx();
        }

        this.ultimo.setProx(anterior);

        No   backup   = this.primeiro;
        this.primeiro = this.ultimo;
        this.ultimo   = backup;
    }

   /* public ListaVoos getInversao ()
    {
        ListaVoos ret = new ListaVoos ();

        for (No atual=this.primeiro; atual!=null; atual=atual.getProx())
            ret.primeiro = new No (atual.getDados(), ret.primeiro, null);

        return ret;
    }*/
}
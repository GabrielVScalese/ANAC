package classes;

/**
 * A classe ListaVoos representa uma classe que armazena uma lista com todos os voos cadastrados.
 * Inst�ncias desta classe permitem a manuten��o desses voos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */

public class ListaVoos implements Cloneable
{
    protected class No
    {
    	/**Destino onde dados do destino do v�o ser�o armazenados. */
        protected Destino destino;
        /**No onde o objeto posterior do atual est� armazenado. */
        protected No prox;
        /**No onde o objeto anterior do atual est� armazenado. */
        protected No ante;

        /**
         * Constroi uma nova inst�ncia da classe No.
         * @param destino Destino contedo dados do destino do v�o.
         * @param prox No contendo o objeto posterior ao atual.
         * @param ante No contendo o objets anterior ao atual.
         *  */
        public No (Destino destino, No prox, No ante)
        {
            this.destino = destino;
            this.prox = prox;
            this.ante = ante;
        }

        /**
         * Constroi uma nova inst�ncia da classe No.
         * @param destino Destino contedo dados do destino do v�o.
         *  */
        public No (Destino destino)
        {
            this.destino = destino;
            this.prox = null;
        }

        /**
         * Retorna o objeto Destino.
         * @return Retorna os valores presentes no objeto Destino.
         *  */
        public Destino getDestino ()
        {
            return this.destino;
        }

        /**
         * Retorna o objeto posterior ao atual.
         * @return Retorna os valores presentes no objeto posterior ao atual.
         *  */
        public No getProx ()
        {
            return this.prox;
        }
        
        /**
         * Retorna o objeto anterior ao atual.
         * @return Retorna os valores presentes no objeto anterior ao atual.
         *  */
        public No getAnte ()
        {
        	return this.ante;
        }

        /**
         * Adiciona valores ao Destino destino.
         * @param destino Destino contedo dados do destino do v�o.
         *  */
        public void setDestino (Destino destino)
        {
            this.destino = destino;
        }

        /**
         * Adiciona valores ao objeto posterior.
         * @param prox No contendo o objeto posterior ao atual.
         *  */
        public void setProx (No prox)
        {
            this.prox = prox;
        }
        
        /**
         * Adiciona valores ao objeto anterior.
         * @param ante No contendo o objeto anterior ao atual.
         *  */
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }
    
    /**No Contendo o primeiro e o ultimo voo da lista de v�os. */
    protected No primeiro, ultimo;

    /**
     * Insere novo objeto Destino na lista de v�os.
     * @param destino Destino contedo dados do destino do v�o.
     * @throws Exception se o destino passado por par�metro for nulo.
     *  */
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
     * Gera uma representa��o textual de todo conte�do da ListaVoos.
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
     * Calcula o c�digo de espalhamento (ou c�digo de hash).
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) da classe ListaVoos representada pela inst�ncia � qual o m�todo for aplicado.
     * @return o c�digo de espalhamento do objeto chamante da classe ListaVoos.
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
     * Verifica se o Object fornecido como par�metro representa um
     * ListaVoos igual �quele representado pela inst�ncia � qual este
     * m�todo for aplicado, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem ListaVoos iguais, ou false, caso contr�rio.
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
    
    /**
     * Remove o objeto Destino a partir do n�mero de voo.
     * @param numeroDoVoo Integer contedo o n�mero do v�o.
     * @throws Exception se o numeroVoo passado por par�metro for menor que 0 ou se a lista de v�os est� vazia.
     *  */
    public void removaVoo (int numeroDoVoo) throws Exception
    {
        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (numeroDoVoo < 0)
        	throw new Exception ("N�mero do v�o inv�lido");
        
        
        if (getQtd() == 1)
        {
        	this.primeiro = null;
        	this.ultimo = null;
        	return;
        }
        
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

    /**
     * Verifica se o v�o existe a partir do n�mero do v�o.
     * @param numeroDoVoo Integer contedo o n�mero do v�o.
     * @return Retorna true se v�o existe ou false caso o v�o n�o exista.
     * @throws Exception se o numeroVoo passado por par�metro for menor que 0.
     *  */
    public boolean temVoo (int numeroDoVoo) throws Exception
    {
    	if (numeroDoVoo < 0)
    		throw new Exception ("N�mero do v�o inv�lido");
    	
         No aux = this.primeiro;

         while (aux != null)
         {
             if (aux.getDestino() == null)
                 aux = aux.getProx();
             else
             {
                 if (aux.getDestino().getNumeroVoo() == numeroDoVoo)
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
     * Constroi uma c�pia deste ListaVoos.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this e a retorna.
     * @return a c�pia deste ListaVoos como Object.
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
     * Constroi uma c�pia da inst�ncia da classe ListaVoos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaVoos para ser
     * utilizada como modelo para a constru��o da nova inst�ncia criada.
     * @param modelo a inst�ncia da classe ListaVoos a ser usada como modelo.
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

    /**
     * Constroi uma nova inst�ncia da classe ListaVoos.
     *  */
    public ListaVoos ()
    {}

    /**
     * Retorna o objeto Destino do in�cio da lista de v�os.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se a lista de aeroportos estiver vazia.
     *  */
    public Destino getDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDestino();
    }
    
    /**
     * Retorna o objeto Destino posterior ao do par�metro, a partir do objeto Destino passado por par�metro.
     * @param destino Destino contedo dados do destino do v�o.
     * @return Retorna os valores presentes no objeto Destino posterior ao do par�metro.
     * @throws Exception se o destino passado por par�metro for nulo.
     *  */
    public Destino getProxDestino (Destino destino) throws Exception
    {
    	if (destino == null)
    		throw new Exception ("Destino inv�lido");
    	
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
    
    /**
     * Retorna o objeto Destino anterior ao do par�metro, a partir do objeto Destino passado por par�metro.
     * @param destino Destino contedo dados do destino do v�o.
     * @return Retorna os valores presentes no objeto Destino anterior ao do par�metro.
     * @throws Exception se o destino passado por par�metro for nulo.
     *  */
    public Destino getAnteDestino (Destino destino) throws Exception
    {
    	if (destino == null)
    		throw new Exception ("Destino inv�lido");
    	
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

    /**
     * Retorna o objeto Destino do fim da lista de v�os.
     * @return Retorna os valores presentes no objeto Destino do fim da lista de v�os.
     * @throws Exception se a lista de v�os estiver vazia.
     *  */
    public Destino getDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDestino();
    }

    /**
     * Retorna a quantidade de itens da lista de v�os.
     * @return Retorna o n�mero de itens da lista de v�os.
     *  */
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
}
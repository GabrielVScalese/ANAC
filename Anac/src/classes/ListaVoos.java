package classes;

/**
 * A classe ListaVoos representa uma classe que armazena uma lista com todos os voos cadastrados.
 * Instâncias desta classe permitem a manutenção desses voos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */

public class ListaVoos implements Cloneable
{
    protected class No
    {
    	/**Destino onde dados do destino do vôo serão armazenados. */
        protected Destino destino;
        /**No onde o objeto posterior do atual está armazenado. */
        protected No prox;
        /**No onde o objeto anterior do atual está armazenado. */
        protected No ante;

        /**
         * Constroi uma nova instância da classe No.
         * @param destino Destino contedo dados do destino do vôo.
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
         * Constroi uma nova instância da classe No.
         * @param destino Destino contedo dados do destino do vôo.
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
         * @param destino Destino contedo dados do destino do vôo.
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
    
    /**No Contendo o primeiro e o ultimo voo da lista de vôos. */
    protected No primeiro, ultimo;

    /**
     * Insere novo objeto Destino na lista de vôos.
     * @param destino Destino contedo dados do destino do vôo.
     * @throws Exception se o destino passado por parâmetro for nulo.
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
    
    /**
     * Remove o objeto Destino a partir do número de voo.
     * @param numeroDoVoo Integer contedo o número do vôo.
     * @throws Exception se o numeroVoo passado por parâmetro for menor que 0 ou se a lista de vôos está vazia.
     *  */
    public void removaVoo (int numeroDoVoo) throws Exception
    {
        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (numeroDoVoo < 0)
        	throw new Exception ("Número do vôo inválido");
        
        
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
     * Verifica se o vôo existe a partir do número do vôo.
     * @param numeroDoVoo Integer contedo o número do vôo.
     * @return Retorna true se vôo existe ou false caso o vôo não exista.
     * @throws Exception se o numeroVoo passado por parâmetro for menor que 0.
     *  */
    public boolean temVoo (int numeroDoVoo) throws Exception
    {
    	if (numeroDoVoo < 0)
    		throw new Exception ("Número do vôo inválido");
    	
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

    /**
     * Constroi uma nova instância da classe ListaVoos.
     *  */
    public ListaVoos ()
    {}

    /**
     * Retorna o objeto Destino do início da lista de vôos.
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
     * Retorna o objeto Destino posterior ao do parâmetro, a partir do objeto Destino passado por parâmetro.
     * @param destino Destino contedo dados do destino do vôo.
     * @return Retorna os valores presentes no objeto Destino posterior ao do parâmetro.
     * @throws Exception se o destino passado por parâmetro for nulo.
     *  */
    public Destino getProxDestino (Destino destino) throws Exception
    {
    	if (destino == null)
    		throw new Exception ("Destino inválido");
    	
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
     * Retorna o objeto Destino anterior ao do parâmetro, a partir do objeto Destino passado por parâmetro.
     * @param destino Destino contedo dados do destino do vôo.
     * @return Retorna os valores presentes no objeto Destino anterior ao do parâmetro.
     * @throws Exception se o destino passado por parâmetro for nulo.
     *  */
    public Destino getAnteDestino (Destino destino) throws Exception
    {
    	if (destino == null)
    		throw new Exception ("Destino inválido");
    	
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
     * Retorna o objeto Destino do fim da lista de vôos.
     * @return Retorna os valores presentes no objeto Destino do fim da lista de vôos.
     * @throws Exception se a lista de vôos estiver vazia.
     *  */
    public Destino getDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDestino();
    }

    /**
     * Retorna a quantidade de itens da lista de vôos.
     * @return Retorna o número de itens da lista de vôos.
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
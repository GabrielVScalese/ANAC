package classes;

/**
 * A classe ListaAeroportos representa uma classe que armazena uma lista com todos os aeroportos presentes.
 * Instâncias desta classe permitem a manutenção desses aeroportos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */

public class ListaAeroportos implements Cloneable
{
    public class No
    {
    	/**DadosAeroporto onde dados do aeroporto será armazenado. */
        protected DadosAeroporto dados;
        /**ListaVoos onde os vôos serao armazenados. */
        protected ListaVoos lisVoos;
        /**No onde os objetos posteriores do atual estão armazenados. */
        protected No prox;
        /**No onde os objetos anteriores do atual estão armazenados. */
        protected No ante;

        /**
         * Constroi uma nova instância da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         * @param prox No contendo os objetos posteriores ao atual.
         * @param ante No contendo os objetos anteriores ao atual.
         *  */
        protected No (DadosAeroporto dados, ListaVoos lisVoos, No prox, No ante)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
            this.prox = prox;
            this.ante = ante;
        }

        /**
         * Constroi uma nova instância da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         *  */
        public No (DadosAeroporto dados)
        {
            this.dados = dados;
            this.prox = null;
        }

        /**
         * Constroi uma nova instância da classe No.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         *  */
        public No (DadosAeroporto dados, ListaVoos lisVoos)
        {
            this.dados = dados;
            this.lisVoos = lisVoos;
        }

        /**
         * Retorna o objeto DadosAeroporto.
         * @return Retorna os valores presentes no objeto DadosAeroporto. 
         *  */
        public DadosAeroporto getDados ()
        {
            return this.dados;
        }

        /**
         * Retorna o objeto ListaVoos.
         * @return Retorna os valores presentes no objeto ListaVoos.
         *  */
        public ListaVoos getVoos()
        {
            return this.lisVoos;
        }

        /**
         * Retorna os objetos posteriores ao atual.
         * @return Retorna os valores presentes nos objetos posteriores ao atual.
         *  */
        public No getProx ()
        {
            return this.prox;
        }

        /**
         * Retorna os objetos anteriores ao atual.
         * @return Retorna os valores presentes nos objetos anteriores ao atual.
         *  */
        public No getAnte()
        {
        	return this.ante;
        }
        
        /**
         * Adiciona valores ao DadosAeroporto dados.
         * @param dados DadosAeroporto contedo dados do aeroporto.
         *  */
        public void setDados (DadosAeroporto dados)
        {
            this.dados = dados;
        }

        /**
         * Adiciona valores ao ListaVoos lisVoos.
         * @param lisVoos ListaVoos contendo a lista de voos desse aeroporto.
         *  */
        public void setVoos (ListaVoos lisVoos)
        {
            this.lisVoos = lisVoos;
        }

        /**
         * Adiciona valores ao objeto posterior.
         * @param prox No contendo os objetos posteriores ao atual.
         *  */
        public void setProx (No prox)
        {
            this.prox = prox;
        }
        
        /**
         * Adiciona valores ao objeto anterior.
         * @param ante No contendo os objetos anteriores ao atual.
         *  */
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }

    /**No Contendo o primeiros e o ultimos aeroporto e lista de vôos da lista. */
    protected No primeiro, ultimo;

    /**
     * Insere novos dados de aeroporto.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @throws Exception se o dados passado por parâmetro for nulo.
     *  */
    public void insiraAeroportoNoFim (DadosAeroporto dados) throws Exception
    {
    	if (dados == null)
            throw new Exception ("Dados de aeroporto ausentes");
    	
        if (this.ultimo == null)
        {
            No novo = new No (dados, null);
            this.primeiro = novo;
            this.primeiro.setAnte(null);
            this.ultimo = this.primeiro;
            this.ultimo.setAnte(this.primeiro);
        }
        else
        {
            No valor = new No (dados, null, null, this.ultimo);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
        }
    }
    
    /**
     * Insere nova lista de vôos a um aeroporto especificado por seu código.
     * @param codigo String contedo o código do aeroporto.
     * @param listaVoos ListaVoos contendo a lista de voos desse aeroporto.
     * @throws Exception se o codAeroporto passado por parâmetro for nulo ou se o listaVoos passado por parâmetro for nulo.
     *  */
    public void insiraListaVoos (String codAeroporto, ListaVoos listaVoos) throws Exception
    {
    	
    	if (codAeroporto == null || codAeroporto.equals(""))
            throw new Exception ("Código de aeroporto inválido");
    	
    	if (listaVoos == null)
    		throw new Exception ("Lista de vôos inválida");
    	
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().getCodigo().equals(codAeroporto))
    		{
    			aux.setVoos(listaVoos);
    			return;
    		}
    		else
    			aux = aux.getProx();
    	}
    }
    
    /**
     * Insere novo vôo na lista de vôos a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @param destino Destino contendo destino do vôo.
     * @throws Exception se o código passado por parâmetro for nulo ou vazio, se o destino passado por parâmetro for nulo ou se código de aeroporto não existe na lista.
     *  */
    public void inserirVoo (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("Código de aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	try
    	{
    		ListaVoos lis;
        	lis = getListaDeVoos(codigo);
        	lis.insiraNoFim(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de vôos inexistente");
    	}
    }

    /**
     * Retorna o No de um aeroporto especificado por seu código.
     * @param codAeroporto String contedo o código do aeroporto.
     * @return Retorna os valores presentes no No do aeroporto especificado por seu código.
     * @throws Exception se o dados passado por parâmetro for nulo.
     *  */
    public No getAeroportoDestino (String codAeroporto) throws Exception
    {
    	if (codAeroporto == null || codAeroporto.equals(""))
    		throw new Exception ("Código de aeroporto inválido");
    	
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().getCodigo().equals(codAeroporto))
    	        return aux;
    		else
    			aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    /**
     * Retorna o objeto DadosAeroporto posterior ao do parâmetro.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto posterior ao atual.
     * @throws Exception se o dados passado por parâmetro for nulo.
     *  */
    public DadosAeroporto getProxDados (DadosAeroporto dados) throws Exception
    {
    	if (dados == null)
    		throw new Exception ("Dados de aeroporto inexistentes");
    	
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().equals(dados))
    		{
    			if (aux.getProx() != null)
    			    return aux.getProx().getDados();
    			else
    				return null;
    		}
    		
    		aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    /**
     * Retorna o objeto DadosAeroporto anterior ao do parâmetro.
     * @param dados DadosAeroporto contedo dados do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto anterior ao atual.
     * @throws Exception se o dados passado por parâmetro for nulo.
     *  */
    public DadosAeroporto getAnteDados (DadosAeroporto dados)
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDados().equals(dados))
    		{
    			return aux.getAnte().getDados();
    		}
    		
    		aux = aux.getProx();
    	}
    	
    	return null;
    }
    
    /**
     * Retorna o objeto Destino do início da lista de vôos a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por parâmetro for nulo.
     *  */
    public Destino getDestinoDoInicio (String codigo) throws Exception
    {
        if (codigo == null || codigo.equals(""))
            throw new Exception ("Codigo do aeroporto invalido");

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos().getDoInicio();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    /**
     * Retorna o objeto Destino do fim da lista de vôos a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por parâmetro for nulo.
     *  */
    public Destino getDestinoDoFim (String codigo) throws Exception
    {
        if (codigo == null || codigo.equals(""))
            throw new Exception ("Codigo do aeroporto invalido");
        
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos().getDoFim();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    /**
     * Retorna o objeto ListaVoos a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna os valores presentes no objeto ListaVoos.
     * @throws Exception se o codigo passado por parâmetro for nulo.
     *  */
    public ListaVoos getListaDeVoos (String codigo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
            throw new Exception ("Codigo do aeroporto invalido");

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getVoos();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    /**
     * Retorna o objeto Destino posterior ao do parâmetro a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @param destino Destino contendo destino do vôo.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por parâmetro for nulo, se o destino passado por parâmetro for nulo ou se a lista de vôos não existe.
     *  */
    public Destino getProxDestino (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("Código do aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getListaDeVoos(codigo);
        	destinoProx = lisVoos.getProxDestino(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de vôos inexistente");
    	}
    	
    	return destinoProx;
    }
    
    /**
     * Retorna o objeto Destino anterior ao do parâmetro a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @param destino Destino contendo destino do vôo.
     * @return Retorna os valores presentes no objeto Destino.
     * @throws Exception se o codigo passado por parâmetro for nulo, se o destino passado por parâmetro for nulo ou se a lista de vôos não existe.
     *  */
    public Destino getAnteDestino (String codigo, Destino destino) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("Código do aeroporto ausente");
    	
    	if (destino == null)
    		throw new Exception ("Destino ausente");
    	
    	Destino destinoProx = null;
    	try
    	{
    		ListaVoos lisVoos = getListaDeVoos(codigo);
        	destinoProx = lisVoos.getAnteDestino(destino);
    	}
    	catch (Exception e)
    	{
    		System.out.println ("Lista de vôos inexistente");
    	}
    	
    	return destinoProx;
    }
    
    /**
     * Retorna o objeto DadosAeroporto do fim da lista de aeroportos.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se a lista de aeroportos estiver vazia.
     *  */
    public DadosAeroporto getDadosDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDados();
    }
    
    /**
     * Retorna o objeto DadosAeroporto do início da lista de aeroportos.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se a lista de aeroportos estiver vazia.
     *  */
    public DadosAeroporto getDadosDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDados();
    }
    
    /**
     * Retorna a quantidade de itens da lista de aeroportos.
     * @return Retorna o número de itens da lista de aeroportos.
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

    /**
     * Retorna o objeto DadosAeroporto a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna os valores presentes no objeto DadosAeroporto.
     * @throws Exception se o codigo passado por parâmetro for nulo.
     *  */
    public DadosAeroporto getAeroporto (String codigo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
            throw new Exception ("Codigo do aeroporto invalido");

        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getDados().getCodigo().equals(codigo))
            {
                return aux.getDados();
            }

            aux = aux.getProx();
        }

        return null;
    }
    
    /**
     * Gera uma representação textual de todo conteúdo da ListaAeroportos.
     * Produz e resulta um String representando a lista de aeroportos.
     * @return um String contendo representando a lista de aeroportos.
     */
    public String toString ()
    {
        String ret = "";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
            {
            	if (aux == this.primeiro)
                    ret = ret + aux.getDados() + aux.getVoos() +  ", ";
            	else
            		ret = "\n" + ret + aux.getDados() + aux.getVoos() +  ", ";
            }
            else
                ret = ret + "(" + aux.getDados() + aux.getVoos() + ")";

            aux = aux.getProx();
        }

        return ret + "}";
    }

    /**
     * Calcula o código de espalhamento (ou código de hash).
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) da classe ListaAeroportos representada pela instância à qual o método for aplicado.
     * @return o código de espalhamento do objeto chamante da classe ListaAeroportos.
     */
    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDados().hashCode();
            ret = ret * 17 + aux.getVoos().hashCode();

            aux = aux.getProx();
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Verifica a igualdade entre dois ListaAeroportos.
     * Verifica se o Object fornecido como parâmetro representa um
     * ListaAeroportos igual àquele representado pela instância à qual este
     * método for aplicado, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem ListaAeroportos iguais, ou false, caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaAeroportos lis = (ListaAeroportos) obj;

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getDados().equals(aux2.getDados()) == false)
                return false;
            
            if (aux1.getVoos().equals(aux2.getVoos()) == false)

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }

    /**
     * Remove o objeto Destino a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @throws Exception se o codigo passado por parâmetro for nulo, se o numeroVoo passado por parâmetro for menor que 0 ou se a lista de vôos não existe.
     *  */
    public void removaVoo (String codigo, int numeroVoo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("Código de aeroporto inválido");
    	
    	if (numeroVoo < 0)
    		throw new Exception ("Número de vôo inválido");
    	try
    	{
        	ListaVoos lis = getListaDeVoos(codigo);
        	
        	lis.removaVoo(numeroVoo);
    	}
    	catch (Exception e)
    	{
    		System.out.println("Lista de vôos inexistente");
    	}
    }
    
    /**
     * Verifica se o vôo existe a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @param numeroVoo int contendo o numero do voo.
     * @return Retorna true se vôo existe ou false caso o vôo não exista.
     * @throws Exception se o codigo passado por parâmetro for nulo ou se o numeroVoo passado por parâmetro for menor que 0.
     *  */
    public boolean temVoo (String codigo, int numeroVoo) throws Exception
    {
    	if (codigo == null || codigo.equals(""))
    		throw new Exception ("Código de aeroporto inválido");
    	
    	if (numeroVoo < 0)
    		throw new Exception ("Número de vôo inválido");
    	
    	boolean ret = false;
    	try
    	{
    		ListaVoos lis = getListaDeVoos(codigo);
    		if (lis.temVoo(numeroVoo))
    			ret = true;
    		else
    			ret = false;
    	}
    	catch (Exception error)
    	{
    		System.out.println("Lista de vôos inexistente");
    	}
    	
    	return ret;
    }
    
    /**
     * Verifica se o aeroporto existe a partir do código do aeroporto.
     * @param codigo String contedo o código do aeroporto.
     * @return Retorna true se aeroporto existe ou false caso o aeroporto não exista.
     * @throws Exception se o codigo passado por parâmetro for nulo.
     *  */
    public boolean temAeroporto (String codigo) throws Exception
    {
    	 if (codigo == null)
             throw new Exception("Parametro ausente");

         No aux = this.primeiro;

         while (aux != null)
         {
             if (aux.getDados() == null)
                 aux = aux.getProx();
             else
             {
                 if (aux.getDados().getCodigo().equals(codigo))
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
     * Constroi uma cópia deste ListaAeroportos.
     * Utiliza o construtor de cópia para gerar uma cópia de this e a retorna.
     * @return a cópia deste ListaAeroportos como Object.
     */
    public Object clone ()
    {
        ListaAeroportos ret = null;
        try
        {
            ret = new ListaAeroportos(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    /**
     * Constroi uma cópia da instância da classe ListaAeroportos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaAeroportos para ser
     * utilizada como modelo para a construção da nova instância criada.
     * @param modelo a instância da classe ListaAeroportos a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public ListaAeroportos (ListaAeroportos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setDados(aux2.getDados());
            aux.setVoos(aux2.getVoos());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    /**
     * Constroi uma nova instância da classe ListaAeroportos.
     *  */
    public ListaAeroportos ()
    {}
}
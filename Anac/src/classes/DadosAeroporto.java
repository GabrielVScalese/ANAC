package classes;

/**
 * A classe DadosAeroporto representa uma classe onde os dados básicos de um aeroporto, como nome e código,
 * são armazenados. Instâncias desta classe permitem esse armazenamento
 * Nela encontramos, por exemplo, getters, setters, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */


public class DadosAeroporto implements Cloneable // Armazena o nome da cidade e codigo do aeroporto
{
	/**String onde o nome do aeroporto será armazenado. */
    protected String nome;
    /**String onde o código do aeroporto será armazenado. */
    protected String codigo;

    /**
     * Constroi uma nova instância da classe DadosAeroporto.
     * @param nome String contedo o nome do aeroporto.
     * @param codigo String contendo o código do aeroporto.
     * @throws Exception se ocorrer algum erro nos Setters.
     *  */
    public DadosAeroporto(String nome, String codigo) throws Exception
    {
        setNome(nome);
        setCodigo(codigo);
    }

    /**
     * Adiciona valores à string nome.
     * @param nome String contedo o nome do aeroporto.
     * @throws Exception se o nome passado por parametro for null ou esteja em branco.
     *  */
    public void setNome (String nome) throws Exception
    {
        if (nome == null || nome == "")
            throw new Exception ("Nome invalido");

        this.nome = nome;
    }

    /**
     * Adiciona valores à string código.
     * @param codigo String contedo o codigo do aeroporto.
     * @throws Exception se o codigo passado por parametro for null ou esteja em branco.
     *  */
    public void setCodigo (String codigo) throws Exception
    {
        if (codigo == null || codigo == "")
            throw new Exception ("Codigo invalido");

        this.codigo = codigo;
    }
    
    
    /**
     * Retorna o nome do aeroporto.
     * @return  Retorna o valor presente na String nome. 
     *  */
    public String getNome ()
    {
        return this.nome;
    }

    /**
     * Retorna o código do aeroporto.
     * @return  Retorna o valor presente na String codigo. 
     *  */
    public String getCodigo ()
    {
        return this.codigo;
    }
    

    /**
     * Verifica a igualdade entre dois DadosAeroporto.
     * Verifica se o Object fornecido como parâmetro representa um
     * DadosAeroporto igual àquele representado pela instância à qual este
     * método for aplicado, resultando true em caso afirmativo,
     * ou false, caso contrário.
     * @param  obj o objeto a ser comparado com a instância à qual esse método
     * for aplicado.
     * @return true, caso o Object fornecido ao método e a instância chamante do
     * método representarem DadosAeroporto iguais, ou false, caso contrário.
     */
    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        DadosAeroporto da = (DadosAeroporto)obj;

        if (!this.nome.equals(da.nome))
            return false;

        if (!this.codigo.equals(da.codigo))
            return false;

        return true;
    }
    
    
    /**
     * Calcula o código de espalhamento (ou código de hash).
     * Calcula e resulta o código de espalhamento (ou código de hash, ou ainda o
     * hashcode) da classe DadosAeroporto representada pela instância à qual o método for aplicado.
     * @return o código de espalhamento do objeto chamante da classe DadosAeroporto.
     */
    public int hashCode ()
    {
        int ret = 17;

        ret = ret * 17 + this.nome.hashCode();
        ret = (ret * 17) + this.codigo.hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Gera uma representação textual de todo conteúdo do DadosAeroporto.
     * Produz e resulta um String representando o nome e o código do aeroporto.
     * @return um String contendo representando o nome e o código do aeroporto.
     */
    public String toString()
    {
        return "Nome: " + this.nome + " | " + "Codigo: " + this.codigo + " | ";
    }

    /**
     * Constroi uma cópia deste DadosAeroporto.
     * Utiliza o construtor de cópia para gerar uma cópia de this e a retorna.
     * @return a cópia deste DadosAeroporto como Object.
     */
    public Object clone ()
    {
        DadosAeroporto ret = null;
        try
        {
            ret = new DadosAeroporto(this);
        }
        catch (Exception e)
        {}

        return ret;
    }
    
    /**
     * Constroi uma cópia da instância da classe DadosAeroporto dada.
     * Para tanto, deve ser fornecida uma instancia da classe DadosAeroporto para ser
     * utilizada como modelo para a construção da nova instância criada.
     * @param modelo a instância da classe DadosAeroporto a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public DadosAeroporto (DadosAeroporto modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo invalido");

        this.nome = modelo.nome;
        this.codigo = modelo.codigo;
    }
}
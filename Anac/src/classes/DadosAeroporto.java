package classes;

/**
 * A classe DadosAeroporto representa uma classe onde os dados b�sicos de um aeroporto, como nome e c�digo,
 * s�o armazenados. Inst�ncias desta classe permitem esse armazenamento
 * Nela encontramos, por exemplo, getters, setters, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */


public class DadosAeroporto implements Cloneable // Armazena o nome da cidade e codigo do aeroporto
{
	/**String onde o nome do aeroporto ser� armazenado. */
    protected String nome;
    /**String onde o c�digo do aeroporto ser� armazenado. */
    protected String codigo;

    /**
     * Constroi uma nova inst�ncia da classe DadosAeroporto.
     * @param nome String contedo o nome do aeroporto.
     * @param codigo String contendo o c�digo do aeroporto.
     * @throws Exception se ocorrer algum erro nos Setters.
     *  */
    public DadosAeroporto(String nome, String codigo) throws Exception
    {
        setNome(nome);
        setCodigo(codigo);
    }

    /**
     * Adiciona valores � string nome.
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
     * Adiciona valores � string c�digo.
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
     * Retorna o c�digo do aeroporto.
     * @return  Retorna o valor presente na String codigo. 
     *  */
    public String getCodigo ()
    {
        return this.codigo;
    }
    

    /**
     * Verifica a igualdade entre dois DadosAeroporto.
     * Verifica se o Object fornecido como par�metro representa um
     * DadosAeroporto igual �quele representado pela inst�ncia � qual este
     * m�todo for aplicado, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem DadosAeroporto iguais, ou false, caso contr�rio.
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
     * Calcula o c�digo de espalhamento (ou c�digo de hash).
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) da classe DadosAeroporto representada pela inst�ncia � qual o m�todo for aplicado.
     * @return o c�digo de espalhamento do objeto chamante da classe DadosAeroporto.
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
     * Gera uma representa��o textual de todo conte�do do DadosAeroporto.
     * Produz e resulta um String representando o nome e o c�digo do aeroporto.
     * @return um String contendo representando o nome e o c�digo do aeroporto.
     */
    public String toString()
    {
        return "Nome: " + this.nome + " | " + "Codigo: " + this.codigo + " | ";
    }

    /**
     * Constroi uma c�pia deste DadosAeroporto.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this e a retorna.
     * @return a c�pia deste DadosAeroporto como Object.
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
     * Constroi uma c�pia da inst�ncia da classe DadosAeroporto dada.
     * Para tanto, deve ser fornecida uma instancia da classe DadosAeroporto para ser
     * utilizada como modelo para a constru��o da nova inst�ncia criada.
     * @param modelo a inst�ncia da classe DadosAeroporto a ser usada como modelo.
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
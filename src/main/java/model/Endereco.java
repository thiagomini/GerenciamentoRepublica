package model;

public class Endereco extends AbstractModel {
    private static int idCount = 0;
    private String cep;
    private String bairro;
    private String pontoReferencia;
    private Geolocation geolocalizacao;


    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Geolocation getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(Geolocation geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }

    public Endereco(String cep, String bairro, String pontoReferencia) {
        this.cep = cep;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.id = ++idCount;
    }

    public Endereco(String cep, String bairro, String pontoReferencia, Geolocation geolocalizacao) {

        this.cep = cep;
        this.bairro = bairro;
        this.pontoReferencia = pontoReferencia;
        this.geolocalizacao = geolocalizacao;
        this.id = ++idCount;
    }


}

package factory;

import model.Endereco;
import model.Geolocation;

public class EnderecoFactory {
    private static final String CEP = "29560-000";
    private static final String BAIRRO = "Quincas Machado";
    private static final String PONTO_REFERENCIA = "Pronto-Socorro";
    private static final Geolocation GEOLOCATION = GeolocationFactory.createGeolocation();

    public static Endereco createEndereco() {
        return new Endereco(
                CEP,
                BAIRRO,
                PONTO_REFERENCIA,
                GEOLOCATION
        );
    }

}

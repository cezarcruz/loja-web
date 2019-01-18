package br.com.cezarcruz.lojaweb.data.enums;

public enum TipoErro {

    VALIDACAO("VALIDACAO");

    private String info;

    TipoErro(final String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

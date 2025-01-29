package br.com.ScreenMatch.Exception;

public class YearConvertionErrorException extends RuntimeException{
    private String mensagem= "Erro na conversão do ano";
    
    public YearConvertionErrorException(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String getMessage() {
        return getMensagem();
    }
}

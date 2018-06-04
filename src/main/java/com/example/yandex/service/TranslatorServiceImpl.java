package com.example.yandex.service;

import java.io.IOException;

import retrofit2.Response;

class TranslatorServiceImpl implements TranslatorService {

    private YandexAPI service;
    private ResultConverter resultConverter;

    TranslatorServiceImpl(YandexAPI service, ResultConverter resultConverter) {
        this.service = service;
        this.resultConverter = resultConverter;
    }

    public String callCreateTranslatedWord(String wordToTranslate) throws Exception {
        Response<String> callResponse;
        try {
            callResponse = service.getTerm(wordToTranslate).execute();
        } catch (IOException e) {
            throw new NoConnectionException("No hay conexion a Internet");
        }

        String resultToConvert;
        resultToConvert = callResponse.body();

        return resultConverter.createTranslatorResult(resultToConvert);
    }
}

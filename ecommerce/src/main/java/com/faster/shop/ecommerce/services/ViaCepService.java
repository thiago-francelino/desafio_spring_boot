package com.faster.shop.ecommerce.services;

import com.faster.shop.ecommerce.dto.ViaCepResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Value("${viacep.baseurl}")
    private String viaCepBaseUrl;

    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponseDTO consultCep(String cep) {
        String apiUrl = viaCepBaseUrl + cep + "/json";
        return restTemplate.getForObject(apiUrl, ViaCepResponseDTO.class);
    }
}

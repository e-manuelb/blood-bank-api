package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import org.springframework.stereotype.Service;

@Service
public class GetBMIService implements GetBMI {
    public Double handle(Double height, Double weight) {
        return weight / (height * height);
    }
}

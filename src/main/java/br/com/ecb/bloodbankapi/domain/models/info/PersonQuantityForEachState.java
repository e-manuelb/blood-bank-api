package br.com.ecb.bloodbankapi.domain.models.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PersonQuantityForEachState {
    private String state;
    private Long quantity;
}
